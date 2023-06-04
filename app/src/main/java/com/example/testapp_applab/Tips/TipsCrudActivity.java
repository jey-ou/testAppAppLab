package com.example.testapp_applab.Tips;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testapp_applab.MainActivity;
import com.example.testapp_applab.R;
import com.example.testapp_applab.SignInOut.SignInActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TipsCrudActivity extends AppCompatActivity {
    TextView tvTitel, tvCategorie, tvBeschrijving;
    String titel, categorie, beschrijving, key;
    ImageView imageView_tb_home,imageView_tb_login;
    Spinner spinner;
    ArrayList<String>cat;
    ArrayAdapter<String> adapter;
    Button btnUpdate, btnDelete;
    DatabaseReference reference, refdel;
    DatabaseReference dataSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_crud);

        key = getIntent().getStringExtra("key");
        setMenubuttons();

        setViews();

        loadSpinnerData();
        setSpinnerListener();

        readData();

        setButtonClickListener();
    }

    private void loadSpinnerData() {
        dataSpinner = FirebaseDatabase.getInstance().getReference("TipsCat");
        cat = new ArrayList<>();
        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,cat);
        spinner.setAdapter(adapter);
        ValueEventListener listener = dataSpinner.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot mijnData : snapshot.getChildren()){
                    cat.add(mijnData.getValue().toString());
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("NewTipUploadActivity", "failed to load gegevens");
            }
        });
    }

    private void setMenubuttons() {
        // bij de attributen: ImageView imageView_tb_home,imageView_tb_login;
        imageView_tb_login = findViewById(R.id.second_image_view);
        imageView_tb_home = findViewById(R.id.image_view);

        imageView_tb_login.setOnClickListener(view ->{
            startActivity(new Intent(getApplicationContext(), SignInActivity.class));
            finish();
        });

        imageView_tb_home.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        });
    }
    private void readData(){

        reference = FirebaseDatabase.getInstance().getReference().child("Tips");
        //key = getIntent().getStringExtra("key");
        reference.child(key).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if(task.isSuccessful()){

                    if(task.getResult().exists()){
                        DataSnapshot snapshot= task.getResult();
                        Object object = snapshot.child("id").getValue();
                        titel = snapshot.child("titel").getValue().toString();
                        categorie = snapshot.child("categorie").getValue().toString();
                        beschrijving = snapshot.child("beschrijving").getValue().toString();

                        tvTitel.setText(titel);
                        tvBeschrijving.setText(beschrijving);
                        tvCategorie.setText(categorie);

                    }else{
                        showToast("Tip bestaat niet");
                    }

                }else{
                    showToast("Inlezen mislukt");
                }
            }
        });

    }

    private void setButtonClickListener() {

        btnDelete.setOnClickListener((view -> {
            refdel = FirebaseDatabase.getInstance().getReference().child("Tips").child(key);

            refdel.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        showToast("record met succes verwijderd");
                        startActivity(new Intent(getApplicationContext(),TipsListActivity.class));
                        finish();
                    } else {
                        showToast("Het verwijderen is mislukt!");
                    }
                }
            });

        }));

        btnUpdate.setOnClickListener(view -> {

            String dbTitel = tvTitel.getText().toString();
            String dbCategorie = tvCategorie.getText().toString();
            String dbBeschrijving = tvBeschrijving.getText().toString();

            updateTipData(dbTitel, dbCategorie, dbBeschrijving);
        });
    }

    private void updateTipData(String titel, String categorie, String beschrijving) {
        reference = FirebaseDatabase.getInstance().getReference().child("Tips");
        //key = getIntent().getStringExtra("key");

        Map<String,Object> map = new HashMap<>();
        map.put("titel", titel);
        map.put("categorie", categorie);
        map.put("beschrijving", beschrijving);

        reference.child(key).updateChildren(map).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                showToast("succesvol opgeslagen");
                startActivity(new Intent(getApplicationContext(),TipsListActivity.class));
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                showToast("wegschrijven naar firebase mislukt");
            }
        });
    }
    public void setSpinnerListener(){
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String newItem = spinner.getSelectedItem().toString();
                //showToast(newItem + " werd geselecteerd");
                if (newItem.equals("Geen categorie")){
                    showToast("geen geldige selectie gemaakt");
                    return;
                }else{
                    tvCategorie.setText(newItem);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void setViews() {
        tvTitel = findViewById(R.id.ed_tips_crud_titel);
        tvBeschrijving = findViewById(R.id.et_tips_crud_Beschrijving);
        tvCategorie = findViewById(R.id.et_tips_crud_categorie);

        spinner = findViewById(R.id.spinner_tips_CRUD);

        btnDelete = findViewById(R.id.btn_crud_delete);
        btnUpdate = findViewById(R.id.btn_crud_update);

    }
}
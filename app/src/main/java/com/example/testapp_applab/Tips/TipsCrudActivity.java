package com.example.testapp_applab.Tips;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testapp_applab.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.android.gms.tasks.Task;

import java.util.HashMap;
import java.util.Map;

public class TipsCrudActivity extends AppCompatActivity {
    TextView tvId, tvTitel, tvCategorie, tvBeschrijving;
    String id, titel, categorie, beschrijving, key;
    String dbid, dbTitel, dbCategorie, dbBeschrijving;
    Spinner spinner;
    Button btnUpdate, btnDelete;
    DatabaseReference reference, refdel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_crud);

        key = getIntent().getStringExtra("key");

        setViews();

        readData();

        setButtonClickListener();
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

                        // voor update
                        /*
                        dbTitel = snapshot.child("titel").getValue().toString();
                        dbCategorie = snapshot.child("categorie").getValue().toString();
                        dbBeschrijving =snapshot.child("beschrijving").getValue().toString();
                        */

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

            dbTitel = tvTitel.getText().toString();
            dbCategorie = tvCategorie.getText().toString();
            dbBeschrijving = tvBeschrijving.getText().toString();

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
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                showToast("wegschrijven naar firebase mislukt");
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
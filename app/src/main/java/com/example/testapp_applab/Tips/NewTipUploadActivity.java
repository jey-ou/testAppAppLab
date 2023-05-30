package com.example.testapp_applab.Tips;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testapp_applab.MainActivity;
import com.example.testapp_applab.R;
import com.example.testapp_applab.SignInOut.SignInActivity;
import com.example.testapp_applab.SignInOut.SignUpActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NewTipUploadActivity extends AppCompatActivity {

    DatabaseReference dataRef;
    DatabaseReference dataSpinner;
    TextView tvTitel, tvBeschrijving;
    Button btnSave, btnClear;
    Spinner spinner;
    ArrayList<String>cat;
    ArrayAdapter<String> adapter;
    ValueEventListener listener;
    ImageView imageView_tb_home,imageView_tb_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_tip_upload);

        Toolbar toolbar = findViewById(R.id.veilig_thuis_toolbar);
        setSupportActionBar(toolbar);

        setViews();
        loadSpinnerData();

        dataRef = FirebaseDatabase.getInstance().getReference().child("Tips");

        buttonAddClickListeners();
        setViews();

    }

    private void loadSpinnerData() {
        //opzetten spinner en onderdelen;
        dataSpinner = FirebaseDatabase.getInstance().getReference("TipsCat");
        cat = new ArrayList<>();
        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,cat);
        spinner.setAdapter(adapter);

        // ophalen data voor spinner uit realtime database
        listener = dataSpinner.addValueEventListener(new ValueEventListener() {
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

    private void setViews() {
        imageView_tb_login = findViewById(R.id.second_image_view);
        imageView_tb_home = findViewById(R.id.image_view);

        spinner = findViewById(R.id.spinner_tip_upload_categorie);
        tvTitel = findViewById(R.id.et_tips_Upload_titel);
        tvBeschrijving = findViewById(R.id.et_tip_upload_beschrijving);
        btnSave = findViewById(R.id.btn_tip_upload_save);
        btnClear= findViewById(R.id.btn_tips_upload_clear);
    }

    private void buttonAddClickListeners() {

        btnSave.setOnClickListener(view->{
            checkAndSave();
        });

        btnClear.setOnClickListener(view->{
            clearform();
        });

        imageView_tb_login.setOnClickListener(view ->{
            startActivity(new Intent(getApplicationContext(), SignInActivity.class));
            finish();
        });

        imageView_tb_home.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        });
    }

    private void clearform() {
        tvTitel.setText("");
        tvBeschrijving.setText("");
    }

    private void checkAndSave() {

        String categorie = spinner.getSelectedItem().toString();
        String isVerwijderd = "neen";
        // nog uit te breiden met resultaat spinner = ok

        String txtTitel = tvTitel.getText().toString();
        String txtBeschrijving = tvBeschrijving.getText().toString();
        if(categorie.equals("Geen categorie")){
            Toast.makeText(getApplicationContext(),"Please choise a category",Toast.LENGTH_LONG).show();
            return;
        }
        // nog uit te breiden met resultaat spinner = ok

        if (txtTitel.isEmpty()){
            tvTitel.setError("Please enter a title.");
            tvTitel.requestFocus();
        }
        if (txtBeschrijving.isEmpty()){
            tvBeschrijving.setError("Please enter a disciption");
            tvBeschrijving.requestFocus();
        }
        if (txtBeschrijving.isEmpty() || txtTitel.isEmpty()) return;
        String id = dataRef.push().getKey();
        TipsListModel model = new TipsListModel(id, categorie, txtBeschrijving,isVerwijderd, txtTitel);

        dataRef.child(id).setValue(model).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Tip successful registered",Toast.LENGTH_SHORT).show();

                    tvTitel.setText("");
                    tvBeschrijving.setText("");
                }else{
                    Toast.makeText(getApplicationContext(),"Failure to load up",Toast.LENGTH_SHORT).show();
                    // hier eventueel uit SharedPreferences een download van gegevens
                    // of de spinner aanpassen zodat gegevens rechtstreeks kunnen ingeladen worden
                }
            }
        });
    }
}
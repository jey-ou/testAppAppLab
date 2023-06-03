package com.example.testapp_applab.Tips;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.testapp_applab.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TipsCrudActivity extends AppCompatActivity {
    TextView tvId, tvTitel, tvCategorie, tvBeschrijving;
    String id, titel, categorie, beschrijving, key;
    Spinner spinner;
    Button btnUpdate, btnDelete;
    DatabaseReference reference, refdel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_crud);

        setViews();
        setButtonClickListener();

        reference = FirebaseDatabase.getInstance().getReference().child("Tips");
        key = getIntent().getStringExtra("key");

        reference.child(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Object object = snapshot.child("id").getValue();
                titel = snapshot.child("titel").getValue().toString();
                categorie = snapshot.child("categorie").getValue().toString();
                beschrijving = snapshot.child("beschrijving").getValue().toString();


                tvTitel.setText(titel);
                tvBeschrijving.setText(beschrijving);
                tvCategorie.setText(categorie);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void setButtonClickListener() {

        btnDelete.setOnClickListener((view -> {
            refdel = FirebaseDatabase.getInstance().getReference().child("Tips").child(key);
            refdel.removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {

                }
            });
        }));

        btnUpdate.setOnClickListener(view -> {

        });


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
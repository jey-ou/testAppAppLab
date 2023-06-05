package com.example.testapp_applab.Tips;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testapp_applab.MainActivity;
import com.example.testapp_applab.R;
import com.example.testapp_applab.SignInOut.SignInActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TipWeergaveActivity extends AppCompatActivity {
    String titel, categorie, beschrijving, key;
    TextView tvTitel, tvCategorie, tvBeschrijving, tv_id;
    Button btnTerug;
    ImageView imageView_tb_home,imageView_tb_login;
    DatabaseReference reference, refdel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_weergave);

        addViews();
        setButtonClickers();
        setMenubuttons();

        readData();

    }

    private void setButtonClickers() {
        btnTerug.setOnClickListener(view->{
            startActivity(new Intent(this, TipsListActivity.class));
            finish();
        });
    }

    private void addViews() {
        tvTitel = findViewById(R.id.tv_tipweergave_titel);
        tvBeschrijving = findViewById(R.id.edm_tepweergave_beschrijving);
        tvCategorie = findViewById(R.id.tv_tipweergave_categorie);
        tv_id= findViewById(R.id.tv_tipweergave_id);

        btnTerug = findViewById(R.id.btn_terugList);

    }

    private void readData(){

        reference = FirebaseDatabase.getInstance().getReference().child("Tips");
        key = getIntent().getStringExtra("key");
        reference.child(key).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {

                    if (task.getResult().exists()) {
                        DataSnapshot snapshot = task.getResult();
                        Object object = snapshot.child("id").getValue();
                        titel = snapshot.child("titel").getValue().toString();
                        categorie = snapshot.child("categorie").getValue().toString();
                        beschrijving = snapshot.child("beschrijving").getValue().toString();

                        tvTitel.setText(titel);
                        tvBeschrijving.setText(beschrijving);
                        tvCategorie.setText(categorie);
                        tv_id.setText(key);

                    } else {
                        showToast("Tip bestaat niet");
                    }

                } else {
                    showToast("Inlezen mislukt");
                }
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
    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
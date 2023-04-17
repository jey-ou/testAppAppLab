package com.example.testapp_applab.SignInOut;



import androidx.appcompat.app.AppCompatActivity;
import com.example.testapp_applab.R;
import com.example.testapp_applab.Voorbeelden.Aminozuren;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TestenActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testen);

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");

        Button btn_primair = (Button) findViewById(R.id.btn_primaireTest);
        btn_primair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primaireTest();
            }
        });

        Button btnAminozuren = findViewById(R.id.btn_recyclerView);
        btnAminozuren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recycler();
            }
        });
    }

    public void primaireTest(){


        myRef.setValue("Hello world");
    }
    public void recycler(){
        Intent intent = new Intent (getApplicationContext(), Aminozuren.class);
        startActivity(intent);

    }
}

/**
 * DatabaseReference ref = FirebaseDatabase.getInstance().getReference("users");
 * FirebaseAuth auth     = FirebaseAuth.getInstance();
 * FirebaseUser user     = auth.getCurrentUser();

 * ref.child(user.getUid()).child("name").setValue("Darryl Fernand");
 * ref.child(user.getUid()).child("email").setValue("fernsdarryyl@gmail.com");
 * ref.child(user.getUid()).child("gender").setValue("male");
 *
 *  FirebaseAuth auth = FirebaseAuth.getInstance();
 *             FirebaseUser user = auth.getCurrentUser();
 *             String uId = firebaseAuth.getCurrentUser().getUid() + "";
 *             FirebaseDatabase database = FirebaseDatabase.getInstance();
 *             DatabaseReference myRef = database.getReference("users");
 *
 *                         myRef.addListenerForSingleValueEvent(new ValueEventListener() {
 *                             @Override
 *                             public void onDataChange(DataSnapshot dataSnapshot) {
 *
 *                                 boolean hasId = dataSnapshot.hasChild(uId);
 *
 *                                 if(hasId){
 *
 *                                     String name = dataSnapshot.child("name").getValue().toString() + "";
 *                                 }
 *                             }
 *
 *                             @Override
 *                             public void onCancelled(DatabaseError databaseError) {
 *                             }
 *                         });
 */
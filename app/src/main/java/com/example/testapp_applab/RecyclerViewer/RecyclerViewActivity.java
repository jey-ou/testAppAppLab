package com.example.testapp_applab.RecyclerViewer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testapp_applab.R;
import com.example.testapp_applab.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RecyclerViewActivity extends AppCompatActivity {

    Button btnInsert, btnView;
    EditText edtTxtName,edtTxtEmail, edtTxtAge,edtTxtPw;
    DatabaseReference databaseUsers;
    //RecyclerView recView;
    //myadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        btnInsert = findViewById(R.id.btnInsert);
        btnView = findViewById(R.id.btnView);
        edtTxtName = findViewById(R.id.edtName);
        edtTxtEmail= findViewById(R.id.edtEmail);
        edtTxtAge = findViewById(R.id.edtAge);
        edtTxtPw = findViewById((R.id.edtPw));

        databaseUsers = FirebaseDatabase.getInstance().getReference();

        btnInsert.setOnClickListener(view ->{
            InsertData();
        });

        btnView.setOnClickListener(view ->{
            startActivity(new Intent(getApplicationContext(), UserList.class));
        });
    }

    private void InsertData() {
        String username = edtTxtName.getText().toString();
        String useremail =edtTxtEmail.getText().toString();
        String userage = edtTxtAge.getText().toString();
        String password = edtTxtEmail.getText().toString();
        String id = databaseUsers.push().getKey();

        UserRecycler user = new UserRecycler(username, useremail, userage);
        databaseUsers.child("usersRecycler").child(id).setValue(user)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // nog testen op lee vakken
                        if(task.isSuccessful()){
                            Toast.makeText(RecyclerViewActivity.this, "<User data inserted", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
/*
    @Override
    private void onStart(){
        super.onStart();
    //    adapter.startListening();
    }
    @Override
    private void onStop(){
    //    super.onstop();

    }
*/

}
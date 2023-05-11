package com.example.testapp_applab.SignInOut;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testapp_applab.R;
import com.example.testapp_applab.Voorbeelden.Aminozuren;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AfterSignInActivity extends AppCompatActivity {

    EditText editText;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_sign_in);

        mAuth = FirebaseAuth.getInstance();
        //Intent intent = new Intent(this, Aminozuren.class);
        //startActivity(intent);
    }
    

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            //There is some one logged in
           //;
        }else {
            Intent intent = new Intent(getApplicationContext(),SignInActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
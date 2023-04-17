package com.example.testapp_applab.SignInOut;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testapp_applab.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgottenPasswordActivity extends AppCompatActivity {

    EditText editTextUserName;
    Button btn_btn_resetPW;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotten_password);

        mAuth = FirebaseAuth.getInstance();
        editTextUserName = findViewById(R.id.editTextUserNameFP);

    }

    public void resetPassword(){
        String txtEmail = editTextUserName.getText().toString().trim();

        if(!Patterns.EMAIL_ADDRESS.matcher(txtEmail).matches()){
            editTextUserName.setError("Please enter valis email address");
            editTextUserName.requestFocus();
            return;
        }
        mAuth.sendPasswordResetEmail(txtEmail)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(), "Please Check your email address to reset your email address", Toast.LENGTH_SHORT).show();

                        }else{
                            Toast.makeText(getApplicationContext(), "failed to reset the password", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
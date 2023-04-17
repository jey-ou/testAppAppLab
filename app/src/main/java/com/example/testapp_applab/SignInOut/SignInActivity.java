package com.example.testapp_applab.SignInOut;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testapp_applab.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class SignInActivity extends AppCompatActivity {
    EditText editTextUserName;
    EditText editTextPassword;

    TextView textViewForgotPassword;
    TextView textViewRegister;
    Button btnSignIn;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        editTextUserName = (EditText) findViewById(R.id.editTextEmailSignIn);
        editTextPassword = (EditText) findViewById(R.id.editTextPasswordSignIn);

        textViewForgotPassword = (TextView) findViewById(R.id.textViewForgetPassword);
        textViewRegister = (TextView) findViewById(R.id.textViewRegister);

        mAuth = FirebaseAuth.getInstance();

        Button btn = (Button) findViewById(R.id.buttonLogIn);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                signInButtonClicked();
            }
        });

    }

    public void signInForgetPasswordClicked(){
        Toast.makeText(SignInActivity.this,"nog niet geactiveerd",Toast.LENGTH_SHORT).show();
    }

    public void signInRegisterClicked(){
        Toast.makeText(SignInActivity.this,"nog niet geactiveerd",Toast.LENGTH_SHORT).show();
    }

    public void signInButtonClicked(){

        String userName = editTextUserName.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if(!Patterns.EMAIL_ADDRESS.matcher(userName).matches()){
            editTextUserName.setError("Please enter valid email address");
            editTextUserName.requestFocus();
        }

        if(editTextPassword.length()<7){
            editTextPassword.setError("Please enter password at least 7 charakters");
            editTextPassword.requestFocus();
        }

        mAuth.signInWithEmailAndPassword(userName, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(SignInActivity.this,"Successfully login",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), AfterSignInActivity.class);
                    startActivity(intent);
                    //finish();
                } else{
                    Toast.makeText(SignInActivity.this,"failed login",Toast.LENGTH_SHORT).show();
                    //editTextUserName.setText("");
                    //editTextPassword.setText("");
                }
            }
        });


    }

}
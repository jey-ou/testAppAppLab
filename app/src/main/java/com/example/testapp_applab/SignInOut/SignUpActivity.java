package com.example.testapp_applab.SignInOut;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

//import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testapp_applab.R;
import com.example.testapp_applab.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    EditText editTextUserName;
    EditText editTextPassword;
    EditText editTextPhoneNo;
    EditText editTextEmail;
    private FirebaseAuth mAuth;
    //
    //Button btn_testen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextPhoneNo =(EditText) findViewById(R.id.editTextMobileNo);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);

        Button button = (Button) findViewById(R.id.buttonAfterInput);
        Button btn_testen = (Button) findViewById(R.id.btn_testen) ; //
        btn_testen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(SignUpActivity.this, TestenActivity.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String txtUserName = editTextUserName.getText().toString().trim();
                String txtPassword = editTextPassword.getText().toString().trim();
                String txtPhoneNo = editTextPhoneNo.getText().toString().trim();
                String txtEmail = editTextEmail.getText().toString().trim();
                mAuth = FirebaseAuth.getInstance();

                if(txtUserName.isEmpty()){
                    editTextUserName.setError("please enter Username");
                    editTextUserName.requestFocus();
                }
                if(txtPassword.isEmpty()){
                    editTextPassword.setError("please enter password");
                    editTextPassword.requestFocus();
                }
                if (txtPhoneNo.isEmpty()){
                    editTextPhoneNo.setError("please enter mobile number");
                    editTextPhoneNo.requestFocus();
                }
                if (txtEmail.isEmpty()){
                    editTextEmail.setError("please enter email adress");
                    editTextEmail.requestFocus();
                }
                if(txtUserName.isEmpty() || txtEmail.isEmpty() || txtPassword.isEmpty() || txtPhoneNo.isEmpty()){
                    Toast.makeText(SignUpActivity.this,"formulier moet volledig ingevuld worden",Toast.LENGTH_LONG).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(txtEmail,txtPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
                            @Override
                            public void onComplete (@NonNull Task<AuthResult> task){
                                if (task.isSuccessful()){
                                    User user = new User(txtUserName, txtPassword,txtPhoneNo,txtEmail);
                                    Log.d("USER AUTH ", "user created");
                                    FirebaseDatabase.getInstance().getReference("Users")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (task.isSuccessful()){
                                                        Toast.makeText(SignUpActivity.this,"User successfully registered",Toast.LENGTH_LONG).show();
                                                        ((EditText) findViewById(R.id.editTextUserName)).setText("");
                                                        ((EditText) findViewById(R.id.editTextPassword)).setText("");
                                                        ((EditText) findViewById(R.id.editTextMobileNo)).setText("");
                                                        ((EditText) findViewById(R.id.editTextEmail)).setText("");
                                                    }else{
                                                        Toast.makeText(SignUpActivity.this,"faillure to register",Toast.LENGTH_LONG).show();
                                                    }
                                                }
                                            });
                                }else{
                                    Toast.makeText(SignUpActivity.this,"faillure authentification",Toast.LENGTH_LONG).show();
                                }

                            }
                });
            }
        });

    }

}
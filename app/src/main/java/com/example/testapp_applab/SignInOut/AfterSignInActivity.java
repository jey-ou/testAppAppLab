package com.example.testapp_applab.SignInOut;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testapp_applab.R;
import com.example.testapp_applab.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AfterSignInActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_sign_in);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        TextView userName = findViewById(R.id.textViewUserNameAfter);
        TextView userEmail =findViewById(R.id.textViewUserEmailAfter);
        TextView userInfo = findViewById(R.id.textViewUserInfoAfter);
        TextView userName2 = findViewById(R.id.tvSecModelNaam);
        TextView userEmail2 = findViewById(R.id.tvSecJModelEmail);
        TextView userInfo2 = findViewById(R.id.tvSecModelInfo);

        Button btnGoOn = findViewById(R.id.buttonGaVerderAfter);

        Log.i("SharedPrefsJSON", "onCreate()) gestart met initiatie");

        btnGoOn.setOnClickListener(v ->{
            Intent intent = new Intent(getApplicationContext(), TestenActivity.class);
            startActivity(intent);
        });

        if (user !=null) {
            String userId = user.getUid();
            //DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users").child(userId);
            Log.i("SharedPrefsJSON", "userId niet leeg na login");
            //header.setText(userId); // te verwijderen

            DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

            ref.child("Users").child(userId).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    if (task.isSuccessful()){
                        if (task.getResult().exists()){

                            Toast.makeText(getApplicationContext(),"Successfully Read",Toast.LENGTH_SHORT).show();

                            DataSnapshot dataSnapshot = task.getResult();
                            String firstName = String.valueOf(dataSnapshot.child("userName").getValue());
                            String email = String.valueOf(dataSnapshot.child("email").getValue());
                            String info = String.valueOf(dataSnapshot.child("authorisatie").getValue());
                            userName.setText(firstName);
                            userEmail.setText(email);
                            userInfo.setText(info);

                            User userProfile = dataSnapshot.getValue(User.class);
                            userName2.setText(userProfile.getUserName());
                            userEmail2.setText(userProfile.getEmail());
                            userInfo2.setText(userProfile.getAuthorisatie());
                        }else {

                            Toast.makeText(getApplicationContext(),"User doesn't Exist",Toast.LENGTH_SHORT).show();

                        }

                    }
                }
            });

        }else{
            Toast.makeText(getApplicationContext(), "no userID", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    protected void onStart() {
        super.onStart();

        //FirebaseAuth mAuth = null;
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if(currentUser != null){
            Toast.makeText(getApplicationContext(), "succesvol ingelogd", Toast.LENGTH_SHORT).show();
            Log.i("SharedPrefsJSON", "onStart() correct uitgevoerd na login");
           //;
        }else {
            Intent intent = new Intent(getApplicationContext(),SignInActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
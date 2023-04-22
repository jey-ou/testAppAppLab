package com.example.testapp_applab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.testapp_applab.SignInOut.SignInActivity;
import com.example.testapp_applab.SignInOut.SignUpActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.veilig_thuis_toolbar);
        setSupportActionBar(toolbar);
        ImageView imageView_tb = findViewById(R.id.second_image_view);

        imageView_tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });


        // Write a message to the database

    }
    public void signInOnclick(View view){

        Intent intent = new Intent(MainActivity.this, SignInActivity.class);
        startActivity(intent);
    }
    public void signUpOnClick(View view){
        // geactiveerd
        Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
        startActivity(intent);
    }
}
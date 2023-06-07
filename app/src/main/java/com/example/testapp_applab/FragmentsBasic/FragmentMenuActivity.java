package com.example.testapp_applab.FragmentsBasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.testapp_applab.R;

public class FragmentMenuActivity extends AppCompatActivity {

    Button basic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_menu);



        addClickButtons();
    }

    private void addClickButtons() {
        basic = findViewById(R.id.btn_basic_frag_basics);

        basic.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), FragmentBasicActivity.class));
            finish();
        });
    }


}
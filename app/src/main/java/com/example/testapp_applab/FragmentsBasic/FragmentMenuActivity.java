package com.example.testapp_applab.FragmentsBasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.testapp_applab.CommFragFrag.FragFragComActivity;
import com.example.testapp_applab.FragmentsVM.DemoFragVM;
import com.example.testapp_applab.FrameManager.DemoFMActivity;
import com.example.testapp_applab.R;

public class FragmentMenuActivity extends AppCompatActivity {

    Button basic, communication, viewmodel, comm2;

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

        communication = findViewById(R.id.btn_frag_com);
        communication.setOnClickListener(view ->{
            startActivity(new Intent(getApplicationContext(), FragFragComActivity.class));
            finish();
        });

        viewmodel = findViewById(R.id.btnComFM);
        viewmodel.setOnClickListener(view ->{
            startActivity(new Intent(getApplicationContext(), DemoFMActivity.class));
            finish();
        });

        comm2 = findViewById(R.id.frag_VM);
        comm2.setOnClickListener(view ->{
            startActivity(new Intent(getApplicationContext(), DemoFragVM.class));
            finish();
        });

    }

}
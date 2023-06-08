package com.example.testapp_applab.FragmentsVM;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.testapp_applab.R;

public class DemoFragVM extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_frag_vm);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_a, new FragmentVmA())
                .add(R.id.container_b, new FragmentVmB())
                .commit();

    }
}
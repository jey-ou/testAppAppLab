package com.example.testapp_applab.FrameManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

import com.example.testapp_applab.R;

public class DemoFMActivity extends AppCompatActivity {
    Button btn_frag1, btn_frag2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_fmactivity);

        btn_frag1 = findViewById(R.id.btnFragFM1);
        btn_frag2 = findViewById(R.id.btnFragFM2);

        changeFragment(new Fragment1());

        setClickableViews();
    }

    private void setClickableViews() {
        btn_frag1.setOnClickListener(view -> {
            changeFragment(new Fragment1());
        });

        btn_frag2.setOnClickListener(view ->{
            changeFragment(new Fragment2());
        });
    }

    private void changeFragment(Fragment fragment){
        //frameFM_Demo2

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameFM_Demo2, fragment);
        fragmentTransaction.commit();
    }
}
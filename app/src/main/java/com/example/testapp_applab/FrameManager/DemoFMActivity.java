package com.example.testapp_applab.FrameManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.testapp_applab.CommFragFrag.FragFragComActivity;
import com.example.testapp_applab.FragmentsBasic.FragmentMenuActivity;
import com.example.testapp_applab.R;

public class DemoFMActivity extends AppCompatActivity {
    Button btn_frag1, btn_frag2, btn_menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_fmactivity);

        btn_frag1 = findViewById(R.id.btnFragFM1);
        btn_frag2 = findViewById(R.id.btnFragFM2);
        btn_menu = findViewById(R.id.btn_back_menuFrag); //btn_back_menuFrag

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

        btn_menu.setOnClickListener(view ->{
            startActivity(new Intent(getApplicationContext(), FragmentMenuActivity.class));
            finish();
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
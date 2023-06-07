package com.example.testapp_applab.FrameManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Button;

import com.example.testapp_applab.FragmentsBasic.FirstFragment;
import com.example.testapp_applab.R;

public class UseFragmentManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_fragment_manager);
    }

    public void addClickableViews(){
        Button btnFrameManager = findViewById(R.id.btn_frmMgr_tst);
        btnFrameManager.setOnClickListener(view -> {
            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, FirstFragment.class, null)
                    .setReorderingAllowed(true)
                    .addToBackStack("naam")
                    .commit();
        });


    }
}
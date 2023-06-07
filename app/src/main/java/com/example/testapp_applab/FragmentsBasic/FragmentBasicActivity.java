package com.example.testapp_applab.FragmentsBasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.testapp_applab.R;

public class FragmentBasicActivity extends AppCompatActivity {
    FirstFragment firstFragment;
    SecondFragment secondFragment;
    FragmentTransaction fragmentTransaction;
    int fragmentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_basic);

        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.flfragment_basics,firstFragment);
        fragmentTransaction.commit();

        addClickButtons();
    }

    private void addClickButtons() {
        Button btnFirstFrag = findViewById(R.id.btn_frame_basics1);
        Button btnSecFrag = findViewById(R.id.btn_frame_basics2);
        Switch swtch = findViewById(R.id.sw_frame_basic);
        fragmentId = 1;

        btnFirstFrag.setOnClickListener(v->{
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.flfragment_basics,firstFragment);
            fragmentTransaction.commit();
            fragmentId = 1;
        });

        btnSecFrag.setOnClickListener(view ->{
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.flfragment_basics,secondFragment);
            fragmentTransaction.commit();
            fragmentId = 2;
        });

        swtch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (fragmentId == 1 ){
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.flfragment_basics, secondFragment);
                        fragmentTransaction.commit();
                        fragmentId = 2;
                    }else {
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.flfragment_basics,firstFragment);
                        fragmentTransaction.commit();
                        fragmentId = 1;
                    }
                } else {
                    if (fragmentId == 1 ){
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.flfragment_basics,secondFragment);
                        fragmentTransaction.commit();
                        fragmentId = 2;
                    }else {
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.flfragment_basics,firstFragment);
                        fragmentTransaction.commit();
                        fragmentId = 1;
                    }

                }
            }
        });
    }


}
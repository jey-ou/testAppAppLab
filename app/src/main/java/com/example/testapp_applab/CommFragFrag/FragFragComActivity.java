package com.example.testapp_applab.CommFragFrag;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.testapp_applab.R;

public class FragFragComActivity extends AppCompatActivity implements Fragment_a.FragmentAListener, Fragment_b.FragmentBListener {
    private Fragment_a fragmentA;
    private Fragment_b fragmentB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag_frag_com);
        fragmentA = new Fragment_a();
        fragmentB = new Fragment_b();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_a, fragmentA)
                .replace(R.id.container_b, fragmentB)
                .commit();
    }

    @Override
    public void onInputASent(CharSequence input) {
        fragmentB.updateEditText(input);
    }

    @Override
    public void onInputBSent(CharSequence input) {
        fragmentA.updateEditText(input);
    }
}
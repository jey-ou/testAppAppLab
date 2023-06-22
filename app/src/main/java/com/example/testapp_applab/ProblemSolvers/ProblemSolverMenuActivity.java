package com.example.testapp_applab.ProblemSolvers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.testapp_applab.R;

public class ProblemSolverMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_solver_menu);

        Button btn_savedRestoreInstantState = findViewById(R.id.btn_shrd_snst_st);
        Button btn_sharePrefs = findViewById(R.id.btn_sharedPres_oplossing);


        btn_savedRestoreInstantState.setOnClickListener(view ->{
            startActivity(new Intent(getApplicationContext(), ScreenOrientationActivity.class));
        });

        btn_sharePrefs.setOnClickListener(view ->{
            startActivity(new Intent(getApplicationContext(), OrientationSharedPrefsActivity.class));
        });


    }
}
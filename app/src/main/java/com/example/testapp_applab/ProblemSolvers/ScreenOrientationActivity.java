package com.example.testapp_applab.ProblemSolvers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.testapp_applab.R;

public class ScreenOrientationActivity extends AppCompatActivity {
    TextView tellerweergave;
    Button btn_verhoog_met_een;
    int teller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_orientation);

        tellerweergave = findViewById(R.id.tv_SO_test);
        btn_verhoog_met_een = findViewById(R.id.btn_SO_test);

        teller = 0;

        btn_verhoog_met_een.setOnClickListener(v->{
            teller ++;
            String str = String.valueOf(teller);
            tellerweergave.setText(str);

        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("key_counter", teller);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        teller = savedInstanceState.getInt("key_counter",0);
        String str = String.valueOf(teller);
        tellerweergave.setText(str);
    }
}
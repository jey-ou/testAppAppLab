package com.example.testapp_applab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class CallBackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_back);

        Log.i("status","onCreate gestart");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i("status","onStart() gestart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i("status","onResume() gestart");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i("status","onPause() gestart");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i("status","onStop() gestart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i("status","onRestart() gestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i("status","onDestroy() gestart");
    }
}
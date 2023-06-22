package com.example.testapp_applab.ProblemSolvers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.testapp_applab.R;

public class OrientationSharedPrefsActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {
    int teller;
    Button btn_aftrekken, btn_optellen, btn_wissen;
    TextView tv_resultaat, tv_no_restore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orientation_shared_prefs);

        teller = PrefConfig.loadTotalFromPrefs(this);

        tv_resultaat = findViewById(R.id.tv_bewerking);
        tv_no_restore = findViewById(R.id.tv_zonder_restore);

        tv_resultaat.setText(String.valueOf(teller));

        btn_optellen = findViewById(R.id.btn_plus1);
        btn_aftrekken = findViewById(R.id.btn_aftrekken);
        btn_wissen = findViewById(R.id.btn_shPrfs_wissen);

        btn_optellen.setOnClickListener(view-> {
            teller ++;
            PrefConfig.saveTotalInPref(getApplicationContext(), teller);
           // tv_resultaat.setText(String.valueOf(teller));
           // tv_no_restore.setText(String.valueOf(teller));

        });

        btn_aftrekken.setOnClickListener(view->{
            teller --;
            PrefConfig.saveTotalInPref(getApplicationContext(), teller);
            //tv_resultaat.setText(String.valueOf(teller));
            //tv_no_restore.setText(String.valueOf(teller));
        });

        btn_wissen.setOnClickListener(view ->{
            PrefConfig.removeDataFromPref(this);
        });
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals(PrefConfig.PREF_TOTAL_KEY)){
            teller = PrefConfig.loadTotalFromPrefs(this);
            String str = "your total is: " + teller;
            tv_resultaat.setText(str);
            tv_no_restore.setText(String.valueOf("listener heeft een wijziging gedetecteerd"));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        PrefConfig.registerPref(this,this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PrefConfig.unRegisterPref(this,this);
    }
}
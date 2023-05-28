package com.example.testapp_applab.Tips;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.testapp_applab.R;

public class TipsMenuActivity extends AppCompatActivity {

    Button btnListView_ui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_menu);

        buildButtons();
    }

    private void buildButtons() {
        btnListView_ui = findViewById(R.id.btn_listview_ui_normal);
        btnListView_ui.setOnClickListener(view ->{
            startActivity(new Intent(getApplicationContext(),TipsListActivity.class));
        });
    }
}
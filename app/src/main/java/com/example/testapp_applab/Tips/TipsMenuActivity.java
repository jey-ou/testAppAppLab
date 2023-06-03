package com.example.testapp_applab.Tips;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.testapp_applab.R;
import com.example.testapp_applab.SearchRecyclerView.SearchRecyclerListActivity;

public class TipsMenuActivity extends AppCompatActivity {

    Button btnListView_ui, button_loadup, btnClickItem, btnSeachView,btnTipsSearch;


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
        button_loadup = findViewById(R.id.btn_tips_upload);
        button_loadup.setOnClickListener(view ->{
            startActivity(new Intent(getApplicationContext(),NewTipUploadActivity.class));
        });

        btnClickItem = findViewById(R.id.btn_tips_itemClick);
        btnClickItem.setOnClickListener(view-> {
            startActivity(new Intent(getApplicationContext(),TipsListItemClickActivity.class));
        });

        btnSeachView = findViewById(R.id.btnSV);
        btnSeachView.setOnClickListener(view ->{
            startActivity(new Intent(getApplicationContext(), SearchRecyclerListActivity.class));
        });

        btnTipsSearch = findViewById(R.id.btn_tip_search);
        btnTipsSearch.setOnClickListener(view ->{
            startActivity(new Intent(getApplicationContext(), TipsSearchActivity.class));
        });

    }
}
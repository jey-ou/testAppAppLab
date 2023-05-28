package com.example.testapp_applab.Tips;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.testapp_applab.R;

public class TipsListActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_list);

        recyclerView = findViewById(R.id.rv_tips_listview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
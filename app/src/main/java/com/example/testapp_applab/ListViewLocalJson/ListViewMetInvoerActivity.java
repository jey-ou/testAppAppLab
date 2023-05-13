package com.example.testapp_applab.ListViewLocalJson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.testapp_applab.AdapterDemos.ExampleAdapter;
import com.example.testapp_applab.R;
import com.example.testapp_applab.Voorbeelden.RecyclerViewInterface;
import com.example.testapp_applab.model.GSONentry;

import java.util.ArrayList;

public class ListViewMetInvoerActivity extends AppCompatActivity implements RecyclerViewInterface {

    private ArrayList<GSONentry> jsonItemLijst;
    private RecyclerView mRecyclerView;
    private ExampleAdapter mExampleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_met_invoer);

        jsonItemLijst = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.recyclerViewGSON);
        GSON_RecycleViewAdapter adapter = new GSON_RecycleViewAdapter(this, jsonItemLijst);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onItemLongClick(int position) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
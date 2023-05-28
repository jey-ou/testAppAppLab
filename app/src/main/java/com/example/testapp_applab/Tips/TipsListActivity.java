package com.example.testapp_applab.Tips;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.testapp_applab.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class TipsListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TipsListAdapter tipsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_list);

        recyclerView = findViewById(R.id.rv_tips_listview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<TipsListModel> options =
                new FirebaseRecyclerOptions.Builder<TipsListModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Tips"), TipsListModel.class)
                        .build();

        tipsListAdapter = new TipsListAdapter(options);
        recyclerView.setAdapter(tipsListAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        tipsListAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        tipsListAdapter.stopListening();
    }
}
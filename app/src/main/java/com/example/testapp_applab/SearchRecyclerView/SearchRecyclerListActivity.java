package com.example.testapp_applab.SearchRecyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.testapp_applab.R;
import com.example.testapp_applab.Tips.TipsListModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class SearchRecyclerListActivity extends AppCompatActivity {
    SearchRecyclerListAdapter adapter;
    RecyclerView recyclerView;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_recycler_list);

        addSearchView();
        recyclerView = findViewById(R.id.rv_searchTips);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<TipsListModel> options =
                new FirebaseRecyclerOptions.Builder<TipsListModel>()
                        .setQuery(FirebaseDatabase.getInstance()
                                .getReference().child("Tips"), TipsListModel.class)
                                .build();

        adapter = new SearchRecyclerListAdapter(options);
        recyclerView.setAdapter(adapter);

    }


    private void addSearchView() {

        searchView = findViewById(R.id.sv_search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                search(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                //String ingevoerd = "Ingevoerde tekst: " + query;
                search(query);
                return false;
            }
        });
    }



    private void search(String str){

        FirebaseRecyclerOptions<TipsListModel> options = new FirebaseRecyclerOptions
                .Builder<TipsListModel>()
                .setQuery(FirebaseDatabase.getInstance()
                        .getReference().child("Tips")
                        .orderByChild("titel")
                        .startAt(str)
                        .endAt(str + "~"),
                        TipsListModel.class).build();
        adapter = new SearchRecyclerListAdapter(options);
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }


    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
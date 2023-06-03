package com.example.testapp_applab.Tips;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.testapp_applab.R;
import com.example.testapp_applab.SearchRecyclerView.SearchRecyclerListAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TipsSearchActivity extends AppCompatActivity {

    TipsListModel model;
    TipsListAdapter adapter;
    RecyclerView recyclerView;
    SearchView searchView;

    TextView tvSearchTitel, tvSearchCategorie, tvSearchBeschrijving;
    DatabaseReference dataRef;
    // StorageReference storageRef


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_search);

        dataRef = FirebaseDatabase.getInstance().getReference().child("Tips");

        addSearchView();
        loadData();


    }

    private void loadData() {

    }

    private void addSearchView() {
        searchView = findViewById(R.id.search_bar);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                search(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                search(s);
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
        adapter = new TipsListAdapter(options);
        adapter.startListening();
        recyclerView.setAdapter(adapter);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return false;
    }
    private void txtSearch (String str){

        FirebaseRecyclerOptions<TipsListModel> options = new FirebaseRecyclerOptions
                .Builder<TipsListModel>()
                .setQuery(FirebaseDatabase.getInstance()
                                .getReference().child("Tips")
                                .orderByChild("titel")
                                .startAt(str)
                                .endAt(str + "~"),
                        TipsListModel.class).build();
        adapter = new TipsListAdapter(options);
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
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
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TipsSearchActivity extends AppCompatActivity {
    /*
    TipsListAdapter tipsListAdapter;
    RecyclerView recyclerView;

     */
    TipsListModel model;
    ArrayList<TipsListModel> tipslijst;
    TextView tvSearchTitel, tvSearchCategorie, tvSearchBeschrijving;
    SearchView searchView;
    DatabaseReference dataRef;
    // StorageReference storageRef


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_search);

        dataRef = FirebaseDatabase.getInstance().getReference().child("Tips");
        //storageRef = FirebaseStorage.getInstance().getReference.child(CarImages);

        initSearchWidgets();
        loadData();

        /*

        recyclerView = findViewById(R.id.rv_tipsSearch); // activity_tips_search.xml
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<TipsListModel> options =
                new FirebaseRecyclerOptions.Builder<TipsListModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Tips"), TipsListModel.class)
                .build();

        tipsListAdapter = new TipsListAdapter(options);
        //tipsSearchAdapter = new TipsSearchAdapter(options);
        recyclerView.setAdapter(tipsListAdapter);
        //recyclerView.setAdapter(tipsSearchAdapter);

         */
    }

    private void loadData() {
        //options = new FirebaseRecyclerOptions.Builder<TipsListModel>().setQuery(Dataref, TipsListModel.class).build();
        //adapter = new FirebaseRecyclerAdapter<TipsListModel, MyViewHolder(options){
        //    >()
        //}
    }

    private void initSearchWidgets() {
        SearchView searchView = findViewById(R.id.search_bar);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList<TipsListModel> filteredTips = new ArrayList<>();
                for(TipsListModel tip: tipslijst){
                    if(tip.getTitel().toLowerCase().contains(s.toLowerCase())){
                        filteredTips.add(tip);
                    }
                }
                return false;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /*
        getMenuInflater().inflate(R.menu.search, menu);
        MenuItem item = menu.findItem(R.id.tips_search);
        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                txtSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                txtSearch(query);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);

         */
        return false;
    }
    private void txtSearch (String str){
/*
        FirebaseRecyclerOptions<TipsListModel> options =
                new FirebaseRecyclerOptions.Builder<TipsListModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Tips")
                                .orderByChild("titel").startAt(str).endAt(str + "~"), TipsListModel.class)
                        .build();
        tipsListAdapter = new TipsListAdapter(options);
        //tipsSearchAdapter = new TipsSearchAdapter(options);
        tipsListAdapter.startListening();
        //tipsSearchAdapter.startListening();
        recyclerView.setAdapter(tipsListAdapter);
        //recyclerView.setAdapter(tipsSearchAdapter);

 */
    }

    @Override
    protected void onStart() {
        super.onStart();
        //tipsListAdapter.startListening();

    }

    @Override
    protected void onStop() {
        super.onStop();
        //tipsListAdapter.stopListening();

    }
}
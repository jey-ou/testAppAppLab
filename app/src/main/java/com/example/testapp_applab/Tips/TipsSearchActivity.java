package com.example.testapp_applab.Tips;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.SearchView;

import com.example.testapp_applab.MainActivity;
import com.example.testapp_applab.R;
import com.example.testapp_applab.SignInOut.SignInActivity;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;


public class TipsSearchActivity extends AppCompatActivity {

    TipsListAdapter adapter;
    RecyclerView recyclerView;
    SearchView searchView;
    ImageView imageView_tb_home,imageView_tb_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_search);

        setMenubuttons();
        addSearchView();

        recyclerView = findViewById(R.id.rv_tipsSearch);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<TipsListModel> options =
                new FirebaseRecyclerOptions.Builder<TipsListModel>()
                        .setQuery(FirebaseDatabase.getInstance()
                                .getReference().child("Tips"),TipsListModel.class )
                        .build();

        adapter = new TipsListAdapter(options);
        recyclerView.setAdapter(adapter);
    }
    private void setMenubuttons() {
        // bij de attributen: ImageView imageView_tb_home,imageView_tb_login;
        imageView_tb_login = findViewById(R.id.second_image_view);
        imageView_tb_home = findViewById(R.id.image_view);

        imageView_tb_login.setOnClickListener(view ->{
            startActivity(new Intent(getApplicationContext(), SignInActivity.class));
            finish();
        });

        imageView_tb_home.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        });
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
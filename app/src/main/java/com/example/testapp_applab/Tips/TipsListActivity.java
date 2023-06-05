package com.example.testapp_applab.Tips;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.testapp_applab.MainActivity;
import com.example.testapp_applab.R;
import com.example.testapp_applab.SignInOut.SignInActivity;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class TipsListActivity extends AppCompatActivity implements TipsListAdapter.TipListListener{

    private RecyclerView recyclerView;
    private TipsListAdapter tipsListAdapter;
    private ImageView imageView_tb_home,imageView_tb_login;
    //private String key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_list);

        setMenubuttons();

        recyclerView = findViewById(R.id.rv_tips_listview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<TipsListModel> options =
                new FirebaseRecyclerOptions.Builder<TipsListModel>()
                        .setQuery(FirebaseDatabase.getInstance()
                        .getReference().child("Tips"), TipsListModel.class)
                        .build();

        tipsListAdapter = new TipsListAdapter(options, this);
        recyclerView.setAdapter(tipsListAdapter);
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

    @Override
    public void onTipClick(String key) {
        String tekst = "key is " + key;
        Log.d ("ClickListener " , key);
        //Toast.makeText(this, tekst, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, TipWeergaveActivity.class).putExtra("key", key));
        finish();
    }
}
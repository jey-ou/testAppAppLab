package com.example.testapp_applab.Tips;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.testapp_applab.MainActivity;
import com.example.testapp_applab.R;
import com.example.testapp_applab.SignInOut.SignInActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class TipsListItemClickActivity extends AppCompatActivity {

    private DatabaseReference reference;
    private FirebaseRecyclerOptions<TipsListModel> options;
    private FirebaseRecyclerAdapter<TipsListModel,TipsViewHolder> adapter;
    private RecyclerView recyclerView;
    private View view;
    ImageView imageView_tb_home,imageView_tb_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_list_item_click);
        setMenubuttons();

        reference = FirebaseDatabase.getInstance().getReference("Tips");

        recyclerView = findViewById(R.id.rv_tip_itemclick);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        options = new FirebaseRecyclerOptions.Builder<TipsListModel>().setQuery(reference,TipsListModel.class).build();
        adapter = new FirebaseRecyclerAdapter<TipsListModel,TipsViewHolder>(options){
            @NonNull
            @Override
            public TipsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tip_list_item,parent,false);
                return new TipsViewHolder(view);
            }

            @Override
            public void onBindViewHolder(@NonNull TipsViewHolder holder, int position, @NonNull TipsListModel model) {

                holder.tvTitel.setText(model.getTitel().toString());
                holder.tvCategorie.setText(model.getCategorie().toString());
                holder.tvBeschrijving.setText(model.getBeschrijving().toString());

                // hier de onclick listener op de holder
                String key = getRef(position).getKey(); // getRef ingebakken instructie

                holder.view.setOnClickListener(view ->{
                    Intent intent = new Intent(getApplicationContext(),TipsCrudActivity.class);

                    intent.putExtra("key", key);

                    startActivity(intent);
                    finish();

                });

            }

        };

        adapter.startListening();
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
}
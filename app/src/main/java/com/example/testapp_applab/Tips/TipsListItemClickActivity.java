package com.example.testapp_applab.Tips;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testapp_applab.R;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_list_item_click);

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
                //super.onBindViewHolder(holder, position, payloads);
                holder.tvTitel.setText("" + model.getTitel());
                holder.tvCategorie.setText("" + model.getCategorie());
                holder.tvBeschrijving.setText("" + model.getBeschrijving());
            }

        };

        adapter.startListening();
        recyclerView.setAdapter(adapter);

    }
}
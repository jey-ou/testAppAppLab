package com.example.testapp_applab.ListViewLocalJson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp_applab.R;
import com.example.testapp_applab.model.GSONentry;

import java.util.ArrayList;

public class GSON_RecycleViewAdapter extends RecyclerView.Adapter<GSON_RecycleViewAdapter.MyViewHolder> {

    Context context;
    ArrayList<GSONentry> itemList;

    // constructor
    public GSON_RecycleViewAdapter(Context context, ArrayList<GSONentry> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public GSON_RecycleViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.gson_demo_entry, parent,false);
        return new GSON_RecycleViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GSON_RecycleViewAdapter.MyViewHolder holder, int position){
        holder.tvName.setText(itemList.get(position).getInfo1());
        holder.tvEmail.setText(itemList.get(position).getInfo2());
        holder.tvInfo.setText(itemList.get(position).getInfo3());
    }

    @Override
    public int getItemCount(){
        // de recycler view wenst het aantal items die weergegeven worden te kennen
        return itemList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // initialisatie van de views in de gebruikte gson_demo_entry.xml file
        TextView tvName, tvEmail, tvInfo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvGsonDemoNaam);
            tvEmail = itemView.findViewById(R.id.tvGsonDemoEmail);
            tvInfo = itemView.findViewById(R.id.tvGsonDemoInfo);
        }
    }
}

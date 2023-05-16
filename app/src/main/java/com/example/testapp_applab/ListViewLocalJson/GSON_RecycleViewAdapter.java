package com.example.testapp_applab.ListViewLocalJson;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.testapp_applab.R;
import com.example.testapp_applab.Voorbeelden.RecyclerViewInterface;
import com.example.testapp_applab.model.GSONentry;

import java.util.ArrayList;

public class GSON_RecycleViewAdapter extends RecyclerView.Adapter<GSON_RecycleViewAdapter.MyViewHolder> {
    RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList<GSONentry> itemList;

    // constructor
    public GSON_RecycleViewAdapter(Context context, ArrayList<GSONentry> itemList, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.itemList = itemList;
        this.recyclerViewInterface = recyclerViewInterface;
        Log.i("SharedPrefsJSON", "Adapter geinitialiseerd");
        int value=0; // te verwijderen
        if (itemList == null){
            Log.i("SharedPrefsJSON", "lege lijst"); // te verwijderen

        }else{
            value = itemList.size(); // te verwijderen
            String str = "De lijst bevat: " + value + " entries"; // te verwijderen
            Log.i("SharedPrefsJSON",str); // te verwijderen
        } // te v
    }

    @NonNull
    @Override
    public GSON_RecycleViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.gson_demo_entry, parent,false);
        return new GSON_RecycleViewAdapter.MyViewHolder(view, recyclerViewInterface);
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

    public static class MyViewHolder extends ViewHolder {
        // initialisatie van de views in de gebruikte gson_demo_entry.xml file
        TextView tvName, tvEmail, tvInfo;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvGsonDemoNaam);
            tvEmail = itemView.findViewById(R.id.tvGsonDemoEmail);
            tvInfo = itemView.findViewById(R.id.tvGsonDemoInfo);
        }
    }
}

package com.example.testapp_applab.Voorbeelden;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.testapp_applab.R;
import com.example.testapp_applab.model.AminoAcidModel;

import java.util.ArrayList;

public class AA_RecyclerViewAdapter extends RecyclerView.Adapter<AA_RecyclerViewAdapter.MyViewHolder>{
    private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList<AminoAcidModel> aminoAcidModels;

    public AA_RecyclerViewAdapter(Context context, ArrayList<AminoAcidModel> aminoAcidModels, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.aminoAcidModels = aminoAcidModels;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public AA_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // this is where you inflate the layout (Giving a look to our rows)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);
        return new AA_RecyclerViewAdapter.MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull AA_RecyclerViewAdapter.MyViewHolder holder, int position) {
        // assigning values to the views we created in de recycler_view_row layout file
        // based on the position of the recycler view
        holder.tvName.setText(aminoAcidModels.get(position).getAminoAcidName());
        holder.tv3Letter.setText(aminoAcidModels.get(position).getAminoAcidAbbreviation());
        holder.tv1Letter.setText(aminoAcidModels.get(position).getAminoAcidAbreviationSmall());
        holder.imageView.setImageResource(aminoAcidModels.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        // the recycler view just wants to know the number of items you want to displayed
        return aminoAcidModels.size();
    }

    public static class MyViewHolder extends ViewHolder{
        // grabbing the views from our recycler_view_row layout file
        // Kinda like in de OnCreate method

        ImageView imageView;
        TextView tvName, tv3Letter, tv1Letter; // tv als afkorting van textview

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewRV);
            tvName = itemView.findViewById(R.id.textViewTop);
            tv3Letter = itemView.findViewById(R.id.textViewSuccessor2);
            tv1Letter = itemView.findViewById(R.id.textViewSuccessor1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null){
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    if(recyclerViewInterface != null){
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemLongClick(pos);
                        }
                    }
                    return true;
                }

            });
        }
    }
}

package com.example.testapp_applab.Tips;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp_applab.R;

public class TipsViewHolder extends RecyclerView.ViewHolder{
    TextView tvTitel, tvCategorie, tvBeschrijving;
    View view;

    public TipsViewHolder(@NonNull View itemView) {
        super(itemView);
        tvTitel = itemView.findViewById(R.id.tv_tip_item_titel);
        tvCategorie = itemView.findViewById(R.id.tv_tip_item_categorie);
        tvBeschrijving = itemView.findViewById(R.id.tv_tip_item_beschrijving);

    }
}

package com.example.testapp_applab.Tips;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp_applab.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class TipsSearchAdapter extends FirebaseRecyclerAdapter<TipsListModel, TipsSearchAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public TipsSearchAdapter(@NonNull FirebaseRecyclerOptions<TipsListModel> options) {
        super(options);
    }
    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull TipsListModel model) {
        holder.tvTipsListTitel.setText(model.getTitel());
        holder.tvTipsListBeschrijving.setText(model.getBeschrijving());
        holder.tvTipsListCategorie.setText(model.getCategorie());
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tip_list_item, parent, false);
        return new TipsSearchAdapter.myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        TextView tvTipsListTitel, tvTipsListBeschrijving, tvTipsListCategorie;
        // deze variabelen worden eveneens gebruikt voor de methode onBindHolder
        public myViewHolder(@NonNull View itemView){
            super(itemView);

            tvTipsListTitel= itemView.findViewById(R.id.tv_tip_item_titel); // tips_list_item.xml
            tvTipsListBeschrijving= itemView.findViewById(R.id.tv_tip_item_beschrijving);
            tvTipsListCategorie = itemView.findViewById(R.id.tv_tip_item_categorie);
        }
    }


}

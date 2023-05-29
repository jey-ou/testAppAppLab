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

public class TipsListAdapter extends FirebaseRecyclerAdapter<TipsListModel, TipsListAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public TipsListAdapter(@NonNull FirebaseRecyclerOptions<TipsListModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull TipsListModel model) {
        // de holder de views parameters opgegeven in myViewHolder!
        holder.tvTipsListTitel.setText(model.getTitel());
        holder.tvTipsListBeschrijving.setText(model.getBeschrijving());
        holder.tvTipsListCategorie.setText(model.getCategorie());
        /*
        Glide.with(holder.img.getContext())
            .load(model.getSurl())
            .placeholder(R.drawable.common_google_signin_button_dark
            .circleCrop()
            .error(R.drawable.common_google_signin_button_normal)
            .into(holer.img);
        */
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tip_list_item, parent, false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        //CircleImageView img;
        TextView tvTipsListTitel, tvTipsListBeschrijving, tvTipsListCategorie;
        // deze variabelen worden eveneens gebruikt voor de methode onBindHolder
        public myViewHolder(@NonNull View itemView){
            super(itemView);

            //img = itemView.findViewById(R.id.img1);
            tvTipsListTitel= itemView.findViewById(R.id.tv_tip_item_titel); // tips_list_item.xml
            tvTipsListBeschrijving= itemView.findViewById(R.id.tv_tip_item_beschrijving);
            tvTipsListCategorie = itemView.findViewById(R.id.tv_tip_item_categorie);
        }
    }
}

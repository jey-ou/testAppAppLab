package com.example.testapp_applab.SearchRecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp_applab.R;
import com.example.testapp_applab.Tips.TipsListModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.Query;

import java.util.ArrayList;

public class SearchRecyclerListAdapter extends FirebaseRecyclerAdapter<TipsListModel, SearchRecyclerListAdapter.MyViewHolder> implements Filterable
{
    private ArrayList<TipsListModel> dataSet;
    private ArrayList<TipsListModel> fullList; // volledige lijst data

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public SearchRecyclerListAdapter(@NonNull FirebaseRecyclerOptions<TipsListModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull TipsListModel model) {
        //model = tiplijst.get(position);
        holder.tipTitel.setText(model.getTitel());
        holder.tipCategorie.setText(model.getCategorie());
        holder.tipBeschrijving.setText(model.getBeschrijving());
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tip_list_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public Filter getFilter() {
        return null;
    }



    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tipTitel, tipCategorie, tipBeschrijving;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tipTitel= itemView.findViewById(R.id.tv_tip_item_titel);
            tipCategorie = itemView.findViewById((R.id.tv_tip_item_categorie));
            tipBeschrijving = itemView.findViewById(R.id.tv_tip_item_beschrijving);
        }
    }

}

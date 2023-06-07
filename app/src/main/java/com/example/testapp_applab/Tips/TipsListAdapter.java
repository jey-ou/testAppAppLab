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
    private TipListListener myTipListListener;

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public TipsListAdapter(@NonNull FirebaseRecyclerOptions<TipsListModel> options, TipListListener tipListListener) {
        super(options);
        this.myTipListListener = tipListListener;
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull TipsListModel model) {
        // de holder de views parameters opgegeven in myViewHolder!
        holder.tvTipsListTitel.setText(model.getTitel());
        holder.tvTipsListBeschrijving.setText(model.getBeschrijving());
        holder.tvTipsListCategorie.setText(model.getCategorie());

        // hier de onclick listener op de holder
        String key = getRef(position).getKey(); // getRef ingebakken instructie
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myTipListListener.onTipClick(key);
            }
        });

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tip_list_item, parent, false);
        return new myViewHolder(view, myTipListListener);
    }

    class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvTipsListTitel, tvTipsListBeschrijving, tvTipsListCategorie;
        //TipListListener tipListListener;


        public myViewHolder(@NonNull View itemView, TipListListener tiplistener) {
            super(itemView);

            tvTipsListTitel= itemView.findViewById(R.id.tv_tip_item_titel); // tips_list_item.xml
            tvTipsListBeschrijving= itemView.findViewById(R.id.tv_tip_item_beschrijving);
            tvTipsListCategorie = itemView.findViewById(R.id.tv_tip_item_categorie);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }


    }
    public interface TipListListener{
        void onTipClick(String key);
    }
}

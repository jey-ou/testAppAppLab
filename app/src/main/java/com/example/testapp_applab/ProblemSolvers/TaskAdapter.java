package com.example.testapp_applab.ProblemSolvers;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp_applab.R;
import com.example.testapp_applab.RecyclerViewer.RecyclerViewAdapter;
import com.example.testapp_applab.RecyclerViewer.UserRecycler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.Holder> {
    private Context context;
    private List<ModelSP> lijst;

    public TaskAdapter(Context context, ArrayList<ModelSP> list) {
        this.context = context;
        this.lijst = list;
        Collections.reverse(lijst);
    }

    public void setLijst(List<ModelSP> lijst){
        this.lijst = lijst;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new Holder(LayoutInflater.from(context)
                .inflate(R.layout.taak_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Log.d("Dagelijks", "takenlijst: " + lijst);
        holder.txtTaskName.setText(lijst.get(position).getItem());
        holder.txtTaskAddTime.setText(String.valueOf(lijst.get(position).getDatum()));
    }

    @Override
    public int getItemCount() {
        return lijst != null ? lijst.size():0;
    }

    public class Holder extends RecyclerView.ViewHolder{
        TextView txtTaskName, txtTaskAddTime;
        public Holder (@NonNull View itemView){
            super(itemView);
            txtTaskName = itemView .findViewById(R.id.txt_task_name);
            txtTaskAddTime = itemView.findViewById(R.id.txt_date);
        }
    }
}

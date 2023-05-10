package com.example.testapp_applab.RecyclerViewer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp_applab.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<UserRecycler> list;

    public RecyclerViewAdapter(Context context, ArrayList<UserRecycler> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.userentry, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        UserRecycler user = list.get(position);
        holder.email.setText(user.getEmail());
        holder.age.setText(user.getAge());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name, email, age;
        public MyViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.crdv_name);
            email = itemView.findViewById(R.id.crdv_email);
            age = itemView.findViewById(R.id.crdv_age);
        }
    }
}

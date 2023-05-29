package com.example.testapp_applab.Tips;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.testapp_applab.R;

import java.util.List;

public class TipsCatSpinnerAdapter extends BaseAdapter {
    private Context context;
    private List<String> categorien;

    public TipsCatSpinnerAdapter(Context context, List<String> categorien) {
        this.context = context;
        this.categorien = categorien;
    }

    @Override
    public int getCount() {
        return categorien !=null ? categorien.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rootView = LayoutInflater.from(context)
                .inflate(R.layout.item_tips_cat, viewGroup, false);
        TextView txtCat = rootView.findViewById(R.id.tips_cat_spinner_txt);

        txtCat.setText(categorien.get(i).toString());

        return rootView;
    }
}

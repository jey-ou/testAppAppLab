package com.example.testapp_applab.FragmentsBasic;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testapp_applab.R;

public class FirstFragment extends Fragment {

    public FirstFragment() {
        // Required empty public constructor
    }

    // voor de demo hebben we enkel deze methode nodig

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        //view.findViewById(R.id)
        return view;
    }
}
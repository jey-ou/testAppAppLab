package com.example.testapp_applab.FragmentsVM;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.testapp_applab.R;


public class FragmentVmA extends Fragment {
    EditText editText;
    Button btn_send;


    public FragmentVmA() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vm_a, container, false);
        editText = view.findViewById(R.id.et_fragvm_a);
        btn_send = view.findViewById(R.id.btn_fragvm_a);

        addClickableView();
        // Inflate the layout for this fragment
        return view;
    }

    private void addClickableView() {
        btn_send.setOnClickListener(view ->{
            // TODO aanvullen
        });
    }
}
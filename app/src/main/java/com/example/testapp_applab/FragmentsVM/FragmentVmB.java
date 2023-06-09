package com.example.testapp_applab.FragmentsVM;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.testapp_applab.R;


public class FragmentVmB extends Fragment {
    private EditText editText;
    private Button btn_send;

    public FragmentVmB() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vm_b, container, false);
        editText = view.findViewById(R.id.et_fragvm_b);
        btn_send = view.findViewById(R.id.btn_fragvm_b);

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
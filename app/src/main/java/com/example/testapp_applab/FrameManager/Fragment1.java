package com.example.testapp_applab.FrameManager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.testapp_applab.R;

public class Fragment1 extends Fragment {
    View view;
    Button btnSendData;
    //EditText editText;

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_1, container, false);

        btnSendData = view.findViewById(R.id.btnFragFMone);


        getParentFragmentManager().setFragmentResultListener("dataFrom2",this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String data = result.getString("df2");
                EditText editText = view.findViewById(R.id.tvDemoFM1);
                editText.setText(data);
            }
        });

        btnSendData.setOnClickListener(v -> {
            Bundle result = new Bundle();
            EditText editText = view.findViewById(R.id.tvDemoFM1);
            result.putString("df1", editText.getText().toString());
            getParentFragmentManager().setFragmentResult("dataFrom1",result);
            editText.setText("");
        });


        return view;
    }
}
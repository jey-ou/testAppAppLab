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


public class Fragment2 extends Fragment {
    View view;
    Button btnSendData;
    //EditText editText;

    public Fragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_2, container, false);

        btnSendData = view.findViewById(R.id.btnFragFMtwo);


        getParentFragmentManager().setFragmentResultListener("dataFrom1",this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String data = result.getString("df1");
                EditText editText = view.findViewById(R.id.tvDemoFM2);
                editText.setText(data);
            }
        });

        btnSendData.setOnClickListener(v -> {
            Bundle result = new Bundle();
            EditText editText = view.findViewById(R.id.tvDemoFM2);
            result.putString("df2", editText.getText().toString());
            getParentFragmentManager().setFragmentResult("dataFrom2",result);
            editText.setText("");
        });

        return view;
    }
}
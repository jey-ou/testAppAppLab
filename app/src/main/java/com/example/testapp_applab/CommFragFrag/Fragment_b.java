package com.example.testapp_applab.CommFragFrag;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.testapp_applab.R;

public class Fragment_b extends Fragment {
    private FragmentBListener listener;
    private EditText editText;
    private Button btn_Send;

    public Fragment_b() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        editText = view.findViewById(R.id.tv_FagFragCom_b);
        btn_Send = view.findViewById((R.id.btn_FragFragCom_b));
        btn_Send.setOnClickListener(v ->{
            CharSequence input = editText.getText();
            listener.onInputBSent(input);
        });

        return view;
    }
    @Override
    public void onAttach(@NonNull Context context){
        super.onAttach(context);
        if(context instanceof  FragmentBListener){
            listener = (FragmentBListener) context;
        } else {
            throw new RuntimeException(context.toString()
            + " must implement FragmentBListener");
        }
    }

    @Override
    public void onDetach(){
        super.onDetach();
        listener = null;
    }

    public void updateEditText(CharSequence newText){
        editText.setText(newText);
    }
    public interface FragmentBListener{
        void onInputBSent(CharSequence input);
    }
}
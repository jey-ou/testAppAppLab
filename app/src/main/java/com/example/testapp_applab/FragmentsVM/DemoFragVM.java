package com.example.testapp_applab.FragmentsVM;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.testapp_applab.CommFragFrag.FragFragComActivity;
import com.example.testapp_applab.FragmentsBasic.FragmentMenuActivity;
import com.example.testapp_applab.R;

public class DemoFragVM extends AppCompatActivity {
    //private NoteViewModel noteViewModel;

    Button btn_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_frag_vm);

        //noteViewModel = viewModelProviders.of(this).get(NoteViewModel.class);
        //noteViewModel.getAllNotes().observe(this);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_a, new FragmentVmA())
                .add(R.id.container_b, new FragmentVmB())
                .commit();
        addClickableViews();
    }

    private void addClickableViews() {
        btn_menu = findViewById(R.id.btn_fragVM_menu);
        btn_menu.setOnClickListener(view ->{
            startActivity(new Intent(getApplicationContext(), FragmentMenuActivity.class));
            finish();
        });
    }
}
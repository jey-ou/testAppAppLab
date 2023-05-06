package com.example.testapp_applab.AdapterDemos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.testapp_applab.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListViewArrayAdapter extends AppCompatActivity {

    Button btnAdd;
    EditText et_addname;
    ListView lv_listofnames;

    List<String> friends = new ArrayList<String>();
    String[] startingList = {"Anselm", "Beatrice","Carlisle","Dennis"};
    ArrayAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_array_adapter);

        btnAdd = findViewById(R.id.btn_add);
        et_addname = findViewById(R.id.et_addname);
        lv_listofnames = findViewById(R.id.lv_listofname);

        // initiate the list of names
        friends = new ArrayList<String>(Arrays.asList(startingList));
        ad = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,friends);

        lv_listofnames.setAdapter(ad);

        btnAdd.setOnClickListener((v)->{
            String newName = et_addname.getText().toString();
            friends.add(newName);
            Collections.sort(friends);

            ad.notifyDataSetChanged();
            et_addname.setText("");
        });

        lv_listofnames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "pos: " + i +" naam: " + friends.get(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
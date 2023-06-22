package com.example.testapp_applab.ProblemSolvers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.testapp_applab.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class SharedPrefsRecyclerViewActivity extends AppCompatActivity {

    private EditText etTaskEntry;
    private Button btn_add;
    private RecyclerView recyclerView;
    private TaskAdapter adapter;
    private List<ModelSP> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_prefs_recycler_view);

        addViews();
        makeClickableViews();

        taskList = PrefConfig.readListFromPrefs(this);
        if (taskList==null){
            taskList = new ArrayList<>();
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext()); // this
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true); // kan weggelaten worden
        adapter = new TaskAdapter(getApplicationContext(), (ArrayList<ModelSP>) taskList);
        recyclerView.setAdapter(adapter);

    }
    private void addViews() {
        etTaskEntry = findViewById(R.id.et_entry);
        btn_add = findViewById(R.id.btn_add);
        recyclerView = findViewById(R.id.sf_recyclerView);
    }
    private void makeClickableViews() {
        btn_add.setOnClickListener(view ->{

            ModelSP model = new ModelSP(etTaskEntry.getText().toString(),getDate());
            taskList.add(model);
            PrefConfig.writeListInPref(this, taskList);
            Collections.reverse(taskList);
            adapter.setLijst(taskList);     //.setTaskModelList(taskList);

            if(!etTaskEntry.getText().equals("")){
                etTaskEntry.setText("");
            }


        });
    }
    private String getDate() {

        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        //DateFormat.getDateInstance();
        // opmerking SimpleDateFormat heeft een ander constructor gekregen ntz
        return String.valueOf(dateFormat.format(date));
    }

}
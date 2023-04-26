package com.example.testapp_applab.JSONdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.testapp_applab.R;
import com.example.testapp_applab.model.Car;
import com.example.testapp_applab.model.CarList;

public class JsonDemoActivity extends AppCompatActivity {
    Button btn_load, btn_Save, btn_addcar, btn_clearlist, btn_fourcars;
    TextView tv_output;
    CarList list = new CarList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_demo);

        btn_load = findViewById(R.id.button_loadcar);
        btn_Save = findViewById(R.id.button_savecar);
        btn_addcar = findViewById(R.id.button_addcar);
        btn_clearlist = findViewById(R.id.button_clearlist);
        btn_fourcars = findViewById(R.id.button_fourcars);
        tv_output= findViewById(R.id.TextView_outputcarlist);

        tv_output.setText("");

        btn_fourcars.setOnClickListener(view -> {
            Car c1 = new Car("Ford", 2020);
            Car c2 = new Car("Chevy", 1993);
            Car c3 = new Car("Dodge", 1982);
            Car c4 = new Car("Bulk", 2019);
            list.getCarList().add(c1);
            list.getCarList().add(c2);
            list.getCarList().add(c3);
            list.getCarList().add(c4);

        });
    }
}
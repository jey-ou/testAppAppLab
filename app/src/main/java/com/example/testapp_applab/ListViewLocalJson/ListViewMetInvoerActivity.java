package com.example.testapp_applab.ListViewLocalJson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.testapp_applab.R;
import com.example.testapp_applab.Voorbeelden.RecyclerViewInterface;
import com.example.testapp_applab.model.GSONentry;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ListViewMetInvoerActivity extends AppCompatActivity implements RecyclerViewInterface {

    private ArrayList<GSONentry> lijst;
    private GSON_RecycleViewAdapter adapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_met_invoer);

        buildRecyclerView();
        initButtons();
    }

    private void deleteData() {
        if (lijst == null || lijst.isEmpty()) return;
        int aantal = lijst.size();
        lijst.clear();
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(lijst);

        editor.putString("task list", json); // voert een lege lijst in
        editor.apply();

        //aangeven van het verwijderen van alle items uit de opgegeven lijst
        adapter.notifyItemRangeRemoved(0,aantal);
    }

    private void buildRecyclerView() {

        lijst = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerViewGSON);
        loadData();

        adapter = new GSON_RecycleViewAdapter(this, lijst, this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        Log.i("SharedPrefsJSON","RecyclerBuild uitgevoerd");

    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onItemLongClick(int position) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
    private void initButtons(){
        Button btnLoad = findViewById(R.id.btn_loadSFGSON);
        Button btnSave = findViewById(R.id.btn_saveSFGSON);
        Button btnDelete = findViewById(R.id.btn_deleteSFGSON);
        Button btnClear = findViewById(R.id.btn_clearSFGSON);
        Button buttonInsert = findViewById(R.id.btn_InsertSFGSON);

        btnLoad.setOnClickListener(v ->{
            renewLoadData();
            Log.i("SharedPrefsJSON","Button load clicked");
        });

        btnClear.setOnClickListener(v ->{
            clearLijst();
            Log.i("SharedPrefsJSON","Button clear clicked");

        });

        btnSave.setOnClickListener(v->{
            saveData();
            Log.i("SharedPrefsJSON", "button save aangeklikt"); // te verwijderen
        });

        btnDelete.setOnClickListener(v ->{
            deleteData();
            Log.i("SharedPrefsJSON", "button delete aangeklikt"); // te verwijderen
        });

        buttonInsert.setOnClickListener(v ->{
                EditText line1 = findViewById(R.id.editTextGSONnaamSF);
                EditText line2 = findViewById(R.id.editTextGSONemailSF);
                EditText line3 = findViewById(R.id.editTextGSONinfoSF);
                insertItem(line1.getText().toString(), line2.getText().toString(), line3.getText().toString());
                Log.i("SharedPrefsJSON", "insertButton aangeklikt"); // te verwijderen
        });
    }

    private void clearLijst() {
        int aantal = lijst.size();
        lijst.clear();

        adapter.notifyItemRangeRemoved(0,aantal);
        Log.i("SharedPrefsJSON","Aantal items uit lijst gewist: "+ aantal);
    }
    private void insertItem(String line1, String line2, String line3) {
        lijst.add(new GSONentry(line1, line2, line3));
        adapter.notifyItemInserted(lijst.size());
        Log.i("SharedPrefsJSON","Nieuw item toegevoerg de lijst bevat: "+ lijst.size() + " items");
    }
    private void saveData() {
        //Log.i("SharedPrefsJSON", "saveData aangeroepen");
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(lijst);

        editor.putString("task list", json);
        editor.apply();


    }
    private void renewLoadData(){

        lijst.clear();
        adapter.notifyItemRangeRemoved(0,lijst.size());
        Log.i("SharedPrefsJSON","lijst bevat na wissen: "+ lijst.size() +" items");
        ArrayList<GSONentry> lijst2;

        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null); // ophalen data in "task list" opgeslagen
        Type type = new TypeToken<ArrayList<GSONentry>>() {}.getType(); // bepalen type lijst = ArrayList<GSONentry>
        lijst2 = gson.fromJson(json, type); // data lijst opbouwen met de opgeslagen json sting in "task list"

        Log.i("SharedPrefsJSON","lijst bevat na inladen: "+ lijst2.size() +" items");
        if (lijst2 == null) {
            lijst2 = new ArrayList<>();
        }
        for ( GSONentry g: lijst2) {
            lijst.add(g);
            adapter.notifyItemInserted(lijst.size());
        }

        Log.i("SharedPrefsJSON","Aantal items ingeladen: "+ lijst.size());
    }
    private void loadData() {
        // instantie van SharedPrefence ophalen
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null); // ophalen data in "task list" opgeslagen
        Type type = new TypeToken<ArrayList<GSONentry>>() {}.getType(); // bepalen type lijst = ArrayList<GSONentry>
        lijst = gson.fromJson(json, type); // data lijst opbouwen met de opgeslagen json sting in "task list"

        if (lijst == null) {
            lijst = new ArrayList<>();
        }

    }


}
package com.example.testapp_applab.Voorbeelden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testapp_applab.R;
import com.example.testapp_applab.model.User;
import com.google.gson.Gson;

public class WithSharedPreferenceActivity extends AppCompatActivity {
    EditText mEmailView, mPasswordView,mUserName, mAge, mInfoSF, mUserNameSF;
    Button btn_SaveFBA, btn_mSkipFBA, btn_SaveSF, btn_ReadSF, btn_DeleteSF;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_shared_preference);
        sharedPreferences = getSharedPreferences("Data",MODE_PRIVATE);

        mEmailView = findViewById(R.id.edtEmailFBA);
        mUserName = findViewById(R.id.edtNameFBA);
        mPasswordView = findViewById(R.id.edtPasswordFBA);

        mAge = findViewById(R.id.edtAgeSF);
        mUserNameSF = findViewById(R.id.edtNaamSF);
        mInfoSF = findViewById(R.id.edtInfoSF);

        btn_SaveSF = findViewById(R.id.btnSaveSF);
        btn_ReadSF = findViewById(R.id.btnReadSF);
        btn_DeleteSF= findViewById(R.id.btnDeleteSF);

        btn_SaveSF.setOnClickListener(v->{
            User user = new User(mUserName.getText().toString(), mEmailView.getText().toString(), mPasswordView.getText().toString(),"");
            Gson gson = new Gson();
            String json = gson.toJson(user);

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("JSONuser", json); // test
            editor.putString("username", mUserName.getText().toString());
            editor.putString("email adres", mEmailView.getText().toString());
            editor.putString("password", mPasswordView.getText().toString());
            editor.apply();
            Toast.makeText(getApplicationContext(), "Data opgeslagen", Toast.LENGTH_SHORT).show();

            mUserName.setText("");
            mEmailView.setText("");
            mPasswordView.setText("");

            mUserNameSF.setText("");
            mInfoSF.setText("");
            mAge.setText("");
        });

        btn_ReadSF.setOnClickListener(v -> {
            mUserNameSF.setText("");
            mInfoSF.setText("");
            mAge.setText("");

            if (sharedPreferences.contains("username")){
                mUserNameSF.setText(sharedPreferences.getString("username", ""));
            }
            if (sharedPreferences.contains("email adres")){
                mAge.setText(sharedPreferences.getString("email adres", ""));
            }
            if (sharedPreferences.contains("password")){
                mInfoSF.setText(sharedPreferences.getString("password", ""));
            }
            Toast.makeText(getApplicationContext(), "Data opgehaald en weergegeven", Toast.LENGTH_SHORT).show();
        });

        btn_DeleteSF.setOnClickListener(v ->{
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();

            mUserName.setText("");
            mEmailView.setText("");
            mPasswordView.setText("");

            mUserNameSF.setText("");
            mInfoSF.setText("");
            mAge.setText("");

            Toast.makeText(getApplicationContext(), "Data verwijdert uit shared Preferences", Toast.LENGTH_SHORT).show();
        });



    }
}
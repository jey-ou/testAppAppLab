package com.example.testapp_applab.JSONdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.testapp_applab.R;
import com.example.testapp_applab.SignInOut.TestenActivity;
import com.example.testapp_applab.model.Adress;
import com.example.testapp_applab.model.Employee;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;

public class GsonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);

        Gson gson = new Gson();

        Button btnTest1 = findViewById(R.id.buttonJSONTest1);
        Button btnTest2 = findViewById(R.id.buttonJSONTest2);
        Button btnTest3 = findViewById(R.id.buttonJSONTest3);
        Button btnHome = findViewById(R.id.buttonJsonHome);
        Button btnTest4 = findViewById(R.id.buttonJSONTest4);
        TextView tvResultaat = findViewById(R.id.et_rs_testJSON2);

        btnTest1.setOnClickListener((view -> {
            String header = "JSON test 1\n\n";
            String body = "In dit onderdeel kijken we na of de instance van de klasse Employee met attributen: \n ";
            body += "firstName, age en mail,\n die omgezet kunnen worden in een JSON file.\n";
            body += "Employe wordt geïnitialiseerd met: \n\nnew Employee(\"John\", 30, \"john@gmail.com\");\n";

            Employee employee = new Employee("John", 30, "john@gmail.com");
            String json =gson.toJson(employee);
            body += "\nVervolgens omgezet in een json string met:\n";
            body += "String json =gson.toJson(employee)\n";
            body += "\nHet resultaat van deze omzetting:\n";
            body += json;
            Log.i("inhoud GSON ", json);
            String footer = "\n\nJe kan dit ook volgen in de Logcat van android";
            tvResultaat.setText(header + body + footer);
        }));

        btnTest2.setOnClickListener((view -> {
            String header = "JSON test 2\n\n";
            String body = "Hierbij wordt zelf een Json file aangemaakt, met de nodige moeilijkheden.";
            body += "\n{\"age\": 30,\"firstName\": \"John\",\"mail\": \"john@gmail.com\"}";

            String json = "{\"age\": 30,\"firstName\": \"John\",\"mail\": \"john@gmail.com\"}";

            Log.i("Eerste test GsonActivity:", "inhoud JSON string " + json);

            Employee employee = gson.fromJson(json, Employee.class);
            Log.i("GSON tweede test Employee: ",  employee.toString());

            body += "\n\n en zetten dit om in een object employee van\n";
            body += "employee = gson.fromJson(json, Employee.class);\n\n";
            body += "De inhoud van het object employee kan uitgelezen worden met:\n";
            body += "employee.toString()\n\n";
            body += "het resultaat is: \n";
            body += employee.toString();


            String footer = "\n\nJe kan dit ook volgen in de Logcat van android";
            tvResultaat.setText(header + body + footer);
        }));

        btnTest3.setOnClickListener(view -> {
            String header = "JSON test 3\n\n";
            String body = "Deze test vertrekt van een eigen aangemaakte json file ";
            body += "die we inbrengen in een employee object.\n\n";
            body += "String json = \n{\"age\": 30,\"firstName\": \"John\",\"mail\": \"john@gmail.com\"}";
            body += "die omgezet wordt met :\n";

            String json = "{\"age\": 30,\"firstName\": \"John\",\"mail\": \"john@gmail.com\"}";
            Employee employee = gson.fromJson(json, Employee.class);

            body += "employee = gson.fromJson(json, Employee.class);";
            body += "\nHet resultaat is:\n";
            body += body += employee.toString();

            Log.i("Derde test GSON: ",  employee.toString());

            String footer = "\n\nJe kan dit ook volgen in de Logcat van android";
            tvResultaat.setText(header + body + footer);
        });

        btnHome.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), TestenActivity.class);
            startActivity(intent);
        });

        btnTest4.setOnClickListener((view -> {
            String header = "JSON test 3\n\n";
            String body = "Deze vierde test gebruikt twee objecten Employee en Adress. ";
            body += "Employee neemt het object adres op in zijn class:\n\n";

            Adress adress = new Adress("Germany", "Berlin");
            Employee employee = new Employee("John", 30, "john@gmail.com", adress);
            String json = gson.toJson(employee);
            Log.i("SharedPrefsJSON",  employee.toString());

            body += json;
            body +="\n\n Deze omzetting verloopt eveneens feilloos";
            String footer = "\n\nJe kan dit ook volgen in de Logcat van android";
            tvResultaat.setText(body);
        }));
        /* deel 1 van de test: creatie van een employee object file naar een json format
        Employee employee = new Employee("John", 30, "john@gmail.com");
        String json1 =gson.toJson(employee);
        // object omgezet in json object
        Log.i("inhoud GSON ", json1);
        */

        /* deel 2 van de test omzetten van de json3 variabele in een variabele object
        String json3 = "{\"age\": 30,\"firstName\": \"John\",\"mail\": \"john@gmail.com\"}";

        Log.i("Eerste test GsonActivity:", "inhoud JSON string " + json3);

        Employee employee1 = gson.fromJson(json3, Employee.class);
        Log.i("Tweede test Employee: ",  employee1.toString());
        */
        /*deel 3: nazicht van een geserializeerde klasse employee
        // String json3 wordt hergebruikt
        String json3 = "{\"age\": 30,\"firstName\": \"John\",\"mail\": \"john@gmail.com\"}";
        Employee employee2 = gson.fromJson(json3, Employee.class);
        Log.i("Derde test Employee: ",  employee2.toString());

        /* deel a1
        Adress adress = new Adress("Germany", "Berlin");
        Employee employee = new Employee("John", 30, "john@gmail.com", adress);
        String json = gson.toJson(employee);
        tvResultaat.setText(json);
        */

        //deel a2
        String json = "{\"adress\":{\"city\": \"New York\",\"country\":\"USA\"},\"age\": 30,\"firstName\": \"John\",\"mail\": \"john@gmail.com\"}";
        Employee employee = gson.fromJson(json, Employee.class);
        Log.i("tweede reeks test GsonActivity:", "inhoud JSON string " + json);
        tvResultaat.setText(employee.toString());



        String dollarJson = "{ '1$': { 'amount': 1, 'currency': 'Dollar'}," +
                "'2$': { 'amount': 2, 'currency': 'Dollar'}, " +
                "'3€': { 'amount': 3, 'currency': 'Euro'} }";

        //Gson gson = new Gson();

        Type amountCurrencyType =
                new TypeToken<HashMap<String, AmountWithCurrency>>(){}.getType();

        HashMap<String, AmountWithCurrency> amountCurrency =
                gson.fromJson(dollarJson, amountCurrencyType);

    }



}
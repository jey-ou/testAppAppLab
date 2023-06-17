package com.example.testapp_applab.FragmentDrawer;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.widget.Toolbar;

import com.example.testapp_applab.R;
import com.google.android.material.navigation.NavigationView;

public class FragmentDrawerActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_drawer);

        drawerLayout = findViewById(R.id.drawer_layout_FDW);
        navigationView= findViewById(R.id.navView_layoutFDW);

        toolbar = findViewById((R.id.nav_view));
        //setSupportActionBar(toolbar);

        //actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,"open", "close");


    }
}
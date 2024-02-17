package com.example.aptitudetest;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class Lessontostudy extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    Button button1;
    Button button2;
    Button button3;
    Button button4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessontostudy);

        /*-----------------------------Hooks----------------------------------------------*/
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        toolbar= findViewById(R.id.toolbar1);

        /*-----------------------------Toolbar----------------------------------------------*/
        setSupportActionBar(toolbar);

        /*-----------------------------Navigation drawer menu----------------------------------------------*/
        //makes profile and logout button invisible from navigation menu


        //working of navigation layout
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        navigationView.setItemIconTintList(null);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        button1 = findViewById(R.id.btn_boat);
        button1.setOnClickListener(v -> Boat());

        button2 = findViewById(R.id.btn_calender);
        button2.setOnClickListener(v -> calend());

        button3 = findViewById(R.id.btn_clock);
        button3.setOnClickListener(v -> clock());

        button4 = findViewById(R.id.btn_train);
        button4.setOnClickListener(v -> train());

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.nav_home) {
            Intent intent1 = new Intent(Lessontostudy.this, MainActivity2.class);
            startActivity(intent1);
        } else if (item.getItemId() == R.id.nav_profile) {
            Intent intent2 = new Intent(Lessontostudy.this, profile.class);
            startActivity(intent2);
        }
        return true;
    }



    //on pressing buttons leads to respective activity
    public void Boat() {
        Intent intent = new Intent(Lessontostudy.this, boat.class);
        startActivity(intent);
    }
        public void calend() {
            Intent intent = new Intent(Lessontostudy.this, calender.class);
            startActivity(intent);
    }

    public void clock() {
        Intent intent = new Intent(Lessontostudy.this, clockk.class);
        startActivity(intent);
    }

    public void train() {
        Intent intent = new Intent(Lessontostudy.this, train.class);
        startActivity(intent);
    }

}
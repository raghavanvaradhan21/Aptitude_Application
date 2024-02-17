package com.example.aptitudetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class Test extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
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
        setContentView(R.layout.activity_test);

        /*-----------------------------Hooks----------------------------------------------*/
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        toolbar = findViewById(R.id.toolbar4);

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
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.freeonlinetest.in/competitive-exams/question-and-answer/aptitude-online-test/boats-and-streams\n");
            }
        });

        button2 = findViewById(R.id.btn_calender);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.freeonlinetest.in/competitive-exams/question-and-answer/aptitude-online-test/calendar\n");
            }
        });

        button3 = findViewById(R.id.btn_clock);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.freeonlinetest.in/competitive-exams/question-and-answer/aptitude-online-test/clocks\n");
            }
        });

        button4 = findViewById(R.id.btn_train);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.freeonlinetest.in/competitive-exams/question-and-answer/aptitude-online-test/problems-on-trains-");
            }
        });
    }


    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }



    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }  else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.nav_home) {
            Intent intent1 = new Intent(Test.this, MainActivity2.class);
            startActivity(intent1);

        }  else if (item.getItemId() == R.id.nav_home) {
            Intent intent2 = new Intent(Test.this, MainActivity2.class);
            startActivity(intent2);
        }
        return true;
    }

}
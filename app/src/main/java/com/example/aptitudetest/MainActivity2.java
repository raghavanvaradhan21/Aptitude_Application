package com.example.aptitudetest;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //variables

    FirebaseAuth auth;
    FirebaseUser user;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ImageButton imgButton1;
    ImageButton imgButton2;
    ImageButton imgButton3;
    ImageButton imgButton4;
    ImageButton imgButton5;



    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        /*-----------------------------Hooks----------------------------------------------*/
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        toolbar = findViewById(R.id.toolbar);
        auth=FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        if(user==null)
        {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        }

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

        //each button leads to its own activity
        imgButton1 = findViewById(R.id.learn);
        imgButton1.setOnClickListener(v -> LessonToStudy());

        imgButton2 = findViewById(R.id.solved_button);
        imgButton2.setOnClickListener(v -> Solved());

        imgButton3 = findViewById(R.id.practice_button);
        imgButton3.setOnClickListener(v -> Practice());

        imgButton4 = findViewById(R.id.test_btn);
        imgButton4.setOnClickListener(v -> Test());

        imgButton5 = findViewById(R.id.tips_btn);
        imgButton5.setOnClickListener(v -> Tips());
    }

    //on pressing back button app will not close
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }  else {
            super.onBackPressed();
        }
    }

    @SuppressLint("NonConstantResourceId")
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.nav_home) {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }

        }else if (item.getItemId() == R.id.nav_profile) {
            Intent intent1 = new Intent(MainActivity2.this, profile.class);
            startActivity(intent1);
        }

        return true;
    }


    public void LessonToStudy() {
        Intent intent = new Intent(MainActivity2.this, Lessontostudy.class);
        startActivity(intent);
    }


    public void Solved() {
        Intent intent = new Intent(MainActivity2.this, Solved.class);
        startActivity(intent);
    }


    public void Practice() {
        Intent intent = new Intent(MainActivity2.this, Practice.class);
        startActivity(intent);
    }

    public void Test() {
        Intent intent = new Intent(MainActivity2.this, Test.class);
        startActivity(intent);
    }

    public void Tips() {
        Intent intent = new Intent(MainActivity2.this, Tips.class);
        startActivity(intent);
    }



}
package com.example.aptitudetest;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class profile extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    Button button1;
    //edit profile
    Button button2;
    //change password
    Button button3;
    //logout button

    FirebaseAuth nauth;

    FirebaseFirestore fstore;

    String Userid;
    //find user using user id stored in firestore

     TextView greetingTextView;
     TextView fullNameTextView;

     TextView emailTextView;

     TextView phoneTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        /*-----------------------------Hooks----------------------------------------------*/
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        toolbar= findViewById(R.id.toolbar6);

         nauth = FirebaseAuth.getInstance();
         fstore = FirebaseFirestore.getInstance();
         greetingTextView = findViewById(R.id.name);
         fullNameTextView = findViewById(R.id.emptyname);
         emailTextView = findViewById(R.id.emptyemail);
         phoneTextView = findViewById(R.id.emptyphone);

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

        button1 = findViewById(R.id.btn_edit_profile);
       // button1.setOnClickListener(v -> edit());

        button2 = findViewById(R.id.btn_password);
        //button2.setOnClickListener(v -> pass());


        button3 = findViewById(R.id.btn_logout);
        button3.setOnClickListener(v -> logout());


        Userid = nauth.getCurrentUser().getUid();
        DocumentReference documentReference = fstore.collection("Users").document(Userid);
        documentReference.addSnapshotListener(profile.this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                greetingTextView.setText(value.getString("Name"));
                fullNameTextView.setText(value.getString("Name"));
                emailTextView.setText(value.getString("Email"));
                phoneTextView.setText(value.getString("Phone"));
            }
        });




    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            moveTaskToBack(true);
        }
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.nav_profile) {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }

        } else if (item.getItemId() == R.id.nav_home) {
            Intent intent1 = new Intent(profile.this, MainActivity2.class);
            startActivity(intent1);
            finish();
        }

        return true;
    }

    public void logout(){
        logoutMenu(profile.this);
    }


    private void logoutMenu(profile profile){
        AlertDialog.Builder builder = new AlertDialog.Builder(profile);
        builder.setTitle("Logout");
        builder.setMessage("Are you sure ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finishAffinity();
            }
        });
        builder.setNegativeButton("No", (dialog, i) -> dialog.dismiss());
        builder.show();
    }


    //on pressing buttons leads to respective activity




}
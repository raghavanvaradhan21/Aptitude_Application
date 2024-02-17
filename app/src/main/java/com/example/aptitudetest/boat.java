package com.example.aptitudetest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class boat extends AppCompatActivity {
    DrawerLayout drawerLayout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        drawerLayout = findViewById(R.id.drawer_layout);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boat);

        PDFView pdfview = findViewById(R.id.boatformula);
        pdfview.fromAsset("boatformula.pdf").load();
    }


    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }  else {
            super.onBackPressed();
        }
    }
}
package com.example.aptitudetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class clockk extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clockk);


        PDFView pdfview = findViewById(R.id.clockformula);
        pdfview.fromAsset("clockformula.pdf").load();

    }
}
package com.example.aptitudetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class clockksolved extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clockksolved);

        PDFView pdfview = findViewById(R.id.clocksolved);
        pdfview.fromAsset("clocksolvedquestions.pdf").load();
    }
}
package com.example.aptitudetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class calendersolved extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendersolved);

        PDFView pdfview = findViewById(R.id.calendersolved);
        pdfview.fromAsset("calendarsolvedquestions.pdf").load();
    }
}
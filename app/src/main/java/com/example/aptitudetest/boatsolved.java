package com.example.aptitudetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class boatsolved extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boatsolved);

        PDFView pdfview = findViewById(R.id.boatsolved);
        pdfview.fromAsset("BoatSolvedQuestions.pdf").load();
    }
}
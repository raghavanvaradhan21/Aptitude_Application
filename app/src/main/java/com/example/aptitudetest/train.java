package com.example.aptitudetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class train extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);

        PDFView pdfview = findViewById(R.id.trainformula);
        pdfview.fromAsset("trainformula.pdf").load();
    }
}
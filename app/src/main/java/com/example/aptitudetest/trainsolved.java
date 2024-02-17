package com.example.aptitudetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class trainsolved extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainsolved);

        PDFView pdfview = findViewById(R.id.trainsolved);
        pdfview.fromAsset("trainsolved.pdf").load();
    }
}
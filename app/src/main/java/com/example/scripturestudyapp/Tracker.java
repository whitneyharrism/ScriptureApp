package com.example.scripturestudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class Tracker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);
        Button btn = findViewById(R.id.button2);

        TextView textView = findViewById(R.id.textView);

        final TextView textView1 = findViewById(R.id.textView2);

        final ProgressBar prg = findViewById(R.id.progressBar);

        int value = prg.getProgress();

        textView1.setText(Integer.toString(value));

        textView.setText("Goal: Read so many days");

        btn.setText("Did you do it?");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeProgress(prg, textView1);

            }
        });

        prg.setProgress(prg.getProgress());

    }

    public void changeProgress(ProgressBar p, TextView e){

        p.incrementProgressBy(5);

        int value = p.getProgress();

        p.setProgress(value);

        e.setText(Integer.toString(value));
    }

}
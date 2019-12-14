package com.example.scripturestudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DecimalFormat;


public class Tracker extends AppCompatActivity {
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference = firebaseDatabase.getReference();
    private DatabaseReference trackerReference = mRootReference.child("tracker");
    int day;
    double percentRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);
        final Button btn = findViewById(R.id.button2);

        TextView goal = findViewById(R.id.goal);

        final TextView percentReadText = findViewById(R.id.textView2);

        final ProgressBar prg = findViewById(R.id.progressBar);

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);

        int value = sharedPreferences.getInt("progressTrack", 0);
        percentRead = 0;
        percentReadText.setText(Integer.toString(value)+"%");

        //goal.setText("Goal: Read "+goalDays from database+" times this month");

        btn.setText("Day 0");

        prg.setProgress(value);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeProgress(prg, percentReadText);

                Toast.makeText(Tracker.this,"value set",Toast.LENGTH_SHORT).show();
                day++;
                percentRead += 1/5;
                //if(day < goalDays)
                btn.setText("Day "+day);
                //else
                //{btn.setEnabled(false);btn.setText("Reading goal met");
            }
        });
        day = 0;


        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("progressTrack",prg.getProgress());
        editor.commit();


    }

    public void changeProgress(ProgressBar p, TextView e){

        p.incrementProgressBy(5);

        int value = p.getProgress();

        e.setText(Integer.toString(value)+"%");
    }
}
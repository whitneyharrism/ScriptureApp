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



public class Tracker extends AppCompatActivity {
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference = firebaseDatabase.getReference();
    private DatabaseReference trackerReference = mRootReference.child("tracker");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);
        Button btn = findViewById(R.id.button2);

        TextView textView = findViewById(R.id.textView);

        final TextView textView1 = findViewById(R.id.textView2);

        final ProgressBar prg = findViewById(R.id.progressBar);

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);

        int value = sharedPreferences.getInt("progressTrack", 0);

        textView1.setText(Integer.toString(value)+"%");

        textView.setText("Goal: Read so many days");

        btn.setText("Did you do it?");

        prg.setProgress(value);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeProgress(prg, textView1);

                Toast.makeText(Tracker.this,"value set",Toast.LENGTH_SHORT).show();


            }
        });


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
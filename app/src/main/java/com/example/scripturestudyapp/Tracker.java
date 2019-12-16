package com.example.scripturestudyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.Date;


public class Tracker extends AppCompatActivity {
    int day;
    int percentRead;
    int goalDays;
    int lastReadMonth;
    int lastReadDay;
    Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);
        final Button btn = findViewById(R.id.button2);
        final TextView goal = findViewById(R.id.goal);
        final TextView percentReadText = findViewById(R.id.textView2);
        final ProgressBar prg = findViewById(R.id.progressBar);

        FirebaseDatabase.getInstance().getReference().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                goal.setText("Goal: Read "+dataSnapshot.child("ReadingTracker").child("GoalDays").getValue()+" times this month");
                goalDays = Integer.parseInt(dataSnapshot.child("ReadingTracker").child("GoalDays").getValue().toString());
                prg.setProgress(Integer.parseInt(dataSnapshot.child("ReadingTracker").child("percentage").getValue().toString()));
                percentRead = Integer.parseInt(dataSnapshot.child("ReadingTracker").child("percentage").getValue().toString());
                percentReadText.setText(dataSnapshot.child("ReadingTracker").child("percentage").getValue().toString()+"%");
                lastReadMonth = Integer.parseInt(dataSnapshot.child("ReadingTracker").child("lastReadMonth").getValue().toString());
                lastReadDay = Integer.parseInt(dataSnapshot.child("ReadingTracker").child("lastReadDay").getValue().toString());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        //Check if new month
        date = new Date();
        if(date.getMonth() != lastReadMonth) {
            prg.setProgress(0);
            FirebaseDatabase.getInstance().getReference()/*.child(FirebaseAuth.getInstance().getCurrentUser().getUid())*/.child("ReadingTracker").child("month").setValue(date.getMonth());
        }


       btn.setText("Day "+ day);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                //++day;

                if(day < goalDays && date.getDay() != lastReadDay)
                {changeProgress(prg, percentReadText);btn.setText("Day "+day);}
                else if(date.getDay() == lastReadDay)
                {
                    btn.setEnabled(false);btn.setText("Marked as read today");
                }
                else
                {btn.setEnabled(false);btn.setText("Reading goal met");}
            }
        });
        day = 1;
    }

    public void changeProgress(ProgressBar prg, TextView percentText){
        double temp1 = goalDays;
        double temp2 = (1.0/temp1)*100.0;
        percentRead = (int)temp2;


        prg.incrementProgressBy(Math.round(percentRead));
        int percent = prg.getProgress();
        percentText.setText(percent+"%");
        FirebaseDatabase.getInstance().getReference().child("ReadingTracker").child("percentage").setValue(percent);
        double temp3 = Math.round(((double)percent/100.0)*goalDays);
        day = (int)temp3;
        if(day == goalDays) {prg.setProgress(100);Log.e("thing","set 100");}
        Log.e("thing",""+day + " " + goalDays);
    }
}
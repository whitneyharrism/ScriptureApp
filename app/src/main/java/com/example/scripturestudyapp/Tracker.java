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

    Button btn;
    TextView goal;
    TextView percentReadText;
    ProgressBar prg;
    Date currentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);

        //find views
        btn =findViewById(R.id.button2);
        goal = findViewById(R.id.goal);
        percentReadText = findViewById(R.id.textView2);
        prg = findViewById(R.id.progressBar);
        currentDate = new Date();


        //Get current data from database for initial display
        FirebaseDatabase.getInstance().getReference().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                goal.setText("Goal: Read "+dataSnapshot.child("ReadingTracker").child("GoalDays").getValue()+" times this month");
                goalDays = Integer.parseInt(dataSnapshot.child("ReadingTracker").child("GoalDays").getValue().toString());
                prg.setProgress(Integer.parseInt(dataSnapshot.child("ReadingTracker").child("percentage").getValue().toString()));
                percentRead = Integer.parseInt(dataSnapshot.child("ReadingTracker").child("percentage").getValue().toString());
                percentReadText.setText(dataSnapshot.child("ReadingTracker").child("percentage").getValue().toString()+"%");
                lastReadMonth = Integer.parseInt(dataSnapshot.child("ReadingTracker").child("lastReadMonth").getValue().toString());
                //Check if new month
                if(currentDate.getMonth() != lastReadMonth) {
                    Log.e("test",""+currentDate.getMonth() + " " + lastReadMonth);
                    prg.setProgress(0);
                    FirebaseDatabase.getInstance().getReference().child("ReadingTracker").child("month").setValue(currentDate.getMonth());
                    FirebaseDatabase.getInstance().getReference().child("ReadingTracker").child("percentage").setValue(0);
                }
                lastReadDay = Integer.parseInt(dataSnapshot.child("ReadingTracker").child("lastReadDay").getValue().toString());
                //Check if new day
                if(getDay(prg) < goalDays && currentDate.getDay() != lastReadDay)
                {btn.setText("Day "+getDay(prg));}
                else if(currentDate.getDay() == lastReadDay)
                { btn.setEnabled(false);btn.setText("Marked as read today"); }
                else
                {btn.setEnabled(false);btn.setText("Reading goal met");}
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

Log.e("latest", "last: "+lastReadDay + " " + currentDate.getDay());
                if(day < goalDays && currentDate.getDay() != lastReadDay)
                    {changeProgress(prg, percentReadText);btn.setText("Day "+getDay(prg));}
                else if(currentDate.getDay() == lastReadDay)
                    { btn.setEnabled(false);btn.setText("Marked as read today"); }
                else
                    {btn.setEnabled(false);btn.setText("Reading goal met");}
            }
        });
        day = 1;
    }

    public void changeProgress(ProgressBar prg, TextView percentText){
        //set increment value
        double temp1 = goalDays;
        double temp2 = (1.0/temp1)*100.0;
        percentRead = (int)temp2;

        prg.incrementProgressBy(Math.round(percentRead));

        //set percentageBox text
        percentText.setText(prg.getProgress()+"%");
        FirebaseDatabase.getInstance().getReference().child("ReadingTracker").child("percentage").setValue(prg.getProgress());
        FirebaseDatabase.getInstance().getReference().child("ReadingTracker").child("lastReadDay").setValue(currentDate.getDay());
        FirebaseDatabase.getInstance().getReference().child("ReadingTracker").child("lastReadMonth").setValue(currentDate.getMonth());

        //set goalButton text

        if(getDay(prg) == goalDays) {prg.setProgress(100);Log.e("thing","set 100");}
        //Log.e("thing",""+day + " " + goalDays);
    }
    public int getDay(ProgressBar prg){
        //Log.e("tracker", ""+(double)prg.getProgress());
        return (int)Math.round(((double)prg.getProgress()/100.0)*goalDays);
    }
}
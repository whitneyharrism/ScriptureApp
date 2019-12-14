package com.example.scripturestudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;

import java.util.LinkedList;

/**
 * Activity were you will see and set your notifications
 */
public class Profile extends AppCompatActivity {
    String userName;
    String password;
    //notification
    int goalDays;
    int goalPercComplete;
    EditText goalDaysBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //get user nme
        goalDaysBox = findViewById(R.id.goalDaysBox);
        goalDaysBox.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean b) {
                if(b == false) {
                    goalDays = Integer.parseInt(goalDaysBox.getText().toString());
                    FirebaseDatabase.getInstance().getReference().child("ReadingTracker").child("GoalDays").setValue(goalDays);
                }
            }
        });
    }

    public void displayNotifications(String message)
    {

    }

    public void muteNotifications()
    {

    }


}

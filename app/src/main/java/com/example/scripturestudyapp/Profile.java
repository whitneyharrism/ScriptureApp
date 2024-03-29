package com.example.scripturestudyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Activity were you will see and set your notifications
 */
public class Profile extends AppCompatActivity {
    //notification
    int goalDays;
    int goalPercComplete;
    EditText goalDaysBox;
    TextView userNameBox, scoresBox;
    String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        /////////////////////////////////////////////get user name////////////////////////////////////
        userNameBox = findViewById(R.id.userNameBox);
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user !=null){
            String email = user.getEmail();
            userNameBox.setText(email);
        }

        ///////////////////////////////////////////////////////////Scores//////////////////////////////
        scoresBox = findViewById(R.id.bookOfMormonBox);
        //bookOfMormonScore.setText(FirebaseDatabase.getInstance().getReference().child("Quiz").child("BOMQuiz").child("score").getValue());
        DatabaseReference scoreDatabase = FirebaseDatabase.getInstance().getReference().child("Quiz");
        DatabaseReference readingTrackDatabase = FirebaseDatabase.getInstance().getReference().child("ReadingTracker");
        scoreDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String BOMScore = dataSnapshot.child("BOMQuiz").child("score").getValue().toString();
                scoresBox.setText(BOMScore);
                scoresBox.append("\n"+dataSnapshot.child("DCQuiz").child("score").getValue().toString());
                scoresBox.append("\n"+dataSnapshot.child("OTQuiz").child("score").getValue().toString());
                scoresBox.append("\n"+dataSnapshot.child("NTQuiz").child("score").getValue().toString());
                scoresBox.append("\n"+dataSnapshot.child("InvQuiz").child("score").getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.");
            }
        });

        ////////////////////////////Goal Day///////////////////////////////////////////////
        readingTrackDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                goalDaysBox = findViewById(R.id.goalDaysBox);
                goalDaysBox.setText(""+dataSnapshot.child("GoalDays").getValue());
                double temp1 = Integer.parseInt(dataSnapshot.child("GoalDays").getValue().toString());
                Log.e("e", ""+goalDays);
                double temp2 = (1.0/temp1)*100.0;
                int percentRead = (int)temp2;
                Log.e("e", ""+percentRead);
                FirebaseDatabase.getInstance().getReference().child("ReadingTracker").child("percentage").setValue(percentRead);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.");
            }
        });
    }

    public void displayNotifications(String message)
    {

    }

    public void muteNotifications()
    {

    }
    public void saveNewGoal(View view){
        goalDaysBox = findViewById(R.id.goalDaysBox);
        goalDays = Integer.parseInt(goalDaysBox.getText().toString());
        FirebaseDatabase.getInstance().getReference().child("ReadingTracker").child("GoalDays").setValue(goalDays);
    }
    public void logOut(View view){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

}

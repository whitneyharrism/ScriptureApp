package com.example.scripturestudyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
    String userName;
    String password;
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
        DatabaseReference BOMDatabase = FirebaseDatabase.getInstance().getReference().child("Quiz");
        BOMDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //bookOfMormonScore = (TextView) dataSnapshot.getValue();
                String BOMScore = dataSnapshot.child("BOMQuiz").child("score").getValue().toString();
                //Toast.makeText(Profile.this,BOMScore,Toast.LENGTH_SHORT).show();
                Log.w(TAG, dataSnapshot.child("CAQuiz").child("score").getValue().toString());
                scoresBox.setText(BOMScore);
                scoresBox.append("\n"+dataSnapshot.child("CAQuiz").child("score").getValue().toString());
                scoresBox.append("\n"+dataSnapshot.child("OTQuiz").child("score").getValue().toString());
                scoresBox.append("\n"+dataSnapshot.child("NTQuiz").child("score").getValue().toString());
                scoresBox.append("\n"+dataSnapshot.child("InvQuiz").child("score").getValue().toString());
                goalDaysBox.setText(dataSnapshot.child("ReadingTracker").child("goalDays").getValue().toString());
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
        goalDays = Integer.parseInt(goalDaysBox.getText().toString());
        FirebaseDatabase.getInstance().getReference().child("ReadingTracker").child("GoalDays").setValue(goalDays);
    }

}

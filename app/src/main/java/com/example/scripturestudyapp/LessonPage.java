package com.example.scripturestudyapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * LessonPage is the individual lesson that the user creates.
 */
public class LessonPage extends AppCompatActivity {

    private String note;
    private String link[];
    final String TAG = "LessonPage";
    EditText commitment,message,notes;
    TextView links;
    final DatabaseReference LessonDatabase = FirebaseDatabase.getInstance().getReference().child("LessonOne");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "emailing students", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        commitment = findViewById(R.id.commitmentBox);
        message = findViewById(R.id.messageBox);
        notes = findViewById(R.id.notesBox);
        links = findViewById(R.id.linkWriter);
        load();
    }

    public void addLink(){}

    public void save(){


        LessonDatabase.child("commitment").setValue(commitment.getText().toString());
        LessonDatabase.child("message").setValue(message.getText().toString());
        LessonDatabase.child("notes").setValue(notes.getText().toString());
        LessonDatabase.child("links").setValue(links.getText().toString());
    }
    public void load(){
        LessonDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                commitment.setText(dataSnapshot.child("commitment").getValue().toString());
                message.setText(dataSnapshot.child("message").getValue().toString());
                notes.setText(dataSnapshot.child("notes").getValue().toString());
                links.setText(dataSnapshot.child("links").getValue().toString());

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.");
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        save();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        save();
    }
}

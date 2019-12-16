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
    EditText commitment,message,notes, title, linkWriter;
    TextView myLinks;
    DatabaseReference LessonDatabase = FirebaseDatabase.getInstance().getReference().child("Lesson").child("LessonOne");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_page);

        commitment = findViewById(R.id.commitmentBox);
        message = findViewById(R.id.messageBox);
        notes = findViewById(R.id.notesBox);
        linkWriter = findViewById(R.id.linkWriter);
        title = findViewById(R.id.titleBox);
        myLinks = findViewById(R.id.myLinksBox);
        load();
    }

    public void addLink(View view){
        myLinks.append(myLinks.getText());
    }

    public void save(){
        LessonDatabase.child("commitment").setValue(commitment.getText().toString());
        LessonDatabase.child("message").setValue(message.getText().toString());
        LessonDatabase.child("notes").setValue(notes.getText().toString());
        LessonDatabase.child("links").setValue(myLinks.getText().toString());
        LessonDatabase.child("title").setValue(title.getText().toString());
    }
    public void load(){
        LessonDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                commitment.setText(dataSnapshot.child("commitment").getValue().toString());
                message.setText(dataSnapshot.child("message").getValue().toString());
                notes.setText(dataSnapshot.child("notes").getValue().toString());
                myLinks.setText(dataSnapshot.child("links").getValue().toString());
                title.setText(dataSnapshot.child("title").getValue().toString());

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

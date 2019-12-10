package com.example.scripturestudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * LessonPlanner is where user can add lesson plans to their profile.
 * It will take in user information, and that is stored on the database.
 */
public class LessonPlanner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_planner);
    }
    public void openLesson(){}
    public void deleteLesson(){}
    public void addLesson(){}
}

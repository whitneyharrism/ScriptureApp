package com.example.scripturestudyapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Will store the users test history and return their current percentage.
 */
public class KnowledgeModel {
    int bomScore;
    int otScore;
    int ntScore;
    int pgpScore;
    int dcScore;

    public void getLowest(){}

    /**
     * LessonPlanner is where user can add lesson plans to their profile.
     * It will take in user information, and that is stored on the database.
     */
    public static class LessonPlanner extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_lesson_planner);
        }
        public void openLesson(){}
        public void deleteLesson(){}
        public void addLesson(){}
    }
}

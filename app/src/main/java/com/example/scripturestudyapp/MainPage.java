package com.example.scripturestudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
    }
    public void goToQuiz(View view){
        Intent intent = new Intent(this, QuizPage.class);
        startActivity(intent);
    }
    public void goToLesson(View view){
        Intent intent = new Intent(this, LessonPage.class);
        startActivity(intent);
    }
    public void goToProfile(View view){
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }
    public void goToReadingTracker(View view){
        Intent intent = new Intent(this, ReadingTracker.class);
        startActivity(intent);
    }
}

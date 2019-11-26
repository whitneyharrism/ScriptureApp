package com.example.scripturestudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;



public class MainPage extends AppCompatActivity {

    private static final String TAG = "My notification";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        Context context;
        Notification n = new Notification();
        boolean mute = n.isMute(this);

        Log.i(TAG, "isMute: " + mute);


    }
    public void goToQuiz(View view){
        Intent intent = new Intent(this, QuizList.class);
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

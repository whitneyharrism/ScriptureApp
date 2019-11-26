package com.example.scripturestudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class QuizList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_list);
    }
    public void goToQuiz(View view, Quiz quiz){
        //tell it which type of quiz to show
        Intent intent = new Intent(this, QuizRunner.class);
        intent.putExtra("QuizName","");
        startActivity(intent);
    }
}

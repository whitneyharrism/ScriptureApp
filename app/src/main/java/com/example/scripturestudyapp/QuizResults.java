package com.example.scripturestudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.util.Pair;

import java.util.List;

public class QuizResults extends AppCompatActivity {
    List<Pair<String,Integer>> quizResultTopics;

    TextView results;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);
        results = findViewById(R.id.resultsText);
        quizResultTopics = Quiz.getTopics();
        display();
    }
    public void display(){
        int topicNumber = 0;
        for(topicNumber < quizResultTopics.length;++topicNumber)
        {
            displayTopicText(quizResultTopics[topicNumber].getKey(),quizResultTopics[topicNumber].getValue());
        }
    }
    public void store(){
        //add the topic scores to firebase here
    }

    public void displayTopicText(String topic, int score)
    {
        String addedText =  "\n"+ topic + " " + score;
        results.append(addedText);
    }
    //    public void suggestedReading()
//    {
//
//    }
    public void goToMain(View view){
        Intent intent = new Intent(this, QuizRunner.class);
        startActivity(intent);
    }
    public void restart(View view){
        Intent intent = new Intent(this, QuizRunner.class);
        startActivity(intent);
    }
}

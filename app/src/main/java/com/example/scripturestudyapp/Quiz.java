package com.example.scripturestudyapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import java.util.LinkedList;
import java.util.Queue;

public class Quiz extends AppCompatActivity {

    private Queue<Question> questions = new LinkedList<>();
    private Question currentQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    public void submit(){}

    public void addQuestion(Question... q){
        for(int i = 0;i < q.length; ++i)
        questions.add(q[i]);
    }
    Question getQuestion(int qNumber){
        return questions.peek();
    }
    public int getSize(){
        return questions.size();
    }

    String getTopic(int qNumber) {
        return currentQuestion.topic;
    }

    public void saveProgress(){}
}
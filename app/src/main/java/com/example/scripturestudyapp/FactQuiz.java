package com.example.scripturestudyapp;

/**
 * Type of quiz that has correct answer and custom choices
 */
public abstract class FactQuiz extends Quiz {
    //only accepts FactQuestions
    public void addQuestion(FactQuestion... q){
        for(int i = 0;i < q.length; ++i)
        {
            questions.add(q[i]);
        }
    }
}

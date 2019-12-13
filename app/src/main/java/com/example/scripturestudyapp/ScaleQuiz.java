package com.example.scripturestudyapp;

/**
 * Type of quiz with set answer choices used to rate how much the user agrees with an question
 */
abstract class ScaleQuiz extends Quiz{

    //only accepts ScaleQuestions
    public void addQuestion(ScaleQuestion... q){
        for(int i = 0;i < q.length; ++i)
        {
            questions.add(q[i]);
        }
    }

    @Override
    public abstract void saveProgress();
}

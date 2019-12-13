package com.example.scripturestudyapp;

/**
 * Quiz that asks the user about the old testament
 * @author caden
 */
class OldTestamentQuiz extends FactQuiz {
    public OldTestamentQuiz() {

    }

    @Override
    public void saveProgress() {
        mDatabase.child("Quiz").child("OTQuiz").child("question").setValue(questionNumber);
    }
}

package com.example.scripturestudyapp;

/**
 * Quiz that asks the user about the new testament
 * Passed to quiz in quizRunner
 * @author caden
 */
class NewTestimentQuiz extends FactQuiz {
    public NewTestimentQuiz() {
        FactQuestion q1 = new FactQuestion("What is the first book of the New Testament?","New Testament");
        q1.setAnswerChoices("Mathew", "Mark", "Luke", "James", 0);
        q1.setScriptureReading("Mathew");
        FactQuestion q2 = new FactQuestion("Is the NT in chronological order?", "New Testament");
        q2.setAnswerChoices("No", "Yes", " ", " ", 1);
        q2.setScriptureReading("      ");
        FactQuestion q3 = new FactQuestion("Which apostle never knew Christ during His life?", "New Testament");
        q3.setAnswerChoices("Peter", "James", "John", "Paul", 3);
        q3.setScriptureReading("      ");
        FactQuestion q4 = new FactQuestion("Christ's first recorded miracle is", "New Testament");
        q4.setAnswerChoices("Water to wine", "Raising the dead", "healing the blind", "healing the sick", 0);
        q4.setScriptureReading("John 2:1-11");
        FactQuestion q5 = new FactQuestion("Christ was born in a...", "New Testament");
        q5.setAnswerChoices("Mansion", "wagon", "stable", "hospital", 2);
        q5.setScriptureReading("Luke 2");
        FactQuestion q6 = new FactQuestion("Christ's cousin was...?", "New Testament");
        q6.setAnswerChoices("James", "Peter", "John the Baptist", "Mathew", 2);
        q6.setScriptureReading("Mathew 3");
        FactQuestion q7 = new FactQuestion("Christ went to pray in...?", "New Testament");
        q7.setAnswerChoices("The garden of eden", "the garden of gethsemane", "the sacred grove", "He never prayed", 1);
        q7.setScriptureReading("Luke 22");
        FactQuestion q8 = new FactQuestion("Revelation is about", "New Testament");
        q8.setAnswerChoices("the last days", "Johns fantasy writings", "how to build temples", "nothing important", 0);
        q8.setScriptureReading("Revelation");
        this.addQuestion(q1,q2,q3,q4,q5,q6,q7,q8);
    }

    @Override
    public void saveProgress() {
        mDatabase.child("Quiz").child("NTQuiz").child("question").setValue(questionNumber);
    }
}

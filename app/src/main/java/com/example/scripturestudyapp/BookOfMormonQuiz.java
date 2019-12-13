package com.example.scripturestudyapp;

import android.util.Log;

/**
 * Quiz that asks the user what they know about the Book of Mormon
 * Passed as quiz in quizRunner
 * @author codyl
 * @since 12/3/19
 */
public class BookOfMormonQuiz extends FactQuiz {

    BookOfMormonQuiz()
    {
        FactQuestion q1 = new FactQuestion("When does the book of mormon begin?","Book of mormon");
        q1.setAnswerChoices("600 BC", "300 BC", "0 AD", "600 AD", 1);
        q1.setScriptureReading("1 Nephi 1:1");
        FactQuestion q2 = new FactQuestion("How many times does Nephi go to get the plates?", "Book of mormon");
        q2.setAnswerChoices("once", "twice", "thrice", "four times", 3);
        q2.setScriptureReading("1 Nephi 3-4");
        FactQuestion q3 = new FactQuestion("Which of these options is one of the things Jesus did while in America?", "Book of mormon");
        q3.setAnswerChoices("Bless the children", "Banish the devil", "Fish with the apostles", "Offer sacrifices", 1);
        q3.setScriptureReading("3 Nephi 17");
        FactQuestion q4 = new FactQuestion("What is one thing the apostles did in America?", "Book of mormon");
        q4.setAnswerChoices("Bless the sick", "Teach in Corinth", "Baptize Amulek", "Pray for rain", 1);
        q4.setScriptureReading("1 Nephi 1:1");
        FactQuestion q5 = new FactQuestion("Which of these options are not a BOM prophet?", "Book of mormon");
        q5.setAnswerChoices("Moroni", "Abenadi", "Lamoni", "Ether", 3);
        FactQuestion q6 = new FactQuestion("Where does the Church say the book of Mormon takes place", "Book of mormon");
        q6.setAnswerChoices("Mexico", "Near the great lakes", "Italy", "They do not take a position", 4);
        FactQuestion q7 = new FactQuestion("Who was Abish?", "Book of mormon");
        q7.setAnswerChoices("A prophet", "A priest", "A converted lamanite", "A wicked Nephite", 3);
        FactQuestion q8 = new FactQuestion("What did Alma teach to the people in Antionum?", "Book of mormon");
        q8.setAnswerChoices("To pray in their hearts", "Not to worship false idols", "To pray humbly", "To make a temple", 3);
        this.addQuestion(q1,q2,q3,q4,q5,q6,q7,q8);

        currentQuestion = questions.peek();
    }

    @Override
    public void saveProgress() {
        mDatabase.child("Quiz").child("BOMQuiz").child("question").setValue(questionNumber);
        Log.e("BOMQuiz","setting");
    }
}

package com.example.scripturestudyapp;

/**
 * Quiz that asks the user about the old testament
 * @author caden
 */
class OldTestamentQuiz extends FactQuiz {
    OldTestamentQuiz() {
        FactQuestion q1 = new FactQuestion("The first book of the OT is...","Old Testament");
        q1.setAnswerChoices("Genesis", "Numbers", "Kings", "Leviticus", 1);
        q1.setScriptureReading("Genesis 1");
        FactQuestion q2 = new FactQuestion("Who was the first prophet", "Old Testament");
        q2.setAnswerChoices("Seth", "Adam", "Enoch", "Christ", 2);
        q2.setScriptureReading("Genesis 1");
        FactQuestion q3 = new FactQuestion("Who did God reveal the commandments to?", "Old Testament");
        q3.setAnswerChoices("Noah", "Moses", "Abraham", "Solomon", 3);
        q3.setScriptureReading("Exodus 31");
        FactQuestion q4 = new FactQuestion("Who was Isaac's father?", "Old Testament");
        q4.setAnswerChoices("Abraham", "Jacob", "Joesph", "David", 1);
        q4.setScriptureReading("Genesis 22");
        FactQuestion q5 = new FactQuestion("How many years were the Hebrews in the wilderness?", "Old Testament");
        q5.setAnswerChoices("2", "100", "57", "40", 4);
        q5.setScriptureReading("Joshua 6:6");
        FactQuestion q6 = new FactQuestion("How many tribes of Israel are there?", "Old Testament");
        q6.setAnswerChoices("144", "10", "12", "3", 3);
        q6.setScriptureReading("Genesis 49");
        FactQuestion q7 = new FactQuestion("What was Noah commanded to do?", "Old Testament");
        q7.setAnswerChoices("Build an ark", "build the tower of babel", "sacrifice his son", "make golden plates", 1);
        q7.setScriptureReading("Genesis 5 - 10");
        FactQuestion q8 = new FactQuestion("Who wrote Genesis?", "Old Testament");
        q8.setAnswerChoices("Moses", "Moroni", "Mormon", "Joesph Smith", 1);
        this.addQuestion(q1,q2,q3,q4,q5,q6,q7,q8);
        currentQuestion = questions.peek();

    }
}

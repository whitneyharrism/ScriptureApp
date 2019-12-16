package com.example.scripturestudyapp;

/**
 * Quiz that asks the user questions an investigator might stump you on
 * Passed to quiz in quizRunner
 * @author caden
 */
class investigatorQuiz extends FactQuiz {
    investigatorQuiz() {
        FactQuestion q1 = new FactQuestion("Who is Jesus Christ","Investigator");
        q1.setAnswerChoices("Just a man", "A jewish political leader", "The Savior", "a myth", 3);
        q1.setScriptureReading("3 Nephi, Luke 22");
        FactQuestion q2 = new FactQuestion("Who is the current Prophet?", "Investigator");
        q2.setAnswerChoices("Nelson", "Hinckly", "Monson", "Smith", 1);
        q2.setScriptureReading("Ensign");
        FactQuestion q3 = new FactQuestion("Who is not part of the Godhead?", "Investigator");
        q3.setAnswerChoices("Heavenly Father", "Jesus Christ", "Joesph Smith", "Holy Ghost", 3);
        q3.setScriptureReading("A of F 1");
        FactQuestion q4 = new FactQuestion("How are you baptised?", "Investigator");
        q4.setAnswerChoices("By sprinkling", "Immersion", "its just symbolic", "By taking the sacrament", 2);
        q4.setScriptureReading("Mathew 3");
        FactQuestion q5 = new FactQuestion("How are we saved?", "Investigator");
        q5.setAnswerChoices("By the Atonement", "we save ourselves", "no one is saved", "everyone is saved", 1);
        q5.setScriptureReading("2 Nephi 25");
        FactQuestion q6 = new FactQuestion("Repentance is...?", "Investigator");
        q6.setAnswerChoices("Bad", "Changing for the better", "not necessary", "impossible", 2);
        q6.setScriptureReading("Jacob 2");
        FactQuestion q7 = new FactQuestion("Which of these are not part of the Gospel", "Investigator");
        q7.setAnswerChoices("Faith", "Ward campouts", "Covenants", "Enduring to the End", 2);
        q7.setScriptureReading("");
        FactQuestion q8 = new FactQuestion("The Priesthood is...?", "Investigator");
        q8.setAnswerChoices("The power of God", "Name of the bishoprick", "only in biblical times", "not a thing", 1);
        q8.setScriptureReading("D+C 84");
        this.addQuestion(q1,q2,q3,q4,q5,q6,q7,q8);

        currentQuestion = questions.peek();
    }
}

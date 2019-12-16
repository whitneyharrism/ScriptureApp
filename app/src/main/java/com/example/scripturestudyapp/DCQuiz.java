package com.example.scripturestudyapp;

/**
 * Quiz that asks the user what they know about the Doctrine and Covenants
 * Passed as quiz in quizRunner
 * @author caden
 */
class DCQuiz extends FactQuiz {
    public DCQuiz() {
        FactQuestion q1 = new FactQuestion("Who wrote the Doctrine and Covenants","DC");
        q1.setAnswerChoices("Moroni", "Latter-day Prophets", "Jesus Christ", "President Nelson", 2);
        q1.setScriptureReading("D+C Intro");
        FactQuestion q2 = new FactQuestion("How many Sections are in the Doctrine and Covenants", "DC");
        q2.setAnswerChoices("10", "56", "138", "312", 3);
        q2.setScriptureReading("D+C 138");
        FactQuestion q3 = new FactQuestion("What does Section 4 talk about", "DC");
        q3.setAnswerChoices("The Sacrament", "Building Faith", "Baptism", "Missionary Work", 4);
        q3.setScriptureReading("D+C 4");
        FactQuestion q4 = new FactQuestion("When was the last Section written", "DC");
        q4.setAnswerChoices("1834", "1918", "2018", "1894", 2);
        q4.setScriptureReading("D+C 138");
        FactQuestion q5 = new FactQuestion("What does the Doctrine and Covenants show", "DC");
        q5.setAnswerChoices("Modern day revelation takes place", "The church likes to read", "D+C is not important", "it replaces the bible", 1);
        q5.setScriptureReading("D+C 1");
        FactQuestion q6 = new FactQuestion("Where does the Doctrine and Covenants take place", "DC");
        q6.setAnswerChoices("USA", "Heaven", "Isreal", "Canada", 1);
        q6.setScriptureReading("D+C Intro");
        FactQuestion q7 = new FactQuestion("Doctrine and Covenants records...", "DC");
        q7.setAnswerChoices("Gods dealings with the latter-day saints", "Seminary attendance", "Newspaper articles", "Book of Mormon revisions", 1);
        q7.setScriptureReading("D+C Intro");
        FactQuestion q8 = new FactQuestion("Which section is the Oath and Covenant of the Priesthood", "DC");
        q8.setAnswerChoices("84", "121", "1", "32", 1);
        q8.setScriptureReading("D+C 84");
        this.addQuestion(q1,q2,q3,q4,q5,q6,q7,q8);
        currentQuestion = questions.peek();
    }
}

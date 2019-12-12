package com.example.scripturestudyapp;

/**
 * Quiz that asks the user what they know about the Doctrine and Covenants
 * Passed as quiz in quizRunner
 * @author caden
 */
class DCQuiz extends FactQuiz {
    public DCQuiz() {
        FactQuestion q1 = new FactQuestion("Who wrote the Doctrine and Covenants","DC");
        q1.setAnswerChoices("Moroni", "Latter-day Prophets", "Jesus Christ", "President Nelson", 1);

        FactQuestion q2 = new FactQuestion("How many Sections are in the Doctrine and Covenants", "Book of mormon");
        q2.setAnswerChoices("10", "56", "138", "312", 2);

        FactQuestion q3 = new FactQuestion("What does Section 4 talk about", "Book of mormon");
        q3.setAnswerChoices("The Sacrament", "Building Faith", "Baptism", "Missionary Work", 3);

        FactQuestion q4 = new FactQuestion("When was the last Section written", "Book of mormon");
        q4.setAnswerChoices("1834", "1918", "2018", "1894", 1);

        FactQuestion q5 = new FactQuestion("What does the Doctrine and Covenants show", "Book of mormon");
        q5.setAnswerChoices("Modern day revelation takes place", "The church likes to read", "D+C is not important", "it replaces the bible", 0);

        FactQuestion q6 = new FactQuestion("Where does the Doctrine and Covenants take place", "Book of mormon");
        q6.setAnswerChoices("USA", "Heaven", "Isreal", "Canada", 0);

        FactQuestion q7 = new FactQuestion("Doctrine and Covenants records...", "Book of mormon");
        q7.setAnswerChoices("Gods dealings with the latter-day saints", "Seminary attendance", "Newspaper articles", "Book of Mormon revisions", 0);

        FactQuestion q8 = new FactQuestion("Which section is the Oath and Covenant of the Priesthood", "Book of mormon");
        q8.setAnswerChoices("84", "121", "1", "32", 0);
        this.addQuestion(q1,q2,q3,q4,q5,q6,q7,q8);
    }
}

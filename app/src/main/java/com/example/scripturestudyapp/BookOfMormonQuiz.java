package com.example.scripturestudyapp;

public class BookOfMormonQuiz {
    Quiz quiz;
    BookOfMormonQuiz()
    {
        Question q1 = new Question("When does the book of mormon begin?","Book of mormon");
        q1.setAnswerChoices("600 BC", "300 BC", "0 AD", "600 AD", 1);
        Question q2 = new Question("How many times does Nephi go to get the plates?", "Book of mormon");
        q1.setAnswerChoices("once", "twice", "thrice", "four times", 3);
    }
}

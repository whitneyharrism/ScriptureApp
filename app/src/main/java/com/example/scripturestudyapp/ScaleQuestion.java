package com.example.scripturestudyapp;

/**
 * Changes the answer choices to always be 'never, sometimes, often, or always'.
 */
public class ScaleQuestion extends Question {

    ScaleQuestion(String question, String topic) {
        super(question, topic);
        answerChoices[0] = "never";
        answerChoices[1] = "sometimes";
        answerChoices[2] = "often";
        answerChoices[3] = "always";
    }
}

package com.example.scripturestudyapp;

import android.util.Log;

/**
 * Is different from ScaleQuestion because it allows you to set the answer choices.
 * Is used for quizzes with a correct answer
 */
public class FactQuestion extends Question{
final String TAG = "Fact question";
    FactQuestion(String question, String topic) {
        super(question, topic);
    }

//    public boolean isCorrectAnswer(String answer){
//        return answer.equals(correctAnswer);
//    }

    /**
     * Used to make a harder question worth more score points.
     * @param value the value to be added to the topic score in QuizRunner
     */
    public void setQuestionValue(int value){
        //this.value = value;
    }

    /**
     * Sets the answerChoices to custom values with one correct answer
     * @param choiceOne coordinates with top button
     * @param choiceTwo second from top
     * @param choiceThree second from bottom
     * @param choiceFour bottom button
     * @param correct Array position of the correct answer: starts with 1.
     */
    public void setAnswerChoices(String choiceOne, String choiceTwo, String choiceThree, String choiceFour, int correct)
    {
        answerChoices[0] = choiceOne;
        answerChoices[1] = choiceTwo;
        answerChoices[2] = choiceThree;
        answerChoices[3] = choiceFour;
        if((correct-1) > 3)
            Log.w(TAG,"Choice is not within 1-4 accepted range.");
        else
            correctAnswer = answerChoices[correct-1];
    }
}

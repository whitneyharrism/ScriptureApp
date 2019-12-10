package com.example.scripturestudyapp;

/**
 * Question contains one question in a quiz and has a specific topic.
 * @since 12/2/19
 * @author codyl
 */
public abstract class Question {
    protected String question;
    protected String correctAnswer;
    protected String topic;
    protected String[] answerChoices = new String[4];
    protected String scriptureReading;

    /**
     * Constructor to set the initial values. Answer choices are set by FactQuestion ot ScaleQuestion.
     * @param question
     * @param topic
     */
    Question(String question, String topic)
    {
        this.question = question;
        this.topic = topic;
        correctAnswer = null;
        scriptureReading = null;
        answerChoices[0] = "unset";
        answerChoices[1] = "unset";
        answerChoices[2] = "unset";
        answerChoices[3] = "unset";
    }

    /**
     * Returns the string of the answer choice. This is used to display the choice in a button.
     * @param choiceNumber May choose from between 1-4
     * @return answerChoices[choiceNumber]
     */
    public String getAnswerChoice(int choiceNumber){ return answerChoices[choiceNumber];}
    public void setScriptureReading(String scr){
        scriptureReading = scr;
    }
}

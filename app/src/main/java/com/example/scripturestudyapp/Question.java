package com.example.scripturestudyapp;

public class Question {
    public String question;
    private String correctAnswer;
    public String topic;
    private String[] answerChoices = new String[4];
    //default values


    Question(String question, String topic)
    {
        this.question = question;
        this.topic = topic;
        answerChoices[0] = "never";
        answerChoices[1] = "sometimes";
        answerChoices[2] = "often";
        answerChoices[3] = "always";
    }
    public boolean isCorrectAnswer(String answer){
        if(answer == correctAnswer)
        {
            return true;
        }
        else return false;
    }
    public String getAnswerChoice(int choiceNumber){ return answerChoices[choiceNumber];}
    public void setAnswerChoices(String choiceOne, String choiceTwo, String choiceThree, String choiceFour, int correct)
    {
        answerChoices[0] = choiceOne;
        answerChoices[1] = choiceTwo;
        answerChoices[2] = choiceThree;
        answerChoices[4] = choiceFour;
        correctAnswer = answerChoices[correct+1];
    }
    //for cases when there is no 'correct' answer ie attributeQuiz
    public void setAnswerChoices(String choiceOne, String choiceTwo, String choiceThree, String choiceFour)
    {
        answerChoices[0] = choiceOne;
        answerChoices[1] = choiceTwo;
        answerChoices[2] = choiceThree;
        answerChoices[4] = choiceFour;
    }
}

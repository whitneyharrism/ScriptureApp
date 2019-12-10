package com.example.scripturestudyapp;

import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The parent of Scale Quiz and FactQuiz.
 * Stores a set of questions in a queue.
 *
 */
public abstract class Quiz {
    protected Queue<Question> questions = new LinkedList<>();
    protected Question currentQuestion;
    public int questionNumber;
    private Button btn_one, btn_two, btn_three, btn_four;
    TextView tv_question;

    /**
     * Tells all children what the buttons in QuizRunner are.
     */
    public Quiz(){
        questionNumber = 0;
        currentQuestion = questions.peek();
    }


    /**
     * Returns the question at the front of the queue
     * @return
     */
    Question getQuestion(){
        //if(questions.peek() == null) QuizRunner.openResultsPage();
        return questions.peek();
    }

    /**
     * Gets the size of the queue of questions.
     * @return
     */
    public int getSize(){
        return questions.size();
    }

    /**
     * Gets the topic(ie faith) of the question at the front of the queue.
     * @return
     */
    String getTopic() {
        currentQuestion = questions.peek();
        return currentQuestion.topic;
    }

    /**
     * Removes the question at the front of the queue so the next question will be viewed next.
     */
    void deleteQuestion(){
        questions.remove();
    }

    /**
     * Removes the question so the next one is ready to be pulled up.
     */
    public void NextQuestion() {
        //Log.e(TAG, "" + getSize());
        deleteQuestion();
        currentQuestion = getQuestion();
        questionNumber++;
    }

    public String isCorrectAnswer(String answer){

        //return answer.equals(currentQuestion.correctAnswer);
        if(answer.equals(currentQuestion.correctAnswer)){
            return "Correct!";
        }
        else{
            return "Incorrect!";
        }
    }
    public boolean testAnswer(String answer){
        return answer.equals(currentQuestion.correctAnswer);
    }




    /**
     * saves the quiz to the database
     */
    public void saveProgress(){}


}

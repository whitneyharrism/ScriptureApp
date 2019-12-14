package com.example.scripturestudyapp;



import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
    protected DatabaseReference mDatabase;
// ...

    /**
     * Tells all children what the buttons in QuizRunner are.
     */
    public Quiz(){
        //questionNumber = 0;
        //TODO Set the current question equal to the saved question from last session
        currentQuestion = questions.peek();
        mDatabase = FirebaseDatabase.getInstance().getReference();
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
    public abstract void saveProgress();
    public void saveScore(){

    }


}

package com.example.scripturestudyapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

/**
 * Starts a quiz requested by the user pressing a button in the QuizList view.
 */
public class QuizRunner extends AppCompatActivity implements View.OnClickListener{

    Button btn_one, btn_two, btn_three, btn_four;
    TextView tv_question;
    //Topics
    public static int faith = 0;
    public static int hope = 0;
    public static int charity = 0;
    public static int virtue = 0;
    public static int knowledge = 0;
    public static int patience = 0;
    public static int humility = 0;
    public static int diligence = 0;
    public static int obedience = 0;

    public static int bom = 0;
    public static int dc = 0;
    public static int nt = 0;
    public static int ot = 0;
    public static int i = 0;


    private Quiz quiz;
    final String TAG = "QuizRunner";
    String results;

    /**
     * Checks the extra provided from QuizList to set the quiz type
     * @param savedInstanceState
     * @throws NullPointerException
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) throws NullPointerException{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        btn_one = findViewById(R.id.btn_one);
        btn_one.setOnClickListener(this);
        btn_two = findViewById(R.id.btn_two);
        btn_two.setOnClickListener(this);
        btn_three = findViewById(R.id.btn_three);
        btn_three.setOnClickListener(this);
        btn_four = findViewById(R.id.btn_four);
        btn_four.setOnClickListener(this);
        tv_question = findViewById(R.id.tv_question);
    }

    @Override
    protected void onStart() {
        faith = 0;
        hope = 0;
        charity = 0;
        virtue = 0;
        knowledge = 0;
        patience = 0;
        humility = 0;
        diligence = 0;
        obedience = 0;
        bom = 0;
        super.onStart();
        if(getIntent().getStringExtra("quiz") != null)
            switch (getIntent().getStringExtra("quiz")){
                case "bom": quiz = new BookOfMormonQuiz();break;
                case "ca": quiz = new AttributeQuiz();break;
                case "dc": quiz = new DCQuiz();break;
                case "nt": quiz = new NewTestimentQuiz();break;
                case "ot": quiz = new OldTestamentQuiz();break;
                case "i": quiz = new investigatorQuiz();break;
                default: Log.w(TAG,"Error with version of quiz. Should be bom, bt, ot, etc.");
            }
        else{System.out.println("failure");}
        if(quiz.getSize() <= 0) Log.e(TAG, "Quiz size is 0. Quiz needs to reset size.");
        else Log.i(TAG, "Quiz size: "+quiz.getSize());

//        ValueEventListener questionListener = new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                //read the question value from the database
//                Quiz getQuiz;
//                try {
//                    getQuiz = dataSnapshot.getValue(Quiz.class);
//                    quiz.questionNumber = getQuiz.questionNumber;
//                }
//                catch (NullPointerException n){
//                    n.printStackTrace();
//                }
//
//                //after we get the value from firebase go to the current question
//                Log.e(TAG, "Quiz question num: "+quiz.questionNumber);
////                for (int i = 0; i < quiz.questionNumber; i++) {
////                    quiz.questions.remove();
////                }
//            }
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                // Getting Post failed, log a message
//                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
//                // [START_EXCLUDE]
//                Toast.makeText(QuizRunner.this, "Failed to load question.",
//                        Toast.LENGTH_SHORT).show();
//                // [END_EXCLUDE]
//            }
//        };
//        quiz.mDatabase.addValueEventListener(questionListener);

        display();
    }

    /**
     * Adds a score to a topic based on the answer button the user clicks on.
     * @param topic
     * @param i
     */
    public void addScore(String topic, int i){
        if (quiz.currentQuestion.correctAnswer == null)
            addScaleScore(topic, i);
        else if(quiz.testAnswer(quiz.currentQuestion.getAnswerChoice(i-1)))
        {
            addFactScore(topic);
            if(quiz.currentQuestion.scriptureReading != null)
            results += " " + quiz.currentQuestion.scriptureReading;
        }

    }

    private void addFactScore(String topic) {
        switch (topic)
        {
            case "Book of mormon":
                bom+=4;break;
            case "dc":
                dc+=4;break;
            case "nt":
                nt+=4;break;
            case "ot":
                ot+=4;break;
            case "investigator":
                i+=4;break;
            default:
                System.out.println("Topic is not archived or is misspelled.");
        }
    }

    private void addScaleScore(String topic, int i){
        switch (topic)
        {
            case "faith":
                faith+=i;break;
            case "hope":
                hope+=i;break;
            case "charity":
                charity+=i;break;
            case "patience":
                patience+=i;break;
            case "virtue":
                virtue+=i;break;
            case "diligence":
                diligence+=i;break;
            case "obedience":
                obedience+=i;break;
            case "humility":
                humility+=i;break;
            case "knowledge":
                knowledge+=i;break;
            default:
                System.out.println("Topic is not archived or is misspelled.");
        }
    }

    /**
     * Controls the question info being displayed and score
     * @param v
     */
    public void onClick(View v) {
        if(quiz.getSize() <= 0) {quiz.questionNumber = 0;openResultsPage();}
        else
        switch (v.getId()){
            case R.id.btn_one:
                addScore(quiz.getTopic(),1);
                displayToast(1);
                quiz.NextQuestion();
                display();
                break;

            case R.id.btn_two:
                addScore(quiz.getTopic(),2);
                displayToast(2);
                quiz.NextQuestion();
                display();
                break;

            case R.id.btn_three:
                addScore(quiz.getTopic(),3);
                displayToast(3);
                quiz.NextQuestion();
                display();
                break;

            case R.id.btn_four:
                addScore(quiz.getTopic(),4);
                displayToast(4);
                quiz.NextQuestion();
                display();
                break;
        }
        if(quiz.getSize() <= 0) {quiz.questionNumber = 0;openResultsPage();}
    }

    private void display() {
        if(quiz.getSize() > 0) {
            btn_one.setText(quiz.currentQuestion.getAnswerChoice(0));
            btn_two.setText(quiz.currentQuestion.getAnswerChoice(1));
            btn_three.setText(quiz.currentQuestion.getAnswerChoice(2));
            btn_four.setText(quiz.currentQuestion.getAnswerChoice(3));
            tv_question.setText(quiz.getTopic() + "\n" + (quiz.questionNumber + 1) + ". " + quiz.currentQuestion.question);
        }
    }
    private void displayToast(int chosenAnswer){
        if (quiz.currentQuestion.correctAnswer != null)
            Toast.makeText(this, quiz.isCorrectAnswer(quiz.currentQuestion.getAnswerChoice(chosenAnswer-1)), Toast.LENGTH_SHORT).show();
    }

    /**
     * Opens the QuizResults activity
     */
    private void openResultsPage() {
        //do intent to switch page
        Intent intent = new Intent(this, QuizResults.class);
        intent.putExtra("quiz",getIntent().getStringExtra("quiz"));
        intent.putExtra("suggest reading", results);
        startActivity(intent);
    }

    public void save(View view){
        quiz.saveProgress();
        //quiz.saveScore();
    }
}

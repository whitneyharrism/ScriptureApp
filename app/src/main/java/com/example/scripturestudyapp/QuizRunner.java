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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
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
                case "BOMQuiz": quiz = new BookOfMormonQuiz();break;
                case "CAQuiz": quiz = new AttributeQuiz();break;
                case "DCQuiz": quiz = new DCQuiz();break;
                case "NTQuiz": quiz = new NewTestimentQuiz();break;
                case "OTQuiz": quiz = new OldTestamentQuiz();break;
                case "InvQuiz": quiz = new investigatorQuiz();break;
                default: Log.w(TAG,"Error with version of quiz. Should be bom, bt, ot, etc.");
            }
        else{System.out.println("failure");}
        if(quiz.getSize() <= 0) Log.e(TAG, "Quiz size is 0. Quiz needs to reset size.");
        else Log.i(TAG, "Quiz size: "+quiz.getSize());

        loadProgress();

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
        }
        else{
            if(quiz.currentQuestion.scriptureReading != null)
            {
                if(results == null)
                results += ": " + quiz.currentQuestion.scriptureReading;
                else
                    results += ", " + quiz.currentQuestion.scriptureReading;
            }
        }

        //score into database

    }

    private void addFactScore(String topic) {
        switch (topic)
        {
            case "Book of mormon":
                bom+=4;
                FirebaseDatabase.getInstance().getReference().child("Quiz").child(getIntent().getStringExtra("quiz")).child("score").setValue(bom);
                break;
            case "dc":
                dc+=4;
                FirebaseDatabase.getInstance().getReference().child("Quiz").child(getIntent().getStringExtra("quiz")).child("score").setValue(dc);
                break;
            case "nt":
                nt+=4;
                FirebaseDatabase.getInstance().getReference().child("Quiz").child(getIntent().getStringExtra("quiz")).child("score").setValue(nt);
                break;
            case "ot":
                ot+=4;
                FirebaseDatabase.getInstance().getReference().child("Quiz").child(getIntent().getStringExtra("quiz")).child("score").setValue(ot);
                break;
            case "investigator":
                i+=4;
                FirebaseDatabase.getInstance().getReference().child("Quiz").child(getIntent().getStringExtra("quiz")).child("score").setValue(i);
                break;
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
                break;

            case R.id.btn_two:
                addScore(quiz.getTopic(),2);
                displayToast(2);
                break;

            case R.id.btn_three:
                addScore(quiz.getTopic(),3);
                displayToast(3);
                break;

            case R.id.btn_four:
                addScore(quiz.getTopic(),4);
                displayToast(4);
                break;
        }

        if(v.getId() == R.id.btn_one ||v.getId() == R.id.btn_two ||v.getId() == R.id.btn_three ||v.getId() == R.id.btn_four) {
            quiz.NextQuestion();
            if(quiz.getSize() <= 0) {quiz.questionNumber = 0;openResultsPage();}
            saveQuestion();
            display();
        }
        Log.e("qr", ""+quiz.getSize());
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
        quiz.questionNumber = 0;
        saveQuestion();
        Intent intent = new Intent(this, QuizResults.class);
        intent.putExtra("quiz",getIntent().getStringExtra("quiz"));
        intent.putExtra("suggest reading", results);
        startActivity(intent);
    }
    public void loadProgress() {
        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Quiz").child("BOMQuiz").child("question");
        ValueEventListener vel=ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Log.e(TAG,"database question is: "+snapshot.getValue());  //prints "Do you have data? You'll love Firebase."
                quiz.questionNumber = Integer.parseInt(snapshot.getValue().toString());
                Log.e(TAG,"question is: "+quiz.questionNumber);
                for(int i = 1;i<quiz.questionNumber;i++)
                {
                    quiz.deleteQuestion();
                    quiz.currentQuestion = quiz.getQuestion();
                    Log.e(TAG,"question: "+quiz.currentQuestion.question);

                }

                display();
                ref.removeEventListener(this);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public void saveQuestion(){
        FirebaseDatabase.getInstance().getReference().child("Quiz").child(getIntent().getStringExtra("quiz")).child("question").setValue(quiz.questionNumber);
        Log.e("BOMQuiz","setting"+quiz.questionNumber);
    }
}

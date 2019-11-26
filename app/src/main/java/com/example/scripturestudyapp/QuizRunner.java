package com.example.scripturestudyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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

    private Quiz activeQuiz = new Quiz();

    //private String answer;
    //private int questionLength = quiz.questions.length;

    int questionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //random = new Random();

        //activeQuiz =
        btn_one = findViewById(R.id.btn_one);
        btn_one.setOnClickListener(this);
        btn_two = findViewById(R.id.btn_two);
        btn_two.setOnClickListener(this);
        btn_three = findViewById(R.id.btn_three);
        btn_three.setOnClickListener(this);
        btn_four = findViewById(R.id.btn_four);
        btn_four.setOnClickListener(this);

        btn_one.setText(R.string.never);
        btn_two.setText(R.string.sometimes);
        btn_three.setText(R.string.often);
        btn_four.setText(R.string.always);

        tv_question = findViewById(R.id.tv_question);

        NextQuestion(questionNumber++);
    }
    public void addMod(String topic, int i){
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
        //Toast.makeText(QuizRunner.this, faith, Toast.LENGTH_SHORT).show();
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_one:
                addMod(activeQuiz.getTopic(questionNumber),1);
                NextQuestion(questionNumber++);
                break;

            case R.id.btn_two:
                addMod(activeQuiz.getTopic(questionNumber),2);
                NextQuestion(questionNumber++);
                break;

            case R.id.btn_three:
                addMod(activeQuiz.getTopic(questionNumber),3);
                NextQuestion(questionNumber++);

                break;

            case R.id.btn_four:
                addMod(activeQuiz.getTopic(questionNumber),4);
                NextQuestion(questionNumber++);

                break;
        }
        if(questionNumber >= activeQuiz.getSize()) {questionNumber = 0;openResultsPage();}
    }

    private void openResultsPage() {
        //do intent to switch page
        Intent intent = new Intent(this, QuizResults.class);
        startActivity(intent);
    }

//    private void GameOver(){
//        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(QuizRunner.this);
//        alertDialogBuilder
//                .setMessage("Game Over")
//                .setCancelable(false)
//                .setPositiveButton("New Game", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        startActivity(new Intent(getApplicationContext(), QuizRunner.class));
//                    }
//                })
//                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        System.exit(0);
//                    }
//                });
//        alertDialogBuilder.show();
//
//    }

    private void NextQuestion(int num){
        //Toast.makeText(QuizRunner.this, num, Toast.LENGTH_SHORT).show();
        tv_question.setText(String.format("%n. %2$s",num,activeQuiz.getQuestion(num).question));
        //if activequiz is not attribute
        btn_one.setText(activeQuiz.getQuestion(num).getAnswerChoice(1));
        btn_two.setText(activeQuiz.getQuestion(num).getAnswerChoice(2));
        btn_three.setText(activeQuiz.getQuestion(num).getAnswerChoice(3));
        btn_four.setText(activeQuiz.getQuestion(num).getAnswerChoice(4));


        //answer = quiz.getCorrectAnswer(num);
    }
}

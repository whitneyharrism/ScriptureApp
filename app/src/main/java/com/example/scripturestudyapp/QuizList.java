package com.example.scripturestudyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Provides a list of quizzes to choose from in a UI activity.
 */
public class QuizList extends AppCompatActivity implements View.OnClickListener {
    Button bom, ca, nt,ot, i, dc; //The buttons for each quiz (names abbrev.)

    /**
     * Initializes the buttons and listens tells buttons to listen for user clicks.
     * @param savedInstanceState required
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_list);

        bom = findViewById(R.id.bom);
        bom.setOnClickListener(this);
        ca = findViewById(R.id.ca);
        ca.setOnClickListener(this);
        nt = findViewById(R.id.nt);
        nt.setOnClickListener(this);
        ot = findViewById(R.id.ot);
        ot.setOnClickListener(this);
        dc = findViewById(R.id.dc);
        dc.setOnClickListener(this);
        i = findViewById(R.id.i);
        i.setOnClickListener(this);
    }

    /**
     * Goes to QuizRunner and tells Quiz which child of quiz was requested by the user.
     * @param quiz
     */
    public void goToQuiz(String quiz) {
        Intent intent = new Intent(this, QuizRunner.class);
        intent.putExtra("quiz", quiz);
        startActivity(intent);
    }

    /**
     * Used to detect which button was pressed by the user and determine which quiz should be sent to goToQuiz function.
     * @param v
     */
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bom:
                goToQuiz("BOMQuiz");
                break;
            case R.id.ca:
                goToQuiz("CAQuiz");
                break;
            case R.id.dc:
                goToQuiz("DCQuiz");
                break;
            case R.id.nt:
                goToQuiz("NTQuiz");
                break;
            case R.id.ot:
                goToQuiz("OTQuiz");
                break;
            case R.id.i:
                goToQuiz("InvQuiz");
                break;
        }
    }
}

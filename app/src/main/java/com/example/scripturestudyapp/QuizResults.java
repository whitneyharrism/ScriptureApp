package com.example.scripturestudyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Displays the resulting score from completing a quiz.
 */
public class QuizResults extends AppCompatActivity {
    TextView results, suggestion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);
        results = findViewById(R.id.resultsText);
        suggestion = findViewById(R.id.suggestionText);

        displayTopicText("faith", QuizRunner.faith);
        displayTopicText("hope", QuizRunner.hope);
        displayTopicText("charity", QuizRunner.charity);
        displayTopicText("virtue", QuizRunner.virtue);
        displayTopicText("knowledge", QuizRunner.knowledge);
        displayTopicText("patience", QuizRunner.patience);
        displayTopicText("humility", QuizRunner.humility);
        displayTopicText("diligence", QuizRunner.diligence);
        displayTopicText("obedience", QuizRunner.obedience);
        displayTopicText("Book of Mormon", QuizRunner.bom);
        displayTopicText("New Testiment", QuizRunner.obedience);
        displayTopicText("Old Testiment", QuizRunner.obedience);
        displayTopicText("Doctrine and covenants", QuizRunner.obedience);
        displayTopicText("investigator", QuizRunner.obedience);
        suggestedReading();
    }

    /**
     * Decides whether or not to display a score
     * @param topic The topic string in a question
     * @param score will always be over 0 if there is at least one question on it.
     */
    public void displayTopicText(String topic, int score)
    {
        if(score > 0) {
            String addedText = "\n" + topic + " " + score;
            results.append(addedText);
        }
    }

    public void suggestedReading()
    {
        String reading = getIntent().getStringExtra("suggest reading");
        if(reading != null)
        {suggestion.append(reading + ".");suggestion.getText().toString().replace("null"," ");}
    }

    /**
     * Sends the user back to the main screen.
     * @param view
     */
    public void goToMain(View view){
        Intent intent = new Intent(this, MainPage.class);
        startActivity(intent);
    }

    /**
     * Sends the user to take the quiz again.
     * @param view
     */
    public void restart(View view){
        Intent intent = new Intent(this, QuizRunner.class);
        intent.putExtra("quiz",getIntent().getStringExtra("quiz"));
        startActivity(intent);
    }
}

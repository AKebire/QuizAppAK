package com.example.android.quizappak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    public int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        score = getIntent().getExtras().getInt("quizResult");
        String scoreMessage = checkScore();
        displayMessage(scoreMessage);
    }


    private String checkScore() {
        String quizResult = "";

        if(score >= 3)
        {
            quizResult += "You passed the quiz, you answered " + score + " correct answers.";
        }else
        {
            quizResult += "You failed the quiz, you answered " + score + " correct answers.";
        }

        return quizResult;
    }

    private void displayMessage(String scoreMessage) {
        TextView scoreTextView = findViewById (R.id.score_text_view);
        scoreTextView.setText (scoreMessage);
      }

}

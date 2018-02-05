package com.example.android.quizappak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
            Toast.makeText(this, "Congratulation you passed the test.", Toast.LENGTH_SHORT).show();
        }else
        {
            quizResult += "You failed the quiz, you answered " + score + " correct answers.";
            Toast.makeText(this, "You failed the quiz, please try it again.", Toast.LENGTH_SHORT).show();
        }

        return quizResult;
    }

    /*
     *  The displayMessage is used to show the result of the quiz.
     */
    private void displayMessage(String scoreMessage) {
        TextView scoreTextView = findViewById (R.id.score_text_view);
        scoreTextView.setText (scoreMessage);
      }


    /*
     * This method is used to prevent the user from going back to the quiz using return button.
     */
    @Override
    public void onBackPressed()
    {
        Toast.makeText(this, "You can't go back to the quiz you took.", Toast.LENGTH_SHORT).show();

    }

}

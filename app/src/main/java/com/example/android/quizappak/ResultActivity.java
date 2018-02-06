package com.example.android.quizappak;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
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

    /*
     * Display the result of the quiz.
     */


    private String checkScore() {
        String quizResult = "";

        if(score >= 5)
        {
            quizResult += "You passed the quiz, you answered " + score + " correct answers.";
            Toast passTest = Toast.makeText(this, "Congratulation you passed the test.", Toast.LENGTH_SHORT);
            passTest.setGravity(Gravity.CENTER,0,0);
            TextView v = (TextView) passTest.getView().findViewById(android.R.id.message);
            v.setTextColor(Color.YELLOW);
            passTest.show();
        }else
        {
            quizResult += "You failed the quiz, you answered " + score + " correct answers.";
            Toast failTest = Toast.makeText(this, "You failed the quiz, please try it again.", Toast.LENGTH_LONG);
            failTest.setGravity(Gravity.CENTER,0,0);
            failTest.setGravity(Gravity.CENTER,0,0);
            TextView v = (TextView) failTest.getView().findViewById(android.R.id.message);
            v.setTextColor(Color.YELLOW);
            failTest.show();
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
     * This method is used to prevent the user from going back to the quiz using return button once finished by displaying a message.
     */
    @Override
    public void onBackPressed()
    {
        Toast returnToQuiz = Toast.makeText(this, "You can't go back to the quiz you took.", Toast.LENGTH_LONG);
        returnToQuiz.setGravity(Gravity.CENTER,0,0);
        TextView v = (TextView) returnToQuiz.getView().findViewById(android.R.id.message);
        v.setTextColor(Color.YELLOW);
        returnToQuiz.show();
    }


    public void playAgain(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void exitApp(View view) {

        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }



}

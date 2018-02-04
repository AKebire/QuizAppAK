package com.example.android.quizappak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startQuiz(View view) {
        //we declare Intent object to open to new Activity
        //this refers to the current activity and then we call the activity we want to open "QuizPage"
        Intent intent = new Intent(this, Activityquiz.class);
        startActivity(intent);
    }

}


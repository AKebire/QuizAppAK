package com.example.android.quizappak;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Activityquiz extends AppCompatActivity {

    public int result = 0;
    public String q4QuizAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }


    public int quizResult(){

        RadioButton q1Answer = findViewById(R.id.q1_answer);
        RadioButton q2Answer = findViewById(R.id.q2_answer);
        CheckBox q3FirstAnswer =  findViewById(R.id.q3_answer_1);
        CheckBox q3SecondAnswer =  findViewById(R.id.q3_answer_2);
        EditText q4Answer = findViewById(R.id.q4_answer);
        RadioButton q5Answer = findViewById(R.id.q5_answer);
        RadioButton q6Answer = findViewById(R.id.q6_answer);
        RadioButton q7Answer = findViewById(R.id.q7_answer);
        RadioButton q8Answer = findViewById(R.id.q8_answer);


        q4QuizAnswer = q4Answer.getText().toString();

        if(q1Answer.isChecked()) { result += 1; }

        if (q2Answer.isChecked()) {  result += 1;}

        if (q3FirstAnswer.isChecked() && q3SecondAnswer.isChecked())  { result += 1; }

        if (q4QuizAnswer.equals("Asia")) { result += 1; }

        if(q5Answer.isChecked())  {  result += 1; }

        if (q6Answer.isChecked()) {  result += 1; }

        if(q7Answer.isChecked())  {  result += 1; }

        if (q8Answer.isChecked()) {  result += 1; }

        return result;
    }


    public void submitQuiz(View view) {

        int result = quizResult();
       // String quizResult ="";
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("quizResult",result);
        startActivity(intent);
    }

}

package com.viktorrahmanovic.nrt4912;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AnswerQuestionActivity extends AppCompatActivity {

    int student;
    int question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_question);


        Intent i = getIntent();

        student = i.getIntExtra("CurrentStudent", 0);
        question = i.getIntExtra("CurrentQuestion", 0);


        if (question == 0)
            ProfActivity.answers[student] = ProfActivity.questions;


        Question currentQuestion = ProfActivity.answers[student].get(question);
        // postavljamo Interface

        ((TextView)findViewById(R.id.tvQuestion)).setText(currentQuestion.getQuestionText());

        LinearLayout llRoot = ((LinearLayout)findViewById(R.id.llRoot));
        if(currentQuestion.getClass().equals(TextQuestion.class)){
            EditText etAnswer = new EditText(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 500);
            etAnswer.setLayoutParams(lp);
            llRoot.addView(etAnswer);



        } else if (currentQuestion.getClass().equals(RadioQuestion.class)) {


            String[] answers = ((RadioQuestion)currentQuestion).getQuestions();
            int noOfAnswers = answers.length;
                    //((RadioQuestion) currentQuestion).getQuestions();
            RadioGroup rgAnswers = new RadioGroup(this);
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            rgAnswers.setLayoutParams(lp);
            llRoot.addView(rgAnswers);

            for (int j = 0; j<noOfAnswers; j++) {
                RadioButton rbAnswer = new RadioButton(this);
                rbAnswer.setText(answers[j]);
                rbAnswer.setLayoutParams(lp);
                rgAnswers.addView(rbAnswer);

            }

        } else if (currentQuestion.getClass().equals(CheckboxQuestion.class)) {
            CheckBox cbAnswer = new CheckBox(this);
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 500);
            cbAnswer.setLayoutParams(lp);

        }



    }

    public void nextQuestionClicked(View view) {

        finish();
        question++;
        if(question == ProfActivity.questions.size()){
            question=0;
            student++;
            if(student==ProfActivity.answers.length){
                return;
            }
        }

        Intent intent = new Intent(this, AnswerQuestionActivity.class);
        intent.putExtra("CurrentQuestion", question);
        intent.putExtra("CurrentStudent", student);
        startActivity(intent);

    }
}

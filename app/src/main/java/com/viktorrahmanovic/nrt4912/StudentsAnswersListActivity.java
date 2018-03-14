package com.viktorrahmanovic.nrt4912;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class StudentsAnswersListActivity extends AppCompatActivity {

    private int studentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_answers_list);

        Intent intent = getIntent();
        studentId = intent.getIntExtra("StudentID",0);
        LinearLayout llRoot = (LinearLayout) findViewById(R.id.llRoot);
        //  TextView tvTv = new TextView(this);
        ArrayList<Question>[] answers = ProfActivity.answers;

//        tvTv.setText(ProfActivity.answers[studentId].toString());
        for (int i = 0; i < ProfActivity.answers[studentId].size(); i++) {
            LinearLayout llQuestion = new LinearLayout(this);
            llQuestion.setBackgroundColor(Color.WHITE);
            LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300);
            llp.setMargins(10, 10, 10, 10);
            llQuestion.setLayoutParams(llp);

            Question currentQuestion = ProfActivity.answers[studentId].get(i);
            TextView tvQuestion = new TextView(this);
            tvQuestion.setText((i + 1) + ". " + currentQuestion.getQuestionText() + "\n");
            tvQuestion.setTextSize(18);
            tvQuestion.setPadding(10,10,10,10);
            llQuestion.addView(tvQuestion);

            Question currentAnswer = ProfActivity.answers[studentId].get(i);
            TextView tvAnswer = new TextView(this);
            tvAnswer.setTextSize(18);
            llQuestion.addView(tvAnswer);

            if (currentAnswer.getClass().equals(TextQuestion.class)) {
                tvAnswer.setText("\nOdgovor: " + ((TextQuestion) currentAnswer).getAnswerText());

            } else if (currentAnswer.getClass().equals(RadioQuestion.class)) {

                tvAnswer.setText("Odgovor: " + ((RadioQuestion) currentAnswer).getSelectedAnswerText());
//                      ((RadioQuestion)currentAnswer).getAnswers()[((RadioQuestion)currentAnswer).getSelectedAnswer()]);

            } else if (currentAnswer.getClass().equals(CheckboxQuestion.class)) {

                tvAnswer.setText("Odgovor: " + ((CheckboxQuestion) currentAnswer).getSelectedAnswersText());



            }

            llRoot.addView(llQuestion);


            TextView tvUsername = findViewById(R.id.tvStudentUsernameAnswers);

            tvUsername.setText(ProfActivity.students.get(studentId));

        }
    }
}

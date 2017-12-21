package com.viktorrahmanovic.nrt4912;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class StudentsAnswersListActivity extends AppCompatActivity {

    private int studentId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_answers_list);

        LinearLayout llRoot = (LinearLayout)findViewById(R.id.llRoot);
      //  TextView tvTv = new TextView(this);
        ArrayList<Question>[] answers = ProfActivity.answers;

//        tvTv.setText(ProfActivity.answers[studentId].toString());
      for(int i =0; i<ProfActivity.answers[studentId].size();i++) {
          LinearLayout llQuestion = new LinearLayout(this);
          llQuestion.setBackgroundColor(Color.WHITE);
          LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300);
          llp.setMargins(10,10,10,10);
          llQuestion.setLayoutParams(llp);

          Question currentQuestion = ProfActivity.answers[studentId].get(i);
          TextView tvQuestion = new TextView(this);
          tvQuestion.setText((i+1) + ". " + currentQuestion.getQuestionText());
          llQuestion.addView(tvQuestion);

          Question currentAnswer = ProfActivity.answers[studentId].get(i);
          TextView tvAnswer = new TextView(this);
          tvAnswer.setText((i+1) + ". " + currentAnswer.getQuestionText());
          llQuestion.addView(tvQuestion);

          if(currentAnswer.equals(TextQuestion.class)) {
              Toast.makeText(this, "Tekst", Toast.LENGTH_SHORT).show();

          } else if (currentAnswer.equals(RadioButton.class)) {
              Toast.makeText(this, "Radio", Toast.LENGTH_SHORT).show();


          } else if (currentAnswer.equals(CheckboxQuestion.class)) {

              Toast.makeText(this, "Check", Toast.LENGTH_SHORT).show();

          }

          llRoot.addView(llQuestion);


       }
    }
}
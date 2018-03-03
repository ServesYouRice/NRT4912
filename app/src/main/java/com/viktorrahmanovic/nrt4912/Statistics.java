package com.viktorrahmanovic.nrt4912;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Statistics extends AppCompatActivity {

    private ArrayList<Integer>[] numbersOfAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        numbersOfAnswers = new ArrayList[ProfActivity.questions.size()];
        for (int j = 0; j < ProfActivity.questions.size();j++) {
//            for (ArrayList<Integer> answers : numbersOfAnswers) {
                numbersOfAnswers[j] = new ArrayList<>();
                for (int i = 0; i < ProfActivity.questions.size(); i++) {
                    numbersOfAnswers[j].add(0);
                }
//            }
        }


        for (ArrayList<Question> q : ProfActivity.answers) {

            int br = 0;
            for (Question a : q) {

                if (a.getClass().equals(RadioQuestion.class)) {
                    numbersOfAnswers[br].set(((RadioQuestion) a).getSelectedAnswer(),
                            numbersOfAnswers[br].get(((RadioQuestion) a).getSelectedAnswer()) + 1);
                } else {
                    int[] selected = ((CheckboxQuestion) a).getSelectedAnswers();
                    for (int i : selected) {
                        numbersOfAnswers[br].set(i, numbersOfAnswers[br].get(i) + 1);
                    }
                }
                br++;
            }
        }
        LinearLayout llRoot = findViewById(R.id.llRoot);

        for (int i = 0; i < numbersOfAnswers.length; i++) {

            TextView tvPitanje = new TextView(this);
            tvPitanje.setTextSize(30);
            tvPitanje.setText(ProfActivity.questions.get(i).getQuestionText());
            llRoot.addView(tvPitanje);


            for (int answer : numbersOfAnswers[i]) {
                TextView tvAnswer = new TextView(this);
                double postotak = 1.0 * answer / ProfActivity.students.size();
                tvAnswer.setText(postotak + " ");
                llRoot.addView(tvAnswer);

            }
        }

    }


}

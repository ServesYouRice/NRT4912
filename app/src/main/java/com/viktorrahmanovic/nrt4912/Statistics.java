package com.viktorrahmanovic.nrt4912;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Statistics extends AppCompatActivity {

    private ArrayList<Integer>[] numbersOfAnswers;
    private ArrayList<String>[] allOptions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

//        numbersOfAnswers = new ArrayList[ProfActivity.questions.size()];
//        for (int j = 0; j < ProfActivity.questions.size(); j++) {
////            for (ArrayList<Integer> answers : numbersOfAnswers) {
//            numbersOfAnswers[j] = new ArrayList<>();
//            for (int i = 0; i < ProfActivity.questions.get(j).getAnswers().length; i++) {
//                numbersOfAnswers[j].add(0);
//            }
////            }
//        }
//
//
//        for (ArrayList<Question> q : ProfActivity.answers) {
//
//            int br = 0;
//            for (Question a : q) {
//
//                if (a.getClass().equals(RadioQuestion.class)) {
//                    numbersOfAnswers[br].set(((RadioQuestion) a).getSelectedAnswer(),
//                            numbersOfAnswers[br].get(((RadioQuestion) a).getSelectedAnswer()) + 1);
//                } else {
//                    int[] selected = ((CheckboxQuestion) a).getSelectedAnswers();
//                    for (int i : selected) {
//                        numbersOfAnswers[br].set(i, numbersOfAnswers[br].get(i) + 1);
//                    }
//                }
//                br++;
//            }
//        }
//        LinearLayout llRoot = findViewById(R.id.llRoot);
//
//        for (int i = 0; i < numbersOfAnswers.length; i++) {
//
//            TextView tvPitanje = new TextView(this);
//            tvPitanje.setTextSize(30);
//            tvPitanje.setText(ProfActivity.questions.get(i).getQuestionText());
//            llRoot.addView(tvPitanje);
//
//
//            for (int answer : numbersOfAnswers[i]) {
//                TextView tvAnswer = new TextView(this);
//                double postotak = 1.0 * answer / ProfActivity.students.size();
//                tvAnswer.setText(postotak + " ");
//                llRoot.addView(tvAnswer);
//
//            }
//        }

        //pokusaj 2
//        for (int i = 0; i < ProfActivity.questions.size(); i++) {
//            for (int j = 0; j < ProfActivity.students.size(); j++) {
//                for (int k = 0; k < ProfActivity.questions.get(i).getNoOfAnswers(); k++) {
//                    for (int l = 0; l < ProfActivity.answers[j].get(k).getSelectedAnswers().length; l++) {
////                        if (ProfActivity.answers[j].get(k).getSelectedAnswers()[l] ==
////                                ProfActivity.questions.get(i).getAnswers()[k]) {
//                        int m = ProfActivity.answers[j].get(k).getSelectedAnswers()[l];
//                        numbersOfAnswers[i].set(m, numbersOfAnswers[i].get(m) + 1);
////                        }
//                    }
//                }
//            }
//        }
//        LinearLayout llRoot = findViewById(R.id.llRoot);
//
//        for (int i = 0; i < numbersOfAnswers.length; i++) {
//
//            TextView tvPitanje = new TextView(this);
//            tvPitanje.setTextSize(30);
//            tvPitanje.setText(ProfActivity.questions.get(i).getQuestionText());
//            llRoot.addView(tvPitanje);
//
//
//            for (int answer : numbersOfAnswers[i]) {
//                TextView tvAnswer = new TextView(this);
//                double postotak = 1.0 * answer / ProfActivity.students.size();
//                tvAnswer.setText(postotak + " ");
//                llRoot.addView(tvAnswer);
//
//
//            }
//        }
//
//    }

        //pokusaj 3

//        for(int i=0;i<ProfActivity.answers.length;i++){
//            for(int j=0;j<ProfActivity.answers[i].size();j++){
//                for (int k = 0;k<ProfActivity.answers[i].get(j).getSelectedAnswers().length;k++){
//                    int selected=ProfActivity.answers[i].get(j).getSelectedAnswers()[k];
//                    numbersOfAnswers[j].set(selected,numbersOfAnswers[j].get(selected)+1);
//                }
//            }
//        }
//
//        LinearLayout llRoot = findViewById(R.id.llRoot);
//
//        for (int i = 0; i < numbersOfAnswers.length; i++) {
//
//            TextView tvPitanje = new TextView(this);
//            tvPitanje.setTextSize(30);
//            tvPitanje.setText(ProfActivity.questions.get(i).getQuestionText());
//            llRoot.addView(tvPitanje);
//
//
//            for (int answer : numbersOfAnswers[i]) {
//                TextView tvAnswer = new TextView(this);
//                double postotak = 1.0 * answer;
//                tvAnswer.setText(postotak + " ");
//                llRoot.addView(tvAnswer);
//
//
//            }
//        }


        //pokusaj 4
        LinearLayout llRoot = findViewById(R.id.llRoot);

//        allOptions = new ArrayList[ProfActivity.questions.size()];
        int brStudenata = ProfActivity.students.size();
        ;

        for (int i = 0; i < ProfActivity.questions.size(); i++) {
            TextView tvPitanje = new TextView(this);
            tvPitanje.setText((i + 1) + ". " + ProfActivity.questions.get(i).getQuestionText());
            tvPitanje.setTextSize(18);
            tvPitanje.setPadding(10,10,10,10);

            llRoot.addView(tvPitanje);

            String[] answers = ProfActivity.questions.get(i).getAnswers();
//            allOptions[i] = new ArrayList<>();
            for (int j = 0; j < ProfActivity.questions.get(i).getNoOfAnswers(); j++) {
                int selektovaniOdgovori = 0;
//                allOptions[i].add(answers[j]);

                for (int n = 0; n < brStudenata; n++) {
                    Question q = ProfActivity.answers[n].get(i);

//                    for (int x = 0; x < q.getSelectedAnswers().length; x++) {
//                        if (q.getSelectedAnswers()[x] == j) {
//                            selektovaniOdgovori++;
//                        }
//                    }
                    if (q.getSelectedAnswers()[j] == 1) {
                            selektovaniOdgovori++;
                }
                }

                int p = 100*selektovaniOdgovori/brStudenata;

//                String procenat = Integer.toString(p);

                TextView tvOpcija = new TextView(this);
                tvOpcija.setText(answers[j] + " - " + p + "%");
                tvOpcija.setTextSize(16);
                tvOpcija.setPadding(20,0,0,0);
                llRoot.addView(tvOpcija);

            }

        }

    }
}

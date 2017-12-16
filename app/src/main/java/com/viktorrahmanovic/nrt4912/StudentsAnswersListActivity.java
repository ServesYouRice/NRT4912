package com.viktorrahmanovic.nrt4912;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentsAnswersListActivity extends AppCompatActivity {

    private int studentId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_answers_list);

        LinearLayout llRoot = (LinearLayout)findViewById(R.id.llRoot);
        TextView tvTv = new TextView(this);
        ArrayList<Question>[] answers = ProfActivity.answers;

        tvTv.setText(ProfActivity.answers[studentId].toString());
//        for(int i =0; i<ProfActivity.answers[studentId].size();i++) {
//            tvTv.setText();
//        }
    }
}

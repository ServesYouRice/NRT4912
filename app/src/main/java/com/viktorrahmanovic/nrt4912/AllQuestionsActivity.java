package com.viktorrahmanovic.nrt4912;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AllQuestionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_questions);

        LinearLayout llRoot = (LinearLayout)findViewById(R.id.llRoot);
        for (Question q: ProfActivity.questions) {
            TextView tvQustion = new TextView(this);

            tvQustion.setText("- " + q.getQuestionText());
            tvQustion.setTextSize(20);
            llRoot.addView(tvQustion);
        }
    }
}

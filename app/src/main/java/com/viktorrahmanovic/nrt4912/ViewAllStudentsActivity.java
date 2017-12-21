package com.viktorrahmanovic.nrt4912;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class ViewAllStudentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_students);

        ArrayList<String> studentsUsername = ProfActivity.students;

        LinearLayout llRoot = (LinearLayout) findViewById(R.id.llRoot);

        for(int i = 0; i < ProfActivity.answers.length; i++) {
            Button btnBtn = new Button(this);
            btnBtn.setText(studentsUsername.get(i));
            llRoot.addView(btnBtn);
            final int studentId = i;
            btnBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), StudentsAnswersListActivity.class);
                    intent.putExtra("StudentID", studentId);
                    startActivity(intent);
                }
            });

        }

    }



}

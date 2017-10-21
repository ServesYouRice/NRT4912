package com.viktorrahmanovic.nrt4912;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class StartPollActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_poll);
    }

    public void allQustionsClicked(View view) {
        Intent intent = new Intent(this,AllQuestionsActivity.class);
        startActivity(intent);
    }

    public void StartNewPoll(View view) {

        int StudentsNo = Integer.parseInt(((EditText)findViewById(R.id.etNoStudents)).getText().toString());
        ProfActivity.answers = new ArrayList[StudentsNo];
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}

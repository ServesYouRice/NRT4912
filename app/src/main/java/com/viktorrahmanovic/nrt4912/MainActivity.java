package com.viktorrahmanovic.nrt4912;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int currentStudent = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view) {

        Intent i = new Intent(this,Login.class);
        startActivity(i);
    }

    public void AnswerQuestion(View view) {

        Intent i = new Intent(this,AnswerQuestionActivity.class);
        i.putExtra("CurrentStudent", currentStudent);

        String username =  ((EditText) findViewById(R.id.etStudentUsername)).getText().toString();
        ProfActivity.students.add(username);

        startActivityForResult(i,0);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ((EditText)findViewById(R.id.etStudentUsername)).setText("");
        currentStudent++;
        if(currentStudent>=ProfActivity.answers.length) {
           finish();
        }
    }
}

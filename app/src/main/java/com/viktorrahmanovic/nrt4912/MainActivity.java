package com.viktorrahmanovic.nrt4912;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
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

        Intent i = new Intent(this, Login.class);
        startActivity(i);
    }

    public void AnswerQuestion(View view) {

        if (!(ProfActivity.answers == null)) {

        Intent i = new Intent(this, AnswerQuestionActivity.class);
        i.putExtra("CurrentStudent", currentStudent);

        String username = ((EditText) findViewById(R.id.etStudentUsername)).getText().toString();
        ProfActivity.students.add(username);

        startActivityForResult(i, 0);

        } else Toast.makeText(this, "Anketa nije u toku!", Toast.LENGTH_SHORT).show();

    }

//    RelativeLayout layout = (RelativeLayout) findViewById(R.id.rlMainActivity);
//    layout.setOnTouchListener(new OnTouchListener()
//    {
//        @Override
//        public boolean onTouch(View view, MotionEvent ev)
//        {
//            hideKeyboard(view);
//            return false;
//        }
//    });


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ((EditText) findViewById(R.id.etStudentUsername)).setText("");
        currentStudent++;
        if (currentStudent >= ProfActivity.answers.length) {
            finish();
        }
    }
}

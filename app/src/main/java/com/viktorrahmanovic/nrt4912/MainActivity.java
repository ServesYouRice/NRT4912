package com.viktorrahmanovic.nrt4912;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


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
        startActivity(i);

    }
}

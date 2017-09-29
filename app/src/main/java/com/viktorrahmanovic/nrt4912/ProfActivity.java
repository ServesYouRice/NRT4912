package com.viktorrahmanovic.nrt4912;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ProfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof);

    }


    public void create(View view) {

        EditText editText = (EditText) findViewById(R.id.etNumberOfQuestions);
        String questionsNumber =editText.getText().toString();
        if(questionsNumber.length()>0) {

            int numberOfQuestions = Integer.parseInt(questionsNumber);

            Intent i = new Intent(this, AddQuestionActivity.class);
            i.putExtra("remainingQuestions",numberOfQuestions);
            startActivity(i);
        }else {
            Toast.makeText(this, "Unesite broj pitanja", Toast.LENGTH_SHORT).show();
        }
    }
}

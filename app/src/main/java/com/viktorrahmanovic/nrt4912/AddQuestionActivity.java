package com.viktorrahmanovic.nrt4912;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class AddQuestionActivity extends AppCompatActivity {

    int questionsRemaining;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);

        RadioButton rb = (RadioButton) findViewById(R.id.rbText);
        rb.setChecked(true);

        Intent i = getIntent();
        questionsRemaining = i.getIntExtra("remainingQuestions", -1);

//        Toast.makeText(this, ""+q, Toast.LENGTH_SHORT).show();

        final EditText etNumberOfAnswersRadio = (EditText)findViewById(R.id.etNumberOfAnswersRadio);
        etNumberOfAnswersRadio.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                Toast.makeText(AddQuestionActivity.this, "pre menjanja", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                Toast.makeText(AddQuestionActivity.this, "u toku", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void afterTextChanged(Editable editable) {

                LinearLayout llOptions = (LinearLayout)findViewById(R.id.llOptions);
                llOptions.removeAllViewsInLayout();
                if(editable.length()!=0) {
                    String s = editable.toString();
                    int br = Integer.parseInt(s);
                    Toast.makeText(AddQuestionActivity.this, s, Toast.LENGTH_SHORT).show();

//                    LinearLayout llOptions = new LinearLayout(getApplicationContext());
//                    llOptions.setId();
//                    llOptions
//                    llOptions.setOrientation(LinearLayout.VERTICAL);
//                    ((RelativeLayout) findViewById(R.id.rlRadioWrapper)).addView(llOptions);

                    for (int i = 0; i < br; i++) {
                        EditText etOption = new EditText(getApplicationContext());
                        etOption.setHint("Naziv opcije " + (i + 1));
                        llOptions.addView(etOption);
                    }

                }
            }

        });



    }


    public void changeQuestionType(View view) {

        int i = view.getId();
        if(i == R.id.rbRadio) {
            findViewById(R.id.rlTextWrapperText).setVisibility(View.GONE);
            findViewById(R.id.rlRadioWrapper).setVisibility(View.VISIBLE);
            findViewById(R.id.rlCheckboxWrapper).setVisibility(View.GONE);
        } else if (i == R.id.rbText) {
            findViewById(R.id.rlTextWrapperText).setVisibility(View.VISIBLE);
            findViewById(R.id.rlRadioWrapper).setVisibility(View.GONE);
            findViewById(R.id.rlCheckboxWrapper).setVisibility(View.GONE);

        } else if (i == R.id.rbCheckbox) {
            findViewById(R.id.rlTextWrapperText).setVisibility(View.GONE);
            findViewById(R.id.rlRadioWrapper).setVisibility(View.GONE);
            findViewById(R.id.rlCheckboxWrapper).setVisibility(View.VISIBLE);
        }
    }

    public void nextQuestionClicked(View view) {

        finish();

        if(--questionsRemaining>0) {
            Intent i = new Intent(this, AddQuestionActivity.class);

            i.putExtra("remainingQuestions", questionsRemaining);
            startActivity(i);
        }




    }
}

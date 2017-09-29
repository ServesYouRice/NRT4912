package com.viktorrahmanovic.nrt4912;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void singin(View view) {

        String username =  ((EditText) findViewById(R.id.etUsername)).getText().toString();
        String password =  ((EditText) findViewById(R.id.etPassword)).getText().toString();

//        if(username.equals("prof") && password.equals("prof")) {
            Intent i = new Intent(this, ProfActivity.class);
            startActivity(i);
//        } else {
//            Toast.makeText(this, "Login podaci nisu ispravni!", Toast.LENGTH_SHORT).show();
//        }

    }
}

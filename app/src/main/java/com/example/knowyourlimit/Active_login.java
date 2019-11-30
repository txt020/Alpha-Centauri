package com.example.knowyourlimit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Active_login extends AppCompatActivity {

    private Handler mHandler = new Handler();

    private EditText username;
    private EditText password;
    private EditText email;
    private Button signup;
    private Button dirsign;

    private boolean firstTime = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_login);

        final SharedPreferences pass = getApplicationContext().getSharedPreferences("savePassBool", 0);

        final Intent intent;

        if(!pass.getBoolean("firstTime", true)){
            intent = new Intent(Active_login.this, PasswordLogin.class);
            startActivity(intent);
            finish();
        } else {
            intent = new Intent(Active_login.this, initialPrompt.class);

            username = (EditText) findViewById(R.id.user);
            password = (EditText) findViewById(R.id.passw);
            email = (EditText) findViewById(R.id.Email);
            signup = (Button) findViewById(R.id.Register);
            dirsign = (Button) findViewById(R.id.dirSignIn);

            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!isEmpty(password) && password.getText().toString().trim().length() == 4) {
                        SharedPreferences.Editor editor = pass.edit();
                        editor.putString("password", password.getText().toString());
                        editor.apply();
                        startActivity(intent);
                        finish();
                    }
                }
            });
        }
    }

    //method to check if editText is empty
    private boolean isEmpty(EditText e) {
        if (e.getText().toString().trim().length() > 0)
            return false;
        return true;
    }
}


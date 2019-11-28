package com.example.knowyourlimit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_login);

        username = (EditText)findViewById(R.id.user);
        password = (EditText)findViewById(R.id.passw);
        email = (EditText) findViewById(R.id.Email);
        signup = (Button)findViewById(R.id.Register);
        dirsign = (Button)findViewById(R.id.dirSignIn);

        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                /*write some sql code where it stores user's username, password, and email*/
                Intent intent = new Intent(Active_login.this, initialPrompt.class);
                startActivity(intent);
            }
        });

        dirsign.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent2 = new Intent(Active_login.this, Login_menu.class);
                startActivity(intent2);
            }
        });

    }
}


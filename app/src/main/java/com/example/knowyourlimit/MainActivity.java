package com.example.knowyourlimit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private EditText email;
    private Button signup;

    DatabaseHelper mydb;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mydb = new DatabaseHelper(this);
        mydb.register("Navid", "navid@jerkoff.com", "password");



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.user);
        password = (EditText)findViewById(R.id.passw);
        email = (EditText) findViewById(R.id.Email);
        signup = (Button)findViewById(R.id.Register);

        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                /*write some sql code where it stores user's username, password, and email*/
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}

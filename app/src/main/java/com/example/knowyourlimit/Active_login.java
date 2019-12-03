package com.example.knowyourlimit;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Active_login extends AppCompatActivity {
    private EditText password;
    private Button signup;
    private TextView error;

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

            password = (EditText) findViewById(R.id.passw);
            signup = (Button) findViewById(R.id.Register);
            error = (TextView)findViewById(R.id.passError);

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
                    else {
                        error.setTextColor(Color.RED);
                        error.setText("Password needs to be 4 numbers");
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


package com.example.knowyourlimit;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.TextView;

public class Login_menu extends AppCompatActivity{
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView something = (TextView)findViewById(R.id.textView);

        something.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
        something.setText("Welcome Back!");

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Login_menu.this, MainMenu.class);
                startActivity(intent);
            }
        }, 2200);
    }
}





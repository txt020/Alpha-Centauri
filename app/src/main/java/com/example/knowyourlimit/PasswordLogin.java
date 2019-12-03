package com.example.knowyourlimit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PasswordLogin extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_enter);

        final SharedPreferences pass = getApplicationContext().getSharedPreferences("savePassBool", 0);
        final EditText passcode = findViewById(R.id.pass);
        final TextView error = findViewById(R.id.inputPassError);
        final Button cont = findViewById(R.id.cont);

        cont.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(passcode.getText().toString().equals(pass.getString("password", ""))){
                    Intent intent2 = new Intent(PasswordLogin.this, Login_menu.class);
                    startActivity(intent2);
                }
                else {
                    error.setTextColor(Color.RED);
                    error.setText("Password incorrect");
                }
            }
        });

    }

}

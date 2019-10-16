package com.example.knowyourlimit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView something = (TextView)findViewById(R.id.textView);
        something.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
        something.setText("You are very gay");
    }
}

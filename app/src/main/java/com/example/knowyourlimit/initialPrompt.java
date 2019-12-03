package com.example.knowyourlimit;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class initialPrompt extends AppCompatActivity {
    private TextView initialError;
    private EditText budget;
    private Button enterInitial;
    private double initialAmount;
    private ArrayList<Expense> budgetHistory = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_prompt);
        initialError = findViewById(R.id.initialError);
        budget = findViewById(R.id.Budget);
        enterInitial = findViewById(R.id.Enter);
        enterInitial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {
                if (budget.getText().toString().trim().length() > 0){
                    initialAmount = Double.parseDouble(budget.getText().toString());
                    Intent myIntent = new Intent(initialPrompt.this, MainMenu.class);
                    Bundle initial = new Bundle();
                    budgetHistory.add(new Expense("Budget Addition", "Initial Budget", initialAmount));
                    initial.putDouble("Initial", initialAmount);
                    myIntent.putExtra("budgetHistory", budgetHistory);
                    myIntent.putExtras(initial);
                    startActivity(myIntent);
                }
                else {
                    initialError.setTextColor(Color.RED);
                    initialError.setText("Please enter in a number");
                }
            }
        });
    }
}


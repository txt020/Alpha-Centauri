package com.example.knowyourlimit;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;
import java.text.DecimalFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class initialPrompt extends AppCompatActivity {
    private TextView textInitial;
    private EditText budget;
    private Button enterInitial;
    private double initialAmount;
    private ArrayList<Expense> budgetHistory = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_prompt);
        textInitial = findViewById(R.id.Initial);
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
            }
        });


    }

}


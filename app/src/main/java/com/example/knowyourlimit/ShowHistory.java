package com.example.knowyourlimit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;
import java.text.DecimalFormat;
import android.view.View;
import android.widget.*;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;
import java.util.List;

public class ShowHistory extends AppCompatActivity {
    //arrayLists for budget history
    ArrayList<Expense> foodHistory, transporHistory, housingHistory, miscHistory, budgetHistory;

    private Button back;
    private TextView history;

    private String totalHistory;

    SharedPreferences pass;

    //main method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);

        pass = getApplicationContext().getSharedPreferences("savePassBool", 0);
        SharedPreferences.Editor editor = pass.edit();

        history = findViewById(R.id.ShowHistory);
        back = findViewById(R.id.backButton);

        //budgetHistory = (ArrayList<Expense>) getIntent().getSerializableExtra("budgetHistory");

        //for (Expense e: budgetHistory)
        //    totalHistory += e.toString();

        totalHistory = (String) getIntent().getSerializableExtra("history");
        history.setText(totalHistory);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

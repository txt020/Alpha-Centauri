package com.example.knowyourlimit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;
import java.text.DecimalFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;


public class MainMenu extends AppCompatActivity {
    String cat [] = {"Food", "Transportaion", "Housing", "Miscellaneous"};

    public double totalBudget, food, transportation, housing,
            miscellaneous, initialBudget;

    float data[] = {(float) food, (float) transportation, (float) housing, (float) miscellaneous};

    DecimalFormat df = new DecimalFormat("#.00");

    private TextView budgetView;
    private EditText username, password, email, initial, textFood, textTransportaion, textHousing,
                        textMiscellaneous;
    private Button signup, submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTextViews();
        submit.setOnClickListener(new View.OnClickListener()){
            @Override
            public void onClick(View w){
                initialBudget = initial
            }
        }

        displayTB();
        setupPieChart(data);
    }

    private void setTextViews() {
        initial = (EditText)findViewById(R.id.InitialBudget);
        textFood = (EditText)findViewById(R.id.FoodExpenses);
        textTransportaion = (EditText)findViewById(R.id.Transportaion);
        textHousing = (EditText) findViewById(R.id.housing);
        textMiscellaneous = (EditText) findViewById(R.id.Miscellaneous);
        submit = (Button) findViewById(R.id.submitButton);
    }

    private void setupPieChart(float[] data) {
        List<PieEntry> pieEntries = new ArrayList<>();
        for(int i = 0; i < data.length; i++){
            pieEntries.add(new PieEntry(data[i], cat[i]));
        }
        PieDataSet dataSet = new PieDataSet(pieEntries,"Pie Chart");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData num = new PieData(dataSet);

        // print chart

        PieChart chart = (PieChart) findViewById(R.id.chart);
        chart.setData(num);
        chart.animateY(1000);
        chart.invalidate();
    }

    private void displayTB() {
        budgetView = (TextView) findViewById(R.id.total_budget);

        totalBudget = initialBudget - (transportation + housing + food + miscellaneous);

        if(totalBudget < 0){
            String totalString = "<font color='black'>Total Budget: </font>" + "<font color='red'>"
                    + "\u0024" + df.format(totalBudget) + "</font>";
            budgetView.setText(Html.fromHtml(totalString), TextView.BufferType.SPANNABLE);
        }
        else {
            String totalString = "<font color='black'>Total Budget: </font>" + "<font color='green'>"
                    + "\u0024" + df.format(totalBudget) + "</font>";
            budgetView.setText(Html.fromHtml(totalString), TextView.BufferType.SPANNABLE);
        }
    }
}

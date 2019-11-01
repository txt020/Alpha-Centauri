package com.example.knowyourlimit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
    String cat [] = {"Food", "Transportaion", "Housing"};
    float data [] = {40.8f, 50.2f, 10.0f};

    private EditText username;
    private EditText password;
    private EditText email;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupPieChart();



    }

    private void setupPieChart() {
        List<PieEntry> pieEntries = new ArrayList<>();
        for(int i = 0; i<data.length;i++){
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
}

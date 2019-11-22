package com.example.knowyourlimit;

import androidx.appcompat.app.AppCompatActivity;

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
<<<<<<< HEAD
=======
    String cat [] = {"Food", "Transportaion", "Housing", "Miscellaneous"};

    //doubles for the money info
    public double totalBudget, food, transportation, housing,
            miscellaneous, initialBudget;

    //this is used for the graph
    float data[] = {(float) food, (float) transportation, (float) housing, (float) miscellaneous};

    DecimalFormat df = new DecimalFormat("#.00");

    //Declare the boxes on the app
    private TextView budgetView;
    private EditText initial;
    private EditText textFood;
    private EditText textTransportaion;
    private EditText textHousing;
    private EditText textMiscellaneous;
    private Button submit, DropDown;

    //main method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        //create dropdown menu object
        DropDown = (Button) findViewById(R.id.DropDownButton);
        //on click listener for the dropdown menu for input
        DropDown.setOnClickListener(new View.OnClickListener(){ //This is the drop down menu
            @Override
            public void onClick(View w){
                if(initial.isShown() && textFood.isShown() && textTransportaion.isShown() && textHousing.isShown() && textMiscellaneous.isShown() && submit.isShown()){
                    //set visibility of the input boxes to not visible
                    initial.setVisibility(View.GONE);
                    textFood.setVisibility(View.GONE);
                    textTransportaion.setVisibility(View.GONE);
                    textHousing.setVisibility(View.GONE);
                    textMiscellaneous.setVisibility(View.GONE);
                    submit.setVisibility(View.GONE);
                }
                else {
                //when the button is clicked hide the input boxes
                initial.setVisibility(View.VISIBLE);
                textFood.setVisibility(View.VISIBLE);
                textTransportaion.setVisibility(View.VISIBLE);
                textHousing.setVisibility(View.VISIBLE);
                textMiscellaneous.setVisibility(View.VISIBLE);
                submit.setVisibility(View.VISIBLE);
                }
            }
        });

        setTextViews();
        //click listener for the submit button
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View w){
                //when the button is pressed the information in the boxes gets parsed a a double then
                    //processed into the graph
                initialBudget = Double.parseDouble(initial.getText().toString());
                food = Double.parseDouble(textFood.getText().toString());
                transportation = Double.parseDouble(textTransportaion.getText().toString());
                housing = Double.parseDouble(textHousing.getText().toString());
                miscellaneous = Double.parseDouble(textMiscellaneous.getText().toString());
                data[0]= (float) food;
                data[1]= (float) transportation;
                data[2]= (float) housing;
                data[3] = (float) miscellaneous;
                displayTB();
                setupPieChart(data);
>>>>>>> 8e9d849cbfdaf07e294e81d2add5f0ea46184b3f

        String cat[] = {"Food", "Transportation", "Housing", "Miscellaneous"};

        public double totalBudget, food, transportation, housing,
                miscellaneous, initialBudget;

        float data[] = {(float) food, (float) transportation, (float) housing, (float) miscellaneous};

        DecimalFormat df = new DecimalFormat("#.00");

        private TextView budgetView;
        private EditText initial;
        private EditText textFood;
        private EditText textTransportaion;
        private EditText textHousing;
        private EditText textMiscellaneous;
        private Button signup, submit, DropDown;

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_mainmenu);

            DropDown = (Button) findViewById(R.id.DropDownButton);
            DropDown.setOnClickListener(new View.OnClickListener() { //This is the drop down menu
                @Override
                public void onClick(View w) {
                    if (initial.isShown() && textFood.isShown() && textTransportaion.isShown() && textHousing.isShown() && textMiscellaneous.isShown() && submit.isShown()) {
                        initial.setVisibility(View.GONE);
                        textFood.setVisibility(View.GONE);
                        textTransportaion.setVisibility(View.GONE);
                        textHousing.setVisibility(View.GONE);
                        textMiscellaneous.setVisibility(View.GONE);
                        submit.setVisibility(View.GONE);
                    } else {
                        initial.setVisibility(View.VISIBLE);
                        textFood.setVisibility(View.VISIBLE);
                        textTransportaion.setVisibility(View.VISIBLE);
                        textHousing.setVisibility(View.VISIBLE);
                        textMiscellaneous.setVisibility(View.VISIBLE);
                        submit.setVisibility(View.VISIBLE);
                    }
                }
            });
            setTextViews();
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View w) {
                    initialBudget = Double.parseDouble(initial.getText().toString());
                    food = Double.parseDouble(textFood.getText().toString());
                    transportation = Double.parseDouble(textTransportaion.getText().toString());
                    housing = Double.parseDouble(textHousing.getText().toString());
                    miscellaneous = Double.parseDouble(textMiscellaneous.getText().toString());
                    data[0] = (float) food;
                    data[1] = (float) transportation;
                    data[2] = (float) housing;
                    data[3] = (float) miscellaneous;
                    displayTB();
                    setupPieChart(data);

                }
            });


<<<<<<< HEAD
        }

        private void setTextViews () {
            initial = (EditText) findViewById(R.id.InitialBudget);
            textFood = (EditText) findViewById(R.id.FoodExpenses);
            textTransportaion = (EditText) findViewById(R.id.Transportaion);
            textHousing = (EditText) findViewById(R.id.housing);
            textMiscellaneous = (EditText) findViewById(R.id.Miscellaneous);
            submit = (Button) findViewById(R.id.submitButton);
=======
    //method to initialize the text boxes
    private void setTextViews() {
        initial = (EditText)findViewById(R.id.InitialBudget);
        textFood = (EditText)findViewById(R.id.FoodExpenses);
        textTransportaion = (EditText)findViewById(R.id.Transportaion);
        textHousing = (EditText) findViewById(R.id.housing);
        textMiscellaneous = (EditText) findViewById(R.id.Miscellaneous);
        submit = (Button) findViewById(R.id.submitButton);
    }

    //method to created the pie chart
    private void setupPieChart(float[] data) {
        List<PieEntry> pieEntries = new ArrayList<>();
        for(int i = 0; i < data.length; i++){
            pieEntries.add(new PieEntry(data[i], cat[i]));
>>>>>>> 8e9d849cbfdaf07e294e81d2add5f0ea46184b3f
        }

        private void setupPieChart ( float[] data){
            List<PieEntry> pieEntries = new ArrayList<>();
            for (int i = 0; i < data.length; i++) {
                pieEntries.add(new PieEntry(data[i], cat[i]));
            }
            PieDataSet dataSet = new PieDataSet(pieEntries, "Pie Chart");
            dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            PieData num = new PieData(dataSet);

<<<<<<< HEAD
            // print chart

            PieChart chart = (PieChart) findViewById(R.id.chart);
            chart.setData(num);
            chart.animateY(1000);
            chart.invalidate();
        }
=======
        PieChart chart = (PieChart) findViewById(R.id.chart);
        chart.setData(num);
        chart.animateY(1000);
        chart.setContentDescription("");
        chart.invalidate();
    }

    //method to display the total budget left
    private void displayTB() {
        budgetView = (TextView) findViewById(R.id.total_budget);
>>>>>>> 8e9d849cbfdaf07e294e81d2add5f0ea46184b3f

        private void displayTB () {
            budgetView = (TextView) findViewById(R.id.total_budget);

            totalBudget = initialBudget - (transportation + housing + food + miscellaneous);

            if (totalBudget < 0) {
                String totalString = "<font color='black'>Total Budget: </font>" + "<font color='red'>"
                        + "\u0024" + df.format(totalBudget) + "</font>";
                budgetView.setText(Html.fromHtml(totalString), TextView.BufferType.SPANNABLE);
            } else {
                String totalString = "<font color='black'>Total Budget: </font>" + "<font color='green'>"
                        + "\u0024" + df.format(totalBudget) + "</font>";
                budgetView.setText(Html.fromHtml(totalString), TextView.BufferType.SPANNABLE);
            }
        }

}

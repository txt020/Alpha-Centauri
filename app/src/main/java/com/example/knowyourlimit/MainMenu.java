package com.example.knowyourlimit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
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


public class MainMenu extends AppCompatActivity {
// Hello there this is a demo stuff
    String cat [] = {"Food", "Transportaion", "Housing", "Miscellaneous"};

    //arrayLists for budget history
    ArrayList<Expense> budgetHistory = new ArrayList<>();

    //doubles for the money info
    public double totalBudget, food, transportation, housing,
            miscellaneous, initialBudget, extraBudget;

    //this is used for the graph
    float data[] = {(float)food, (float)transportation, (float)housing, (float)miscellaneous};

    DecimalFormat df = new DecimalFormat("#.00");

    //Declare the boxes on the app
    private TextView budgetView;
    private EditText textFood, textTransportaion, textHousing, textMiscellaneous,
                    foodDec, transpDec, housingDec, micellDec, amountAddBudget, textBudget;
    private Button submitFood, submitTransp, submitHousing, submitMisc, submitBudget, viewHistory;
    private ConstraintLayout constraintLayout;

    //main method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        Bundle b = getIntent().getExtras();
        initialBudget = b.getDouble("Initial");
        budgetHistory.add(new Expense("Budget Addition", "Initial Budget", initialBudget));
        displayTB();

        //create scroll layout
        constraintLayout = (ConstraintLayout)findViewById(R.id.scrollLayout);

        //initialize up text views and buttons
        setTextViewsAndButtons();

        //click listeners for submit buttons
        submitFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isEmpty(textFood) && !isEmpty(foodDec)){
                    budgetHistory.add(new Expense("Food",
                            editTextString(textFood), editTextDouble(foodDec)));
                    food += editTextDouble(foodDec);
                    data[0] = (float) food;
                    textFood.setText("");
                    foodDec.setText("");
                    displayTB();
                    setupPieChart(data);
                }
            }
        });

        submitTransp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isEmpty(textTransportaion) && !isEmpty(transpDec)){
                    budgetHistory.add(new Expense("Transportation",
                            editTextString(textTransportaion), editTextDouble(transpDec)));
                    transportation += editTextDouble(transpDec);
                    data[1] = (float) transportation;
                    textTransportaion.setText("");
                    transpDec.setText("");
                    displayTB();
                    setupPieChart(data);
                }
            }
        });

        submitHousing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isEmpty(textHousing) && !isEmpty(housingDec)){
                    budgetHistory.add(new Expense("Housing",
                            editTextString(textHousing), editTextDouble(housingDec)));
                    housing += editTextDouble(housingDec);
                    data[2] = (float) housing;
                    textHousing.setText("");
                    housingDec.setText("");
                    displayTB();
                    setupPieChart(data);
                }
            }
        });

        submitMisc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isEmpty(textMiscellaneous) && !isEmpty(micellDec)){
                    budgetHistory.add(new Expense("Miscellaneous",
                            editTextString(textMiscellaneous), editTextDouble(micellDec)));
                    miscellaneous += editTextDouble(micellDec);
                    data[3] = (float) miscellaneous;
                    textMiscellaneous.setText("");
                    micellDec.setText("");
                    displayTB();
                    setupPieChart(data);
                }
            }
        });

        submitBudget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isEmpty(textBudget) && !isEmpty(amountAddBudget)){
                    budgetHistory.add(new Expense("Budget Addition",
                            editTextString(textBudget), editTextDouble(amountAddBudget)));
                    extraBudget += editTextDouble(amountAddBudget);
                    textBudget.setText("");
                    amountAddBudget.setText("");
                    displayTB();
                    setupPieChart(data);
                }
            }
        });

        viewHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, ShowHistory.class);
                intent.putExtra("budgetHistory", budgetHistory);
                startActivity(intent);
            }
        });
    }

    //method to initialize the text boxes
    private void setTextViewsAndButtons() {
        //descriptions
        textFood = (EditText)findViewById(R.id.FoodText);
        textTransportaion = (EditText)findViewById(R.id.TransportationText);
        textHousing = (EditText) findViewById(R.id.HousingText);
        textMiscellaneous = (EditText) findViewById(R.id.MicellText);
        textBudget = findViewById(R.id.TextBudget);

        //amount
        foodDec = (EditText) findViewById(R.id.FoodExpenses);
        transpDec = (EditText) findViewById(R.id.Transportaion);
        housingDec = (EditText) findViewById(R.id.housing);
        micellDec = (EditText) findViewById(R.id.Miscellaneous);
        amountAddBudget = (EditText)findViewById(R.id.AddBudget);


        //submit buttons
        submitFood = findViewById(R.id.submitFood);
        submitTransp = findViewById(R.id.submitTransp);
        submitHousing = findViewById(R.id.submitHousing);
        submitMisc = findViewById(R.id.submitMisc);
        submitBudget = findViewById(R.id.submitBudget);
        viewHistory = findViewById(R.id.HistoryButton);
    }

    //method to created the pie chart
    private void setupPieChart(float[] data) {
        List<PieEntry> pieEntries = new ArrayList<>();
        for(int i = 0; i < data.length; i++){
            if(data[i] != 0)
                pieEntries.add(new PieEntry(data[i], cat[i]));
        }
        PieDataSet dataSet = new PieDataSet(pieEntries,"");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData num = new PieData(dataSet);

        // print chart
        PieChart chart = (PieChart) findViewById(R.id.chart);
        chart.setData(num);
        chart.animateY(1000);
        chart.getDescription().setText("");
        chart.invalidate();
    }

    //method to display the total budget left
    private void displayTB() {
        budgetView = (TextView) findViewById(R.id.total_budget);
        totalBudget = addTotalBudget(initialBudget, transportation, housing, food, miscellaneous, extraBudget);

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

    //method to check if editText is empty
    private boolean isEmpty(EditText e) {
        if (e.getText().toString().trim().length() > 0)
            return false;

        return true;
    }

    //method to get description text from edittext object
    private String editTextString(EditText e){
        return e.getText().toString();
    }

    //method to convert edit text value from string to double
    private double editTextDouble(EditText e){
        return Double.parseDouble(e.getText().toString());
    }

    //method to calculate total budget
    public static double addTotalBudget(double initialBudget, double transportation, double housing,
                                  double food, double miscellaneous, double extraBudget){
        return initialBudget + extraBudget - (transportation + housing + food + miscellaneous);
    }
}
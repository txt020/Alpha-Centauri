package com.example.knowyourlimit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
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


public class MainMenu extends AppCompatActivity {
    String cat [] = {"Food", "Transportaion", "Housing", "Miscellaneous"};

    //arrayLists for budget history **not used**
    ArrayList<Expense> budgetHistory = new ArrayList<>();

    //String for the history
    HistoryString history = new HistoryString("");

    //array to hold totals (0 = totalBudget, 1 = food, 2 = transp 3 = housing 4 = miscellaneous
    //5 = initialBudget 6 = extraBudget
    public double totals[] = new double[7];

    //this is used for the graph
    float data[] = {(float)totals[1], (float)totals[2], (float)totals[3], (float)totals[4]};

    DecimalFormat df = new DecimalFormat("#.00");

    //Declare the boxes on the app
    private TextView budgetView;
    private EditText textFood, textTransportaion, textHousing, textMiscellaneous,
            foodDec, transpDec, housingDec, micellDec, amountAddBudget, textBudget;
    private Button submitFood, submitTransp, submitHousing, submitMisc, submitBudget, viewHistory,
            resetButton;

    //main method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        final SharedPreferences pass = getApplicationContext().getSharedPreferences("savePassBool", 0);
        final SharedPreferences.Editor editor = pass.edit();
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        initialSetup(pass, editor);

        //initialize up text views and buttons
        setTextViewsAndButtons();

        //click listeners for submit buttons
        submitFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isEmpty(textFood) && !isEmpty(foodDec)){
                    if(editTextDouble(foodDec) <= 70 && editTextDouble(foodDec) > 0) { //Limits to change
                        food(editor);
                    } else
                    {
                        //pop up
                        builder.setCancelable(true);
                        builder.setMessage("Are you sure you entered: $" + editTextDouble(foodDec) +
                                " for " + editTextString(textFood));
                        builder.setPositiveButton("Confirm",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        food(editor);
                                    }
                                });
                        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                }
            }
        });

        submitTransp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isEmpty(textTransportaion) && !isEmpty(transpDec)){
                    if(editTextDouble(transpDec) <= 100 && editTextDouble(transpDec) > 0) { //Limits to change
                        transp(editor);
                    } else {
                        //pop up
                        builder.setCancelable(true);
                        builder.setMessage("Are you sure you entered: $" + editTextDouble(transpDec) +
                                " for " + editTextString(textTransportaion));
                        builder.setPositiveButton("Confirm",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        transp(editor);
                                    }
                                });
                        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                }
            }
        });

        submitHousing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isEmpty(textHousing) && !isEmpty(housingDec)){
                    if(editTextDouble(housingDec) <= 3000 && editTextDouble(housingDec) > 0) { //Limits to change
                        housing(editor);
                    } else
                    {
                        builder.setCancelable(true);
                        builder.setMessage("Are you sure you entered: $" + editTextDouble(housingDec) +
                                " for " + editTextString(textHousing));
                        builder.setPositiveButton("Confirm",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        housing(editor);
                                    }
                                });
                        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                }
            }
        });

        submitMisc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isEmpty(textMiscellaneous) && !isEmpty(micellDec)){
                    if(editTextDouble(micellDec) <= 100 && editTextDouble(micellDec) > 0) {
                        misc(editor);
                    }
                    else
                    {
                        builder.setCancelable(true);
                        builder.setMessage("Are you sure you entered: $" + editTextDouble(micellDec) +
                                " for " + editTextString(textMiscellaneous));
                        builder.setPositiveButton("Confirm",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        misc(editor);
                                    }
                                });
                        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                }
            }
        });

        submitBudget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isEmpty(textBudget) && !isEmpty(amountAddBudget)){
                    history.addHistory(new Expense("Budget Addition",
                            editTextString(textBudget), editTextDouble(amountAddBudget)));
                    budgetHistory.add(new Expense("Budget Addition",
                            editTextString(textBudget), editTextDouble(amountAddBudget)));
                    totals[6] += editTextDouble(amountAddBudget);
                    textBudget.setText("");
                    amountAddBudget.setText("");
                    editor.putFloat("extra", (float)totals[6]);
                    editor.putString("history", history.getHistory());
                    editor.apply();
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
                intent.putExtra("history", history.getHistory());
                startActivity(intent);
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {

            SharedPreferences.Editor editor = pass.edit();
            @Override
            public void onClick(View v) {
                builder.setCancelable(true);
                builder.setTitle("Reset Data");
                builder.setMessage("Are you sure?");

                builder.setPositiveButton("Confirm",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                reset(pass, editor);
                                Intent intent = new Intent(MainMenu.this, initialPrompt.class);
                                startActivity(intent);
                            }
                        });
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }


    private void food(SharedPreferences.Editor editor){
        history.addHistory(new Expense("Food",
                editTextString(textFood), editTextDouble(foodDec)));
//                      budgetHistory.add(new Expense("Food",
//                            editTextString(textFood), editTextDouble(foodDec)));
        totals[1] += editTextDouble(foodDec);
        data[0] = (float) totals[1];
        textFood.setText("");
        foodDec.setText("");
        editor.putFloat("food", (float) totals[1]);
        editor.putString("history", history.getHistory());
        editor.apply();
        displayTB();
        setupPieChart(data);
    }

    private void transp(SharedPreferences.Editor editor){
        history.addHistory(new Expense("Transportation",
                editTextString(textTransportaion), editTextDouble(transpDec)));
//      budgetHistory.add(new Expense("Transportation",
//              editTextString(textTransportaion), editTextDouble(transpDec)));
        totals[2] += editTextDouble(transpDec);
        data[1] = (float) totals[2];
        textTransportaion.setText("");
        transpDec.setText("");
        editor.putFloat("transp", (float)totals[2]);
        editor.putString("history", history.getHistory());
        editor.apply();
        displayTB();
        setupPieChart(data);
    }

    private void housing(SharedPreferences.Editor editor){
        history.addHistory(new Expense("Housing",
                editTextString(textHousing), editTextDouble(housingDec)));
//      budgetHistory.add(new Expense("Housing",
//              editTextString(textHousing), editTextDouble(housingDec)));
        totals[3] += editTextDouble(housingDec);
        data[2] = (float) totals[3];
        textHousing.setText("");
        housingDec.setText("");
        editor.putFloat("housing", (float) totals[3]);
        editor.putString("history", history.getHistory());
        editor.apply();
        displayTB();
        setupPieChart(data);
    }

    private void misc(SharedPreferences.Editor editor){
        history.addHistory(new Expense("Miscellaneous",
                editTextString(textMiscellaneous), editTextDouble(micellDec)));
//      budgetHistory.add(new Expense("Miscellaneous",
//      editTextString(textMiscellaneous), editTextDouble(micellDec)));
        totals[4] += editTextDouble(micellDec);
        data[3] = (float) totals[4];
        textMiscellaneous.setText("");
        micellDec.setText("");
        editor.putFloat("misc", (float)totals[4]);
        editor.putString("history", history.getHistory());
        editor.apply();
        displayTB();
        setupPieChart(data);
    }

    private void reset(SharedPreferences pass, SharedPreferences.Editor editor) {
        editor.putFloat("food", 0);
        editor.putFloat("total", 0);
        editor.putFloat("transp", 0);
        editor.putFloat("housing", 0);
        editor.putFloat("misc", 0);
        editor.putFloat("initial", 0);
        editor.putFloat("extra", 0);
        editor.putBoolean("firstTime", true);
        editor.putString("history", new HistoryString("").getHistory());
        editor.apply();
        for(int i = 0; i < totals.length; i++){
            totals[i] = 0;
        }
        for(int i = 0; i < data.length; i++){
            data[i] = 0;
        }
    }

    private void initialSetup(SharedPreferences pass, SharedPreferences.Editor editor) {
        if(pass.getBoolean("firstTime", true)){
            budgetHistory = (ArrayList<Expense>) getIntent().getSerializableExtra("budgetHistory");
            editor.putBoolean("firstTime", false);
            Bundle b = getIntent().getExtras();
            totals[5] = b.getDouble("Initial");
            editor.putFloat("initial", (float)b.getDouble("Initial"));
            history.addHistory(new Expense("Budget Addition", "Initial Budget", totals[5]));
            editor.putString("history", history.getHistory());
            editor.apply();
        } else {
            totals[0] = pass.getFloat("total", 0);
            totals[1] = pass.getFloat("food", 0);
            totals[2] = pass.getFloat("transp", 0);
            totals[3] = pass.getFloat("housing", 0);
            totals[4] = pass.getFloat("misc", 0);
            totals[5] = pass.getFloat("initial", 0);
            totals[6] = pass.getFloat("extra", 0);
            history = new HistoryString(pass.getString("history", ""));
            data[0] = (float)totals[1];
            data[1] = (float)totals[2];
            data[2] = (float)totals[3];
            data[3] = (float)totals[4];
        }
        displayTB();
        setupPieChart(data);
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
        housingDec = (EditText) findViewById(R.id.Housing);
        micellDec = (EditText) findViewById(R.id.Miscellaneous);
        amountAddBudget = (EditText)findViewById(R.id.AddBudget);


        //submit buttons
        submitFood = findViewById(R.id.submitFood);
        submitTransp = findViewById(R.id.submitTransp);
        submitHousing = findViewById(R.id.submitHousing);
        submitMisc = findViewById(R.id.submitMisc);
        submitBudget = findViewById(R.id.submitBudget);
        viewHistory = findViewById(R.id.HistoryButton);
        resetButton = findViewById(R.id.resetButton);
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
        SharedPreferences pass = getApplicationContext().getSharedPreferences("savePassBool", 0);
        SharedPreferences.Editor editor = pass.edit();

        budgetView = (TextView) findViewById(R.id.total_budget);
        totals[0] = addTotalBudget(totals[5], totals[2], totals[3], totals[1], totals[4], totals[6]);
        editor.putFloat("total", (float)totals[0]);
        editor.apply();

        if(totals[0] < 0){
            String totalString = "<font color='black'>Total Budget: </font>" + "<font color='red'>"
                    + "\u0024" + df.format(totals[0]) + "</font>";
            budgetView.setText(Html.fromHtml(totalString), TextView.BufferType.SPANNABLE);
        }
        else {
            String totalString = "<font color='black'>Total Budget: </font>" + "<font color='green'>"
                    + "\u0024" + df.format(totals[0]) + "</font>";
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
package com.example.knowyourlimit;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;
import java.text.DecimalFormat;

public class LoginActivity extends AppCompatActivity{

    public double totalBudget, transportation, housing, food, miscellaneous, initialBudget = 18767.566;
    private TextView budgetView;
    DecimalFormat df = new DecimalFormat("#.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        budgetView = (TextView) findViewById(R.id.textView2);

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

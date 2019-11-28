package com.example.knowyourlimit;

import java.text.DecimalFormat;

public class Expense implements java.io.Serializable{
    private String category, desc;
    private double amount;

    private DecimalFormat df = new DecimalFormat("#.00");

    //empty constructor
    public Expense(){
        category = null;
        desc = null;
        amount = 0;
    }

    //constructor with parameters
    public Expense(String category, String desc, double amount){
        this.category = category;
        this.desc = desc;
        this.amount = amount;
    }

    //to string
    public String toString() {
        return "Category: " + this.category + "\n\tDescription: " + this.desc + "\n\tAmount: $" + df.format(this.amount) + "\n\n";
    }
}

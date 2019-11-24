package com.example.knowyourlimit;

public class Expense {
    private String category, desc;
    private double amount;

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
}

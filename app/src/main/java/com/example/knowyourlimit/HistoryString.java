package com.example.knowyourlimit;

public class HistoryString {
    private String history;

    public HistoryString(Expense e) {
        this.history += e.toString();
    }

    public HistoryString (String s) {
        this.history = s;
    }

    public String getHistory() {
        return this.history;
    }

    public void addHistory (Expense e){
        this.history += e.toString();
    }
}

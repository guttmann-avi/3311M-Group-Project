package src.BudgetingSystem;

import java.util.Date;

public class Income {

    private double amount;
    private String Income_source;
    private String frequency; 
    private Date Income_tabulation_date;
    Purchases purchases = new Purchases(); // aggregation is used

    public Income(double amount, String Income_source, Date Income_tabulation_date) {
        this.amount = amount;
        this.Income_source = Income_source;
        this.Income_tabulation_date = Income_tabulation_date;
        this.frequency = "";
    }
    public Income(double amount, String Income_source, Date Income_tabulation_date, String frequency) {
        this.amount = amount;
        this.Income_source = Income_source;
        this.Income_tabulation_date = Income_tabulation_date;
        this.frequency = frequency;
    }

    public double getBaseAmount() {
        return this.amount;
    }

    public double getAmount() {
        switch(frequency){
            case "Weekly": 
                return amount*52;
            case "Monthly": 
                return amount*12;
        }
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSource() {
        return Income_source;
    }

    public void setSource(String source) {
        this.Income_source = source;
    }

    public Date getDate() {
        return Income_tabulation_date;
    }

    public void setDate(Date date) {
        this.Income_tabulation_date = date;
    }
    public String getFrequency() {
        return frequency;
    }
}
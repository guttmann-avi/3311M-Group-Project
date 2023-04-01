package src.BudgetingSystem;

import java.util.Date;

public class Income {

    private double amount;
    private String Income_source;
    private String frequency; 
    private Date Income_tabulation_date;

    public Income(double amount, String Income_source) {
        this.amount = amount;
        this.Income_source = Income_source;
        this.Income_tabulation_date = new Date();
        this.frequency = "";
    }

    public Income(double amount, String Income_source, String frequency) {
        this.amount = amount;
        this.Income_source = Income_source;
        this.Income_tabulation_date = new Date();
        this.frequency = frequency;
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

    public double getAmountYearly() {
        switch(frequency) {
            case "Monthly": 
                return amount*12;
            case "Weekly": 
                return amount*52;
        }
        return amount;
    }

    public double getAmountMonthly() {
        switch(frequency) {
            case "Weekly": 
                return amount*4;
        }
        return amount;
    }

    public double getAmountWeekly() {
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

    public String outputAlert() {
        String result = null;
        if (getAmountYearly() < 0) {
            result="The Income at this point is neagtive";
        }
        return result;
    }
}
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
        if (frequency == null) {
            this.frequency = "Yearly";
        } else {
            this.frequency = frequency;
        }
    }

    public Income(double amount, String Income_source, Date Income_tabulation_date, String frequency) {
        this.amount = amount;
        this.Income_source = Income_source;
        this.Income_tabulation_date = Income_tabulation_date;
        if (frequency == null) {
            this.frequency = "Yearly";
        } else {
            this.frequency = frequency;
        }
    }

    public double getBaseAmount() {
        return this.amount;
    }

    public double getAmountAllTime(double value) {
        switch(frequency) {
            case "Yearly":
                return amount*Math.floor(Math.abs((value/86400000)/365.25));
            case "Monthly": 
                return amount*Math.floor(Math.abs((value/86400000)/30.4));
            case "Weekly": 
                return amount*Math.floor(Math.abs((value/86400000)/7));
        }
        return amount;
    }

    public double getAmountYearly(double value) {
        switch(frequency) {
            case "Monthly": 
                return amount*Math.floor(Math.abs((value/86400000)/30.4));
            case "Weekly": 
                return amount*Math.floor(Math.abs((value/86400000)/7));
        }
        return amount;
    }

    public double getAmountMonthly(double value) {
        switch(frequency) {
            case "Weekly": 
                return amount*Math.floor(Math.abs((value/86400000)/4));
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
}
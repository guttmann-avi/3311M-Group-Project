package src.PrintingInformation;

import src.BudgetingSystem.Income;
import src.UserImplements.User;
import java.lang.String;
import java.util.Date;

public class IncomeInformation implements TotalInformation {

    private double amount;
    private String income_source;

    public IncomeInformation(User user, Boolean allTime, String time) {
        if (allTime) {
            amount = user.totalUserIncomeAllTime();
        } else {
            for (Income income : user.getIncome()) {
               amount += getValue(income, time);
            }
        }
        this.income_source = user.getName();
        printinfo();
    }

    private double getValue(Income income, String time) {
        Date holder = new Date();
        holder.setSeconds(0);
        holder.setMinutes(0);
        holder.setHours(0);
        Long timeValue = holder.getTime();
        holder.setSeconds(59);
        holder.setMinutes(59);
        holder.setHours(23);
        if (income.getFrequency().equalsIgnoreCase("One Time Bonus")) {
            return income.getBaseAmount();
        } else if (time.equalsIgnoreCase("Yearly")) {
            if (income.getDate().getTime() >= timeValue-Long.parseLong("31536001000") 
            && income.getDate().before(holder)) {
                    return income.getAmountYearly(timeValue - income.getDate().getTime());
                }
        } else if (time.equalsIgnoreCase("Monthly")) {
           if (income.getDate().getTime() >= timeValue-Long.parseLong("2678401000") 
            && income.getDate().before(holder)) {
                    return income.getAmountMonthly(timeValue - income.getDate().getTime());
                }
        } else if (time.equalsIgnoreCase("Weekly")) {
            if (income.getDate().getTime() >= timeValue-Long.parseLong("604801000") 
            && income.getDate().before(holder)) {
                    return income.getAmountWeekly();
                }
        }
        return 0.00;
    }

    @Override
    public String printinfo() {
        String resultString;
        if (amount < 0) {
            resultString = "Amount cannot be negative";
        } else {
            resultString = "User " + income_source + " Income is " + String.format("%.2f", amount);
        }
        return resultString;
    }
}

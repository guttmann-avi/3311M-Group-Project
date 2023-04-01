package src.PrintingInformation;

import java.util.Date;

import src.BudgetingSystem.Income;
import src.BudgetingSystem.Purchases;
import src.UserImplements.User;

public class MoneyLeftInformation implements TotalInformation {

    private String info = "";

    public MoneyLeftInformation(User user, boolean allTime, String time) {
        double moneyLeft = 0.00;
        if (allTime) {
            moneyLeft = user.totalUserIncomeAllTime();
        } else {
            for (Income income : user.getIncome()) {
                moneyLeft += getValue(income, time);
            }
        }
        for (Purchases purchases : user.getPurchases()) {
            if (allTime) {
                moneyLeft = moneyLeft - purchases.getAmount();
            } else {
                if (purchases.getDate() != null && checkDate(purchases, time)) {
                    moneyLeft = moneyLeft - purchases.getAmount();
                }
            }
        }
        info  = "Money Left: " + String.format("%.2f", moneyLeft) + "\n"; 
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
                    return income.getAmountYearly();
                }
        } else if (time.equalsIgnoreCase("Monthly")) {
           if (income.getDate().getTime() >= timeValue-Long.parseLong("2678401000") 
            && income.getDate().before(holder)) {
                    return income.getAmountMonthly();
                }
        } else if (time.equalsIgnoreCase("Weekly")) {
            if (income.getDate().getTime() >= timeValue-Long.parseLong("604801000") 
            && income.getDate().before(holder)) {
                    return income.getAmountWeekly();
                }
        } 
        return 0.00;
    }

    private Boolean checkDate(Purchases purchase, String time) {
        Date holder = new Date();
        holder.setSeconds(0);
        holder.setMinutes(0);
        holder.setHours(0);
        Long timeValue = holder.getTime();
        holder.setSeconds(59);
        holder.setMinutes(59);
        holder.setHours(23);
        if (time.equalsIgnoreCase("Yearly")) {
            if (purchase.getDate().getTime() >= timeValue-Long.parseLong("31536001000") 
            && purchase.getDate().before(holder)) {
                    return true;
                }
        } else if (time.equalsIgnoreCase("Monthly")) {
           if (purchase.getDate().getTime() >= timeValue-Long.parseLong("2678401000") 
            && purchase.getDate().before(holder)) {
                    return true;
                }
        } else if (time.equalsIgnoreCase("Weekly")) {
            if (purchase.getDate().getTime() >= timeValue-Long.parseLong("604801000") 
            && purchase.getDate().before(holder)) {
                    return true;
                } 
        }
        return false;
    }


    public String printinfo() {
        return this.info;
    }
}
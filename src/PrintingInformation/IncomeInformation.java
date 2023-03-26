package src.PrintingInformation;

import java.util.Date;

import src.BudgetingSystem.Income;
import src.BudgetingSystem.Purchases;
import src.UserImplements.User;
import java.lang.String;

public class IncomeInformation implements TotalInformation {

    // user class will get
    // from user to income then print
    // assciation is used in constructor
    private double amount;
    private String Income_source;
    private Date Income_tabulation_date;
    private Income incomes;

    public IncomeInformation(Income income) {

        amount = income.getAmount();
        Income_tabulation_date = income.getDate();
        Income_source = income.getSource();
        
        printinfo();
    }

    @Override
    public String printinfo() {
        String resultString;
        if(amount < 0) {
            resultString="Amount cannot be negative";
        }
        else{
        String amount_string = " " + amount;
        resultString = "User " + Income_source + " Income is" + String.format(amount_string, "%.2f");
       }
        return resultString;
    }
}

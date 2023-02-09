package PrintingInformation;

import java.util.Date;

import BudgetingSystem.Income;
import BudgetingSystem.Purchases;
import userImplements.User;
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
        String amount_string = " " + amount;
        String reulString = "This " + Income_source + " is" + String.format(amount_string, "%2f");
        return reulString;
    }
}

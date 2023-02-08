package PrintingInformation;

import java.util.Date;

import BudgetingSystem.Income;
import BudgetingSystem.Purchases;
import userImplements.User;

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

        String reulString = "This" + Income_source + "is" + amount + "as of" + Income_tabulation_date;
        return reulString;
    }
}

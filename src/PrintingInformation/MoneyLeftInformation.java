package src.PrintingInformation;

import src.BudgetingSystem.Purchases;
import src.UserImplements.User;

public class MoneyLeftInformation implements TotalInformation {

    private String info = "";

    public MoneyLeftInformation(User user) {
        double moneyLeft = user.getIncome().getAmount();
        for (Purchases purchases : user.getPurchases()) {
            moneyLeft = moneyLeft - purchases.getAmount();
        }
        if(moneyLeft<0)
        {
            info="There is no more money left";
        }
        info  = "Money Left: " + String.format("%.2f", moneyLeft) + "\n"; 
    }

    public String printinfo() {
        return this.info;
    }
}
package src.PrintingInformation;

import src.BudgetingSystem.Purchases;
import src.userImplements.User;

public class MoneyLeftInformation implements TotalInformation {

    private String info = "";

    public MoneyLeftInformation(User user) {
        double moneyLeft = user.getIncome().getAmount();
        for (Purchases purchases : user.getPurchases()) {
            moneyLeft = moneyLeft - purchases.getAmount();
        }
        info  = "Money Left: " + String.format("%.2f", moneyLeft) + "\n"; 
    }

    public String printinfo() {
        return this.info;
    }
}
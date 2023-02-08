package PrintingInformation;

import BudgetingSystem.Income;

public class IncomeInformation implements TotalInformation {
    
    String incomeInformation;// aggregation is used

    public IncomeInformation(Income incomes) {
        if (incomes != null) {
            incomeInformation = "Income: " + incomes.getAmount() + "\n";
        }
    }
    
    public IncomeInformation() {
        this(null);
    }

    public String printinfo() {
        return this.incomeInformation;
     }
}

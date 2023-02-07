package PrintingInformation;

import java.util.ArrayList;
import java.util.Date;

import BudgetingSystem.Income;
import BudgetingSystem.Purchases;

public class IncomeInformation  implements TotalInformation{
    
   Income income= new Income(0, null, null);// aggregation is used

    public IncomeInformation(Income incomes)
    {
        printinfo();
    }
    public IncomeInformation()
    {
        this(null);
    }

    public String printinfo(){


    

        return null;
     }
}

package src.PrintingInformation;

import java.util.Date;

import src.BudgetingSystem.Purchases;
import src.userImplements.User;

public class purchaseInformation implements TotalInformation{
  
    String info = "";

    public purchaseInformation(User user, String category, Date startDate, Date endDate){
        for (Purchases purchase : user.getPurchases()) {
            info += "Purchase Amount: " + String.format("%.2f", purchase.getAmount()) + "\t Purchase Date: " + purchase.getDate().getDate() + "/" 
                + purchase.getDate().getMonth() + "/" + purchase.getDate().getYear() + "\n"; 
        }
    }

    public purchaseInformation(User user, String category){
        this(user, category, null, null);
    }

    public purchaseInformation(User user, Date startDate, Date endDate){
        this(user, null, startDate, endDate);
    }

    public String printinfo() {
        return this.info;
    }
}
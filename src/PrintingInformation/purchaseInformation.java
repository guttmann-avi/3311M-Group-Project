package src.PrintingInformation;

import java.util.Date;

import src.BudgetingSystem.Purchases;
import src.UserImplements.User;

public class PurchaseInformation implements TotalInformation {
  
    String info = "";

    public PurchaseInformation(User user, String category, Date startDate, Date endDate){
        for (Purchases purchase : user.getPurchases()) {
            if(purchase.getDate() == null){
                info += "Purchase Amount: " + String.format("%.2f", purchase.getAmount()) + "\t Purchase Date:  No Date"  + "\n"; 
            } else {
            info += "Purchase Amount: " + String.format("%.2f", purchase.getAmount()) + "\t Purchase Date: " + purchase.getDate().getDate() + "/" 
                + purchase.getDate().getMonth() + "/" + purchase.getDate().getYear() + "\n"; 
            }
        }
    }

    public PurchaseInformation(User user, String category){
        this(user, category, null, null);
    }

    public PurchaseInformation(User user, Date startDate, Date endDate){
        this(user, null, startDate, endDate);
    }

    public String printinfo() {
        return this.info;
    }
}
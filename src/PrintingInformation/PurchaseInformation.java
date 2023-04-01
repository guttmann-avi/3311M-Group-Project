package src.PrintingInformation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import src.BudgetingSystem.Purchases;
import src.UserImplements.User;

public class PurchaseInformation implements TotalInformation {

    String info = "";

    public PurchaseInformation(User user, String category, String time, Boolean allTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Purchases purchase : user.getPurchases()) {
            if (allTime) {
                if (purchase.getDate() == null) {
                    info += "Purchase Id: " + purchase.getPurchaseId() + "\t Purchase Amount: " + String.format("%.2f", purchase.getAmount()) + "\t Purchase Date:  No Date"  + "\n"; 
                } else {
                    info += "Purchase Id: " + purchase.getPurchaseId() + "\t Purchase Amount: "
                            + String.format("%.2f", purchase.getAmount()) + "\t Purchase Date: "
                            + sdf.format(purchase.getDate()) + "\n";
                }
            } else {
                if (purchase.getDate() != null && checkDate(purchase, time)) {
                    info += "Purchase Id: " + purchase.getPurchaseId() + "\t Purchase Amount: "
                    + String.format("%.2f", purchase.getAmount()) + "\t Purchase Date: "
                    + sdf.format(purchase.getDate()) + "\n";
                }
            }
        }
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

package src.UILogic;

import src.PrintingInformation.IncomeInformation;
import src.PrintingInformation.MoneyLeftInformation;
import src.PrintingInformation.PurchaseInformation;
import src.PrintingInformation.UserInformation;
import src.UserImplements.User;

public class ViewPurchases implements Output {

    private User user;
    private Boolean allTime;
    private String time;

    public ViewPurchases(User user, Boolean allTime, String time) {
        this.user = user;
        this.allTime = allTime;
        this.time = time;
    }

    @Override
    public String output() {
        String info;
        if (user != null) {
            try {
                UserInformation userInformation = new UserInformation(user);
                IncomeInformation incomeInformation = new IncomeInformation(user, allTime, time);
                MoneyLeftInformation moneyLeftInformation = new MoneyLeftInformation(user, allTime, time);
                PurchaseInformation purchaseInformation = new PurchaseInformation(user, null, time, allTime);
                info = userInformation.printinfo() + incomeInformation.printinfo() + " \t"
                        + moneyLeftInformation.printinfo() + purchaseInformation.printinfo();
            } catch (Exception exception) {
                info = exception.getLocalizedMessage();
            }
        } else {
            info = "Please Choose a User from the User Choice list in order to see the Purchases of a User.";
        }
        return info;
    }
}

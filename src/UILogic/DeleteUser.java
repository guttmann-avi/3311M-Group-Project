package src.UILogic;

import java.util.ArrayList;
import java.util.List;

import src.PrintingInformation.IncomeInformation;
import src.PrintingInformation.MoneyLeftInformation;
import src.PrintingInformation.PurchaseInformation;
import src.PrintingInformation.UserInformation;
import src.UIElements.GUI;
import src.UserImplements.Household;
import src.UserImplements.User;

public class DeleteUser implements Output {

    private User user;

    public DeleteUser(User user) {
        this.user = user;

    }

    @Override
    public String output() {
        String info;
        if (user != null) {

            try {
                UserInformation userInformation = new UserInformation(user);
                info = userInformation.printinfo() + "this user has been removed successfully";
            } catch (Exception exception) {
                info = exception.getLocalizedMessage();
            }
        } else {
            info = "Please Choose a User from the User Choice list in order to see the Purchases of a User.";

        }
        return info;
    }
}
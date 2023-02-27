package src.Database;

import java.util.Date;
import src.BudgetingSystem.Income;
import src.BudgetingSystem.Purchases;
import java.util.Iterator;
import src.userImplements.User;
import java.util.ArrayList;
import src.userImplements.Household;

public class CreateData
{
    public CreateData(Household household) {
        new WriteData(this.createUserInfoData(household), this.createHouseholdData(household));
    }
    
    public ArrayList<String> createUserInfoData(Household household) {
        ArrayList<String> data = new ArrayList<String>();
        for (User user : household.getUsers()) {
            String userInfo = "[name:" + user.getName() + ",transID:" + user.getTransID() + ",Date:" + this.getDate(user.getDate()) + ", " + this.incomeStorageString(user.getIncome()) + ",purchases:[";
            if (!user.getPurchases().isEmpty()) {
                userInfo = String.valueOf(userInfo) + this.purchaseStorageString(user.getPurchases());
            }
            else {
                userInfo = String.valueOf(userInfo) + "]";
            }
            data.add(String.valueOf(userInfo) + "]");
        }
        return data;
    }
    
    public String createHouseholdData(Household household) {
        String householdInfo = "";
        householdInfo = String.valueOf(householdInfo) + "{{" + this.incomeStorageString(household.getIncome()) + ",purchases:[";
        if (!household.getPurchases().isEmpty()) {
            householdInfo = String.valueOf(householdInfo) + this.purchaseStorageString(household.getPurchases());
        }
        else {
            householdInfo = String.valueOf(householdInfo) + "]";
        }
        return String.valueOf(householdInfo) + "}";
    }
    
    private String purchaseStorageString(final ArrayList<Purchases> purchases) {
        String purchaseString = "";
        for (int i = 0; i < purchases.size(); ++i) {
            final Purchases purchase = purchases.get(i);
            purchaseString = String.valueOf(purchaseString) + "{Amount:" + purchase.getAmount() + ",Date:" + this.getDate(purchase.getDate()) + ",Category:" + purchase.getCategory();
            if (purchases.size() != i + 1) {
                purchaseString = String.valueOf(purchaseString) + "},";
            }
            else {
                purchaseString = String.valueOf(purchaseString) + "}]";
            }
        }
        return purchaseString;
    }
    
    private String incomeStorageString(final Income income) {
        String incomeString = "";
        incomeString = "income:{amount:" + income.getAmount() + ",Income_source:" + income.getSource() + ",Income_tabulation_date:" + this.getDate(income.getDate()) + "}";
        return incomeString;
    }
    
    private String getDate(final Date date) {
        if (date != null) {
            return String.valueOf(date.getDate()) + "/" + date.getMonth() + "/" + date.getYear();
        }
        return "null";
    }
}
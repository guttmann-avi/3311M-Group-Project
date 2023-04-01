package src.Database;

import java.util.Date;
import src.BudgetingSystem.Income;
import src.BudgetingSystem.Purchases;
import src.UserImplements.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import src.UserImplements.Household;

public class CreateData
{
    public CreateData(Household household) {
        new WriteData(this.createUserInfoData(household), this.createHouseholdData(household));
    }
    
    private ArrayList<String> createUserInfoData(Household household) {
        ArrayList<String> data = new ArrayList<String>();
        for (User user : household.getUsers()) {
            String userInfo = "[name:" + user.getName() + ",transID:" + user.getTransID() + ",Date:" + this.getDate(user.getDate()) + "," + this.incomeStorageStringUser(user.getIncome()) + ",purchases:[";
            if (!user.getPurchases().isEmpty()) {
                userInfo = String.valueOf(userInfo) + this.purchaseStorageString(user.getPurchases());
            } else {
                userInfo = String.valueOf(userInfo) + "]";
            }
            data.add(String.valueOf(userInfo) + "]");
        }
        return data;
    }
    
    private String createHouseholdData(Household household) {
        String householdInfo = "";
        householdInfo = String.valueOf(householdInfo) + "{{" + this.incomeStorageStringHouseHold(household.getIncome()) + ",purchases:[";
        if (!household.getPurchases().isEmpty()) {
            householdInfo = String.valueOf(householdInfo) + this.purchaseStorageString(household.getPurchases());
        } else {
            householdInfo = String.valueOf(householdInfo) + "]";
        }
        return String.valueOf(householdInfo) + "}";
    }
    
    private String purchaseStorageString(ArrayList<Purchases> purchases) {
        String purchaseString = "";
        for (int i = 0; i < purchases.size(); ++i) {
            Purchases purchase = purchases.get(i);
            purchaseString = String.valueOf(purchaseString) + "{Amount:" + purchase.getAmount() + ",Date:" + this.getDate(purchase.getDate()) + ",Category:" + purchase.getCategory();
            if (purchases.size() != i + 1) {
                purchaseString = String.valueOf(purchaseString) + "},";
            } else {
                purchaseString = String.valueOf(purchaseString) + "}]";
            }
        }
        return purchaseString;
    }
    
    private String incomeStorageStringUser(ArrayList<Income> incomes) {
        String incomeString = "income:[";
        for (int i = 0; i < incomes.size(); i++) {
            Income income = incomes.get(i);
            incomeString += "{amount:" + income.getBaseAmount() + ",Income_source:" + income.getSource() + ",Income_tabulation_date:" + this.getDate(income.getDate()) +",frequency:" + income.getFrequency() + "}";
            if (incomes.size() > i+1) {
                incomeString += ",";
            } else {
                incomeString += "]";
            }
        }
        return incomeString;
    }

    private String incomeStorageStringHouseHold(Income income) {
        String incomeString = "";
        incomeString = "income:{amount:" + income.getBaseAmount() + ",Income_source:" + income.getSource() + ",Income_tabulation_date:" + this.getDate(income.getDate()) +",frequency:" + income.getFrequency() + "}";
        return incomeString;
    }
    
    private String getDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if (date != null) {
            return sdf.format(date);
            // return String.valueOf(date.getDate()) + "/" + date.getMonth() + "/" + date.getYear();
        }
        return "null";
    }
}
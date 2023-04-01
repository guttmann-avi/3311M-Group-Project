package src.Database;

import java.util.Date;
import src.BudgetingSystem.Purchases;
import java.util.ArrayList;
import src.BudgetingSystem.Income;
import src.UserImplements.User;
import src.UserImplements.Household;

public class SetData {
    private Household household;

    public Household passData() {
        String data = new GetData().saveData();
        this.household = new Household();
        this.getIncomeHouseHold(data.substring(data.indexOf("income:{"), data.indexOf("},")));
        data = data.substring(data.indexOf("},") + 2);
        this.getPurchases(data.substring(0, data.indexOf("]")), null);
        data = data.substring(data.indexOf("},") + 2);
        this.getUsers(data, this.household);
        this.household.getUsers().get(household.getUsers().size() - 1).setCount(household.getUsers().size());

        return this.household;
    }

    private void getIncomeHouseHold(String incomeString) {
        String[] incomeValues = new String[3];
        String[] toReplace = { "income:{amount:", ",Income_source:", ",Income_tabulation_date:", ",frequency:" };
        incomeString = incomeString.replace(toReplace[0], "");
        for (int i = 0; i < toReplace.length - 1; incomeString = incomeString
                .replace(String.valueOf(incomeValues[i]) + toReplace[++i], "")) {
            incomeValues[i] = incomeString.substring(0, incomeString.indexOf(","));
        }

        this.household.setIncome(
                new Income(Double.parseDouble(incomeValues[0]), incomeValues[1], this.createDate(incomeValues[2]),
                        incomeString));
    }

    private void getPurchases(String purchaseString, User user) {
        if (!purchaseString.equalsIgnoreCase("purchases:[")) {
            String[] toReplace = { "{Amount:", ",Date:", ",Category:" };
            ArrayList<Purchases> purchases = new ArrayList<Purchases>();
            purchaseString = purchaseString.replace("purchases:[", "");
            String[] purchasesList = purchaseString.split("},");
            if (purchasesList.length == 1)
                purchasesList[0] = purchasesList[0].substring(0, purchasesList[0].length()-1); 
            for (int i = 0; i < purchasesList.length; ++i) {
                String[] purchaseValues = new String[2];
                for (int f = 0; f < toReplace.length - 1; ++f) {
                    purchasesList[i] = purchasesList[i].substring(toReplace[f].length());
                    purchaseValues[f] = purchasesList[i].substring(0, purchasesList[i].indexOf(","));
                    purchasesList[i] = purchasesList[i].substring(purchaseValues[f].length());
                }
                purchasesList[i] = purchasesList[i].substring(toReplace[2].length());
                if (!purchasesList[i].equalsIgnoreCase("null")) {
                    purchases.add(new Purchases(Double.parseDouble(purchaseValues[0]), purchasesList[i],
                            this.createDate(purchaseValues[1])));
                } else {
                    purchases.add(
                            new Purchases(Double.parseDouble(purchaseValues[0]), this.createDate(purchaseValues[1])));
                }
            }
            if (user == null) {
                this.household.addPurchases(purchases);
            } else {
                user.addPurchases(purchases);
            }
        }
    }

    private void getUsers(String userString, Household household) {
        String[] toReplace = { ",transID:", ",Date:" };
        userString = userString.substring(userString.indexOf("["), userString.lastIndexOf("]") + 1);
        String[] userValues = new String[2];
        String[] usersAllInfo = userString.split("name");
        for (int i = 1; i < usersAllInfo.length; ++i) {
            usersAllInfo[i] = usersAllInfo[i].substring(1);
            for (int f = 0; f < toReplace.length; ++f) {
                userValues[f] = usersAllInfo[i].substring(0, usersAllInfo[i].indexOf(","));
                usersAllInfo[i] = usersAllInfo[i]
                        .substring(usersAllInfo[i].indexOf(toReplace[f]) + toReplace[f].length());
            }
            User user = new User(userValues[0],
                    this.createDate(usersAllInfo[i].substring(0, usersAllInfo[i].indexOf(","))));
            try {
                String userIncomeString = usersAllInfo[i].substring(usersAllInfo[i].indexOf("income:["),
                    usersAllInfo[i].indexOf("],purchases"));
            this.getIncomeUser(userIncomeString, user);
            } catch (Exception e) {}
            try {
                String userPurchaseString = usersAllInfo[i].substring(usersAllInfo[i].indexOf("purchases:["),
                        usersAllInfo[i].lastIndexOf("}"));
                this.getPurchases(userPurchaseString, user);
            } catch (Exception ex) {}
            household.addUser(user);
        }
    }

    private void getIncomeUser(String incomeString, User user) {
        if (!incomeString.equalsIgnoreCase("income:[")) {
            String[] toReplace = { "{amount:", ",Income_source:", ",Income_tabulation_date:", ",frequency:"};
            ArrayList<Income> incomes = new ArrayList<Income>();
            incomeString = incomeString.replace("income:[", "");
            String[] incomeList = incomeString.split("},");
            if (incomeList.length == 1)
                incomeList[0] = incomeList[0].substring(0, incomeList[0].length()-1); 
            for (int i = 0; i < incomeList.length; ++i) {
                String[] incomeValues = new String[3];
                for (int f = 0; f < toReplace.length - 1; ++f) {
                    incomeList[i] = incomeList[i].substring(toReplace[f].length());
                    incomeValues[f] = incomeList[i].substring(0, incomeList[i].indexOf(","));
                    incomeList[i] = incomeList[i].substring(incomeValues[f].length());
                }
                incomeList[i] = incomeList[i].substring(toReplace[3].length());
                if (incomeList[i].equalsIgnoreCase("null")) {
                    incomes.add(new Income(Double.parseDouble(incomeValues[0]), incomeList[i],
                            this.createDate(incomeValues[1]), null));
                } else {
                    incomes.add(
                            new Income(Double.parseDouble(incomeValues[0]), incomeValues[1], this.createDate(incomeValues[2]), incomeList[i]));
                }
            }
            user.setIncome(incomes);
        }
    }

    private Date createDate(String dateString) {
        if (dateString != null) {
            try {
                String[] dateValues = dateString.split("/");
                Date date = new Date();
                date.setYear(Integer.parseInt(dateValues[2])-1900);
                date.setMonth(Integer.parseInt(dateValues[1])-1);
                date.setDate(Integer.parseInt(dateValues[0]));
                return date;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
package src.Database;

import java.util.Date;
import src.BudgetingSystem.Purchases;
import java.util.ArrayList;
import src.BudgetingSystem.Income;
import src.userImplements.User;
import src.userImplements.Household;

public class SetData {
    private Household household;

    public Household passData() {
        String data = new GetData().saveData();
        this.household = new Household();
        this.getIncome(data.substring(data.indexOf("income:{"), data.indexOf("},")), null);
        data = data.substring(data.indexOf("},") + 2);
        this.getPurchases(data.substring(0, data.indexOf("]")), null);
        data = data.substring(data.indexOf("},") + 2);
        this.getUsers(data, this.household);
        final int f = 0;
        return this.household;
    }

    private void getIncome(String incomeString, final User user) {
        final String[] incomeValues = new String[2];
        final String[] toReplace = { "income:{amount:", ",Income_source:", ",Income_tabulation_date:" };
        incomeString = incomeString.replace(toReplace[0], "");
        for (int i = 0; i < toReplace.length - 1; incomeString = incomeString
                .replace(String.valueOf(incomeValues[i]) + toReplace[++i], "")) {
            incomeValues[i] = incomeString.substring(0, incomeString.indexOf(","));
        }
        if (user == null) {
            this.household.setIncome(
                    new Income(Double.parseDouble(incomeValues[0]), incomeValues[1], this.createDate(incomeString)));
        } else {
            user.setIncome(
                    new Income(Double.parseDouble(incomeValues[0]), incomeValues[1], this.createDate(incomeString)));
        }
    }

    private void getPurchases(String purchaseString, final User user) {
        if (!purchaseString.equalsIgnoreCase("purchases:[")) {
            final String[] toReplace = { "{Amount:", ",Date:", ",Category:" };
            final ArrayList<Purchases> purchases = new ArrayList<Purchases>();
            purchaseString = purchaseString.replace("purchases:[", "");
            final String[] purchasesList = purchaseString.split("},");
            for (int i = 0; i < purchasesList.length; ++i) {
                final String[] purchaseValues = new String[2];
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

    private void getUsers(String userString, final Household household) {
        final String[] toReplace = { ",transID:", ",Date:" };
        userString = userString.substring(userString.indexOf("["), userString.lastIndexOf("]") + 1);
        final String[] userValues = new String[2];
        final String[] usersAllInfo = userString.split("name");
        for (int i = 1; i < usersAllInfo.length; ++i) {
            usersAllInfo[i] = usersAllInfo[i].substring(1);
            for (int f = 0; f < toReplace.length; ++f) {
                userValues[f] = usersAllInfo[i].substring(0, usersAllInfo[i].indexOf(","));
                usersAllInfo[i] = usersAllInfo[i]
                        .substring(usersAllInfo[i].indexOf(toReplace[f]) + toReplace[f].length());
            }
            final User user = new User(userValues[0], Double.parseDouble(userValues[1]),
                    this.createDate(usersAllInfo[i].substring(0, usersAllInfo[i].indexOf(","))));
            final String userIncomeString = usersAllInfo[i].substring(usersAllInfo[i].indexOf("income:"),
                    usersAllInfo[i].indexOf("},purchases"));
            this.getIncome(userIncomeString, user);
            try {
                final String userPurchaseString = usersAllInfo[i].substring(usersAllInfo[i].indexOf("purchases:["),
                        usersAllInfo[i].lastIndexOf("}"));
                this.getPurchases(userPurchaseString, user);
            } catch (Exception ex) {
            }
            household.addUser(user);
        }
    }

    private Date createDate(final String dateString) {
        if (dateString != null) {
            try {
                final String[] dateValues = dateString.split("/");
                final Date date = new Date();
                date.setYear(Integer.parseInt(dateValues[2]));
                date.setMonth(Integer.parseInt(dateValues[1]));
                date.setDate(Integer.parseInt(dateValues[0]));
                return date;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
package src.UILogic;

import java.util.Date;
import java.util.HashMap;

import src.BudgetingSystem.Purchases;
import src.UserImplements.Household;
import src.UserImplements.User;

public class NewPurchase implements Output {

    private Household household;
    private HashMap<String, String> inputValues;
    private String[] inputs;

    public NewPurchase(HashMap<String, String> inputValues, String[] inputs, Household household) {
        this.inputValues = inputValues;
        this.inputs = inputs;
        this.household = household;
    }

    @Override
    public String output() {
        User user = household.findUser(inputValues.get(inputs[4]));
        if (user.totalUserIncomeAllTime() < (user.totalUserPurchaseAmountAllTime() + Double.parseDouble(inputValues.get(inputs[2])))) {
            return "All Incomes of the User is not enough to satisfy the purchase.";
        }        
        return "Purchase has been added successfully to " + inputValues.get(inputs[4]) + ".";
    }
    
    public Household setHousehold(Date returnDate) {
        if (output().contains("successfully")) {
            User user = household.findUser(inputValues.get(inputs[4]));
            user.addPurchases(new Purchases(Double.parseDouble(inputValues.get(inputs[2])), returnDate));
            household.replaceUser(user);
        }
        return household;
    }
}

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
        return "Purchase has been added successfully to " + inputValues.get(inputs[4]) + ".";
    }
    
    public Household setHousehold(Date returnDate) {
        User user = household.findUser(inputValues.get(inputs[4]));
        user.addPurchases(new Purchases(Double.parseDouble(inputValues.get(inputs[2])), returnDate));
        household.replaceUser(user);
        return household;
    }
}

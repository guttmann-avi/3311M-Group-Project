package src.UILogic;

import java.util.Date;
import java.util.HashMap;

import src.UserImplements.Household;
import src.UserImplements.User;

public class NewUser implements Output {    

    private HashMap<String, String> inputValues;
    private String[] inputs;

    public NewUser(HashMap<String, String> inputValues, String[] inputs) {
        this.inputValues = inputValues;
        this.inputs = inputs;
    }

    @Override
    public String output() {
        if (inputValues.get(inputs[0]) == null || inputValues.get(inputs[1]) == null) {
            return "Pease fill in fields for 'New User Name' and 'Total User Income'";
        } else {
            try {
                double amount = Double.parseDouble(inputValues.get(inputs[1]));
                return "User has been added successfully.";
            } catch (NumberFormatException numberFormatException) {
                return "Please make sure the value in the 'Total Income Of User' is a valid value.";
            }
        }
    }

    public Household setHousehold(Household household) {
        if (success()) {
            User user = new User(inputValues.get(inputs[0]), Double.parseDouble(inputValues.get(inputs[1])), inputValues.get(inputs[6]));
            household.addUser(user);
            return household;
        } 
        return household;
    }

    public Boolean success() {
        if (output().equalsIgnoreCase("User has been added successfully.")) {
            return true;
        } else {
           return false;
        }
    }
}
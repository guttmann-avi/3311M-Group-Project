package src.UILogic;

import java.util.Date;
import java.util.HashMap;

import src.BudgetingSystem.Income;
import src.UserImplements.Household;

public class ExtraIncome implements Output {

    private HashMap<String, String> inputValues;
    private String[] inputs;

    public ExtraIncome(HashMap<String, String> inputValues, String[] inputs) {
        this.inputValues = inputValues;
        this.inputs = inputs;
    }

    @Override
    public String output() {
        if (inputValues.get(inputs[4]) == null || inputValues.get(inputs[1]) == null) {
            return "Please fill in field for 'Total User Income' and choose a User from the 'User Choice' selection.";
        } else {
            try {
                double amount = Double.parseDouble(inputValues.get(inputs[1]));
                return "Income has been added to " + inputValues.get(inputs[4]) + " successfully.";
            } catch (NumberFormatException numberFormatException) {
                return "Please make sure the value in the 'Total Income Of User' is a valid value.";
            }
        }
    }

    public Household setHousehold(Household household) {
        if (success()) {
            Income income = new Income(Double.parseDouble(inputValues.get(inputs[1])), inputValues.get(inputs[4]), inputValues.get(inputs[6]));
            household.findUser(inputValues.get(inputs[4])).addIncome(income);
            return household;
        } 
        return household;
    }

    public Boolean success() {
        if (output().equalsIgnoreCase("Income has been added to " + inputValues.get(inputs[4]) + " successfully.")) {
            return true;
        } else {
           return false;
        }
    }
    
}

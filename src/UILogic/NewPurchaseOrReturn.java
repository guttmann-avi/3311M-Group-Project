package src.UILogic;

import java.util.Date;
import java.util.HashMap;

import src.UserImplements.Household;

public class NewPurchaseOrReturn implements Output{

    private Household household;
    private HashMap<String, String> inputValues;
    private String[] inputs;
    private String radioButton;
    

    public NewPurchaseOrReturn(String radioButton, HashMap<String, String> inputValues, String[] inputs, Household household) {
        this.inputValues = inputValues;
        this.inputs = inputs;
        this.household = household;
        this.radioButton = radioButton;
    }

    private Date purchaseOrReturnDateField() {
        String[] purchaseTime = inputValues.get(inputs[3]).split("/");
        try {
            return new Date(Integer.parseInt(purchaseTime[2]),
                Integer.parseInt(purchaseTime[1]), Integer.parseInt(purchaseTime[0]));
        } catch (Exception exception) {
            return null;
        }
    }

    

    @Override
    public String output() {
        String output = "";
        if (inputValues.get(inputs[2]) == null || inputValues.get(inputs[4]) == null) {
            output = "Please fill in fields for 'Amount' and choose a user from the 'User Choice' list.";
        } else if (inputValues.get(inputs[3]) != null && purchaseOrReturnDateField() == null) {
            output = "Please make sure the 'Purchase/Return Date' field is filled correctly.";
        } else {
            try {
                double amount = Double.parseDouble(inputValues.get(inputs[2]));
                if (radioButton.equalsIgnoreCase("Purchase")) {
                   output = new NewPurchase(inputValues, inputs, household).output();
                } else if (radioButton.equalsIgnoreCase("Return")) {
                    output = new NewRefund(inputValues, inputs, household).output();
                }
            } catch (Exception exception) {
                output = "Please make sure the 'Amount' field is filled correctly.";
            }
        }
        return output;
    }

    public Household setHousehold() {
        if (!output().startsWith("Please")) {
            if (radioButton.equalsIgnoreCase("Purchase")) {
                return new NewPurchase(inputValues, inputs, household).setHousehold(purchaseOrReturnDateField());
            } else if (radioButton.equalsIgnoreCase("Return")) {
                return new NewRefund(inputValues, inputs, household).setHousehold(purchaseOrReturnDateField());
            }
        }
        return household;
    }
}
package src.UILogic;

import java.util.HashMap;

import src.Database.CreateData;
import src.Database.GetData;
import src.Database.SetData;
import src.UserImplements.Household;
import java.util.List;
import src.BudgetingSystem.*;

public class InputHolder {

    private Household household;

    private String action;
    private String radioButton;
    private HashMap<String, String> inputValues;
    private String[] inputs;
    private List<Purchases> categories;
 
    final String[] actionOptions = {"Insert New User", "Insert Purchase", "View Purchases"};
    final String[] purchaseOrReturn = {"Purchase","Return"};

    public InputHolder() {
        if (new GetData().saveData() != null) {
            household = new SetData().passData();
        } else {
            household = new Household();
        }
    }

    public Household getHousehold() {
        return household;
    }

    public void setHousehold(Household household) {
        this.household = household;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getRadioButton() {
        return radioButton;
    }

    public void setRadioButton(String radioButton) {
        this.radioButton = radioButton;
    }
    
    public HashMap<String, String> getInputValues() {
        return inputValues;
    }

    public void setInput(HashMap<String, String> inputValues, String[] inputs) {
        this.inputValues = inputValues;
        this.inputs = inputs;
    }
    public List<Purchases> getCategories(){
    	return this.categories;
    }
    
    public void setCategories(Purchases purchase) {
    	this.categories.add(purchase);
    }

    public String output() {
        String output = "";
        switch (action) {
            case "Insert New User":
                output = new NewUser(inputValues, inputs).output();
                setHousehold(new NewUser(inputValues, inputs).setHousehold(household));  
                break;
            case "Insert Purchase":    
                output = new NewPurchaseOrReturn(radioButton, inputValues, inputs, household,categories).output();
                setHousehold(new NewPurchaseOrReturn(radioButton, inputValues, inputs, household,categories).setHousehold());
                break;
            case "View Purchases":
                    output = new ViewPurchases(household.findUser(inputValues.get(inputs[4]))).output();
                break;
        }
        new CreateData(household);
        return output;
    }
}
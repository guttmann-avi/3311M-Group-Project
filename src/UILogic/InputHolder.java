package src.UILogic;

import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.Date;
import src.Database.CreateData;
import src.Database.GetData;
import src.Database.SetData;
import src.UserImplements.Household;
import src.UserImplements.User;

import java.util.List;
import src.BudgetingSystem.*;

public class InputHolder {

	private Household household;

	private String action;
	private String radioButton;
	private HashMap<String, String> inputValues;
	private String[] inputs;
	private String categories;
	private Boolean allTime;

	// final String[] actionOptions = { "Insert New User", "Insert Purchase", "View
	// Purchases" };
	// final String[] purchaseOrReturn = { "Purchase", "Return" };

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

	public String[] getCategories() {

		String[] categories = new String[10];

		if (household.getPurchases().size() > 10) {
			categories = new String[household.getPurchases().size()];
		}

		for (int i = 0; i < household.getPurchases().size(); i++) {
			categories[i] = household.getPurchases().get(i).getCategory();
		}
		return categories;

	}

	public void setCategories(String category) {
		this.categories = category;
	}

	public void setAllTime(Boolean allTime) {
		this.allTime = allTime;
	}

	public String output() {
		String output = "";
		switch (action) {
			case "Insert New User":
				output = new NewUser(inputValues, inputs).output();
				setHousehold(new NewUser(inputValues, inputs).setHousehold(household));
				break;

			case "Insert Purchase":
				output = new NewPurchaseOrReturn(radioButton, inputValues, inputs, household, categories).output();
				setHousehold(new NewPurchaseOrReturn(radioButton, inputValues, inputs, household, categories)
						.setHousehold());
				break;

			case "View Purchases":
				output = new ViewPurchases(household.findUser(inputValues.get(inputs[4])), allTime,
						inputValues.get(inputs[6])).output();
				break;

			case "delete user":
				output = new DeleteUser(household.findUser(inputValues.get(inputs[4]))).output();
				household.removeUser(household.findUser(inputValues.get(inputs[4])));
				break;

			case "Delete Transaction":
				try {
					boolean result = true;
					for (Purchases purchases : household.getPurchases()) {
						if (purchases.getPurchaseId() == Integer.parseInt(inputValues.get(inputs[5]))) {
							household.removePurchase(purchases);
							result = false;
							break;
						}
					}
					for (User user : household.getUsers()) {
						for (Purchases purchases : user.getPurchases()) {
							if (purchases.getPurchaseId() == Integer.parseInt(inputValues.get(inputs[5]))) {

								user.removepurchase(purchases);
								result = false;
								break;
							}
						}
						if (result == false) {
							break;
						}
					}
					if (result == false) {
						output = "Purchase with ID: " + inputValues.get(inputs[5]) + " has been deleted.";
					} else {
						output = "Purchase with ID: " + inputValues.get(inputs[5]) + " did not exist please try again.";
					}
				} catch (Exception e) {
					output = "Please make sure to enter a vaild ID value in the Transaction ID Field.";
				}
				break;

			case "Extra Income":
				output = new ExtraIncome(inputValues, inputs).output();
				setHousehold(new ExtraIncome(inputValues, inputs).setHousehold(household));
				break;

			case "Replace Purchase Info":
				try {
					boolean result = true;
					for (Purchases purchases : household.getPurchases()) {
						if (purchases.getPurchaseId() == Integer.parseInt(inputValues.get(inputs[5]))) {
							household.replacePurchase(purchases, new Purchases());
							result = false;
							break;
						}
					}
					for (User user : household.getUsers()) {
						for (Purchases purchases : user.getPurchases()) {
							if (purchases.getPurchaseId() == Integer.parseInt(inputValues.get(inputs[5]))) {
								Date newDate;
								try {
									newDate = new SimpleDateFormat("dd/MM/yyyy").parse(inputValues.get(inputs[3]));
								} catch (Exception e) {
									output = "Please make sure the 'Purchase/Return Date' field is filled correctly and that all values are positive.";
									result = false;
									break;
								}
								try {
									if (user.totalUserIncomeAllTime() < (user.totalUserPurchaseAmountAllTime()
											+ Double.parseDouble(inputValues.get(inputs[2])))) {
										return "All Incomes of the User is not enough to satisfy the purchase.";
									} else {
										user.replacePurchase(purchases,
												new Purchases(Double.parseDouble(inputValues.get(inputs[2])),
														inputValues.get(inputs[7]), newDate));
									}
								} catch (Exception e) {
									output = "Please fill in the field for 'Amount' with a valid integer if not filled in properly.";
								}
								result = false;
								break;
							}
						}
						if (result == false) {
							break;
						}
					}
					if (result == false && output.equalsIgnoreCase("")) {
						output = "Purchase with ID: " + inputValues.get(inputs[5]) + " has been updated.";
					} else if (output.equalsIgnoreCase("")) {
						output = "Purchase with ID: " + inputValues.get(inputs[5]) + " did not exist please try again.";
					}
				} catch (Exception e) {
					output = "Please make sure to enter a vaild ID value in the Transaction ID Field.";
				}
				break;

			case "One-Time Bonus":
				output = new OneTimeBonus(inputValues, inputs).output();
				setHousehold(new OneTimeBonus(inputValues, inputs).setHousehold(household));
				break;
		}

		new CreateData(household);
		return output;
	}
}
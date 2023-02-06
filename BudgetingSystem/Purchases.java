package BudgetingSystem;

import java.util.Date;

public class Purchases {
	private static final int Id = 0; 
	private double amount; 				// Make sure to only show two decimal places
	private String category;			// Not for Iteration 1 
	private Date date;
	
	public Purchases(double amount, String category, Date date) {
		this.amount = amount;
		this.category = category;
		this.date = date;
	}

	public Purchases(double amount, Date date) {
		this(amount, null, date);
	}

	public Purchases() {
		this.amount = 0;
	}

	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}

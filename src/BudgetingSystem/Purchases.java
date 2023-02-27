package src.BudgetingSystem;

import java.util.Date;
import src.BudgetingSystem.Categories;
import java.util.List;

public class Purchases implements Categories {
	private static final int Id = 0; 
	private double amount; 				// Make sure to only show two decimal places
	private Categories category;			// Not for Iteration 1 
	private Date date;
	
	
	// public Purchases(double amount, Categories category, Date date) {
	// 	this.amount = amount;
	// 	this.category = category;
	// 	this.date = date;
	// }

	public Purchases(double amount, String category, Date date) {
		this.amount = amount;
		if (category != null) {
			setCategory(category);
		}
		this.date = date;
	}

	public Purchases(double amount, Date date) {
		this(amount, null, date);
	}

	public Purchases(double amount){
		this.amount = amount;
		this.date = null;
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

	@Override
	public String getCategory() {
		return category.getCategory();
	}

	@Override
	public void setCategory(String category) {
		this.category.setCategory(category);
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
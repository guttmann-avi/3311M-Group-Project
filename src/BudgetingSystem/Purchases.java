package src.BudgetingSystem;

import java.util.Date;

public class Purchases {
	private static final int Id = 0; 
	private double amount;
	private String category;	
	private Date date;
	
	
	public Purchases(double amount, String category, Date date) {
		this.amount = amount;
		this.category = category;
		this.date = date;
	 }


	public Purchases(double amount, Date date) {
		this(amount, null, date);
	}

	public Purchases(double amount) {
		this(amount, null, null);
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
	public String getCategory(){
		return this.category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
package src.UserImplements;

import java.util.ArrayList;
import java.util.Date;

import src.BudgetingSystem.Income;
import src.BudgetingSystem.Purchases;

public class User {

	private static int num = 1;
	private static int nextTransID = 0;
	private String name;
	private Income income;
	private int transID;
	private Date date;
	private double salary;

	ArrayList<Purchases> purchases;

	public User(String name, double salary, Date date) {
		if (!name.contains("0")) {
			this.name = name + String.format("%04d", num++);
		} else {
			this.name = name;
		}
		this.salary = salary;
		this.income = new Income(this.salary, this.name, this.date);
		this.transID = nextTransID++;
		this.date = date;
		purchases = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (!
		name.contains("0")) {
			this.name = name + String.format("%04d", num++);
		} else {
			this.name = name;
		}
	}

	public Income getIncome() {
		return income;
	}

	public void setIncome(Income income) {
		this.income = income;
	}

	public int getTransID() {
		return transID;
	}

	public void setTransID(int transID) {
		this.transID = transID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void addPurchases(Purchases purchases) {
		this.purchases.add(purchases);
	}

	public void addPurchases(ArrayList<Purchases> purchases) {
		this.purchases = purchases;
	}

	public ArrayList<Purchases> getPurchases() {
		return this.purchases;
	}
}
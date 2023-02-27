package src.userImplements;

import java.util.ArrayList;
import java.util.Date;

import src.BudgetingSystem.Income;
import src.BudgetingSystem.Purchases;

public class User {

	private static int nextTransID = 0;
	private String name;
	private Income income;
	private int transID;
	private Date date;
	private double salary;

	ArrayList<Purchases> purchases;

	public User(String name, double salary, Date date) {
		this.name = name;
		this.salary = salary;
		this.income = new Income(this.salary, this.name, this.date);
		this.transID = nextTransID++;
		this.date = date;
		purchases = new ArrayList<>();
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public Income getIncome() {
		return income;
	}

	public int getTransID() {
		return transID;
	}

	public void setTransID(int transID) {
		this.transID = transID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIncome(Income income) {
		this.income = income;
	}
}
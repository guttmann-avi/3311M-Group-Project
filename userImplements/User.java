package userImplements;

import java.util.ArrayList;
import java.util.Date;

import BudgetingSystem.Income;
import BudgetingSystem.Purchases;

public class User {

	private static int nextTransID = 0;
	private String name;
	private Income income;
	private double salary;
	private int transID;
	private Date date;

	ArrayList<Purchases> purchases;

	public User(String name, double salary, Date date) {
		this.name = name;
		this.salary = salary;
		this.transID = nextTransID++;
		this.date = date;
		income = new Income(this.transID, this.name, this.date);
		purchases = new ArrayList<>();
	}

	public void addPurchases(Purchases purchases){

		this.purchases.add(purchases);

	}

	public ArrayList<Purchases> getPurchases(){

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

	public double getSalary() {
		return salary;
	}

	public int getTransID() {
		return transID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}

package src.UserImplements;

import java.util.ArrayList;
import java.util.Date;

import src.BudgetingSystem.Income;
import src.BudgetingSystem.Purchases;

public class User {

	private static int count = 1;
	private static int nextTransID = 0;
	private String name;
	private ArrayList<Income> income;
	private int transID;
	private Date date;

	ArrayList<Purchases> purchases;

	public User(String name, Date date) {
		setName(name);
		setDate(date);
		this.income = new ArrayList<>();
		this.purchases = new ArrayList<>();
		this.transID = nextTransID++;
		count++;
	}

	public User(String name, double salary, String frequency) {
		if (!name.contains("0")) {
			this.name = name + String.format("%04d", count);
		} else {
			this.name = name;
		}
		this.income = new ArrayList<>();
		this.income.add(new Income(salary, name, frequency));
		this.transID = nextTransID++;
		this.date = new Date();
		purchases = new ArrayList<>();
		count++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (!name.contains("0")) {
			this.name = name + String.format("%04d", count);
		} else {
			this.name = name;
		}
		count++;
	}

	public ArrayList<Income> getIncome() {
		return this.income;
	}

	public void setIncome(ArrayList<Income> incomes) {
		this.income = incomes;
	}

	public void setIncome(Income income) {
		this.income = new ArrayList<>();
		this.income.add(income);
	}

	public void addIncome(Income income) {
		this.income.add(income);
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

	public void setCount(int count) {
		this.count = count + 1;
	}

	public void removepurchase(Purchases purchases) {
		this.purchases.remove(purchases);
	}
	public void replacePurchase(Purchases purchases, Purchases newPurchase){
		int i=0; 
		for(Purchases iterator : this.purchases){
			if(iterator.equals(purchases)){
				this.purchases.set(i, newPurchase);
			}
			i++;
		}
	}

	public double totalUserIncomeAllTime() {
		double totalUserIncome = 0.00;
		for (Income income : this.income) {
			if (income.getFrequency().equalsIgnoreCase("One Time Bonus")) { 
				totalUserIncome += income.getBaseAmount();
			} else {
				totalUserIncome += income.getAmountYearly(); 
			}
		}
		return totalUserIncome;
	}

	public double totalUserIncomeTimePeriod(String time) {
		double totalUserIncome = 0.00;
		for (Income income : this.income) {
			if (time.equalsIgnoreCase("Yearly")) {
				totalUserIncome += income.getAmountYearly();
			} else if (time.equalsIgnoreCase("Monthly")) {
				totalUserIncome += income.getAmountMonthly();
			} else if (time.equalsIgnoreCase("Weekly")) {
				totalUserIncome += income.getAmountWeekly();
			} else if (time.equalsIgnoreCase("One Time Bonus")) {
				totalUserIncome += income.getBaseAmount();
			}
		}
		return totalUserIncome;
	}
}
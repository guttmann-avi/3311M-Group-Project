package src.UserImplements;

import java.util.ArrayList;
import java.util.List;
import src.BudgetingSystem.Purchases;
import src.BudgetingSystem.Income;

public class Household implements UserManager {

	private List<User> users;
	private String name;
	private static int nexthouseID = 0;
	private int houseID;
	private Income income;
	ArrayList<Purchases> purchases;

	public Household() {
		this.users = new ArrayList<>();
		this.houseID = nexthouseID++;
		this.income = new Income(0, null, null);
		this.purchases = new ArrayList<Purchases>();
	}

	// Next iteration we should make an interface for get/set name/ID as to not have
	// duplicate code
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHouseID() {
		return this.houseID;
	}

	public Income getIncome() {
		return income;
	}

	public void setIncome(Income income) {
		this.income = income;
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

	@Override
	public void addUser(User user) {
		this.users.add(user);
		// adds income of each user in household as they are added, defaulting the date
		// and source to the same as the first user
		double incomeHelper = 0;
		for (int i = 0; i < users.size(); i++) {
			incomeHelper += users.get(i).getIncome().getAmount();
		}
		this.income = new Income(incomeHelper, users.get(0).getIncome().getSource(),
				users.get(0).getIncome().getDate());
	}

	@Override
	public void removeUser(User user) {
		this.users.remove(user);
		// this fixes the income of the household if a user is removed,
		if (users.isEmpty()) {
			this.income = new Income(0, null, null);
		} else {
			double incomeHelper = 0;
			for (int i = 0; i < users.size(); i++) {
				incomeHelper += users.get(i).getIncome().getAmount();
			}
			// this may cause problems if there is no user at users(0)
			this.income = new Income(incomeHelper, users.get(0).getIncome().getSource(),
					users.get(0).getIncome().getDate());
		}
	}

	public void removePurchase(Purchases purchases) {

		this.purchases.remove(purchases);

	}

	public List<User> getUsers() {
		return users;
	}

	public User findUser(String name) {
		for (User user : users) {
			if (user.getName().equalsIgnoreCase(name)) {
				return user;
			}
		}
		return null;
	}

	public void replaceUser(User replacedUser) {
		for (User user : users) {
			if (user.getName().equalsIgnoreCase(replacedUser.getName())) {
				int index = users.indexOf(user);
				users.remove(user);
				users.add(index, replacedUser);
				break;
			}
		}
	}
}
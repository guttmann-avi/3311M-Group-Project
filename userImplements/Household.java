package userImplements;

import java.util.ArrayList;
import java.util.List;
import BudgetingSystem.Purchases;

public class Household implements userManager {

    private List<User> users;
    private String name;
    private static int nexthouseID = 0;
    private int houseID;
    ArrayList<Purchases> purchases;

    public Household() {
        this.users = new ArrayList<>();
        this.houseID = nexthouseID++;
        
    }

    public String getName() {
		return name;
	}
    public void setName(String name) {
    	this.name = name;
    }
    public void setname(String name) {
    	this.name = name;
    }
    
    public int getHouseID() {
    	return this.houseID;
    }
    
    public void addPurchases(Purchases purchases) {
		this.purchases.add(purchases);
	}
    
    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public void removeUser(User user) {
        this.users.remove(user);
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

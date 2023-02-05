package userImplements;

import java.util.ArrayList;
import java.util.List;

public class Household implements userManager {

	private List<User> users;
	
	public Household() {
		this.users = new ArrayList<>();
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
	
	
}

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

package src.UILogic;

import src.UserImplements.Household;

public class Users {

    Household household;

    public Users(Household household) {
        this.household = household;
    }
    
    public String[] getUserNames() {
        String[] users = new String[10];
        if (household.getUsers().size() > 10) {
            users = new String[household.getUsers().size()];
        }
        
        if (!household.getUsers().isEmpty()) {
            for (int i = 0; i < household.getUsers().size(); i++) {
                users[i] = household.getUsers().get(i).getName();
            }
        }
        return users;
    }
}

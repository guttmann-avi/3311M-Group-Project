package src.PrintingInformation;

import src.UserImplements.User; 

public class UserInformation  implements TotalInformation{
    private String info;
    
    public UserInformation(User user) {
        info = "User Name: " + user.getName() + "\n"; 
    }

    public String printinfo() {
        return this.info;
    }
}
package PrintingInformation;

import java.util.Date;

import userImplements.User; 
;
public class UserInformation  implements TotalInformation{
    private String info;
    public UserInformation(User user){
        //logic 
        info = "User's name is " + user.getName(); 
    }
    public String printinfo(){

        return this.info;
        }
    
}

package PrintingInformation;

import java.util.Date;

public class UserInformation  implements TotalInformation{
    private String info;
    public UserInformation(String userName, double totalIncome, Date creationDate){
        //logic 
        printinfo();
    }
    public String printinfo(){

        return this.info;
        }
    
}

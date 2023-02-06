package PrintingInformation;

import java.util.ArrayList;
import java.util.Date;

import BudgetingSystem.Purchases;

public class purchaseInformation implements TotalInformation{
  
String info;

ArrayList<Purchases> purchases=new ArrayList<>();

//Purchases purchase = new Purchases();



public purchaseInformation(String userName, String category, Date startDate, Date endDate){

    //logic
    printinfo();


}


public purchaseInformation(String userName, Date startDate, Date endDate){
    this(userName, null, startDate, endDate);
}


@Override
public String printinfo() {
    
    return this.info;
}




}

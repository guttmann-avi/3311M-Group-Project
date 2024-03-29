package src.Testing_Suite;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import src.BudgetingSystem.Purchases;
import src.PrintingInformation.PurchaseInformation;
import src.UserImplements.User;

public class PurchaseInformationTest {

    @Test
    public void testPrintinfo() {
        User user = new User("Avi0001", 0, null);
        Purchases purchase1 = new Purchases(100.0, "Food", new Date(2022-1900, 2-1, 27));
        Purchases purchase2 = new Purchases(50.0, "Clothes", new Date(2022-1900, 2-1, 26));
        user.addPurchases(purchase1);
        user.addPurchases(purchase2);
        PurchaseInformation info = new PurchaseInformation(user, null, null, true);
        // the purchase id is gotten from the class due to static variable when all Junit is run at once the static variable mess up
        String expected = "Purchase Id: "+ purchase1.getPurchaseId()+"\t Purchase Amount: 100.00\t Purchase Date: 27/02/2022" + "\t Category: Groceries\n"
                + "Purchase Id: "+ purchase2.getPurchaseId()+"\t Purchase Amount: 50.00\t Purchase Date: 26/02/2022" + "\t Category: Clothing\n";
        assertEquals(expected, info.printinfo());
    }
}
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
        Purchases purchase1 = new Purchases(100.0, "Food", new Date(2022, 2, 27));
        Purchases purchase2 = new Purchases(50.0, "Clothes", new Date(2022, 2, 26));
        user.addPurchases(purchase1);
        user.addPurchases(purchase2);
        PurchaseInformation info = new PurchaseInformation(user, null, null);
        String expected = "Purchase Id: 1\t Purchase Amount: 100.00\t Purchase Date: 27/2/2022\n"
                + "Purchase Id: 2\t Purchase Amount: 50.00\t Purchase Date: 26/2/2022\n";
        assertEquals(expected, info.printinfo());
    }

}

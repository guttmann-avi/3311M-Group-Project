package src.Testing_Suite;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;
import src.BudgetingSystem.Purchases;

public class PurchasesTest {

    @Test
    public void testGettersAndSetters() {
        Purchases p = new Purchases();
        p.setAmount(100.0);
        p.setCategory("Bills");
        Date d = new Date();
        p.setDate(d);
        assertEquals(100.0, p.getAmount(), 0.001);
        assertEquals("BillS", p.getCategory());
        assertEquals(d, p.getDate());
    }

    @Test
    public void testConstructorWithAmountAndDate() {
        double amount = 200.0;
        Date date = new Date();
        Purchases p = new Purchases(amount, date);
        assertEquals(amount, p.getAmount(), 0.001);
        assertNull(p.getCategory());
        assertEquals(date, p.getDate());
    }

    @Test
    public void testConstructorWithAmountAndCategoryAndDate() {
        double amount = 300.0;
        String category = "Entertainment";
        Date date = new Date();
        Purchases p = new Purchases(amount, category, date);
        assertEquals(amount, p.getAmount(), 0.001);
        assertEquals(category, p.getCategory());
        assertEquals(date, p.getDate());
    }

    @Test
    public void testConstructorWithAmount() {
        double amount = 400.0;
        Purchases p = new Purchases(amount);
        assertEquals(amount, p.getAmount(), 0.001);
        assertNull(p.getCategory());
        assertNull(p.getDate());
    }

    @Test
    public void testGetId() {
        Purchases p1 = new Purchases();
        Purchases p2 = new Purchases();
        assertEquals(p1.getid() + 1, p2.getid());
    }

    @Test
    public void testPurchaseId() {
        Purchases p1 = new Purchases();
        Purchases p2 = new Purchases();
        assertEquals(p1.gtPurchaseId() + 1, p2.gtPurchaseId());
    }
}

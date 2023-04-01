package src.Testing_Suite;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import src.BudgetingSystem.Purchases;
import src.UILogic.ViewPurchases;
import src.UserImplements.User;

public class ViewPurchasesTest {

	@Test
	public void testViewPurchasesOutput1() {
		User user = new User("Avi0001", 1000, "Monthly");
		Purchases purchase1 = new Purchases(100, new Date(2022-1900-1900, 02-1, 02));
		Purchases purchase2 = new Purchases(200, new Date(2022-1900-1900, 02-1, 02));
		Purchases purchase3 = new Purchases(-100, new Date(2022-1900-1900, 02-1, 10));
		user.addPurchases(purchase1);
		user.addPurchases(purchase2);
		user.addPurchases(purchase3);

		assertEquals(
				"User Name: Avi0001\nUser Avi0001 Income is 12000.0 \tMoney Left: 11800.00\nPurchase Id: "+purchase1.getPurchaseId()+"\t Purchase Amount: 100.00\t Purchase Date: 2/2/2022-1900\nPurchase Id: "+purchase2.getPurchaseId()+"\t Purchase Amount: 200.00\t Purchase Date: 2/2/2022-1900\nPurchase Id: "+purchase3.getPurchaseId()+"\t Purchase Amount: -100.00\t Purchase Date: 10/2/2022-1900\n",
				new ViewPurchases(user, true, null).output());
	}

	@Test
	public void testViewPurchasesOutput2() {
		User user = new User("Mark0002", 5000, "Yearly");
		Purchases purchase1 = new Purchases(400, new Date(2022-1900-1900, 02-1, 02));
		Purchases purchase2 = new Purchases(600, new Date(2022-1900-1900, 02-1, 02));
		Purchases purchase3 = new Purchases(-1000, new Date(2022-1900-1900, 02-1, 10));
		user.addPurchases(purchase1);
		user.addPurchases(purchase2);
		user.addPurchases(purchase3);
		assertEquals(
				"User Name: Mark0002\nUser Mark0002 Income is 5000.0 \tMoney Left: 5000.00\nPurchase Id: "+purchase1.getPurchaseId()+"\t Purchase Amount: 400.00\t Purchase Date: 2/2/2022-1900\nPurchase Id: "+purchase2.getPurchaseId()+"\t Purchase Amount: 600.00\t Purchase Date: 2/2/2022-1900\nPurchase Id: "+purchase3.getPurchaseId()+"\t Purchase Amount: -1000.00\t Purchase Date: 10/2/2022-1900\n",
				new ViewPurchases(user, true, null).output());
	}

	@Test
	public void testViewPurchasesOutput3() {
		User user = new User("John0007", 1000, "Weekly");
		Purchases purchase1 = new Purchases(10000, new Date(2022-1900, 02-1, 02));
		Purchases purchase2 = new Purchases(2500, new Date(2022-1900, 02-1, 02));
		Purchases purchase3 = new Purchases(-1200, new Date(2022-1900, 02-1, 10));
		user.addPurchases(purchase1);
		user.addPurchases(purchase2);
		user.addPurchases(purchase3);
		assertEquals(
				"User Name: John0007\nUser John0007 Income is 52000.0 \tMoney Left: 40700.00\nPurchase Id: "+purchase1.getPurchaseId()+"\t Purchase Amount: 10000.00\t Purchase Date: 2/2/2022-1900\nPurchase Id: "+purchase2.getPurchaseId()+"\t Purchase Amount: 2500.00\t Purchase Date: 2/2/2022-1900\nPurchase Id: "+purchase3.getPurchaseId()+"\t Purchase Amount: -1200.00\t Purchase Date: 10/2/2022-1900\n",
				new ViewPurchases(user, true, null).output());
	}

	@Test
	public void testViewPurchasesOutput4() {
		User user = new User("Avi0001", 1000, "Yearly");
		Purchases purchase1 = new Purchases(100, new Date(2022-1900, 02-1, 02));
		Purchases purchase2 = new Purchases(200, new Date(2022-1900, 02-1, 02));
		Purchases purchase3 = new Purchases(-100, new Date(2022-1900, 02-1, 10));
		user.addPurchases(purchase1);
		user.addPurchases(purchase2);
		user.addPurchases(purchase3);
		assertEquals(
				"User Name: Avi0001\nUser Avi0001 Income is 1000.0 \tMoney Left: 800.00\nPurchase Id: "+purchase1.getPurchaseId()+"\t Purchase Amount: 100.00\t Purchase Date: 2/2/2022-1900\nPurchase Id: "+purchase2.getPurchaseId()+"\t Purchase Amount: 200.00\t Purchase Date: 2/2/2022-1900\nPurchase Id: "+purchase3.getPurchaseId()+"\t Purchase Amount: -100.00\t Purchase Date: 10/2/2022-1900\n",
				new ViewPurchases(user, true, null).output());
	}

	@Test
	public void testViewPurchasesOutput5() {
		User user = new User("Avi0001", 1000, "Weekly");
		Purchases purchase1 = new Purchases(100, new Date(2022-1900, 02-1, 02));
		Purchases purchase2 = new Purchases(200, new Date(2022-1900, 02-1, 02));
		Purchases purchase3 = new Purchases(-100, new Date(2022-1900, 02-1, 10));
		user.addPurchases(purchase1);
		user.addPurchases(purchase2);
		user.addPurchases(purchase3);
		assertEquals(
				"User Name: Avi0001\nUser Avi0001 Income is 52000.0 \tMoney Left: 51800.00\nPurchase Id: "+purchase1.getPurchaseId()+"\t Purchase Amount: 100.00\t Purchase Date: 2/2/2022-1900\nPurchase Id: "+purchase2.getPurchaseId()+"\t Purchase Amount: 200.00\t Purchase Date: 2/2/2022-1900\nPurchase Id: "+purchase3.getPurchaseId()+"\t Purchase Amount: -100.00\t Purchase Date: 10/2/2022-1900\n",
				new ViewPurchases(user, true, null).output());
	}

	@Test
	public void testViewPurchasesOutput6() {
		assertEquals("Please Choose a User from the User Choice list in order to see the Purchases of a User.", new ViewPurchases(null, true, null).output());
	}

}

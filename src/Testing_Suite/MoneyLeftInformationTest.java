package src.Testing_Suite;

import static org.junit.Assert.*;

import org.junit.Test;

import src.BudgetingSystem.Purchases;
import src.PrintingInformation.MoneyLeftInformation;
import src.UserImplements.User;

public class MoneyLeftInformationTest {
	
	@Test
	public void testPrintinfo1() {
		User user = new User("Avi0001", 1000, null, "Yearly");
		user.addPurchases(new Purchases(200));
		assertEquals("Money Left: 800.00\n", new MoneyLeftInformation(user).printinfo());
	}

	@Test
	public void testPrintinfo2() {
		User user = new User("Avi0001", 2500, null, "Yearly");
		user.addPurchases(new Purchases(200));
		assertEquals("Money Left: 2300.00\n", new MoneyLeftInformation(user).printinfo());
	}

	@Test
	public void testPrintinfo3() {
		User user = new User("Avi0001", 1000, null, "Weekly");
		user.addPurchases(new Purchases(200));
		assertEquals("Money Left: 51800.00\n", new MoneyLeftInformation(user).printinfo());
	}

	@Test
	public void testPrintinfo4() {
		User user = new User("Avi0001", 2500, null, "Monthly");
		user.addPurchases(new Purchases(200));
		assertEquals("Money Left: 29800.00\n", new MoneyLeftInformation(user).printinfo());
	}

	@Test
	public void testPrintinfo5() {
		User user = new User("Avi0001", 1000, null, "Weekly");
		user.addPurchases(new Purchases(600));
		user.addPurchases(new Purchases(1000));
		user.addPurchases(new Purchases(2300));
		assertEquals("Money Left: 48100.00\n", new MoneyLeftInformation(user).printinfo());
	}

	@Test
	public void testPrintinfo6() {
		User user = new User("Avi0001", 2500, null, "Monthly");
		user.addPurchases(new Purchases(600));
		user.addPurchases(new Purchases(1000));
		user.addPurchases(new Purchases(2300));
		user.addPurchases(new Purchases(-1000));
		assertEquals("Money Left: 27100.00\n", new MoneyLeftInformation(user).printinfo());
	}
}

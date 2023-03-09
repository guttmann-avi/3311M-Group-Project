package src.Testing_Suite;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import src.BudgetingSystem.Purchases;
import src.UserImplements.User;

public class UserTest {
	
	@Test
	public void testConstructorWithName() {
		User user = new User("Avi0001", 0, null);
		assertEquals("Avi0001", user.getName());

		ArrayList purchases = new ArrayList<>();
		assertEquals(purchases, user.getPurchases());

		assertEquals(null, 0, user.getIncome().getAmount(), 0);
		assertEquals(null, user.getIncome().getDate());
		assertEquals("Avi0001", user.getIncome().getSource());

		assertEquals(null, user.getDate());
	}

	@Test
	public void testConstructorWithNameAndSalary() {
		User user = new User("Avi0001", 1000, null);
		assertEquals("Avi0001", user.getName());

		ArrayList purchases = new ArrayList<>();
		assertEquals(purchases, user.getPurchases());

		assertEquals(null, 1000, user.getIncome().getAmount(), 0);
		assertEquals(null, user.getIncome().getDate());
		assertEquals("Avi0001", user.getIncome().getSource());

		assertEquals(null, user.getDate());
	}

	@Test
	public void testConstructorWithNameAndSalaryAndDate() {
		Date date = new Date();
		User user = new User("Avi0001", 1000, date);
		assertEquals("Avi0001", user.getName());

		ArrayList purchases = new ArrayList<>();
		assertEquals(purchases, user.getPurchases());

		assertEquals(null, 1000, user.getIncome().getAmount(), 0);
		assertEquals(null, user.getIncome().getDate());
		assertEquals("Avi0001", user.getIncome().getSource());

		assertEquals(date, user.getDate());
	}

	@Test
	public void testWithSinglePurchase() {
		Date date = new Date();
		User user = new User("Avi0001", 1000, date);
		Purchases purchase = new Purchases();
		user.addPurchases(purchase);
		assertEquals("Avi0001", user.getName());

		ArrayList purchases = new ArrayList<>();
		purchases.add(purchase);
		assertEquals(purchases, user.getPurchases());

		assertEquals(null, 1000, user.getIncome().getAmount(), 0);
		assertEquals(null, user.getIncome().getDate());
		assertEquals("Avi0001", user.getIncome().getSource());

		assertEquals(date, user.getDate());
	}

	@Test
	public void testWithMultiplePurchases() {
		Date date = new Date();
		User user = new User("Avi0001", 1000, date);
		Purchases purchase = new Purchases();
		Purchases purchase2 = new Purchases();
		user.addPurchases(purchase);
		user.addPurchases(purchase2);
		assertEquals("Avi0001", user.getName());

		ArrayList purchases = new ArrayList<>();
		purchases.add(purchase);
		purchases.add(purchase2);
		assertEquals(purchases, user.getPurchases());

		assertEquals(null, 1000, user.getIncome().getAmount(), 0);
		assertEquals(null, user.getIncome().getDate());
		assertEquals("Avi0001", user.getIncome().getSource());

		assertEquals(date, user.getDate());
	}

	@Test
	public void testMultipleUsers() {
		Date date = new Date();
		User user = new User("Avi0001", 1000, date);
		User user2 = new User("Mark0002", 2500, date);
		assertEquals("Avi0001", user.getName());
		ArrayList purchases = new ArrayList<>();
		assertEquals(purchases, user.getPurchases());

		assertEquals(null, 1000, user.getIncome().getAmount(), 0);
		assertEquals(null, user.getIncome().getDate());
		assertEquals("Avi0001", user.getIncome().getSource());

		assertEquals(date, user.getDate());

		// user2 Tests
		assertEquals("Mark0002", user2.getName());

		assertEquals(purchases, user2.getPurchases());

		assertEquals(null, 2500, user2.getIncome().getAmount(), 0);
		assertEquals(null, user2.getIncome().getDate());
		assertEquals("Mark0002", user2.getIncome().getSource());

		assertEquals(date, user2.getDate());
	}
}
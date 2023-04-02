package src.Testing_Suite;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import src.BudgetingSystem.Purchases;
import src.UserImplements.User;

public class UserTest {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Test
	public void testConstructorWithName() {
		User user = new User("Avi0001", 0, null);
		assertEquals("Avi0001", user.getName());

		ArrayList purchases = new ArrayList<>();
		assertEquals(purchases, user.getPurchases());

		assertEquals(null, 0, user.getIncome().get(0).getAmountYearly(), 0);
		assertEquals(sdf.format(new Date()), sdf.format(user.getIncome().get(0).getDate()));
		assertEquals("Avi0001", user.getIncome().get(0).getSource());

		assertEquals(sdf.format(new Date()), sdf.format(user.getDate()));
	}

	@Test
	public void testConstructorWithNameAndSalary() {
		User user = new User("Avi0001", 1000, null);
		assertEquals("Avi0001", user.getName());

		ArrayList purchases = new ArrayList<>();
		assertEquals(purchases, user.getPurchases());

		assertEquals(null, 1000, user.getIncome().get(0).getAmountYearly(), 0);
		assertEquals(sdf.format(new Date()), sdf.format(user.getIncome().get(0).getDate()));
		assertEquals("Avi0001", user.getIncome().get(0).getSource());

		assertEquals(sdf.format(new Date()), sdf.format(user.getDate()));
	}

	@Test
	public void testConstructorWithNameAndSalaryAndDate() {
		Date date = new Date();
		User user = new User("Avi0001", 1000, "Yearly");
		assertEquals("Avi0001", user.getName());

		ArrayList purchases = new ArrayList<>();
		assertEquals(purchases, user.getPurchases());

		assertEquals(null, 1000, user.getIncome().get(0).getAmountYearly(), 0);
		assertEquals(sdf.format(new Date()), sdf.format(user.getIncome().get(0).getDate()));
		assertEquals("Avi0001", user.getIncome().get(0).getSource());

		assertEquals(date, user.getDate());
	}

	@Test
	public void testWithSinglePurchase() {
		Date date = new Date();
		User user = new User("Avi0001", 1000, "Yearly");
		Purchases purchase = new Purchases();
		user.addPurchases(purchase);
		assertEquals("Avi0001", user.getName());

		ArrayList purchases = new ArrayList<>();
		purchases.add(purchase);
		assertEquals(purchases, user.getPurchases());

		assertEquals(null, 1000, user.getIncome().get(0).getAmountYearly(), 0);
		assertEquals(sdf.format(new Date()), sdf.format(user.getIncome().get(0).getDate()));
		assertEquals("Avi0001", user.getIncome().get(0).getSource());

		assertEquals(date, user.getDate());
	}

	@Test
	public void testWithMultiplePurchases() {
		Date date = new Date();
		User user = new User("Avi0001", 1000, "Yearly");
		Purchases purchase = new Purchases();
		Purchases purchase2 = new Purchases();
		user.addPurchases(purchase);
		user.addPurchases(purchase2);
		assertEquals("Avi0001", user.getName());

		ArrayList purchases = new ArrayList<>();
		purchases.add(purchase);
		purchases.add(purchase2);
		assertEquals(purchases, user.getPurchases());

		assertEquals(null, 1000, user.getIncome().get(0).getAmountYearly(), 0);
		assertEquals(sdf.format(new Date()), sdf.format(user.getIncome().get(0).getDate()));
		assertEquals("Avi0001", user.getIncome().get(0).getSource());

		assertEquals(date, user.getDate());
	}

	@Test
	public void testMultipleUsers() {
		Date date = new Date();
		User user = new User("Avi0001", 1000, "Yearly");
		User user2 = new User("Mark0002", 2500, "Yearly");
		assertEquals("Avi0001", user.getName());
		ArrayList purchases = new ArrayList<>();
		assertEquals(purchases, user.getPurchases());

		assertEquals(null, 1000, user.getIncome().get(0).getAmountYearly(), 0);
		assertEquals(sdf.format(new Date()), sdf.format(user.getIncome().get(0).getDate()));
		assertEquals("Avi0001", user.getIncome().get(0).getSource());

		assertEquals(date, user.getDate());

		// user2 Tests
		assertEquals("Mark0002", user2.getName());

		assertEquals(purchases, user2.getPurchases());

		assertEquals(null, 2500, user2.getIncome().get(0).getAmountYearly(), 0);
		assertEquals(sdf.format(new Date()), sdf.format(user2.getIncome().get(0).getDate()));
		assertEquals("Mark0002", user2.getIncome().get(0).getSource());

		assertEquals(sdf.format(date), sdf.format(user2.getDate()));
	}
}
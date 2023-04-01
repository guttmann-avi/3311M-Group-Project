package src.Testing_Suite;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import src.BudgetingSystem.Purchases;
import src.Database.CreateData;
import src.Database.SetData;
import src.UserImplements.Household;
import src.UserImplements.User;

public class DatabaseTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Household household = new Household();
		household.addPurchases(new Purchases(100));
		User user1 = new User("Avi0001", 1000, "Yearly");
		user1.addPurchases(new Purchases(250));
		user1.addPurchases(new Purchases(450));
		User user2 = new User("Mark0002", 2500, "Monthly");
		user2.addPurchases(new Purchases(350));
		user2.addPurchases(new Purchases(550));
		household.addUser(user1);
		household.addUser(user2);
		household.addUser(new User("John0003", 10000, "Weekly"));
		new CreateData(household);
	}

	@Test
	public void testUser1() {
		Household household = new SetData().passData();
		assertEquals("Avi0001", household.getUsers().get(0).getName());
		assertEquals(null,1000 , household.getUsers().get(0).getIncome().get(0).getBaseAmount(), 0);
		assertEquals(null,1000 , household.getUsers().get(0).getIncome().get(0).getAmountYearly(), 0);	
		assertEquals("Yearly", household.getUsers().get(0).getIncome().get(0).getFrequency());
		assertEquals("Avi0001", household.getUsers().get(0).getIncome().get(0).getSource());
		assertEquals(null, household.getUsers().get(0).getIncome().get(0).getDate());

		assertEquals(null, 250, household.getUsers().get(0).getPurchases().get(0).getAmount(),0);
		assertEquals(null, household.getUsers().get(0).getPurchases().get(0).getCategory());
		assertEquals(null, household.getUsers().get(0).getPurchases().get(0).getDate());

		assertEquals(null, 450, household.getUsers().get(0).getPurchases().get(1).getAmount(),0);
		assertEquals(null, household.getUsers().get(0).getPurchases().get(1).getCategory());
		assertEquals(null, household.getUsers().get(0).getPurchases().get(1).getDate());
	}

	@Test
	public void testUser2() {
		Household household = new SetData().passData();
		assertEquals("Mark0002", household.getUsers().get(1).getName());
		assertEquals(null,2500, household.getUsers().get(1).getIncome().get(0).getBaseAmount(), 0);
		assertEquals(null,2500*12, household.getUsers().get(1).getIncome().get(0).getAmountYearly(), 0);	
		assertEquals("Monthly", household.getUsers().get(1).getIncome().get(0).getFrequency());
		assertEquals("Mark0002", household.getUsers().get(1).getIncome().get(0).getSource());
		assertEquals(null, household.getUsers().get(1).getIncome().get(0).getDate());

		assertEquals(null, 350, household.getUsers().get(1).getPurchases().get(0).getAmount(),0);
		assertEquals(null, household.getUsers().get(1).getPurchases().get(0).getCategory());
		assertEquals(null, household.getUsers().get(1).getPurchases().get(0).getDate());

		assertEquals(null, 550, household.getUsers().get(1).getPurchases().get(1).getAmount(),0);
		assertEquals(null, household.getUsers().get(1).getPurchases().get(1).getCategory());
		assertEquals(null, household.getUsers().get(1).getPurchases().get(1).getDate());
	}

	@Test
	public void testUser3() {
		Household household = new SetData().passData();
		assertEquals("John0003", household.getUsers().get(2).getName());
		assertEquals(null,10000, household.getUsers().get(2).getIncome().get(0).getBaseAmount(), 0);
		assertEquals(null,10000*52, household.getUsers().get(2).getIncome().get(0).getAmountYearly(), 0);	
		assertEquals("Weekly", household.getUsers().get(2).getIncome().get(0).getFrequency());
		assertEquals("John0003", household.getUsers().get(2).getIncome().get(0).getSource());
		assertEquals(null, household.getUsers().get(2).getIncome().get(0).getDate());
	}

	@Test
	public void testHousehold() {
		Household household = new SetData().passData();
		assertEquals(null, 100, household.getPurchases().get(0).getAmount(),0);
		assertEquals(null, household.getPurchases().get(0).getCategory());
		assertEquals(null, household.getPurchases().get(0).getDate());
		assertEquals(null, 1000+10000*52+2500*12, household.getIncome().getAmountYearly(),0);
	}
}
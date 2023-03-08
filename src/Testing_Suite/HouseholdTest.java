package src.Testing_Suite;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import src.BudgetingSystem.Income;
import src.BudgetingSystem.Purchases;
import src.UserImplements.Household;
import src.UserImplements.User;

public class HouseholdTest {

	@Test
	public void testConstructor() {
		Household household = new Household();
		assertEquals(household, household);
	}

	@Test
	public void testConstructor2() {
		Household household = new Household();
		ArrayList arrayList = new ArrayList<>();
		assertEquals(arrayList, household.getUsers());
		assertEquals(null, 0, household.getIncome().getAmount(), 0);
		assertEquals(null, household.getIncome().getDate());
		assertEquals(null, household.getIncome().getSource());
		assertEquals(arrayList, household.getPurchases());
	}

	@Test
	public void testSingleUser() {
		Household household = new Household();
		User user1 = new User("Avi0001", 0, null);
		household.addUser(user1);
		ArrayList arrayListUsers = new ArrayList<>();
		arrayListUsers.add(user1);
		assertEquals(arrayListUsers, household.getUsers());
		assertEquals(null, 0, household.getIncome().getAmount(), 0);
		assertEquals(null, household.getIncome().getDate());
		assertEquals("Avi0001", household.getIncome().getSource());
		ArrayList arrayListPurchases = new ArrayList<>();
		assertEquals(arrayListPurchases, household.getPurchases());
	}

	@Test
	public void testSingleUserAndHouseholdPurchase() {
		Household household = new Household();
		User user1 = new User("Avi0001", 0, null);
		household.addUser(user1);
		ArrayList arrayListUsers = new ArrayList<>();
		arrayListUsers.add(user1);
		assertEquals(arrayListUsers, household.getUsers());
		assertEquals(null, 0, household.getIncome().getAmount(), 0);
		assertEquals(null, household.getIncome().getDate());
		assertEquals("Avi0001", household.getIncome().getSource());
		ArrayList arrayListPurchases = new ArrayList<>();
		Purchases purchase = new Purchases();
		household.addPurchases(purchase);
		arrayListPurchases.add(purchase);
		assertEquals(arrayListPurchases, household.getPurchases());
	}

	@Test
	public void testSingleUserAndMultipleHouseholdPurchases() {
		Household household = new Household();
		User user1 = new User("Avi0001", 0, null);
		household.addUser(user1);
		ArrayList arrayListUsers = new ArrayList<>();
		arrayListUsers.add(user1);
		assertEquals(arrayListUsers, household.getUsers());
		assertEquals(null, 0, household.getIncome().getAmount(), 0);
		assertEquals(null, household.getIncome().getDate());
		assertEquals("Avi0001", household.getIncome().getSource());
		ArrayList arrayListPurchases = new ArrayList<>();
		Purchases purchase = new Purchases();
		Purchases purchase2 = new Purchases();
		household.addPurchases(purchase);
		household.addPurchases(purchase2);
		arrayListPurchases.add(purchase);
		arrayListPurchases.add(purchase2);
		assertEquals(arrayListPurchases, household.getPurchases());
	}

	@Test
	public void testSetIncome() {
		Household household = new Household();
		Income income = new Income(0, null, null);
		household.setIncome(income);
		assertEquals(income, household.getIncome());
	}

	@Test
	public void testMultipleUsers() {
		Household household = new Household();
		User user1 = new User("Avi0001", 0, null);
		household.addUser(user1);
		User user2 = new User("Mark0002", 1000, null);
		household.addUser(user2);
		ArrayList arrayListUsers = new ArrayList<>();
		arrayListUsers.add(user1);
		arrayListUsers.add(user2);
		assertEquals(arrayListUsers, household.getUsers());
		assertEquals(null, 1000, household.getIncome().getAmount(), 0);
		assertEquals(null, household.getIncome().getDate());
		assertEquals("Avi0001", household.getIncome().getSource());
		ArrayList arrayListPurchases = new ArrayList<>();
		assertEquals(arrayListPurchases, household.getPurchases());
	}

	@Test
	public void testMultipleUsersWithIncomes() {
		Household household = new Household();
		User user1 = new User("Avi0001", 2500, null);
		household.addUser(user1);
		User user2 = new User("Mark0002", 1000, null);
		household.addUser(user2);
		ArrayList arrayListUsers = new ArrayList<>();
		arrayListUsers.add(user1);
		arrayListUsers.add(user2);
		assertEquals(arrayListUsers, household.getUsers());
		assertEquals(null, 3500, household.getIncome().getAmount(), 0);
		assertEquals(null, household.getIncome().getDate());
		assertEquals("Avi0001", household.getIncome().getSource());
		ArrayList arrayListPurchases = new ArrayList<>();
		assertEquals(arrayListPurchases, household.getPurchases());
	}

	@Test
	public void testFindUser() {
		Household household = new Household();
		User user1 = new User("Avi0001", 0, null);
		household.addUser(user1);
		User user2 = new User("Mark0002", 1000, null);
		household.addUser(user2);
		assertEquals(user1, household.findUser("Avi0001"));
		assertEquals(user2, household.findUser("Mark0002"));
	}

	@Test
	public void testRemoveUser() {
		Household household = new Household();
		User user1 = new User("Avi0001", 0, null);
		household.addUser(user1);
		User user2 = new User("Mark0002", 1000, null);
		household.addUser(user2);
		assertEquals(user1, household.findUser("Avi0001"));
		assertEquals(user2, household.findUser("Mark0002"));
		household.removeUser(user2);
		assertEquals(null, household.findUser("Mark0002"));
	}	

	@Test
	public void testRemoveUserAndAddBack() {
		Household household = new Household();
		User user1 = new User("Avi0001", 0, null);
		household.addUser(user1);
		User user2 = new User("Mark0002", 1000, null);
		household.addUser(user2);
		assertEquals(user1, household.findUser("Avi0001"));
		assertEquals(user2, household.findUser("Mark0002"));
		household.removeUser(user2);
		assertEquals(null, household.findUser("Mark0002"));
		household.addUser(user2);
		assertEquals(user1, household.findUser("Avi0001"));
		assertEquals(user2, household.findUser("Mark0002"));
	}	

	@Test
	public void testReplaceUser() {
		Household household = new Household();
		User user1 = new User("Avi0001", 0, null);
		household.addUser(user1);
		User user2 = new User("Mark0002", 1000, null);
		household.addUser(user2);
		assertEquals(user1, household.findUser("Avi0001"));
		assertEquals(user2, household.findUser("Mark0002"));
		assertEquals(null, 1000, household.findUser("Mark0002").getIncome().getAmount(), 0);
		user2 = new User("Mark0002", 2500, null);
		household.replaceUser(user2);
		assertEquals(user1, household.findUser("Avi0001"));
		assertEquals(null, 2500, household.findUser("Mark0002").getIncome().getAmount(), 0);
	}	

	@Test
	public void testReplaceUser2() {
		Household household = new Household();
		User user1 = new User("Avi0001", 0, null);
		household.addUser(user1);
		User user2 = new User("Mark0002", 1000, null);
		household.addUser(user2);
		assertEquals(user1, household.findUser("Avi0001"));
		assertEquals(user2, household.findUser("Mark0002"));
		Purchases purchases = new Purchases();
		user2.addPurchases(purchases);
		household.replaceUser(user2);
		assertEquals(user1, household.findUser("Avi0001"));
		assertEquals(user2, household.findUser("Mark0002"));
		assertEquals(purchases, household.findUser("Mark0002").getPurchases().get(0));
	}	
}
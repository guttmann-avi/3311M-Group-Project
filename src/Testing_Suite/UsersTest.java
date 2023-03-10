package src.Testing_Suite;

import static org.junit.Assert.*;

import org.junit.Test;

import src.UILogic.Users;
import src.UserImplements.Household;
import src.UserImplements.User;

public class UsersTest {

	@Test
	public void testgetUserNames1() {
		Household household = new Household();
		User user1 = new User("Avi0001", 2000, null);
		User user2 = new User("Avi0002", 3000, null);
		User user3 = new User("Avi0003", 4000, null);
		User user4 = new User("Avi0004", 5000, null);
		User user5 = new User("Avi0005", 6000, null);
		User user6 = new User("Avi0001", 2000, null);
		User user7 = new User("Avi0002", 3000, null);
		User user8 = new User("Avi0003", 4000, null);
		User user9 = new User("Avi0004", 5000, null);
		User user10 = new User("Avi0005", 6000, null);
		household.addUser(user1);
		household.addUser(user2);
		household.addUser(user3);
		household.addUser(user4);
		household.addUser(user5);
		household.addUser(user6);
		household.addUser(user7);
		household.addUser(user8);
		household.addUser(user9);
		household.addUser(user10);
		String[] array = {"Avi0001","Avi0002","Avi0003","Avi0004","Avi0005", "Avi0001","Avi0002","Avi0003","Avi0004","Avi0005"};
		assertEquals(array, new Users(household).getUserNames());
	}

	@Test
	public void testgetUserNames2() {
		Household household = new Household();
		User user1 = new User("Avi0001", 2000, null);
		User user2 = new User("Avi0002", 3000, null);
		User user3 = new User("Avi0003", 4000, null);
		User user4 = new User("Avi0004", 5000, null);
		User user5 = new User("Avi0005", 6000, null);
		household.addUser(user1);
		household.addUser(user2);
		household.addUser(user3);
		household.addUser(user4);
		household.addUser(user5);
		String[] array = {"Avi0001","Avi0002","Avi0003","Avi0004","Avi0005", null, null, null, null, null};
		assertEquals(array, new Users(household).getUserNames());
	}

}

package src.Testing_Suite;

import static org.junit.Assert.*;

import org.junit.Test;

import src.BudgetingSystem.Income;
import src.PrintingInformation.IncomeInformation;
import src.UserImplements.User;

public class IncomeInformationTest {

	@Test
	public void test1() {
		User user = new User("Avi0001", 2000, "Yearly");
		assertEquals("User Avi0001 Income is 2000.00", new IncomeInformation(user, true, "Yearly").printinfo());
	}

	@Test
	public void test2() {
		User user = new User("Mark0002", 5000, "Yearly");
		assertEquals("User Mark0002 Income is 5000.00", new IncomeInformation(user, true, "Yearly").printinfo());
	}

	@Test
	public void test3() {
		User user = new User("Avi0001", 2000, "Monthly");
		assertEquals("User Avi0001 Income is 24000.00", new IncomeInformation(user, true, "Yearly").printinfo());
	}

	@Test
	public void test4() {
		User user = new User("Avi0001", 2000, "Weekly");
		assertEquals("User Avi0001 Income is 104000.00", new IncomeInformation(user, true, "Yearly").printinfo());
	}

	@Test
	public void test5() {
		User user = new User("Avi0001", 2000, "Weekly");
		assertEquals("User Avi0001 Income is 104000.00", new IncomeInformation(user, true, "Yearly").printinfo());
	}

	@Test
	public void test6() {
		User user = new User("Avi0001", 2000, "Weekly");
		assertEquals("User Avi0001 Income is 8000.00", new IncomeInformation(user, false, "Monthly").printinfo());
	}

	@Test
	public void test7() {
		User user = new User("Avi0001", 2000, "Weekly");
		assertEquals("User Avi0001 Income is 2000.00", new IncomeInformation(user, false, "Weekly").printinfo());
	}

	@Test
	public void test8() {
		User user = new User("Avi0001", 2000, "Weekly");
		user.addIncome(new Income(1000, "Avi0001", "Monthly"));
		assertEquals("User Avi0001 Income is 3000.00", new IncomeInformation(user, false, "Weekly").printinfo());
	}
}
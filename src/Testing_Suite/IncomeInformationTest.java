package src.Testing_Suite;

import static org.junit.Assert.*;

import org.junit.Test;

import src.BudgetingSystem.Income;
import src.PrintingInformation.IncomeInformation;
import src.UserImplements.User;

public class IncomeInformationTest {

	@Test
	public void test1() {
		Income income = new Income(2000, "Avi0001", null);
		assertEquals("User Avi0001 Income is 2000.0", new IncomeInformation(income).printinfo());
	}

	@Test
	public void test2() {
		Income income = new Income(5000, "Mark0002", null);
		assertEquals("User Mark0002 Income is 5000.0", new IncomeInformation(income).printinfo());
	}

	@Test
	public void test3() {
		Income income = new Income(2000, "Avi0001", null, "Monthly");
		assertEquals("User Avi0001 Income is 24000.0", new IncomeInformation(income).printinfo());
	}

	@Test
	public void test4() {
		Income income = new Income(2000, "Avi0001", null, "Weekly");
		assertEquals("User Avi0001 Income is 104000.0", new IncomeInformation(income).printinfo());
	}

	@Test
	public void test5() {
		User user = new User("Avi0001", 2000, null, "Weekly");
		assertEquals("User Avi0001 Income is 104000.0", new IncomeInformation(user.getIncome()).printinfo());
	}
}
package src.Testing_Suite;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import src.UILogic.NewPurchase;
import src.UserImplements.Household;
import src.UserImplements.User;

public class NewPurchaseTest {

	@Test
	public void testOutput1() {
		Household household = new Household();
		household.addUser(new User("Avi0001", 1000, null));
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null, null, null, "Avi0001", null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		assertEquals("Please input a valid Integer in the 'Amount' area.", new NewPurchase(inputValues, inputs, household).output());
	}

	@Test
	public void testOutput2() {
		Household household = new Household();
		household.addUser(new User("Mark0001", 1000, null));
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null,null, null, "Mark0001", null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		assertEquals("Please input a valid Integer in the 'Amount' area.", new NewPurchase(inputValues, inputs, household).output());
	}

	@Test
	public void testsetHousehold1() {
		Household household = new Household();
		household.addUser(new User("Avi0001", 1000, null));
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null, "1000", null, "Avi0001", null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		household = new NewPurchase(inputValues, inputs, household).setHousehold(null);
		assertEquals("Avi0001", household.getUsers().get(0).getName());
		assertEquals(null, 1000, household.getUsers().get(0).getPurchases().get(0).getAmount(), 0);
		assertEquals(null, 1, household.getUsers().size(),0);
	}

	@Test
	public void testsetHousehold2() {
		Household household = new Household();
		household.addUser(new User("Avi0001", 1000, null));
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null, "5000", null, "Avi0001", null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		household = new NewPurchase(inputValues, inputs, household).setHousehold(null);
		assertEquals("Avi0001", household.getUsers().get(0).getName());
		assertEquals(true, household.getUsers().get(0).getPurchases().isEmpty());
		assertEquals(null, 1, household.getUsers().size(), 0);
	}

	@Test
	public void testsetHousehold3() {
		Household household = new Household();
		household.addUser(new User("Avi0001", 1000, null));
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null, "10000", null, "Avi0001", null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		household = new NewPurchase(inputValues, inputs, household).setHousehold(null);
		assertEquals("Avi0001", household.getUsers().get(0).getName());
		assertEquals(true, household.getUsers().get(0).getPurchases().isEmpty());
		assertEquals(null, 1, household.getUsers().size(),0);
	}
}

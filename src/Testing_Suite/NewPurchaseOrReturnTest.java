package src.Testing_Suite;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import src.UILogic.NewPurchaseOrReturn;
import src.UserImplements.Household;
import src.UserImplements.User;

public class NewPurchaseOrReturnTest {

	@Test
	public void testOutput1() {
		Household household = new Household();
		household.addUser(new User("Avi0001", 1000, null));
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null, "100", null, "Avi0001", null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		assertEquals("Return has been added successfully to Avi0001.", new NewPurchaseOrReturn("Return", inputValues, inputs, household, null).output());
	}

	@Test
	public void testOutput2() {
		Household household = new Household();
		household.addUser(new User("Avi0001", 1000, null));
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null, "250", null, "Avi0001", null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		assertEquals("Return has been added successfully to Avi0001.", new NewPurchaseOrReturn("Return", inputValues, inputs, household, null).output());
	}

	@Test
	public void testOutput3() {
		Household household = new Household();
		household.addUser(new User("Avi0001", 1000, null));
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null, "250", null, "Avi0001", null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		assertEquals("Purchase has been added successfully to Avi0001.", new NewPurchaseOrReturn("Purchase", inputValues, inputs, household, null).output());
	}

	@Test
	public void testOutput4() {
		Household household = new Household();
		household.addUser(new User("Avi0001", 1000, null));
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null, "250", null, "Avi0001", null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		assertEquals("Purchase has been added successfully to Avi0001.", new NewPurchaseOrReturn("Purchase", inputValues, inputs, household, null).output());
	}

	@Test
	public void testOutput5() {
		Household household = new Household();
		household.addUser(new User("Avi0001", 1000, null));
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null, null, null, "Avi0001", null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		assertEquals("Please fill in fields for 'Amount' and choose a user from the 'User Choice' list.", new NewPurchaseOrReturn("Purchase", inputValues, inputs, household, null).output());
	}

	@Test
	public void testOutput6() {
		Household household = new Household();
		household.addUser(new User("Avi0001", 1000, null));
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null, "250", null, null, null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		assertEquals("Please fill in fields for 'Amount' and choose a user from the 'User Choice' list.", new NewPurchaseOrReturn("Purchase", inputValues, inputs, household, null).output());
	}

	@Test
	public void testOutput7() {
		Household household = new Household();
		household.addUser(new User("Avi0001", 1000, null));
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null, "100", "209102", "Avi0001", null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		assertEquals("Please make sure the 'Purchase/Return Date' field is filled correctly.", new NewPurchaseOrReturn("Purchase", inputValues, inputs, household, null).output());
	}

	@Test
	public void testOutput8() {
		Household household = new Household();
		household.addUser(new User("Avi0001", 1000, null));
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null, "250", "point", "Avi0001", null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		assertEquals("Please make sure the 'Purchase/Return Date' field is filled correctly.", new NewPurchaseOrReturn("Purchase", inputValues, inputs, household, null).output());
	}

	@Test
	public void testOutput9() {
		Household household = new Household();
		household.addUser(new User("Avi0001", 1000, null));
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null, null, "209102", "Avi0001", null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		assertEquals("Please fill in fields for 'Amount' and choose a user from the 'User Choice' list.", new NewPurchaseOrReturn("Purchase", inputValues, inputs, household, null).output());
	}

	@Test
	public void testOutput10() {
		Household household = new Household();
		household.addUser(new User("Avi0001", 1000, null));
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null, "250", "point", null, null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		assertEquals("Please fill in fields for 'Amount' and choose a user from the 'User Choice' list.", new NewPurchaseOrReturn("Purchase", inputValues, inputs, household, null).output());
	}

	@Test
	public void testOutput11() {
		Household household = new Household();
		household.addUser(new User("Avi0001", 1000, null));
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null, "100", null, "Avi0001", null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		assertEquals("Please make sure you have either 'Purchase' or 'Refund' selected.", new NewPurchaseOrReturn(null, inputValues, inputs, household, null).output());
	}

	@Test
	public void testOutput12() {
		Household household = new Household();
		household.addUser(new User("Avi0001", 1000, null));
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null, "250", null, "Avi0001", null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		assertEquals("Please make sure you have either 'Purchase' or 'Refund' selected.", new NewPurchaseOrReturn(null, inputValues, inputs, household, null).output());
	}

	@Test
	public void testOutput13() {
		Household household = new Household();
		household.addUser(new User("Avi0001", 1000, null));
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null, "nak", null, "Avi0001", null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		assertEquals("Please make sure the 'Amount' field is filled correctly.", new NewPurchaseOrReturn(null, inputValues, inputs, household, null).output());
	}

	@Test
	public void testOutput14() {
		Household household = new Household();
		household.addUser(new User("Avi0001", 1000, null));
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null, "abks", null, "Avi0001", null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		assertEquals("Please make sure the 'Amount' field is filled correctly.", new NewPurchaseOrReturn(null, inputValues, inputs, household, null).output());
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
		household = new NewPurchaseOrReturn("Purchase", inputValues, inputs, household, null).setHousehold();
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
		household = new NewPurchaseOrReturn("Purchase", inputValues, inputs, household, null).setHousehold();
		assertEquals("Avi0001", household.getUsers().get(0).getName());
		assertEquals(null, 5000, household.getUsers().get(0).getPurchases().get(0).getAmount(), 0);
		assertEquals(null, 1, household.getUsers().size(),0);
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
		household = new NewPurchaseOrReturn("Purchase", inputValues, inputs, household, null).setHousehold();
		assertEquals("Avi0001", household.getUsers().get(0).getName());
		assertEquals(null, 10000, household.getUsers().get(0).getPurchases().get(0).getAmount(), 0);
		assertEquals(null, 1, household.getUsers().size(),0);
	}

	@Test
	public void testsetHousehold4() {
		Household household = new Household();
		household.addUser(new User("Avi0001", 1000, null));
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null, "1000", null, "Avi0001", null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		household = new NewPurchaseOrReturn("Return", inputValues, inputs, household, null).setHousehold();
		assertEquals("Avi0001", household.getUsers().get(0).getName());
		assertEquals(null, -1000, household.getUsers().get(0).getPurchases().get(0).getAmount(), 0);
		assertEquals(null, 1, household.getUsers().size(),0);
	}

	@Test
	public void testsetHousehold5() {
		Household household = new Household();
		household.addUser(new User("Avi0001", 1000, null));
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null, "5000", null, "Avi0001", null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		household = new NewPurchaseOrReturn("Return", inputValues, inputs, household, null).setHousehold();
		assertEquals("Avi0001", household.getUsers().get(0).getName());
		assertEquals(null, -5000, household.getUsers().get(0).getPurchases().get(0).getAmount(), 0);
		assertEquals(null, 1, household.getUsers().size(),0);
	}

	@Test
	public void testsetHousehold6() {
		Household household = new Household();
		household.addUser(new User("Avi0001", 1000, null));
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null, "10000", null, "Avi0001", null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		household = new NewPurchaseOrReturn("Return", inputValues, inputs, household, null).setHousehold();
		assertEquals("Avi0001", household.getUsers().get(0).getName());
		assertEquals(null, -10000, household.getUsers().get(0).getPurchases().get(0).getAmount(), 0);
		assertEquals(null, 1, household.getUsers().size(),0);
	}
}
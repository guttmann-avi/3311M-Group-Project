package src.Testing_Suite;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import src.UILogic.NewUser;
import src.UserImplements.Household;

public class NewUserTest {

	@Test
	public void testOutput1() {
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {"Avi", "1000", null, null, null, null, "Yearly"};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		assertEquals("User has been added successfully.", new NewUser(inputValues, inputs).output());
	}

	@Test
	public void testOutput2() {
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {"Mark", "2000", null, null, null, null, "Yearly"};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		assertEquals("User has been added successfully.", new NewUser(inputValues, inputs).output());
	}

	@Test
	public void testOutput3() {
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {"Mark", null, null, null, null, null, "Yearly"};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		assertEquals("Pease fill in fields for 'New User Name' and 'Total User Income'", new NewUser(inputValues, inputs).output());
	}

	@Test
	public void testOutput4() {
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, "1000", null, null, null, null, "Yearly"};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		assertEquals("Pease fill in fields for 'New User Name' and 'Total User Income'", new NewUser(inputValues, inputs).output());
	}

	@Test
	public void testOutput5() {
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, "bjsbkd", null, null, null, null, "Yearly"};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		assertEquals("Pease fill in fields for 'New User Name' and 'Total User Income'", new NewUser(inputValues, inputs).output());
	}

	@Test
	public void testOutput6() {
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {"Avi", "bjsbkd", null, null, null, null, "Yearly"};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		assertEquals("Please make sure the value in the 'Total Income Of User' is a valid value.", new NewUser(inputValues, inputs).output());
	}

	@Test
	public void testSetHousehold() {
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {"Avi0001", "1000", null, null, null, null, "Yearly"};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		Household householdOutput = new Household();
		new NewUser(inputValues, inputs).setHousehold(householdOutput);
		assertEquals("Avi0001", householdOutput.getUsers().get(0).getName());
		assertEquals(null, 1000, householdOutput.getUsers().get(0).getIncome().getAmount(), 0);
		assertEquals(null, householdOutput.getUsers().get(0).getIncome().getDate());
		assertEquals("Yearly", householdOutput.getUsers().get(0).getIncome().getFrequency());
		assertEquals("Avi0001", householdOutput.getUsers().get(0).getIncome().getSource());
		assertEquals(null, 1, householdOutput.getUsers().size(),0);
	}

	@Test
	public void testSuccessTrue() {
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {"Avi", "1000", null, null, null, null, "Yearly"};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		assertEquals(true, new NewUser(inputValues, inputs).success());
	}

	@Test
	public void testSuccessFalse() {
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {"Avi", "bjsbkd", null, null, null, null, "Yearly"};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		assertEquals(false, new NewUser(inputValues, inputs).success());
	}
}

package src.Testing_Suite;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.junit.BeforeClass;
import org.junit.Test;

import src.BudgetingSystem.Purchases;
import src.Database.CreateData;
import src.UILogic.InputHolder;
import src.UserImplements.Household;
import src.UserImplements.User;

public class InputHolderTest {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

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
	public void testConstructor1() {
		Household household = new InputHolder().getHousehold();
		assertEquals("Avi0001", household.getUsers().get(0).getName());
		assertEquals(null,1000 , household.getUsers().get(0).getIncome().get(0).getBaseAmount(), 0);
		assertEquals("Yearly", household.getUsers().get(0).getIncome().get(0).getFrequency());
		assertEquals("Avi0001", household.getUsers().get(0).getIncome().get(0).getSource());
		assertEquals(sdf.format(new Date()), sdf.format(household.getUsers().get(0).getIncome().get(0).getDate()));

		assertEquals(null, 250, household.getUsers().get(0).getPurchases().get(0).getAmount(),0);
		assertEquals(null, household.getUsers().get(0).getPurchases().get(0).getCategory());
		assertEquals(null, household.getUsers().get(0).getPurchases().get(0).getDate());

		assertEquals(null, 450, household.getUsers().get(0).getPurchases().get(1).getAmount(),0);
		assertEquals(null, household.getUsers().get(0).getPurchases().get(1).getCategory());
		assertEquals(null, household.getUsers().get(0).getPurchases().get(1).getDate());
	}

	@Test
	public void testConstructor2() {
		Household household = new InputHolder().getHousehold();
		assertEquals("Mark0002", household.getUsers().get(1).getName());
		assertEquals(null,2500, household.getUsers().get(1).getIncome().get(0).getBaseAmount(), 0);
		assertEquals("Monthly", household.getUsers().get(1).getIncome().get(0).getFrequency());
		assertEquals("Mark0002", household.getUsers().get(1).getIncome().get(0).getSource());
		assertEquals(sdf.format(new Date()), sdf.format(household.getUsers().get(1).getIncome().get(0).getDate()));

		assertEquals(null, 350, household.getUsers().get(1).getPurchases().get(0).getAmount(),0);
		assertEquals(null, household.getUsers().get(1).getPurchases().get(0).getCategory());
		assertEquals(null, household.getUsers().get(1).getPurchases().get(0).getDate());

		assertEquals(null, 550, household.getUsers().get(1).getPurchases().get(1).getAmount(),0);
		assertEquals(null, household.getUsers().get(1).getPurchases().get(1).getCategory());
		assertEquals(null, household.getUsers().get(1).getPurchases().get(1).getDate());
	}

	@Test
	public void testGetHousehold1() {
		Household household = new InputHolder().getHousehold();
		assertEquals("John0003", household.getUsers().get(2).getName());
		assertEquals(null,10000, household.getUsers().get(2).getIncome().get(0).getBaseAmount(), 0);
		assertEquals("Weekly", household.getUsers().get(2).getIncome().get(0).getFrequency());
		assertEquals("John0003", household.getUsers().get(2).getIncome().get(0).getSource());
		assertEquals(sdf.format(new Date()), sdf.format(household.getUsers().get(2).getIncome().get(0).getDate()));
	}

	@Test
	public void testGetHousehold2() {
		Household household = new InputHolder().getHousehold();
		assertEquals(null, 100, household.getPurchases().get(0).getAmount(),0);
		assertEquals(null, household.getPurchases().get(0).getCategory());
		assertEquals(null, household.getPurchases().get(0).getDate());
	}

	@Test
	public void testsetHousehold1() {
		InputHolder inputHolder = new InputHolder();
		Household household = new Household();
		household.addUser(new User("Avi0001", 1000, "Monthly"));
		inputHolder.setHousehold(household);
		assertEquals("Avi0001", household.getUsers().get(0).getName());
		assertEquals(null,1000 , household.getUsers().get(0).getIncome().get(0).getBaseAmount(), 0);
		assertEquals("Monthly", household.getUsers().get(0).getIncome().get(0).getFrequency());
		assertEquals("Avi0001", household.getUsers().get(0).getIncome().get(0).getSource());
		assertEquals(sdf.format(new Date()), sdf.format(household.getUsers().get(0).getIncome().get(0).getDate()));
		assertEquals(null, 12000, household.getIncome().getBaseAmount(), 0);
	}

	@Test 
	public void testGetAction1() {
		InputHolder inputHolder = new InputHolder();
		inputHolder.setAction("Insert New User");
		assertEquals("Insert New User", inputHolder.getAction());
	}

	@Test 
	public void testGetAction2() {
		InputHolder inputHolder = new InputHolder();
		inputHolder.setAction("Insert Purchase");
		assertEquals("Insert Purchase", inputHolder.getAction());
	}

	@Test 
	public void testGetAction3() {
		InputHolder inputHolder = new InputHolder();
		inputHolder.setAction("View Purchases");
		assertEquals("View Purchases", inputHolder.getAction());
	}

	@Test 
	public void testGetRadioButton1() {
		InputHolder inputHolder = new InputHolder();
		inputHolder.setRadioButton("Purchase");
		assertEquals("Purchase", inputHolder.getRadioButton());
	}

	@Test 
	public void testGetRadioButton2() {
		InputHolder inputHolder = new InputHolder();
		inputHolder.setRadioButton("Purchase");
		assertEquals("Purchase", inputHolder.getRadioButton());
	}

	@Test
	public void testOutputNewUser1() {
		InputHolder inputHolder = new InputHolder();
		inputHolder.setAction("Insert New User");
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {"Avi", "1000", null, null, null, null, "Yearly"};
		inputHolder.setInput(inputValues, inputs);
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		assertEquals("User has been added successfully.", inputHolder.output());
	}

	@Test
	public void testOutputNewUser2() {
		InputHolder inputHolder = new InputHolder();
		inputHolder.setAction("Insert New User");
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {"Mark", "2000", null, null, null, null, "Yearly"};
		inputHolder.setInput(inputValues, inputs);
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		assertEquals("User has been added successfully.", inputHolder.output());
	}

	@Test
	public void testOutputNewUser3() {
		InputHolder inputHolder = new InputHolder();
		inputHolder.setAction("Insert New User");
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {"Mark", null, null, null, null, null, "Yearly"};
		inputHolder.setInput(inputValues, inputs);
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		assertEquals("Pease fill in fields for 'New User Name' and 'Total User Income'", inputHolder.output());
	}

	@Test
	public void testOutputNewUser4() {
		InputHolder inputHolder = new InputHolder();
		inputHolder.setAction("Insert New User");
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, "1000", null, null, null, null, "Yearly"};
		inputHolder.setInput(inputValues, inputs);
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		assertEquals("Pease fill in fields for 'New User Name' and 'Total User Income'", inputHolder.output());
	}

	@Test
	public void testOutputNewUser5() {
		InputHolder inputHolder = new InputHolder();
		inputHolder.setAction("Insert New User");
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, "bjsbkd", null, null, null, null, "Yearly"};
		inputHolder.setInput(inputValues, inputs);
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		assertEquals("Pease fill in fields for 'New User Name' and 'Total User Income'", inputHolder.output());
	}

	@Test
	public void testOutputNewUser6() {
		InputHolder inputHolder = new InputHolder();
		inputHolder.setAction("Insert New User");
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {"Avi", "bjsbkd", null, null, null, null, "Yearly"};
		inputHolder.setInput(inputValues, inputs);
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		assertEquals("Please make sure the value in the 'Total Income Of User' is a valid value.",inputHolder.output());
	}

	@Test
	public void testOutputInsertPurchase1() {
		InputHolder inputHolder = new InputHolder();
		inputHolder.setAction("Insert Purchase");
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null, "100", null, "Avi0001", null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		inputHolder.setInput(inputValues, inputs);
		inputHolder.setRadioButton("Return");
		assertEquals("Return has been added successfully to Avi0001.", inputHolder.output());
	}

	@Test
	public void testOutputInsertPurchase2() {
		InputHolder inputHolder = new InputHolder();
		inputHolder.setAction("Insert Purchase");
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null, "250", null, "Avi0001", null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		inputHolder.setInput(inputValues, inputs);
		inputHolder.setRadioButton("Return");
		assertEquals("Return has been added successfully to Avi0001.", inputHolder.output());
	}

	@Test
	public void testOutputInsertPurchase3() {
		InputHolder inputHolder = new InputHolder();
		inputHolder.setAction("Insert Purchase");
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null, "250", null, "Avi0001", null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		inputHolder.setInput(inputValues, inputs);
		inputHolder.setRadioButton("Purchase");
		assertEquals("Purchase has been added successfully to Avi0001.", inputHolder.output());
	}

	@Test
	public void testOutputInsertPurchase4() {
		InputHolder inputHolder = new InputHolder();
		inputHolder.setAction("Insert Purchase");
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null, "250", null, "Avi0001", null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		inputHolder.setInput(inputValues, inputs);
		inputHolder.setRadioButton("Purchase");
		assertEquals("Purchase has been added successfully to Avi0001.", inputHolder.output());
	}

	@Test
	public void testOutputInsertPurchase5() {
		InputHolder inputHolder = new InputHolder();
		inputHolder.setAction("Insert Purchase");
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null, null, null, "Avi0001", null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		inputHolder.setInput(inputValues, inputs);
		assertEquals("Please fill in fields for 'Amount' and choose a user from the 'User Choice' list.", inputHolder.output());
	}

	@Test
	public void testOutputInsertPurchase6() {
		InputHolder inputHolder = new InputHolder();
		inputHolder.setAction("Insert Purchase");
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null, "250", null, null, null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		inputHolder.setInput(inputValues, inputs);
		assertEquals("Please fill in fields for 'Amount' and choose a user from the 'User Choice' list.", inputHolder.output());
	}

	@Test
	public void testOutputInsertPurchase7() {
		InputHolder inputHolder = new InputHolder();
		inputHolder.setAction("Insert Purchase");
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null, "100", "209102", "Avi0001", null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		inputHolder.setInput(inputValues, inputs);
		assertEquals("Please make sure the 'Purchase/Return Date' field is filled correctly and that all values are positive.", inputHolder.output());
	}

	@Test
	public void testOutputInsertPurchase8() {
		InputHolder inputHolder = new InputHolder();
		inputHolder.setAction("Insert Purchase");
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null, "250", "point", "Avi0001", null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		inputHolder.setInput(inputValues, inputs);
		assertEquals("Please make sure the 'Purchase/Return Date' field is filled correctly and that all values are positive.", inputHolder.output());
	}

	@Test
	public void testOutputInsertPurchase9() {
		InputHolder inputHolder = new InputHolder();
		inputHolder.setAction("Insert Purchase");
		HashMap<String, String> inputValues = new HashMap();
		String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null, null, "209102", "Avi0001", null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		inputHolder.setInput(inputValues, inputs);
		assertEquals("Please fill in fields for 'Amount' and choose a user from the 'User Choice' list.", inputHolder.output());
	}

	@Test
	public void testOutputInsertPurchase10() {
		InputHolder inputHolder = new InputHolder();
		inputHolder.setAction("Insert Purchase");
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null, "250", "point", null, null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		inputHolder.setInput(inputValues, inputs);
		assertEquals("Please fill in fields for 'Amount' and choose a user from the 'User Choice' list.", inputHolder.output());
	}

	@Test
	public void testOutputInsertPurchase11() {
		InputHolder inputHolder = new InputHolder();
		inputHolder.setAction("Insert Purchase");
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null, "100", null, "Avi0001", null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		inputHolder.setInput(inputValues, inputs);
		assertEquals("Please make sure you have either 'Purchase' or 'Refund' selected.", inputHolder.output());
	}

	@Test
	public void testOutputInsertPurchase12() {
		InputHolder inputHolder = new InputHolder();
		inputHolder.setAction("Insert Purchase");
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null, "250", null, "Avi0001", null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		inputHolder.setInput(inputValues, inputs);
		assertEquals("Please make sure you have either 'Purchase' or 'Refund' selected.", inputHolder.output());
	}

	@Test
	public void testOutputInsertPurchase13() {
		InputHolder inputHolder = new InputHolder();
		inputHolder.setAction("Insert Purchase");
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null, "nak", null, "Avi0001", null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		inputHolder.setInput(inputValues, inputs);
		assertEquals("Please make sure the 'Amount' field is filled correctly.", inputHolder.output());
	}

	@Test
	public void testOutputInsertPurchase14() {
		InputHolder inputHolder = new InputHolder();
		inputHolder.setAction("Insert Purchase");
		HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency"};
		String[] values = {null, null, "abks", null, "Avi0001", null, null};
		for (int i = 0; i < inputs.length; i++) {
			inputValues.put(inputs[i], values[i]);
		}
		inputHolder.setInput(inputValues, inputs);
		assertEquals("Please make sure the 'Amount' field is filled correctly.", inputHolder.output());
	}
}
package UIElements;

import javax.swing.*;

import userImplements.Household;
import userImplements.User;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.ArrayList;

public class GUI extends JFrame implements ItemListener, ActionListener {

    private int userCounter = 0;

    JLabel nameL;
    JLabel budgetL;
    JLabel amountL;
	JLabel startDateL;
	JLabel endDateL;
	JLabel usersL;
    
	JTextField nameT;
    JTextField budgetT;
    JTextField amountT;
    JTextField startDateT;
    JTextField endDateT;
    JList<String> userList;
    
    JButton insertNewUser;
    JButton insertNewPurchase;
    JTextArea purchaseOutputPanel;

    Household household = new Household();

	String[] userss = new String[10];

    public GUI() {
        initialize();
    }

    private void initialize() {

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        nameL = new JLabel("       New User Name ");
        nameL.setEnabled(true);
        budgetL = new JLabel("		Total User Income ");
        budgetL.setEnabled(true);
        nameT = new JTextField();
        nameT.setEnabled(true);
        budgetT = new JTextField();
        budgetT.setEnabled(true);

        JPanel newInformation = new JPanel(new GridLayout(0, 1));
        newInformation.add(nameL);
        newInformation.add(nameT);
        newInformation.add(budgetL);
        newInformation.add(budgetT);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        this.add(newInformation, c);

        JLabel emptyLabel1 = new JLabel("                    \n          ");
        JPanel emptyPanel1 = new JPanel(new GridLayout(0, 1));
        emptyPanel1.add(emptyLabel1);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        this.add(emptyPanel1, c);
        
        JPanel datePanel = new JPanel(new GridLayout(0, 1));
		
		amountL = new JLabel("       Amount ");
		amountL.setEnabled(true);
		startDateL = new JLabel("       Start Date (DD/MM/YYYY)  ");
		startDateL.setEnabled(true);
		endDateL = new JLabel("       End Date (DD/MM/YYYY)  ");
		endDateL.setEnabled(true);
		
        usersL = new JLabel("			User Choice");
        usersL.setEnabled(true);
        amountT = new JTextField();
        amountT.setEnabled(true);
        startDateT = new JTextField();
        startDateT.setEnabled(true);
        endDateT = new JTextField();
        endDateT.setEnabled(true);

        userList = new JList<String>();
        userList.setEnabled(true);
		userList.setListData(userss);
        JPanel newPurchase = new JPanel(new GridLayout(0, 2));
		newPurchase.add(amountL);
		newPurchase.add(amountT);
		newPurchase.add(startDateL);
		newPurchase.add(startDateT);
		newPurchase.add(endDateL);
		newPurchase.add(endDateT);
		newPurchase.add(usersL);
		newPurchase.add(userList);
		datePanel.add(newPurchase);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 0;
        this.add(datePanel, c);
        
        JLabel emptyLabel2 = new JLabel("                    \n          ");
        JPanel emptyPanel2 = new JPanel(new GridLayout(0, 1));
        emptyPanel2.add(emptyLabel2);
        c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
        this.add(emptyPanel2, c);
        
        insertNewPurchase = new JButton("Insert Purchase");
        insertNewPurchase.addActionListener(this);
		JPanel submitPanelPurchase = new JPanel(new GridLayout(0, 1));
		submitPanelPurchase.add(insertNewPurchase);
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_START;
		c.gridx = 3;
		c.gridy = 2;
        this.add(submitPanelPurchase, c);

        insertNewUser = new JButton("Insert New User");
        insertNewUser.addActionListener(this);
		JPanel submitPanelNewUser = new JPanel(new GridLayout(0, 1));
		submitPanelNewUser.add(insertNewUser);
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_START;
		c.gridx = 1;
		c.gridy = 2;
        this.add(submitPanelNewUser, c);
        
        JLabel emptyLabel3 = new JLabel("                    \n          ");
        JPanel emptyPanel3 = new JPanel(new GridLayout(0, 1));
        emptyPanel3.add(emptyLabel3);
        c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
        this.add(emptyPanel3, c);

        purchaseOutputPanel = new JTextArea(18,50);
        purchaseOutputPanel.setText("Any Output will be shown here.");
		JScrollPane outputPanel = new JScrollPane(purchaseOutputPanel);
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 4;
        this.add(outputPanel, c);
        
		this.setBounds(50, 50, 600, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void itemStateChanged(ItemEvent e) {    
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getActionCommand();
        if (source == insertNewUser.getText()) {
            if (nameT.getText().isBlank() || budgetT.getText().isBlank()) {
                purchaseOutputPanel.setText("Pease fill in fields for 'New User Name' and 'Total User Income' "); 
            } else {
                try {
                    User user = new User(nameT.getText(), Double.parseDouble(budgetT.getText()), null);
                    household.addUser(user);
                    userss[userCounter] = user.getName();
                    userCounter++;
                    userList.setListData(userss);
                    purchaseOutputPanel.setText("User has been added successfully");
                } catch (NumberFormatException numberFormatException) {
                    purchaseOutputPanel.setText("Please make sure the value in the 'Total User Income' is a valid value.");
                }
            } 
        }
    }
}
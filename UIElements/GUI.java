package UIElements;

import javax.swing.*;

import BudgetingSystem.Purchases;
import PrintingInformation.IncomeInformation;
import PrintingInformation.MoneyLeftInformation;
import PrintingInformation.UserInformation;
import PrintingInformation.purchaseInformation;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;

import userImplements.Household;
import userImplements.User;

public class GUI extends JFrame implements ItemListener, ActionListener {

    JLabel nameL;
    JLabel incomeL;
    JLabel amountL;
    JLabel purchaseDateL;
    JLabel usersL;

    private int userCounter = 0;
    JTextField nameT;
    JTextField incomeT;
    JTextField amountT;
    JTextField purchaseDateT;
    JList<String> userList;

    JButton insertNewUser;
    JButton insertNewPurchase;
    JButton viewPurchases;
    JTextArea purchaseOutputPanel;

    Household household = new Household();

    String[] userss = new String[10];

    public GUI() {
        initialize();
    }

    private void initialize() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        nameL = new JLabel("New User Name");
        nameL.setEnabled(true);
        incomeL = new JLabel("Total Income Of User");
        incomeL.setEnabled(true);
        nameT = new JTextField();
        nameT.setEnabled(true);
        incomeT = new JTextField();
        incomeT.setEnabled(true);

        JPanel newInformation = new JPanel(new GridLayout(0, 1));
        newInformation.add(nameL);
        newInformation.add(nameT);
        newInformation.add(incomeL);
        newInformation.add(incomeT);
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

        JPanel purchasePanel = new JPanel(new GridLayout(0, 1));
        amountL = new JLabel("Amount");
        amountL.setEnabled(true);
        purchaseDateL = new JLabel("Purchase Date (DD/MM/YYYY)");
        purchaseDateL.setEnabled(true);
        amountT = new JTextField();
        amountT.setEnabled(true);
        purchaseDateT = new JTextField();
        purchaseDateT.setEnabled(true);
        JPanel newPurchase = new JPanel(new GridLayout(0, 1));
        newPurchase.add(amountL);
        newPurchase.add(amountT);
        newPurchase.add(purchaseDateL);
        newPurchase.add(purchaseDateT);
        purchasePanel.add(newPurchase);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 0;
        this.add(purchasePanel, c);

        JLabel emptyLabel2 = new JLabel("                    \n          ");
        JPanel emptyPanel2 = new JPanel(new GridLayout(0, 1));
        emptyPanel2.add(emptyLabel2);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 1;
        this.add(emptyPanel2, c);

        JPanel userPanel = new JPanel(new GridLayout(0, 1));

        usersL = new JLabel("User Choice");
        usersL.setEnabled(true);
        userList = new JList<String>();
        userList.setEnabled(true);
        JPanel userChoicePanel = new JPanel(new GridLayout(0, 1));
        userChoicePanel.add(usersL);
        userChoicePanel.add(userList);
        userPanel.add(userChoicePanel);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 4;
        c.gridy = 0;
        this.add(userPanel, c);

        JLabel emptyLabel3 = new JLabel("                    \n          ");
        JPanel emptyPanel3 = new JPanel(new GridLayout(0, 1));
        emptyPanel3.add(emptyLabel3);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        this.add(emptyPanel3, c);

        insertNewUser = new JButton("Insert New User");
        insertNewUser.addActionListener(this);
        JPanel submitPanelNewUser = new JPanel(new GridLayout(0, 1));
        submitPanelNewUser.add(insertNewUser);
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.LINE_START;
        c.gridx = 0;
        c.gridy = 2;
        this.add(submitPanelNewUser, c);

        insertNewPurchase = new JButton("Insert Purchase");
        insertNewPurchase.addActionListener(this);
        JPanel submitPanelPurchase = new JPanel(new GridLayout(0, 1));
        submitPanelPurchase.add(insertNewPurchase);
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.LINE_START;
        c.gridx = 2;
        c.gridy = 2;
        this.add(submitPanelPurchase, c);        

        viewPurchases = new JButton("View Purchases");
        viewPurchases.addActionListener(this);
        JPanel viewPurchasesPanel = new JPanel(new GridLayout(0, 1));
        viewPurchasesPanel.add(viewPurchases);
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.LINE_START;
        c.gridx = 4;
        c.gridy = 2;
        this.add(viewPurchasesPanel, c);       

        JLabel emptyLabel4 = new JLabel("                    \n          ");
        JPanel emptyPanel4 = new JPanel(new GridLayout(0, 1));
        emptyPanel4.add(emptyLabel4);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 3;
        this.add(emptyPanel4, c);

        purchaseOutputPanel = new JTextArea(18, 50);
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
            if (nameT.getText().isBlank() || incomeT.getText().isBlank()) {
                purchaseOutputPanel.setText("Pease fill in fields for 'New User Name' and 'Total User Income' ");
            } else {
                try {
                    User user = new User(nameT.getText(), Double.parseDouble(incomeT.getText()), null);
                    household.addUser(user);
                    userss[userCounter] = user.getName();
                    userCounter++;
                    userList.setListData(userss);
                    purchaseOutputPanel.setText("User has been added successfully.");
                } catch (NumberFormatException numberFormatException) {
                    purchaseOutputPanel.setText("Please make sure the value in the 'Total User Income' is a valid value.");
                }
            }
        } else if (source == insertNewPurchase.getText()) {
            if (amountT.getText().isBlank() || purchaseDateT.getText().isBlank() 
            || userList.getSelectedValue() == null) {
                purchaseOutputPanel.setText("Please fill in fields for 'Amount', 'Purchase Date' and choose a user from the 'User Choice' list.");
            } else {
                Date purchaseDate = new Date();
                try {
                    String[] purchaseTime =  purchaseDateT.getText().split("/");
                    purchaseDate = new Date(Integer.parseInt(purchaseTime[2]), Integer.parseInt(purchaseTime[1]), Integer.parseInt(purchaseTime[0]));
                    try {
                        User user = household.findUser(userList.getSelectedValue());
                        user.addPurchases(new Purchases(Double.parseDouble(amountT.getText()), purchaseDate));
                        household.replaceUser(user);
                        purchaseOutputPanel.setText("Purchase has been added successfully to " + userList.getSelectedValue() + ".");
                    } catch (Exception exception) {
                        purchaseOutputPanel.setText("Please make sure the 'Amount' field is filled correctly.");
                    }
                } catch (Exception exception) {
                    purchaseOutputPanel.setText("Please make sure the 'Purchase Date' field is filled correctly.");
                }
            }
        } else if (source == viewPurchases.getText()) { 
            try {
                String info;
                User user = household.findUser(userList.getSelectedValue());
                UserInformation userInformation = new UserInformation(user);
                IncomeInformation incomeInformation = new IncomeInformation(user.getIncome());
                MoneyLeftInformation moneyLeftInformation = new MoneyLeftInformation(user);
                purchaseInformation purchaseInformation = new purchaseInformation(user, null, null, null);
                info = userInformation.printinfo() + incomeInformation.printinfo()+" \t" + moneyLeftInformation.printinfo() + purchaseInformation.printinfo();
                purchaseOutputPanel.setText(info);
            } catch (Exception exception) {
                purchaseOutputPanel.setText(exception.getMessage());
            }
        }
    }
}
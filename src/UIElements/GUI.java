package src.UIElements;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

import src.UILogic.InputHolder;
import src.UILogic.Users;

public class GUI extends JFrame implements ItemListener, ActionListener {

    JLabel nameL;
    JLabel incomeL;
    JLabel amountL;
    JLabel purchaseDateL;
    JLabel usersL;
    JLabel deleteL;
    JLabel categoryL;
    

    JTextField nameT;
    JTextField incomeT;
    JTextField amountT;
    JTextField purchaseDateT;
    JTextField deleteT;
    JTextField categoryT;

    JList<String> userList;
    JList<String> categoryList;

    
    JButton insertNewUser;
    JButton insertNewPurchase;
    JButton viewPurchases;
    JButton deletePurchases;
    JButton bonusRadioButton;
    JButton newIncomeButton;
    JButton replacePurchasesButton;
    JTextArea purchaseOutputPanel;
    JCheckBox allTimeCheckbox;

    JPanel radioButtonsPanel;
    JRadioButton purchaseRadioButton;
    JRadioButton returnRadioButton;
    

    private JComboBox<String> frequencyDropdown;
    

    private InputHolder inputHolder;

    public GUI() {
        this.inputHolder = new InputHolder();
        initialize();
    }

    private void initialize() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10,20,10,20);

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
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 0;
        this.add(newInformation, c);

        JLabel emptyLabel1 = new JLabel("                    \n          ");
        JPanel emptyPanel1 = new JPanel(new GridLayout(0, 1));
        emptyPanel1.add(emptyLabel1);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 1;
        c.gridy = 0;
        this.add(emptyPanel1, c);

        JPanel purchasePanel = new JPanel(new GridLayout(0, 1));
        amountL = new JLabel("Amount");
        amountL.setEnabled(true);
        purchaseDateL = new JLabel("Purchase/Return Date (DD/MM/YYYY)");
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
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 2;
        c.gridy = 0;
        this.add(purchasePanel, c);

        JLabel emptyLabel2 = new JLabel("                    \n          ");
        JPanel emptyPanel2 = new JPanel(new GridLayout(0, 1));
        emptyPanel2.add(emptyLabel2);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 3;
        c.gridy = 1;
        this.add(emptyPanel2, c);

        JPanel userPanel = new JPanel(new GridLayout(0, 1));

        usersL = new JLabel("User Choice");
        usersL.setEnabled(true);
        userList = new JList<String>();
        userList.setListData(new Users(inputHolder.getHousehold()).getUserNames());
        userList.setEnabled(true);
        JPanel userChoicePanel = new JPanel(new GridLayout(0, 1));
        userChoicePanel.add(usersL);
        userChoicePanel.add(userList);
        userPanel.add(userChoicePanel);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 4;
        c.gridy = 0;
        this.add(userPanel, c);
        
        
        JPanel categoryPanel1 = new JPanel(new GridLayout(0,1));
        categoryL = new JLabel("Category Choice");
        categoryL.setEnabled(true);
        categoryList = new JList<String>();
        categoryList.setListData(inputHolder.getCategories());
        categoryList.setEnabled(true);
        JPanel categoryChoicePanel = new JPanel(new GridLayout(0,1));
        categoryChoicePanel.add(categoryL);
        categoryChoicePanel.add(categoryList);
        categoryPanel1.add(categoryChoicePanel);
        categoryPanel1.hide();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 5;
        c.gridy = 1;
        this.add(categoryPanel1,c);
        
        

        JLabel emptyLabel3 = new JLabel("                    \n          ");
        JPanel emptyPanel3 = new JPanel(new GridLayout(0, 1));
        emptyPanel3.add(emptyLabel3);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 1;
        c.gridy = 1;
        this.add(emptyPanel3, c);

        String[] frequencyOptions = { "Yearly", "Monthly", "Weekly" };
        frequencyDropdown = new JComboBox<String>(frequencyOptions);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 1;
        this.add(frequencyDropdown, c);

        insertNewUser = new JButton("Insert New User");
        insertNewUser.addActionListener(this);
        JPanel submitPanelNewUser = new JPanel(new GridLayout(0, 1));
        submitPanelNewUser.add(insertNewUser);
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.LINE_START;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 2;
        this.add(submitPanelNewUser, c);

        insertNewPurchase = new JButton("Insert Purchase");
        insertNewPurchase.addActionListener(this);
        JPanel submitPanelPurchase = new JPanel(new GridLayout(0, 1));
        submitPanelPurchase.add(insertNewPurchase);
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.LINE_START;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 2;
        c.gridy = 2;
        this.add(submitPanelPurchase, c);

        radioButtonsPanel = new JPanel(new GridLayout(2, 2));
        purchaseRadioButton = new JRadioButton("Purchase");
        returnRadioButton = new JRadioButton("Return");
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(purchaseRadioButton);
        radioGroup.add(returnRadioButton);
        radioButtonsPanel.add(purchaseRadioButton);
        radioButtonsPanel.add(returnRadioButton);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 2;
        c.gridy = 1;
        this.add(radioButtonsPanel, c);

        viewPurchases = new JButton("View Purchases");
        viewPurchases.addActionListener(this);
        JPanel viewPurchasesPanel = new JPanel(new GridLayout(0, 1));
        viewPurchasesPanel.add(viewPurchases);
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.LINE_START;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 4;
        c.gridy = 2;
        this.add(viewPurchasesPanel, c);

        JLabel emptyLabel4 = new JLabel("                    \n          ");
        JPanel emptyPanel4 = new JPanel(new GridLayout(0, 1));
        emptyPanel4.add(emptyLabel4);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 1;
        c.gridy = 3;
        this.add(emptyPanel4, c);

        purchaseOutputPanel = new JTextArea(18, 50);
        purchaseOutputPanel.setText(
                "Any Output will be shown here. Please begin by creating a User and after adding some purchase information.");
        JScrollPane outputPanel = new JScrollPane(purchaseOutputPanel);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 4;
        this.add(outputPanel, c);

        this.setBounds(50, 50, 600, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // new code
        JPanel deletePanel = new JPanel(new GridLayout(0, 1));
        deleteL = new JLabel("Transaction Id");
        deleteL.setEnabled(true);
        deleteT = new JTextField();
        deleteT.setEnabled(true);
        JPanel deleteInformation = new JPanel(new GridLayout(0, 1));
        deleteInformation.add(deleteL);
        deleteInformation.add(deleteT);
        deletePanel.add(deleteInformation);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 5;
        c.gridy = 0;
        this.add(deletePanel, c);

        deletePurchases = new JButton("Delete Transaction");
        deletePurchases.addActionListener(this);
        JPanel deletePurchasesPanel = new JPanel(new GridLayout(0, 1));
        deletePurchasesPanel.add(deletePurchases);
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.LINE_START;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 7;
        c.gridy = 2;
        this.add(deletePurchasesPanel, c);
        
        // Category panel here
        JPanel categoryPanel = new JPanel(new GridLayout(0,1));
        categoryL = new JLabel("Category");
        categoryL.setEnabled(true);
        categoryT = new JTextField();
        categoryT.setEnabled(true);
        
        JPanel insertCategory = new JPanel(new GridLayout(0, 1));
        insertCategory.add(categoryL);
        insertCategory.add(categoryT);
        categoryPanel.add(insertCategory);
        insertCategory.hide();
        c.fill = GridBagConstraints.NONE;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 3;
        c.gridy = 2;
        this.add(categoryPanel, c);
        
        //new buttons below
        bonusRadioButton = new JButton("One-Time Bonus");
        bonusRadioButton.addActionListener(this);
        JPanel bonusButtonPanel = new JPanel(new GridLayout(0, 1));
        bonusButtonPanel.add(bonusRadioButton);
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.LINE_START;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 2;
        c.gridy = 3;
        this.add(bonusButtonPanel, c);
        
        newIncomeButton = new JButton("Extra Income");
        newIncomeButton.addActionListener(this);
        JPanel incomeButtonPanel = new JPanel(new GridLayout(0, 1));
        incomeButtonPanel.add(newIncomeButton);
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.LINE_START;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 3;
        this.add(incomeButtonPanel, c);
        
        replacePurchasesButton = new JButton("Replace Purchase Info");
        replacePurchasesButton.addActionListener(this);
        JPanel purchaseButtonPanel = new JPanel(new GridLayout(0, 1));
        purchaseButtonPanel.add(replacePurchasesButton);
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.LINE_START;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 4;
        c.gridy = 3;
        this.add(purchaseButtonPanel, c);   
        
        allTimeCheckbox = new JCheckBox("All Time");
        allTimeCheckbox.setAlignmentY((float) 10.0);
        allTimeCheckbox.setAlignmentX((float) 1.0);
        // this.add(allTimeCheckbox);
        JPanel allTimeCheckboxPanel = new JPanel(new GridLayout(0, 1));
        allTimeCheckboxPanel.add(allTimeCheckbox);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0; // Change the value of gridx and gridy according to the desired position in the grid
        c.gridy = 5; // For example: c.gridx = 0 and c.gridy = 5 place the checkbox in the first column and the sixth row
        this.add(allTimeCheckboxPanel, c);
        this.setMinimumSize(new Dimension(400, 600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    public void itemStateChanged(ItemEvent e) {}

    public void actionPerformed(ActionEvent e) {
        Object source = e.getActionCommand();
        inputHolder.setAction(source.toString());
        if (purchaseRadioButton.isSelected() || returnRadioButton.isSelected()) {
            if (purchaseRadioButton.isSelected()) {
                inputHolder.setRadioButton(purchaseRadioButton.getText());
            } else {
                inputHolder.setRadioButton(returnRadioButton.getText());
            }
        }
        HashMap<String, String> inputValues = new HashMap();
        String[] inputs = {"User Name","Income","Amount","Purchase/Return Date","User Choice","Transaction Id","Frequency","Category"};

        for (String input : inputs) inputValues.put(input, null);
        if (!nameT.getText().isBlank()) inputValues.put(inputs[0], nameT.getText());
        if (!incomeT.getText().isBlank()) inputValues.put(inputs[1], incomeT.getText());
        if (!amountT.getText().isBlank()) inputValues.put(inputs[2], amountT.getText());
        if (!purchaseDateT.getText().isBlank()) inputValues.put(inputs[3], purchaseDateT.getText());
        if (userList.getSelectedValue() != null) inputValues.put(inputs[4], userList.getSelectedValue());
        if (!deleteT.getText().isBlank()) inputValues.put(inputs[5], deleteT.getText());
        inputValues.put(inputs[6], frequencyDropdown.getSelectedItem().toString());
        if (!categoryT.getText().isBlank()) inputValues.put(inputs[7],categoryT.getText());
        inputHolder.setAllTime(allTimeCheckbox.isSelected());
        inputHolder.setInput(inputValues, inputs);
        purchaseOutputPanel.setText(inputHolder.output());
        String selected = userList.getSelectedValue();
        userList.setListData(new Users(inputHolder.getHousehold()).getUserNames());
        userList.setSelectedValue(selected, rootPaneCheckingEnabled);
    }
}
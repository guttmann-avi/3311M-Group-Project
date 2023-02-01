package BudgetingSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.ArrayList;

public class GUI extends JFrame implements ItemListener, ActionListener {

    JLabel nameL;
    JLabel budgetL;
    JTextField nameT;
    JTextField budgetT;

    public GUI() {
        initialize();
    }

    private void initialize() {

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        nameL = new JLabel("       New User Name ");
        nameL.setEnabled(true);
        budgetL = new JLabel("		Total Budget Of User ");
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
    }

    public void itemStateChanged(ItemEvent e) {

    }

    public void actionPerformed(ActionEvent e) {

    }
}
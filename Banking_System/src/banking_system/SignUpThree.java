package banking_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class SignUpThree extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
    JRadioButton r1, r2, r3, r4;
    JButton b1, b2;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    String formno;

    SignUpThree(String formno) {
        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l14 = new JLabel(i3);
        l14.setBounds(150, 0, 100, 100);
        add(l14);

        l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));

        l2 = new JLabel("Account Type:");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));

        l3 = new JLabel("Card Number:");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));

        l4 = new JLabel("XXXX-XXXX-XXXX-4184");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));

        l5 = new JLabel("(Your 16-digit Card number)");
        l5.setFont(new Font("Raleway", Font.BOLD, 12));

        l6 = new JLabel("PIN:");
        l6.setFont(new Font("Raleway", Font.BOLD, 18));

        l7 = new JLabel("XXXX");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));

        l8 = new JLabel("(4-digit password)");
        l8.setFont(new Font("Raleway", Font.BOLD, 12));

        l10 = new JLabel("Services Required:");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));

        b1 = new JButton("Submit");
        b2 = new JButton("Cancel");

        c1 = new JCheckBox("ATM CARD");
        c2 = new JCheckBox("Internet Banking");
        c3 = new JCheckBox("Mobile Banking");
        c4 = new JCheckBox("EMAIL Alerts");
        c5 = new JCheckBox("Cheque Book");
        c6 = new JCheckBox("E-Statement");

        r1 = new JRadioButton("Saving Account");
        r2 = new JRadioButton("Fixed Deposit Account");
        r3 = new JRadioButton("Current Account");
        r4 = new JRadioButton("Recurring Deposit Account");

        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        setLayout(null);

        l1.setBounds(280, 30, 600, 40);
        add(l1);
        l2.setBounds(100, 140, 200, 30);
        add(l2);
        r1.setBounds(100, 180, 150, 30);
        add(r1);
        r2.setBounds(350, 180, 300, 30);
        add(r2);
        r3.setBounds(100, 220, 250, 30);
        add(r3);
        r4.setBounds(350, 220, 250, 30);
        add(r4);
        l3.setBounds(100, 300, 200, 30);
        add(l3);
        l4.setBounds(330, 300, 250, 30);
        add(l4);
        l5.setBounds(100, 330, 200, 20);
        add(l5);
        l6.setBounds(100, 370, 200, 30);
        add(l6);
        l7.setBounds(330, 370, 200, 30);
        add(l7);
        l8.setBounds(100, 400, 200, 20);
        add(l8);
        l10.setBounds(100, 450, 200, 30);
        add(l10);
        c1.setBounds(100, 500, 200, 30);
        add(c1);
        c2.setBounds(350, 500, 200, 30);
        add(c2);
        c3.setBounds(100, 550, 200, 30);
        add(c3);
        c4.setBounds(350, 550, 200, 30);
        add(c4);
        c5.setBounds(100, 600, 200, 30);
        add(c5);
        c6.setBounds(350, 600, 200, 30);
        add(c6);

        b1.setBounds(250, 720, 100, 30);
        add(b1);
        b2.setBounds(420, 720, 100, 30);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setSize(850, 850);
        setLocation(500, 120);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String atype = null;
        if (r1.isSelected()) {
            atype = "Saving Account";
        } else if (r2.isSelected()) {
            atype = "Fixed Deposit Account";
        } else if (r3.isSelected()) {
            atype = "Current Account";
        } else if (r4.isSelected()) {
            atype = "Recurring Deposit Account";
        }

        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
        String cardno = "" + Math.abs(first7);

        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);

        String facility = "";
        if (c1.isSelected()) {
            facility += " ATM Card";
        }
        if (c2.isSelected()) {
            facility += " Internet Banking";
        }
        if (c3.isSelected()) {
            facility += " Mobile Banking";
        }
        if (c4.isSelected()) {
            facility += " EMAIL Alerts";
        }
        if (c5.isSelected()) {
            facility += " Cheque Book";
        }
        if (c6.isSelected()) {
            facility += " E-Statement";
        }

        try {
            if (atype.equals("")) {
                JOptionPane.showMessageDialog(null, "Account Type is required.");
            } else {
                Conn c1 = new Conn();
                String query1 = "INSERT INTO signupthree (formno, accountType, cardnumber, pin, facility) VALUES ('" + formno + "', '" + atype + "', '" + cardno + "', '" + pin + "', '" + facility + "')";
                String query2 = "INSERT INTO login (formno, cardnumber, pin) VALUES ('" + formno + "', '" + cardno + "', '" + pin + "')";
                c1.s.executeUpdate(query1);
                c1.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n Pin:" + pin);

                new Deposit(pin).setVisible(true);
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignUpThree("").setVisible(true);
    }
}

package banking_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton loginButton, clearButton, signUpButton;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login() {
        setLayout(null);
        setTitle("Automated Teller Machine - Login");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel logoLabel = new JLabel(i3);
        logoLabel.setBounds(50, 10, 100, 100);
        add(logoLabel);
        
        JLabel welcomeText = new JLabel("Welcome to Your Bank ATM");
        welcomeText.setFont(new Font("Oswald", Font.BOLD, 36));
        welcomeText.setForeground(new Color(0, 102, 204));
        welcomeText.setBounds(180, 40, 600, 50);
        add(welcomeText);
        
        JLabel cardNoLabel = new JLabel("Card Number:");
        cardNoLabel.setFont(new Font("Raleway", Font.BOLD, 28));
        cardNoLabel.setForeground(new Color(34, 139, 34));
        cardNoLabel.setBounds(125, 150, 200, 30);
        add(cardNoLabel);
        
        cardTextField = new JTextField(16);
        cardTextField.setBounds(330, 151, 260, 30);
        cardTextField.setFont(new Font("Arial", Font.PLAIN, 18));
        cardTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        add(cardTextField);
        
        JLabel pinLabel = new JLabel("PIN:");
        pinLabel.setFont(new Font("Raleway", Font.BOLD, 28));
        pinLabel.setForeground(new Color(34, 139, 34));
        pinLabel.setBounds(125, 220, 200, 30);
        add(pinLabel);
        
        pinTextField = new JPasswordField(6);
        pinTextField.setBounds(330, 220, 260, 30);
        pinTextField.setFont(new Font("Arial", Font.PLAIN, 18));
        pinTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        add(pinTextField);
        
        loginButton = new JButton("SIGN IN");
        loginButton.setBackground(new Color(0, 51, 102));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setBounds(330, 300, 120, 35);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.addActionListener(this);
        add(loginButton);

        clearButton = new JButton("CLEAR");
        clearButton.setBackground(new Color(139, 0, 0));
        clearButton.setForeground(Color.WHITE);
        clearButton.setFont(new Font("Arial", Font.BOLD, 16));
        clearButton.setBounds(470, 300, 120, 35);
        clearButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        clearButton.addActionListener(this);
        add(clearButton);

        signUpButton = new JButton("SIGN UP");
        signUpButton.setBackground(new Color(0, 153, 76));
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setFont(new Font("Arial", Font.BOLD, 16));
        signUpButton.setBounds(330, 350, 260, 35);
        signUpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signUpButton.addActionListener(this);
        add(signUpButton);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(800, 500);
        setLocation(500, 200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ac) {
        if(ac.getSource() == clearButton) {
            cardTextField.setText("");
            pinTextField.setText("");
        } else if(ac.getSource() == loginButton) {
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "SELECT * FROM login WHERE cardnumber = ? AND pin = ?";
            try {
                PreparedStatement pstmt = conn.c.prepareStatement(query);
                pstmt.setString(1, cardnumber);
                pstmt.setString(2, pinnumber);
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()) {
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            } catch(Exception e) {
                System.out.println(e);
            }
        } else if(ac.getSource() == signUpButton) {
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}

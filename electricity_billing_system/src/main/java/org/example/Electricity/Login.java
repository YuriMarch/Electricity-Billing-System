package org.example.Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JLabel label1, label2, label3, label4;
    JTextField textfield;
    JPasswordField passwordfield;
    JButton button1, button2, button3;
    Choice choice;

    public Login() {
        super("Login Page");
        this.setLayout(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.label1 = new JLabel("Username");
        this.label1.setBounds(300, 20, 100, 20);
        this.add(this.label1);
        this.label2 = new JLabel("Password");
        this.label2.setBounds(300, 60, 100, 20);
        this.add(this.label2);
        this.textfield = new JTextField(15);
        this.textfield.setBounds(400, 20, 150, 20);
        this.add(this.textfield);
        this.passwordfield = new JPasswordField(15);
        this.passwordfield.setBounds(400, 60, 150, 20);
        this.add(this.passwordfield);
        this.label4 = new JLabel("Logging in as");
        this.label4.setBounds(300, 100, 100, 20);
        this.add(this.label4);
        this.choice = new Choice();
        this.choice.add("Admin");
        this.choice.add("Customer");
        this.choice.setBounds(400, 100, 150, 20);
        this.add(this.choice);
        ImageIcon ic1 = new ImageIcon("src/main/java/org/example/icon/login.png");
        Image i1 = ic1.getImage().getScaledInstance(16, 16, 1);
        this.button1 = new JButton("Login", new ImageIcon(i1));
        this.button1.setBounds(330, 160, 100, 20);
        this.add(this.button1);
        ImageIcon ic2 = new ImageIcon("src/main/java/org/example/icon/cancel.jpg");
        Image i2 = ic2.getImage().getScaledInstance(16, 16, 1);
        this.button2 = new JButton("Cancel", new ImageIcon(i2));
        this.button2.setBounds(450, 160, 100, 20);
        this.add(this.button2);
        ImageIcon ic4 = new ImageIcon("src/main/java/org/example/icon/signup.png");
        Image i4 = ic4.getImage().getScaledInstance(16, 16, 1);
        this.button3 = new JButton("Signup", new ImageIcon(i4));
        this.button3.setBounds(380, 200, 130, 20);
        this.add(this.button3);
        this.button1.addActionListener(this);
        this.button2.addActionListener(this);
        this.button3.addActionListener(this);
        ImageIcon ic3 = new ImageIcon("src/main/java/org/example/icon/second.jpg");
        Image i3 = ic3.getImage().getScaledInstance(250, 250, 1);
        ImageIcon icc3 = new ImageIcon(i3);
        this.label3 = new JLabel(icc3);
        this.label3.setBounds(0, 0, 250, 250);
        this.add(this.label3);
        this.setLayout(new BorderLayout());
        this.setSize(640, 300);
        this.setLocation(600, 300);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.button1) {
            try {
                Conn c = new Conn();
                String username = this.textfield.getText();
                String password = this.passwordfield.getText();
                String user = this.choice.getSelectedItem();
                String query = "select * from login where username = '" + username + "' and password = '" + password + "' and user = '" + user + "'";
                ResultSet resultSet = c.statement.executeQuery(query);
                if (resultSet.next()) {
                    String meter = resultSet.getString("meter_no");
                    (new Project(meter, user)).setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    this.textfield.setText("");
                    this.passwordfield.setText("");
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        } else if (ae.getSource() == this.button2) {
            this.setVisible(false);
        } else if (ae.getSource() == this.button3) {
            this.setVisible(false);
            (new Signup()).setVisible(true);
        }
    }

    public static void main(String[] args) {(new Login()).setVisible(true);}
}
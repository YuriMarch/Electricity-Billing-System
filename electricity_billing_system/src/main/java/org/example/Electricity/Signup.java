package org.example.Electricity;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Signup extends JFrame implements ActionListener {

    JPanel panel1;
    JTextField textfield1, textfield2, textfield3, textfield4;
    Choice choice;
    JButton button1, button2;

    Signup(){
        this.setBounds(600, 250, 700, 400);
        this.panel1 = new JPanel();
        this.panel1.setBounds(30, 30, 650, 300);
        this.setLayout(null);
        this.panel1.setBackground(Color.WHITE);
        this.panel1.setForeground(new Color(34, 139, 34));
        this.panel1.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 2), "Create Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(173, 216, 230)));
        this.add(this.panel1);

        JLabel label1 = new JLabel("Username");
        label1.setForeground(Color.DARK_GRAY);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        label1.setBounds(100, 50, 100, 20);
        this.panel1.add(label1);

        this.textfield1 = new JTextField(15);
        this.textfield1.setBounds(260, 50, 150, 200);
        this.panel1.add(this.textfield1);

        JLabel label2 = new JLabel("Name");
        label2.setForeground(Color.DARK_GRAY);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setBounds(100, 90, 100, 20);
        this.panel1.add(label2);

        this.textfield2 = new JTextField(15);
        this.textfield2.setBounds(260, 90, 150, 20);
        this.panel1.add(textfield2);

        JLabel label3 = new JLabel("Password");
        label3.setForeground(Color.DARK_GRAY);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setBounds(100, 130, 100, 20);
        this.panel1.add(label3);

        this.textfield3 = new JTextField(15);
        this.textfield3.setBounds(260, 130, 150, 20);
        this.panel1.add(this.textfield3);

        JLabel label4 = new JLabel("Create account as");
        label4.setForeground(Color.DARK_GRAY);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setBounds(100, 170, 140, 20);
        this.panel1.add(label4);

        final JLabel label5 = new JLabel("Meter Number");
        label5.setForeground(Color.DARK_GRAY);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        label5.setBounds(100, 210, 100, 20);
        label5.setVisible(false);
        this.panel1.add(label5);

        this.textfield4 = new JTextField(15);
        this.textfield4.setBounds(260, 210, 150, 20);
        this.textfield4.setVisible(false);
        this.panel1.add(this.textfield4);

        this.choice = new Choice();
        this.choice.add("Admin");
        this.choice.add("Customer");
        this.choice.setBounds(260, 170, 150, 20);
        this.panel1.add(this.choice);
        this.choice.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent itemEvent){
                String userType = choice.getSelectedItem();
                if (userType.equals("Customer")){
                    label5.setVisible(true);
                    textfield4.setVisible(true);
                } else {
                    label5.setVisible(false);
                    textfield4.setVisible(false);
                }
            }
        });

        this.button1 = new JButton("Create");
        this.button1.setBackground(Color.WHITE);
        this.button1.setForeground(Color.BLACK);
        this.button1.setBounds(140, 290, 120, 30);
        this.button1.addActionListener(this);
        this.panel1.add(this.button1);

        this.button2 = new JButton("Back");
        this.button2.setBackground(Color.WHITE);
        this.button2.setForeground(Color.BLACK);
        this.button2.setBounds(300, 290, 120, 30);
        this.button2.addActionListener(this);
        this.panel1.add(this.button2);

        ImageIcon signupIcon = new ImageIcon("src/main/java/org/example/icon/signupImage.png");
        Image signupImage = signupIcon.getImage().getScaledInstance(150, 150, 1);
        ImageIcon signupIcon1 = new ImageIcon(signupImage);

        JLabel label6 = new JLabel(signupIcon1);
        label6.setBounds(450, 450, 250, 250);
        this.panel1.add(label6);
    }

    public void actionPerformed(ActionEvent actionEvent){
        if (actionEvent.getSource() == this.button1) {
            String username = this.textfield1.getText();
            String name = this.textfield2.getText();
            String password = this.textfield3.getText();
            String userType = this.choice.getSelectedItem();
            String meterNumber = this.textfield4.getText();

            try{
                Conn connection = new Conn();
                String query;
                if(userType.equals("Admin")){
                    query = "insert into login values('" + meterNumber + "', '" + username + "', '" + name + "', '" + password + "', '" + userType + "')";
                } else {
                    query = "update login set username = '" + username + "', name = '" + name + "', password = '" + password + "', user = '" + userType + "' where meter_no = '" + this.textfield4.getText() + "'";
                }

                connection.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Account created successfully");
                this.setVisible(false);
                (new Login()).setVisible(true);
            } catch (Exception exception){
                JOptionPane.showMessageDialog(null, "Error creating account");
                System.out.println("Error: " + exception);
            }
        } else if(actionEvent.getSource() == this.button2){
            this.setVisible(false);
            (new Login()).setVisible(true);
        }
    }

    public static void main(String[] args) {
        (new Signup()).setVisible(true);
    }
}

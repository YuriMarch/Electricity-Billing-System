package org.example.Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewInformation extends JFrame implements ActionListener {
    JButton button;

    ViewInformation(String meter) {
        this.setBounds(600, 250, 850, 650);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(null);
        JLabel title = new JLabel("VIEW CUSTOMER INFORMATION");
        title.setBounds(250, 0, 500, 40);
        title.setFont(new Font("Tahoma", Font.PLAIN, 20));
        this.add(title);

        JLabel label1 = new JLabel("Name");
        label1.setBounds(70, 80, 100, 20);
        this.add(label1);

        JLabel label11 = new JLabel();
        label11.setBounds(250, 80, 100, 20);
        this.add(label11);

        JLabel label2 = new JLabel("Meter Number");
        label2.setBounds(70, 140, 100, 20);
        this.add(label2);

        JLabel label12 = new JLabel();
        label12.setBounds(250, 140, 100, 20);
        this.add(label12);

        JLabel label3 = new JLabel("Address");
        label3.setBounds(70, 200, 100, 20);
        this.add(label3);

        JLabel label13 = new JLabel();
        label13.setBounds(250, 200, 100, 20);
        this.add(label13);

        JLabel label4 = new JLabel("City");
        label4.setBounds(70, 260, 100, 20);
        this.add(label4);

        JLabel label14 = new JLabel();
        label14.setBounds(250, 260, 100, 20);
        this.add(label14);

        JLabel label5 = new JLabel("State");
        label5.setBounds(500, 80, 100, 20);
        this.add(label5);

        JLabel label15 = new JLabel();
        label15.setBounds(650, 80, 100, 20);
        this.add(label15);

        JLabel label6 = new JLabel("Email");
        label6.setBounds(500, 140, 100, 20);
        this.add(label6);

        JLabel label16 = new JLabel();
        label16.setBounds(650, 140, 150, 20);
        this.add(label16);

        JLabel label7 = new JLabel("Phone");
        label7.setBounds(500, 200, 100, 20);
        this.add(label7);

        JLabel label17 = new JLabel();
        label17.setBounds(650, 200, 100, 20);
        this.add(label17);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from customer where meter = '" + meter + "'");

            while(resultSet.next()) {
                label11.setText(resultSet.getString(1));
                label12.setText(resultSet.getString(2));
                label13.setText(resultSet.getString(3));
                label14.setText(resultSet.getString(4));
                label15.setText(resultSet.getString(5));
                label16.setText(resultSet.getString(6));
                label17.setText(resultSet.getString(7));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        this.button = new JButton("Back");
        this.button.setBackground(Color.WHITE);
        this.button.setForeground(Color.BLACK);
        this.button.setBounds(350, 340, 100, 25);
        this.button.addActionListener(this);
        this.add(this.button);
        ImageIcon i1 = new ImageIcon("src/main/java/org/example/icon/viewcustomer.jpg");
        Image i2 = i1.getImage().getScaledInstance(600, 300, 1);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label8 = new JLabel(i3);
        label8.setBounds(20, 350, 600, 300);
        this.add(label8);
    }

    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);
    }

    public static void main(String[] args) {
        (new ViewInformation("")).setVisible(true);
    }
}
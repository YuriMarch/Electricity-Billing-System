package org.example.Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateInformation extends JFrame implements ActionListener {
    JTextField textField1, textField2, textField3, textField4, textField5;
    JLabel label1, label2;
    JButton button1, button2;
    String meter;

    UpdateInformation(String meter) {
        this.meter = meter;
        this.setBounds(500, 220, 1050, 450);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.WHITE);
        JLabel title = new JLabel("UPDATE CUSTOMER INFORMATION");
        title.setBounds(110, 0, 400, 30);
        title.setFont(new Font("Tahoma", Font.PLAIN, 20));
        this.add(title);

        JLabel l1 = new JLabel("Name");
        l1.setBounds(30, 70, 100, 20);
        this.add(l1);
        this.label1 = new JLabel();
        this.label1.setBounds(230, 70, 200, 20);
        this.add(this.label1);

        JLabel l2 = new JLabel("Meter Number");
        l2.setBounds(30, 110, 100, 20);
        this.add(l2);
        this.label2 = new JLabel();
        this.label2.setBounds(230, 110, 200, 20);
        this.add(this.label2);

        JLabel l3 = new JLabel("Address");
        l3.setBounds(30, 150, 100, 20);
        this.add(l3);
        this.textField1 = new JTextField();
        this.textField1.setBounds(230, 150, 200, 20);
        this.add(this.textField1);

        JLabel l4 = new JLabel("City");
        l4.setBounds(30, 190, 100, 20);
        this.add(l4);
        this.textField2 = new JTextField();
        this.textField2.setBounds(230, 190, 200, 20);
        this.add(this.textField2);

        JLabel l5 = new JLabel("State");
        l5.setBounds(30, 230, 100, 20);
        this.add(l5);
        this.textField3 = new JTextField();
        this.textField3.setBounds(230, 230, 200, 20);
        this.add(this.textField3);

        JLabel l6 = new JLabel("Email");
        l6.setBounds(30, 270, 100, 20);
        this.add(l6);
        this.textField4 = new JTextField();
        this.textField4.setBounds(230, 270, 200, 20);
        this.add(this.textField4);

        JLabel l7 = new JLabel("Phone");
        l7.setBounds(30, 310, 100, 20);
        this.add(l7);
        this.textField5 = new JTextField();
        this.textField5.setBounds(230, 310, 200, 20);
        this.add(this.textField5);

        this.button1 = new JButton("Update");
        this.button1.setBackground(Color.WHITE);
        this.button1.setForeground(Color.BLACK);
        this.button1.setBounds(70, 360, 100, 25);
        this.button1.addActionListener(this);
        this.add(this.button1);

        this.button2 = new JButton("Back");
        this.button2.setBackground(Color.WHITE);
        this.button2.setForeground(Color.BLACK);
        this.button2.setBounds(230, 360, 100, 25);
        this.button2.addActionListener(this);
        this.add(this.button2);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from customer where meter = '" + meter + "'");

            while(resultSet.next()) {
                this.label1.setText(resultSet.getString(1));
                this.label2.setText(resultSet.getString(2));
                this.textField1.setText(resultSet.getString(3));
                this.textField2.setText(resultSet.getString(4));
                this.textField3.setText(resultSet.getString(5));
                this.textField4.setText(resultSet.getString(6));
                this.textField5.setText(resultSet.getString(7));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        ImageIcon i1 = new ImageIcon("src/main/java/org/example/icon/update.jpg");
        Image i2 = i1.getImage().getScaledInstance(400, 300, 1);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label8 = new JLabel(i3);
        label8.setBounds(550, 50, 400, 300);
        this.add(label8);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.button1) {
            String address = this.textField1.getText();
            String city = this.textField2.getText();
            String state = this.textField3.getText();
            String email = this.textField4.getText();
            String phone = this.textField5.getText();

            try {
                Conn c = new Conn();
                c.statement.executeUpdate("update customer set address = '" + address + "', city = '" + city + "', state = '" + state + "', email = '" + email + "', phone = '" + phone + "' where meter = '" + this.meter + "'");
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
                this.setVisible(false);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        } else if (actionEvent.getSource() == this.button2) {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        (new UpdateInformation("")).setVisible(true);
    }
}
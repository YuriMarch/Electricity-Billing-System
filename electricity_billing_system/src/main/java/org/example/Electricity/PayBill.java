package org.example.Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class PayBill extends JFrame implements ActionListener {
    JLabel label1, label2, label3, label4, label5, label6, label11, label12, label13, label14, label15;
    Choice choice;
    JButton button1, button2;

    String meter;

    PayBill(final String meter) {
        this.meter = meter;
        this.setLayout(null);
        this.setBounds(550, 220, 900, 600);
        JLabel title = new JLabel("Electricity Bill");
        title.setFont(new Font("Tahoma", Font.BOLD, 24));
        title.setBounds(120, 5, 400, 30);
        this.add(title);
        this.label1 = new JLabel("Meter No");
        this.label1.setBounds(35, 80, 200, 20);
        this.add(this.label1);

        this.label11 = new JLabel();
        this.label11.setBounds(300, 80, 200, 20);
        this.add(this.label11);
        this.label2 = new JLabel("Name");
        this.label2.setBounds(35, 140, 200, 20);
        this.add(this.label2);

        this.label12 = new JLabel();
        this.label12.setBounds(300, 140, 200, 20);
        this.add(this.label12);

        this.label3 = new JLabel("Month");
        this.label3.setBounds(35, 200, 200, 20);
        this.add(this.label3);

        this.choice = new Choice();
        this.choice.setBounds(300, 200, 200, 20);
        this.choice.add("January");
        this.choice.add("February");
        this.choice.add("March");
        this.choice.add("April");
        this.choice.add("May");
        this.choice.add("June");
        this.choice.add("July");
        this.choice.add("August");
        this.choice.add("September");
        this.choice.add("October");
        this.choice.add("November");
        this.choice.add("December");
        this.add(this.choice);

        this.label4 = new JLabel("Units");
        this.label4.setBounds(35, 260, 200, 20);
        this.add(this.label4);

        this.label13 = new JLabel();
        this.label13.setBounds(300, 260, 200, 20);
        this.add(this.label13);

        this.label5 = new JLabel("Total Bill");
        this.label5.setBounds(35, 320, 200, 20);
        this.add(this.label5);

        this.label14 = new JLabel();
        this.label14.setBounds(300, 320, 200, 20);
        this.add(this.label14);

        this.label6 = new JLabel("Status");
        this.label6.setBounds(35, 380, 200, 20);
        this.add(this.label6);

        this.label15 = new JLabel();
        this.label15.setBounds(300, 380, 200, 20);
        this.label15.setForeground(Color.RED);
        this.add(this.label15);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from customer where meter = '" + meter + "'");

            while(resultSet.next()) {
                label11.setText(resultSet.getString("meter"));
                label12.setText(resultSet.getString("name"));
            }

            resultSet = c.statement.executeQuery("select * from bill where meter = '" + meter + "' AND month = 'January' ");

            while(resultSet.next()) {
                label13.setText(resultSet.getString("units"));
                label14.setText(resultSet.getString("total_bill"));
                label15.setText(resultSet.getString("status"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        this.choice.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ae) {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.statement.executeQuery("select * from bill where meter = '" + meter + "' AND month = '" + PayBill.this.choice.getSelectedItem() + "'");

                    while(rs.next()) {
                        label13.setText(rs.getString("units"));
                        label14.setText(rs.getString("total_bill"));
                        label15.setText(rs.getString("status"));
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        this.button1 = new JButton("Pay");
        this.button1.setBounds(100, 460, 100, 25);
        this.add(this.button1);

        this.button2 = new JButton("Back");
        this.button2.setBounds(230, 460, 100, 25);
        this.add(this.button2);

        this.button1.setBackground(Color.WHITE);
        this.button1.setForeground(Color.BLACK);
        this.button2.setBackground(Color.WHITE);
        this.button2.setForeground(Color.BLACK);

        ImageIcon i1 = new ImageIcon("src/main/java/org/example/icon/bill.png");
        Image i2 = i1.getImage().getScaledInstance(600, 300, 1);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label21 = new JLabel(i3);
        label21.setBounds(400, 120, 600, 300);
        this.add(label21);

        this.button1.addActionListener(this);
        this.button2.addActionListener(this);
        this.getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.button1) {
            try {
                Conn c = new Conn();
                c.statement.executeUpdate("update bill set status = 'Paid' where meter = '" + this.meter + "' AND month = '" + this.choice.getSelectedItem() + "'");
                JOptionPane.showMessageDialog(null, "Bill successfully paid");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            this.setVisible(false);
            (new Paytm(this.meter)).setVisible(true);
        } else if (actionEvent.getSource() == this.button2) {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        (new PayBill("")).setVisible(true);
    }
}
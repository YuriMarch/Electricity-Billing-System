package org.example.Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class CalculateBill extends JFrame  implements ActionListener {
    JLabel label1, label2, label3, label4, label5;
    JTextField textField3;
    Choice choice1, choice2;
    JButton button1, button2;
    JPanel panel = new JPanel();
    CalculateBill() {
        this.panel.setLayout(null);
        this.panel.setBackground(new Color(173, 216, 230));

        this.label1 = new JLabel("Calculate Electricity Bill");
        this.label1.setBounds(30, 10, 400, 30);

        this.label2 = new JLabel("Meter No");
        this.label2.setBounds(60, 70, 100, 30);

        JLabel label6 = new JLabel("Name");
        label6.setBounds(60, 120, 100, 30);

        JLabel label7 = new JLabel("Address");
        label7.setBounds(60, 170, 100, 30);

        this.label3 = new JLabel("Units Used");
        this.label3.setBounds(60, 220, 100, 30);

        this.label5 = new JLabel("Month");
        this.label5.setBounds(60, 270, 100, 30);

        this.choice1 = new Choice();
        this.choice1.setBounds(200, 70, 180, 20);

        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("select * from customer");

            while(rs.next()) {
                this.choice1.add(rs.getString("meter"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        final JLabel l11 = new JLabel();
        l11.setBounds(210, 120, 180, 30);
        this.panel.add(l11);
        final JLabel l12 = new JLabel();
        l12.setBounds(210, 170, 180, 30);
        this.panel.add(l12);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from customer where meter = '" + this.choice1.getSelectedItem() + "'");

            while(resultSet.next()) {
                l11.setText(resultSet.getString("name"));
                l12.setText(resultSet.getString("address"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        this.choice1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ae) {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.statement.executeQuery("select * from customer where meter = '" + CalculateBill.this.choice1.getSelectedItem() + "'");

                    while(rs.next()) {
                        l11.setText(rs.getString("name"));
                        l12.setText(rs.getString("address"));
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        this.textField3 = new JTextField();
        this.textField3.setBounds(200, 220, 180, 30);

        this.choice2 = new Choice();
        this.choice2.setBounds(200, 270, 180, 20);
        this.choice2.add("January");
        this.choice2.add("February");
        this.choice2.add("March");
        this.choice2.add("April");
        this.choice2.add("May");
        this.choice2.add("June");
        this.choice2.add("July");
        this.choice2.add("August");
        this.choice2.add("September");
        this.choice2.add("October");
        this.choice2.add("November");
        this.choice2.add("December");

        this.button1 = new JButton("Submit");
        this.button1.setBounds(100, 350, 100, 25);
        this.button2 = new JButton("Cancel");
        this.button2.setBounds(230, 350, 100, 25);

        this.button1.setBackground(Color.WHITE);
        this.button1.setForeground(Color.BLACK);
        this.button2.setBackground(Color.WHITE);
        this.button2.setForeground(Color.BLACK);

        ImageIcon i1 = new ImageIcon("src/main/java/org/example/icon/hicon2.jpg");
        Image i2 = i1.getImage().getScaledInstance(180, 270, 1);
        ImageIcon i3 = new ImageIcon(i2);
        this.label4 = new JLabel(i3);
        this.label1.setFont(new Font("Sanserif", Font.PLAIN, 26));
        this.label1.setHorizontalAlignment(0);

        this.panel.add(this.label1);
        this.panel.add(this.label2);
        this.panel.add(label6);
        this.panel.add(label7);
        this.panel.add(this.choice1);
        this.panel.add(this.label5);
        this.panel.add(this.choice2);
        this.panel.add(this.label3);
        this.panel.add(this.textField3);
        this.panel.add(this.button1);
        this.panel.add(this.button2);

        this.setLayout(new BorderLayout(30, 30));

        this.add(this.panel, "Center");
        this.add(this.label4, "West");

        this.button1.addActionListener(this);
        this.button2.addActionListener(this);

        this.getContentPane().setBackground(Color.WHITE);
        this.setSize(750, 500);
        this.setLocation(550, 220);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.button1) {
            String meterNumber = this.choice1.getSelectedItem();
            String units = this.textField3.getText();
            String month = this.choice2.getSelectedItem();
            int unitsConsumed = Integer.parseInt(units);
            int totalBill = 0;

            try {
                Conn c = new Conn();

                for(ResultSet resultSet = c.statement.executeQuery("select * from tax"); resultSet.next(); totalBill += Integer.parseInt(resultSet.getString("fixed_tax"))) {
                    totalBill = unitsConsumed * Integer.parseInt(resultSet.getString("cost_per_unit"));
                    totalBill += Integer.parseInt(resultSet.getString("meter_rent"));
                    totalBill += Integer.parseInt(resultSet.getString("service_charge"));
                    totalBill += Integer.parseInt(resultSet.getString("service_tax"));
                    totalBill += Integer.parseInt(resultSet.getString("swacch_bharat_cess"));
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }

            String query = "insert into bill values('" + meterNumber + "','" + month + "','" + units + "','" + totalBill + "', 'Not Paid')";

            try {
                Conn c1 = new Conn();
                c1.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
                this.setVisible(false);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        } else if (actionEvent.getSource() == this.button2) {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        (new CalculateBill()).setVisible(true);
    }
}
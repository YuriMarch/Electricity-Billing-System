package org.example.Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class DepositDetails extends JFrame implements ActionListener {

    JTable table1;
    JButton button1, button2;
    JLabel label1, label2;
    Choice choice1, choice2;
    String[] x = new String[]{"Meter Number", "Month", "Units", "Total Bill", "Status"};
    String[][] y = new String[40][8];

    DepositDetails() {
        super("Deposit Details");
        this.setSize(700, 750);
        this.setLocation(600, 150);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.label1 = new JLabel("Sort by Meter Number");
        this.label1.setBounds(20, 20, 150, 20);
        this.add(this.label1);

        this.choice1 = new Choice();
        this.label2 = new JLabel("Sort By Month");
        this.label2.setBounds(400, 20, 100, 20);
        this.add(this.label2);
        this.choice2 = new Choice();
        this.table1 = new JTable(this.y, this.x);

        try {
            Conn c = new Conn();
            String query1 = "select * from bill";
            ResultSet resultSet = c.statement.executeQuery(query1);
            this.table1.setModel(DbUtils.resultSetToTableModel(resultSet));
            String query2 = "select * from customer";
            resultSet = c.statement.executeQuery(query2);

            while(resultSet.next()) {
                this.choice1.add(resultSet.getString("meter"));
            }
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        this.choice1.setBounds(180, 20, 150, 20);
        this.add(this.choice1);
        this.choice2.setBounds(520, 20, 150, 20);
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
        this.add(this.choice2);

        this.button1 = new JButton("Search");
        this.button1.setBounds(20, 70, 80, 20);
        this.button1.addActionListener(this);
        this.add(this.button1);
        this.button2 = new JButton("Print");
        this.button2.setBounds(120, 70, 80, 20);
        this.button2.addActionListener(this);
        this.add(this.button2);

        JScrollPane scrollPane = new JScrollPane(this.table1);
        scrollPane.setBounds(0, 100, 700, 650);
        this.add(scrollPane);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.button1) {
            String query3 = "select * from bill where meter = '" + this.choice1.getSelectedItem() + "' AND month = '" + this.choice2.getSelectedItem() + "'";

            try {
                Conn c = new Conn();
                ResultSet resultSet2 = c.statement.executeQuery(query3);
                this.table1.setModel(DbUtils.resultSetToTableModel(resultSet2));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        } else if (actionEvent.getSource() == this.button2) {
            try {
                this.table1.print();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        (new DepositDetails()).setVisible(true);
    }
}
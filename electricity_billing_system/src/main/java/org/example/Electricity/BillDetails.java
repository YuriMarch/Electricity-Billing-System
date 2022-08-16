package org.example.Electricity;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class BillDetails extends JFrame {
    JTable table;
    String[] x = new String[]{"Meter Number", "Month", "Units", "Total Bill", "Status"};
    String[][] y = new String[40][8];

    BillDetails(String meter) {
        super("Bill Details");
        this.setSize(700, 650);
        this.setLocation(600, 150);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.table = new JTable(this.y, this.x);

        try {
            Conn c = new Conn();
            String query = "select * from bill where meter = " + meter;
            ResultSet resultSet = c.statement.executeQuery(query);
            this.table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(this.table);
        scrollPane.setBounds(0, 0, 700, 650);
        this.add(scrollPane);
    }

    public static void main(String[] args) {
        (new BillDetails("")).setVisible(true);
    }
}
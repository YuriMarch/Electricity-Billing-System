package org.example.Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class GenerateBill extends JFrame implements ActionListener {
    JLabel label1, label2;
    JTextArea textArea;
    JButton button;
    Choice choice;
    JPanel panel;
    String meter;

    GenerateBill(String meter) {
        this.meter = meter;
        this.setSize(500, 900);
        this.setLayout(new BorderLayout());
        this.panel = new JPanel();
        this.label1 = new JLabel("Generate Bill");
        this.label2 = new JLabel(meter);
        this.choice = new Choice();
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

        this.textArea = new JTextArea(50, 15);
        this.textArea.setText("\n\n\t------- Click on the -------\n\t Generate Bill Button to get\n\tthe bill of the Selected Month\n\n");
        JScrollPane scrollPane = new JScrollPane(this.textArea);
        this.textArea.setFont(new Font("Sanserif", Font.ITALIC, 18));

        this.button = new JButton("Generate Bill");
        this.panel.add(this.label1);
        this.panel.add(this.label2);
        this.panel.add(this.choice);
        this.add(this.panel, "North");
        this.add(scrollPane, "Center");
        this.add(this.button, "South");

        this.button.addActionListener(this);
        this.setLocation(750, 100);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        try {
            Conn c = new Conn();
            String month = this.choice.getSelectedItem();
            this.textArea.setText("\tReliance Power Limited\nELECTRICITY BILL FOR THE MONTH OF " + month + " ,2022\n\n\n");
            ResultSet resultSet = c.statement.executeQuery("select * from customer where meter=" + this.meter);
            if (resultSet.next()) {
                this.textArea.append("\n    Customer Name: " + resultSet.getString("name"));
                this.textArea.append("\n    Meter Number:   " + resultSet.getString("meter"));
                this.textArea.append("\n    Address:            " + resultSet.getString("address"));
                this.textArea.append("\n    State:                " + resultSet.getString("state"));
                this.textArea.append("\n    City:                  " + resultSet.getString("city"));
                this.textArea.append("\n    Email:                " + resultSet.getString("email"));
                this.textArea.append("\n    Phone Number:  " + resultSet.getString("phone"));
                this.textArea.append("\n-------------------------------------------------------------");
                this.textArea.append("\n");
            }

            resultSet = c.statement.executeQuery("select * from meter_info where meter_number = " + this.meter);
            if (resultSet.next()) {
                this.textArea.append("\n    Meter Location: " + resultSet.getString("meter_location"));
                this.textArea.append("\n    Meter Type:      " + resultSet.getString("meter_type"));
                this.textArea.append("\n    Phase Code:      " + resultSet.getString("phase_code"));
                this.textArea.append("\n    Bill Type:          " + resultSet.getString("bill_type"));
                this.textArea.append("\n    Days:               " + resultSet.getString("days"));
                this.textArea.append("\n");
            }

            resultSet = c.statement.executeQuery("select * from tax");
            if (resultSet.next()) {
                this.textArea.append("---------------------------------------------------------------");
                this.textArea.append("\n\n");
                this.textArea.append("\n Cost per Unit:              $ " + resultSet.getString("cost_per_unit"));
                this.textArea.append("\n Meter Rent:                 $ " + resultSet.getString("meter_rent"));
                this.textArea.append("\n Service Charge:            $ " + resultSet.getString("service_charge"));
                this.textArea.append("\n Service Tax:                $ " + resultSet.getString("service_tax"));
                this.textArea.append("\n Swacch Bharat Cess:     $ " + resultSet.getString("swacch_bharat_cess"));
                this.textArea.append("\n Fixed Tax:                   $ " + resultSet.getString("fixed_tax"));
                this.textArea.append("\n");
            }

            resultSet = c.statement.executeQuery("select * from bill where meter=" + this.meter + " AND month = '" + this.choice.getSelectedItem() + "'");
            if (resultSet.next()) {
                this.textArea.append("\n    Current Month :\t" + resultSet.getString("month"));
                this.textArea.append("\n    Units Consumed:\t" + resultSet.getString("units"));
                this.textArea.append("\n    Total Charges :\t" + resultSet.getString("total_bill"));
                this.textArea.append("\n---------------------------------------------------------------");
                this.textArea.append("\n    TOTAL PAYABLE :\t" + resultSet.getString("total_bill"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        (new GenerateBill("")).setVisible(true);
    }
}
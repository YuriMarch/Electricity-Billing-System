package org.example.Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class LastBill extends JFrame implements ActionListener {
    JLabel label1;
    JTextArea textArea1, textArea2;
    JButton button;
    JPanel panel;

    LastBill() {
        this.setSize(500, 900);
        this.setLayout(new BorderLayout());
        this.panel = new JPanel();
        this.label1 = new JLabel("Generate Bill");
        this.textArea2 = new JTextArea();
        this.textArea1 = new JTextArea(50, 15);
        JScrollPane scrollPane = new JScrollPane(this.textArea1);
        this.textArea1.setFont(new Font("Sanserif", Font.ITALIC, 18));
        this.button = new JButton("Generate Bill");
        this.panel.add(this.label1);
        this.panel.add(this.textArea2);
        this.add(this.panel, "North");
        this.add(scrollPane, "Center");
        this.add(this.button, "South");
        this.button.addActionListener(this);
        this.setLocation(350, 40);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from customer where meter=" + this.textArea2.getSelectedText());
            if (resultSet.next()) {
                this.textArea1.append("\n    Customer Name:" + resultSet.getString("name"));
                this.textArea1.append("\n    Meter Number:  " + resultSet.getString("meter"));
                this.textArea1.append("\n    Address:            " + resultSet.getString("address"));
                this.textArea1.append("\n    State:                 " + resultSet.getString("state"));
                this.textArea1.append("\n    City:                   " + resultSet.getString("city"));
                this.textArea1.append("\n    Email:                " + resultSet.getString("email"));
                this.textArea1.append("\n    Phone Number  " + resultSet.getString("phone"));
                this.textArea1.append("\n-------------------------------------------------------------");
                this.textArea1.append("\n");
            }

            this.textArea1.append("Details of the Last Bills\n\n\n");
            resultSet = c.statement.executeQuery("select * from bill where meter=" + this.textArea2.getSelectedText());

            while(resultSet.next()) {
                this.textArea1.append("       " + resultSet.getString("month") + "           " + resultSet.getString("amount") + "\n");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        (new LastBill()).setVisible(true);
    }
}
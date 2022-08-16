package org.example.Electricity;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerDetails extends JFrame implements ActionListener {
    JTable table1;
    JButton button1;
    String[] x = new String[]{"Customer Name", "Meter Number", "Address", "City", "State", "Email", "Phone"};
    String[][] y = new String[40][8];
    int i = 0;
    int j = 0;

    CustomerDetails() {
        super("Customer Details");
        this.setSize(1200, 650);
        this.setLocation(400, 150);

        try {
            Conn c1 = new Conn();
            String s1 = "select * from customer";

            for(ResultSet rs = c1.statement.executeQuery(s1); rs.next(); this.j = 0) {
                this.y[this.i][this.j++] = rs.getString("name");
                this.y[this.i][this.j++] = rs.getString("meter");
                this.y[this.i][this.j++] = rs.getString("address");
                this.y[this.i][this.j++] = rs.getString("city");
                this.y[this.i][this.j++] = rs.getString("state");
                this.y[this.i][this.j++] = rs.getString("email");
                this.y[this.i][this.j++] = rs.getString("phone");
                ++this.i;
            }

            this.table1 = new JTable(this.y, this.x);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        this.button1 = new JButton("Print");
        this.add(this.button1, "South");
        JScrollPane sp = new JScrollPane(this.table1);
        this.add(sp);
        this.button1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        try {
            this.table1.print();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        (new CustomerDetails()).setVisible(true);
    }
}
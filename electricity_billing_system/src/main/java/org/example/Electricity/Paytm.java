package org.example.Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Paytm extends JFrame implements ActionListener {
    String meter;
    JButton button;
    JLabel label1, label11;

    Paytm(String meter) {
        super("Bill Payment Confirmation");
        this.meter = meter;
        this.setBounds(600, 250, 850, 650);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(null);

        this.label1 = new JLabel("Meter Number: ");
        this.label1.setBounds(70, 80, 100, 20);
        this.add(label1);

        this.label11 = new JLabel(this.meter);
        this.label11.setBounds(170, 80, 100, 20);
        this.add(label11);

        this.button = new JButton("Back");
        this.button.setBackground(Color.WHITE);
        this.button.setForeground(Color.BLACK);
        this.button.setBounds(100, 120, 120, 25);
        this.button.addActionListener(this);
        this.add(this.button);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        this.setVisible(false);
        (new PayBill(this.meter)).setVisible(true);
    }

    public static void main(String[] args) {
        (new Paytm("")).setVisible(true);
    }
}
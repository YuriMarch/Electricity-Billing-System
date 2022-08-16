package org.example.Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends JFrame implements ActionListener {

    JButton button1;
    JLabel label1;
    Font font, font1, font2;
    TextArea textArea1;
    String aboutString;

    public About(){
        setLayout(null);
        button1 = new JButton("Exit");
        add(button1);
        button1.setBounds(180, 430, 120, 20);
        button1.addActionListener(this);

        font = new Font("RALE WAY", Font.BOLD, 12);
        setFont(font);

        aboutString = "                              About Project                      \n   "
                    + "\nElectricity Billing system is a software-based application "
                    + "\ndeveloped in Java. This project aims at serving as a platform "
                    + "\nto computerize the process of billing of electricity bills. "
                    + "\nIt is focused on the calculation of Units consumed during the "
                    + "\nspecified time and the amount to be paid. The application aims "
                    + "\nto simplify the billing process, while being accessible to all.\n\n";

        textArea1 = new TextArea(aboutString, 10, 40, Scrollbar.VERTICAL);
        textArea1.setEditable(false);
        textArea1.setBounds(20, 100, 450, 300);

        add(textArea1);

        font1 = new Font("RALE WAY", Font.BOLD, 16);
        textArea1.setFont(font1);

        textArea1 = new TextArea();

        label1 = new JLabel("About Project");
        add(label1);
        label1.setBounds(170,10,180,80);
        label1.setForeground(Color.RED);

        font2 = new Font("RALE WAY", Font.BOLD, 20);
        label1.setFont(font2);

        setBounds(700, 220, 500, 550);

        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent actionEvent){
        dispose();
    }

    public static void main(String[] args) {
        new About().setVisible(true);
    }
}
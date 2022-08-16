package org.example.Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NewCustomer extends JFrame implements ActionListener {
    JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9;
    JTextField textfield1, textfield3, textfield4, textfield5, textfield6, textfield7;
    JButton button1, button2;

    NewCustomer(){
        this.setLocation(600, 200);
        this.setSize(700, 500);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        panel.setBackground(new Color(173, 216, 230));
        JLabel title = new JLabel("New Customer");
        title.setBounds(180, 10, 200, 26);
        title.setFont(new Font("Tahoma", Font.PLAIN, 24));
        panel.add(title);

        this.label1 = new JLabel("Customer Name");
        this.label1.setBounds(100, 80, 100, 20);
        this.textfield1 = new JTextField();
        this.textfield1.setBounds(240, 80, 200, 20);
        panel.add(this.label1);
        panel.add(this.textfield1);

        this.label2 = new JLabel("Meter No");
        this.label2.setBounds(100, 120, 100, 20);
        this.label9 = new JLabel();
        this.label9.setBounds(240, 120, 200, 20);
        panel.add(this.label2);
        panel.add(this.label9);

        this.label3 = new JLabel("Address");
        this.label3.setBounds(100, 160, 100, 20);
        this.textfield3 = new JTextField();
        this.textfield3.setBounds(240, 160, 200, 20);
        panel.add(this.label3);
        panel.add(this.textfield3);

        this.label5 = new JLabel("City");
        this.label5.setBounds(100, 200, 100, 20);
        this.textfield5 = new JTextField();
        this.textfield5.setBounds(240, 200, 200, 20);
        panel.add(this.label5);
        panel.add(this.textfield5);

        this.label4 = new JLabel("State");
        this.label4.setBounds(100, 240, 100, 20);
        this.textfield4 = new JTextField();
        this.textfield4.setBounds(240, 240, 200, 20);
        panel.add(this.label4);
        panel.add(this.textfield4);

        this.label6 = new JLabel("Email");
        this.label6.setBounds(100, 280, 100, 20);
        this.textfield6 = new JTextField();
        this.textfield6.setBounds(240, 280, 200, 20);
        panel.add(this.label6);
        panel.add(this.textfield6);

        this.label7 = new JLabel("Phone Number");
        this.label7.setBounds(100, 320, 100, 20);
        this.textfield7 = new JTextField();
        this.textfield7.setBounds(240, 320, 200, 20);
        panel.add(this.label7);
        panel.add(this.textfield7);

        this.button1 = new JButton("Next");
        this.button1.setBounds(120, 390, 100, 25);
        this.button2 = new JButton("Cancel");
        this.button2.setBounds(250, 390, 100, 25);
        this.button1.setBackground(Color.WHITE);
        this.button1.setForeground(Color.BLACK);
        this.button2.setBackground(Color.WHITE);
        this.button2.setForeground(Color.BLACK);
        panel.add(this.button1);
        panel.add(this.button2);
        this.setLayout(new BorderLayout());
        this.add(panel, "Center");

        ImageIcon ic1 = new ImageIcon("src/main/java/org/example/icon/hicon1.jpg");
        Image i3 = ic1.getImage().getScaledInstance(150, 300, 1);
        ImageIcon ic2 = new ImageIcon(i3);
        this.label8 = new JLabel(ic2);
        this.add(this.label8, "West");
        this.getContentPane().setBackground(Color.WHITE);
        this.button1.addActionListener(this);
        this.button2.addActionListener(this);

        Random randomNumber = new Random();
        long first = randomNumber.nextLong() % 1000000L;
        this.label9.setText("" + Math.abs(first));
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.button1) {
            String name = this.textfield1.getText();
            String meter = this.label9.getText();
            String address = this.textfield3.getText();
            String state = this.textfield4.getText();
            String city = this.textfield5.getText();
            String email = this.textfield6.getText();
            String phone = this.textfield7.getText();
            String query1 = "insert into customer values('" + name + "','" + meter + "','" + address + "','" + city + "','" + state + "','" + email + "','" + phone + "')";
            String query2 = "insert into login values('" + meter + "', '', '', '', '')";

            try {
                Conn c1 = new Conn();
                c1.statement.executeUpdate(query1);
                c1.statement.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                this.setVisible(false);
                (new MeterInfo(meter)).setVisible(true);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        } else if (actionEvent.getSource() == this.button2) {
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        (new NewCustomer()).setVisible(true);
    }
}
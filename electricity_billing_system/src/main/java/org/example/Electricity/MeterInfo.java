package org.example.Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MeterInfo extends Frame implements ActionListener {
    JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10;

    JTextField textField;
    Choice choice1, choice2, choice3, choice4;
    JButton button1, button2;

    MeterInfo(String meter) {
        this.setLocation(600, 200);
        this.setSize(700, 500);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(173, 216, 230));
        JLabel title = new JLabel("Meter Information");
        title.setBounds(180, 10, 200, 26);
        title.setFont(new Font("Tahoma", Font.PLAIN, 24));
        panel.add(title);
        this.label1 = new JLabel("Meter Number");
        this.label1.setBounds(100, 80, 100, 20);
        this.textField = new JTextField(meter);
        this.textField.setBounds(240, 80, 200, 20);
        this.textField.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.add(this.label1);
        panel.add(this.textField);
        this.label2 = new JLabel("Meter Location");
        this.label2.setBounds(100, 120, 100, 20);
        this.choice1 = new Choice();
        this.choice1.add("Outside");
        this.choice1.add("Inside");
        this.choice1.setBounds(240, 120, 200, 20);
        panel.add(this.label2);
        panel.add(this.choice1);
        this.label3 = new JLabel("Meter Type");
        this.label3.setBounds(100, 160, 100, 20);
        this.choice2 = new Choice();
        this.choice2.add("Electric Meter");
        this.choice2.add("Solar Meter");
        this.choice2.add("Smart Meter");
        this.choice2.setBounds(240, 160, 200, 20);
        panel.add(this.label3);
        panel.add(this.choice2);
        this.label5 = new JLabel("Phase Code");
        this.label5.setBounds(100, 200, 100, 20);
        this.choice3 = new Choice();
        this.choice3.add("011");
        this.choice3.add("022");
        this.choice3.add("033");
        this.choice3.add("044");
        this.choice3.add("055");
        this.choice3.add("066");
        this.choice3.add("077");
        this.choice3.add("088");
        this.choice3.add("099");
        this.choice3.setBounds(240, 200, 200, 20);
        panel.add(this.label5);
        panel.add(this.choice3);
        this.label4 = new JLabel("Bill Type");
        this.label4.setBounds(100, 240, 100, 20);
        this.choice4 = new Choice();
        this.choice4.add("Normal");
        this.choice4.add("Industrial");
        this.choice4.setBounds(240, 240, 200, 20);
        panel.add(this.label4);
        panel.add(this.choice4);
        this.label6 = new JLabel("Days");
        this.label6.setBounds(100, 280, 100, 20);
        this.label9 = new JLabel("30 Days");
        this.label9.setBounds(240, 280, 200, 20);
        panel.add(this.label6);
        panel.add(this.label9);
        this.label7 = new JLabel("Note");
        this.label7.setBounds(100, 320, 100, 20);
        this.label10 = new JLabel("By Default Bill is calculated for 30 days only");
        this.label10.setBounds(240, 320, 300, 20);
        panel.add(this.label7);
        panel.add(this.label10);
        this.button1 = new JButton("Submit");
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
//        this.getContentPane().setBackground(Color.WHITE);
        panel.setBackground(Color.WHITE);
        this.button1.addActionListener(this);
        this.button2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.button1) {
            String meter_number = this.textField.getText();
            String meter_location = this.choice1.getSelectedItem();
            String meter_type = this.choice2.getSelectedItem();
            String phase_code = this.choice3.getSelectedItem();
            String bill_type = this.choice4.getSelectedItem();
            String days = "30";
            String q1 = "insert into meter_info values('" + meter_number + "','" + meter_location + "','" + meter_type + "','" + phase_code + "','" + bill_type + "','" + days + "')";

            try {
                Conn c1 = new Conn();
                c1.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Meter Info Added Successfully");
                this.setVisible(false);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        } else if (actionEvent.getSource() == this.button2) {
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        (new MeterInfo("")).setVisible(true);
    }
}
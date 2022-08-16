package org.example.Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

public class Project extends JFrame implements ActionListener {
    String meter;

    Project(String meter, String person){
        super("Electricity Billing System");
        this.meter = meter;
        this.setSize(1920, 1030);
        ImageIcon imageIcon = new ImageIcon("src/main/java/org/example/icon/elect1.jpg");
        Image iconImage = imageIcon.getImage().getScaledInstance(1900, 950, Image.SCALE_DEFAULT);
        ImageIcon imageIconResized = new ImageIcon(iconImage);
        JLabel label1 = new JLabel(imageIconResized);
        this.add(label1);

        JMenuBar menuBar = new JMenuBar();
        JMenu masterMenu = new JMenu("Master");
        JMenuItem menuItem1 = new JMenuItem("New Customer");
        JMenuItem menuItem2 = new JMenuItem("Customer Details");
        JMenuItem menuItem3 = new JMenuItem("Deposit Details");
        JMenuItem menuItem4 = new JMenuItem("Calculate Bill");
        masterMenu.setForeground(Color.BLUE);

        menuItem1.setFont(new Font("Arial", Font.PLAIN, 12));
        ImageIcon icon1 = new ImageIcon("src/main/java/org/example/icon/icon1.png");
        Image image1 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        menuItem1.setIcon(new ImageIcon(image1));
        menuItem1.setMnemonic('D');
        menuItem1.setAccelerator(KeyStroke.getKeyStroke(68, InputEvent.CTRL_DOWN_MASK));
        menuItem1.setBackground(Color.WHITE);

        menuItem2.setFont(new Font("Arial", Font.PLAIN, 12));
        ImageIcon icon2 = new ImageIcon("src/main/java/org/example/icon/icon2.png");
        Image image2 = icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        menuItem2.setIcon(new ImageIcon(image2));
        menuItem2.setMnemonic('M');
        menuItem2.setAccelerator(KeyStroke.getKeyStroke(77, InputEvent.CTRL_DOWN_MASK));
        menuItem2.setBackground(Color.WHITE);

        menuItem3.setFont(new Font("Arial", Font.PLAIN, 12));
        ImageIcon icon3 = new ImageIcon("src/main/java/org/example/icon/icon3.png");
        Image image3 = icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        menuItem3.setIcon(new ImageIcon(image3));
        menuItem3.setMnemonic('N');
        menuItem3.setAccelerator(KeyStroke.getKeyStroke(78, InputEvent.CTRL_DOWN_MASK));
        menuItem3.setBackground(Color.WHITE);

        menuItem4.setFont(new Font("Arial", Font.PLAIN, 12));
        ImageIcon icon5 = new ImageIcon("src/main/java/org/example/icon/icon5.png");
        Image image5 = icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        menuItem4.setIcon(new ImageIcon(image5));
        menuItem4.setMnemonic('B');
        menuItem4.setAccelerator(KeyStroke.getKeyStroke(66, InputEvent.CTRL_DOWN_MASK));
        menuItem4.setBackground(Color.WHITE);

        menuItem1.addActionListener(this);
        menuItem2.addActionListener(this);
        menuItem3.addActionListener(this);
        menuItem4.addActionListener(this);

        JMenu infoMenu = new JMenu("Information");
        JMenuItem infoMenuItem1 = new JMenuItem("Update Information");
        JMenuItem infoMenuItem2 = new JMenuItem("View Information");
        infoMenu.setForeground(Color.RED);

        infoMenuItem1.setFont(new Font("Arial", Font.PLAIN, 12));
        ImageIcon icon4 = new ImageIcon("src/main/java/org/example/icon/icon4.png");
        Image image4 = icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        infoMenuItem1.setIcon(new ImageIcon(image4));
        infoMenuItem1.setMnemonic('P');
        infoMenuItem1.setAccelerator(KeyStroke.getKeyStroke(80, InputEvent.CTRL_DOWN_MASK));
        infoMenuItem1.setBackground(Color.WHITE);

        infoMenuItem2.setFont(new Font("Arial", Font.PLAIN, 12));
        ImageIcon icon6 = new ImageIcon("src/main/java/org/example/icon/icon6.png");
        Image image6 = icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        infoMenuItem2.setIcon(new ImageIcon(image6));
        infoMenuItem2.setMnemonic('L');
        infoMenuItem2.setAccelerator(KeyStroke.getKeyStroke(76, InputEvent.CTRL_DOWN_MASK));
        infoMenuItem2.setBackground(Color.WHITE);

        infoMenuItem1.addActionListener(this);
        infoMenuItem2.addActionListener(this);

        JMenu userMenu = new JMenu("User");
        JMenuItem userMenuItem1 = new JMenuItem("Pay Bill");
        JMenuItem userMenuItem2 = new JMenuItem("Bill Details");
        userMenu.setForeground(Color.RED);

        userMenuItem1.setFont(new Font("Arial", Font.PLAIN, 12));
        userMenuItem1.setIcon(new ImageIcon(image4));
        userMenuItem1.setMnemonic('P');
        userMenuItem1.setAccelerator(KeyStroke.getKeyStroke(80, InputEvent.CTRL_DOWN_MASK));
        userMenuItem1.setBackground(Color.WHITE);

        userMenuItem2.setFont(new Font("Arial", Font.PLAIN, 12));
        userMenuItem2.setIcon(new ImageIcon(image6));
        userMenuItem2.setMnemonic('L');
        userMenuItem2.setAccelerator(KeyStroke.getKeyStroke(76, InputEvent.CTRL_DOWN_MASK));
        userMenuItem2.setBackground(Color.WHITE);

        userMenuItem1.addActionListener(this);
        userMenuItem2.addActionListener(this);

        JMenu reportMenu = new JMenu("Report");
        JMenuItem reportMenuItem1 = new JMenuItem("Generate Bill");
        reportMenu.setForeground(Color.BLUE);

        reportMenuItem1.setFont(new Font("Arial", Font.PLAIN, 12));
        ImageIcon icon7 = new ImageIcon("src/main/java/org/example/icon/icon7.png");
        Image image7 = icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        reportMenuItem1.setIcon(new ImageIcon(image7));
        reportMenuItem1.setMnemonic('R');
        reportMenuItem1.setAccelerator(KeyStroke.getKeyStroke(82, InputEvent.CTRL_DOWN_MASK));
        reportMenuItem1.setBackground(Color.WHITE);

        reportMenuItem1.addActionListener(this);

        JMenu exitMenu = new JMenu("Logout");
        JMenuItem exitMenuItem1 = new JMenuItem("Logout");
        exitMenu.setForeground(Color.BLUE);

        exitMenuItem1.setFont(new Font("Arial", Font.PLAIN, 12));
        ImageIcon icon11 = new ImageIcon("src/main/java/org/example/icon/icon11.png");
        Image image11 = icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        exitMenuItem1.setIcon(new ImageIcon(image11));
        exitMenuItem1.setMnemonic('Z');
        exitMenuItem1.setAccelerator(KeyStroke.getKeyStroke(90, InputEvent.CTRL_DOWN_MASK));
        exitMenuItem1.setBackground(Color.WHITE);

        exitMenuItem1.addActionListener(this);

        masterMenu.add(menuItem1);
        masterMenu.add(menuItem2);
        masterMenu.add(menuItem3);
        masterMenu.add(menuItem4);

        infoMenu.add(infoMenuItem1);
        infoMenu.add(infoMenuItem2);
        userMenu.add(userMenuItem1);
        userMenu.add(userMenuItem2);
        reportMenu.add(reportMenuItem1);
        exitMenu.add(exitMenuItem1);

        if (person.equals("Admin")){
            menuBar.add(masterMenu);
        } else {
            menuBar.add(infoMenu);
            menuBar.add(userMenu);
            menuBar.add(reportMenu);
        }

        menuBar.add(exitMenu);
        this.setJMenuBar(menuBar);
        this.setFont(new Font("Sanserif", Font.PLAIN, 16));
        this.setLayout(new FlowLayout());
        this.setVisible(false);
    }

    public void actionPerformed(ActionEvent actionEvent){
        String message = actionEvent.getActionCommand();
        switch (message) {
            case "Customer Details":
                (new CustomerDetails()).setVisible(true);
                break;
            case "New Customer":
                (new NewCustomer()).setVisible(true);
                break;
            case "Calculate Bill":
                (new CalculateBill()).setVisible(true);
                break;
            case "Pay Bill":
                (new PayBill(this.meter)).setVisible(true);
                break;
            case "Logout":
                this.setVisible(false);
                (new Login()).setVisible(true);
                break;
            case "Generate Bill":
                (new GenerateBill(this.meter)).setVisible(true);
                break;
            case "Deposit Details":
                (new DepositDetails()).setVisible(true);
                break;
            case "View Information":
                (new ViewInformation(this.meter)).setVisible(true);
                break;
            case "Update Information":
                (new UpdateInformation(this.meter)).setVisible(true);
                break;
            case "Bill Details":
                (new BillDetails(this.meter)).setVisible(true);
                break;
        }
    }

    public static void main(String[] args) {
        new Project("", "").setVisible(true);
    }
}

















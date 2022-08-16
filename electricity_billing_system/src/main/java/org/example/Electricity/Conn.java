package org.example.Electricity;

import java.sql.*;

public class Conn {
    Connection connection;
    Statement statement;

    Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql:///ebs", "root", Password.password);
            this.statement = this.connection.createStatement();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
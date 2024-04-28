package com.mycompany.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.mycompany.models.MySQLConnector.getConnection;

public class Admin {
    public static void addAdmin(String firstName, String lastName, String email, String password) throws SQLException {
        String Query = "INSERT INTO admin (first_name, last_name, email, password) VALUES (?, ?, ?, ?)";
        Connection conct = getConnection();
        conct.setAutoCommit(false);
        PreparedStatement stmt = conct.prepareStatement(Query);
        stmt.setString(1, firstName);
        stmt.setString(2, lastName);
        stmt.setString(3, email);
        stmt.setString(4, password);
        stmt.executeUpdate();
        conct.commit();
        conct.close();
    }

    public static boolean checkLogin(String email, String password) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String Query = "SELECT * FROM admin WHERE email = ? AND password = ?";
        Connection conct = getConnection();
        PreparedStatement stmt = conct.prepareStatement(Query);
        stmt.setString(1, email);
        stmt.setString(2, password);
        ResultSet resultSet = stmt.executeQuery();
        boolean result = resultSet.next();
        conct.close();
        return result;
    }

    public static int getAdminId(String email) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String Query = "SELECT id_admin FROM admin WHERE email = ?";
        Connection conct = getConnection();
        PreparedStatement stmt = conct.prepareStatement(Query);
        stmt.setString(1, email);
        ResultSet resultSet = stmt.executeQuery();
        resultSet.next();
        int result = resultSet.getInt("id_admin");
        conct.close();
        return result;
    }

    public static void main(String[] args) throws SQLException {
        addAdmin("admin","admin","admin","admin");
    }
}


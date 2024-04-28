package com.mycompany.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/hr";
        String username = "root";
        String password = "root";

        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new SQLException("Échec de l'établissement d'une connexion à la base de données.", e);
        }
    }
}
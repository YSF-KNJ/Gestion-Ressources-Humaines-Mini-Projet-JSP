package com.mycompany.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Createdb {
    private static final String protocole = "jdbc:mysql:";
    private static final String ip = "localhost";  // dépend du contexte
    private static final String port = "3306";  // port MySQL par défaut
    private static final String conString = protocole + "//" + ip + ":" + port;
    private static final String nomConnexion = "root";  // dépend du contexte
    private static final String motDePasse = "root";  // dépend du contexte

    public static void createdb() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conct = DriverManager.getConnection(conString, nomConnexion, motDePasse);
        Statement stmt = conct.createStatement();
        stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS HR;");
        conct.close();
    }
}

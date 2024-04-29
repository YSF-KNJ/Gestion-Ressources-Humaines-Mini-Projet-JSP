package com.mycompany.servlets;

import com.mycompany.models.Createdb;
import com.mycompany.models.Createtables;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.sql.SQLException;

@WebServlet(name = "initServlet", value = "/init", loadOnStartup = 1)
public class InitServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            Createdb.createdb();
            Createtables.createtables();
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException("Error initializing database", e);
        }
    }
}
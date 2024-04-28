package com.mycompany.servlets;

import com.mycompany.models.Createdb;
import com.mycompany.models.Createtables;
import com.mycompany.models.Departement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "departementsServlet", value = "/departements")
public class DepartementServlet extends HttpServlet {
    private String message;

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        /*
        String[][] departments = new String[0][];
        try {
            Createdb.createdb();
            Createtables.createtables();
            departments = Departement.getDepartements();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

         */
        String[][] departments;
        // dummy data
        departments = new String[][]{
                {"1", "Informatique", "1"},
                {"2", "Ressources Humaines", "2"},
                {"3", "Comptabilité", "3"},
                {"4", "Marketing", "4"},
                {"5", "Vente", "5"},
        };
        request.setAttribute("departments", departments);

        request.getRequestDispatcher("/departement.jsp").forward(request, response);
    }

    public void destroy() {
    }
}
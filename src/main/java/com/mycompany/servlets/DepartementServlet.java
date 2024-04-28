package com.mycompany.servlets;

import com.mycompany.models.Createdb;
import com.mycompany.models.Createtables;
import com.mycompany.models.Departement;
import com.mycompany.models.InsertValues;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "departementsServlet", value = "/departements")
public class DepartementServlet extends HttpServlet {
    public static List<String[]> data = new ArrayList<>();
    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        /*
        String[][] departments;
        // dummy data
        departments = new String[][]{
                {"1", "Informatique", "1"},
                {"2", "Ressources Humaines", "2"},
                {"3", "Comptabilité", "3"},
                {"4", "Marketing", "4"},
                {"5", "Vente", "5"},
        };
        *§
         */




        try {
            Createdb.createdb();
            Createtables.createtables();
            data = Departement.getDepartmentDataList();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("departments", data);

        request.getRequestDispatcher("/departement.jsp").forward(request, response);
    }

}
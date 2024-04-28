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
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "departementsServlet3", value = "/departements3")
public class DepartementServlet3 extends HttpServlet {
    public static List<String[]> data = new ArrayList<>();

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            Createdb.createdb();
            Createtables.createtables();
            data = Departement.getDepartmentDataList();
            request.setAttribute("departments", data);
            request.getRequestDispatcher("/departement.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
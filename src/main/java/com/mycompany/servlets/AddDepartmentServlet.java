package com.mycompany.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addDepartmentServlet", value = "/addDepartment")
public class AddDepartmentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("addDepartement.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom_departement = request.getParameter("nom_departement");
        int id_localisation = Integer.parseInt(request.getParameter("id_localisation"));

        try {
            System.out.println(nom_departement + " " + id_localisation);
        } catch (Exception e) {
            throw new ServletException("Error adding department", e);
        }

        response.sendRedirect("addDepartment");
    }
}
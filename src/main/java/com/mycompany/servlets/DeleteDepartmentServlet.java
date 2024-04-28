package com.mycompany.servlets;

import com.mycompany.models.Departement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteDepartmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String departmentId = request.getParameter("departmentId").trim();
        int id = Integer.parseInt(departmentId);
        try {
            Departement.deleteDepartement(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // delete logic

        response.sendRedirect(request.getContextPath() + "/departements");
    }
}

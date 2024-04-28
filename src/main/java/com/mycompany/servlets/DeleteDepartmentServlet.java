package com.mycompany.servlets;

import com.mycompany.models.Departement;
import com.mycompany.models.Employe;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeleteDepartmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String departmentId = request.getParameter("departmentId").trim();
        int id = Integer.parseInt(departmentId);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Employe.replaceDepartementWithNull(id);
            Departement.deleteDepartement(id);
            List<String[]> data = new ArrayList<>();
            data = Departement.getDepartmentDataList();
            request.setAttribute("departments", data);
            response.sendRedirect(request.getContextPath() + "/departements");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

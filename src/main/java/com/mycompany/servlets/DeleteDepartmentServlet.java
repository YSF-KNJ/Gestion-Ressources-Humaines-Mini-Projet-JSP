package com.mycompany.servlets;

import com.mycompany.models.Departement;
import com.mycompany.models.Employe;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeleteDepartmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String departmentId = request.getParameter("departmentId").trim();
        int id = Integer.parseInt(departmentId);
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userId") != null) {
            String userId = String.valueOf(session.getAttribute("userId"));
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Employe.replaceDepartementWithNull(id);
                Departement.deleteDepartement(id);
                List<String[]> data = new ArrayList<>();
                data = Departement.getDepartmentDataList();
                request.setAttribute("departments", data);
                response.sendRedirect(request.getContextPath() + "/departements");
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }

        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }

    }
}

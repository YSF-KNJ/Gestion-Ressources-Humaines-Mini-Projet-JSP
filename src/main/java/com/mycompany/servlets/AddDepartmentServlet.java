package com.mycompany.servlets;

import com.mycompany.models.Departement;
import com.mycompany.models.Localisation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "addDepartmentServlet", value = "/addDepartment")
public class AddDepartmentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("addDepartement.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom_departement = request.getParameter("nom_departement").trim();
        HttpSession session = request.getSession(false);
        String userId = String.valueOf(session.getAttribute("userId"));
        int id_localisation = Integer.parseInt(request.getParameter("id_localisation"));
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            if (!Localisation.checkID(id_localisation)) {
                // error message attribute
                request.setAttribute("error", "Localisation not found");
                request.getRequestDispatcher("addDepartement.jsp").forward(request, response);

            } else {
                Departement.addDepartement(nom_departement, id_localisation, Integer.parseInt(userId));
                response.sendRedirect("departements");
            }

        } catch (Exception e) {
            throw new RuntimeException("Error adding department", e);
        }
    }
}
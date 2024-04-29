package com.mycompany.servlets;

import com.mycompany.models.Departement;
import com.mycompany.models.Employe;
import com.mycompany.models.Poste;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "addEmployeeServlet", value = "/addEmployee")
public class AddEmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("addEmployee.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String prenom = request.getParameter("prenom").trim();
        String nom = request.getParameter("nom").trim();
        String email = request.getParameter("email").trim();
        String telephone = request.getParameter("telephone").trim();
        double salaire = Double.parseDouble(request.getParameter("salaire"));
        int id_poste = Integer.parseInt(request.getParameter("id_poste"));
        int id_departement = Integer.parseInt(request.getParameter("id_departement"));
        HttpSession session = request.getSession(false);
        String userId = String.valueOf(session.getAttribute("userId"));
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            if (!Departement.checkID(id_departement)) {
                request.setAttribute("error", "Department not found");
                request.getRequestDispatcher("addEmployee.jsp").forward(request, response);
            } else if (!Poste.checkID(id_poste)) {
                request.setAttribute("error", "Post not found");
                request.getRequestDispatcher("addEmployee.jsp").forward(request, response);

            } else {
                Employe.addEmploye(prenom, nom, email, telephone, salaire, id_poste, id_departement, Integer.parseInt(userId));
                response.sendRedirect("employees");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error adding employee", e);
        }
    }
}
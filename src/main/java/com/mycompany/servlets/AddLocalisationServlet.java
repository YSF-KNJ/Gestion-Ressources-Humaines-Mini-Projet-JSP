package com.mycompany.servlets;

import com.mycompany.models.Localisation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "addLocalisationServlet", value = "/addLocalisation")
public class AddLocalisationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("addLocalisation.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adresse = request.getParameter("adresse");
        String ville = request.getParameter("ville");
        HttpSession session = request.getSession(false);
        String userId = String.valueOf(session.getAttribute("userId"));
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Localisation.addLocalisation(adresse, ville, Integer.parseInt(userId));
            response.sendRedirect("localisations");
        } catch (Exception e) {
            throw new RuntimeException("Error adding localisation", e);
        }
    }
}
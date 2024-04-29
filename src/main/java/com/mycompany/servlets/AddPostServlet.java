package com.mycompany.servlets;

import com.mycompany.models.Poste;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "addPostServlet", value = "/addPost")
public class AddPostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("addPost.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom_poste = request.getParameter("nom_poste");
        HttpSession session = request.getSession(false);
        String userId = String.valueOf(session.getAttribute("userId"));

        try {
            Poste.addPost(nom_poste, Integer.parseInt(userId));
            response.sendRedirect("postes");
        } catch (Exception e) {
            throw new ServletException("Error adding poste", e);
        }
    }
}
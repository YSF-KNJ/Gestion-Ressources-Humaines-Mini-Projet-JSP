package com.mycompany.servlets;

import com.mycompany.models.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/signinServlet")
public class SigninServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("login").trim();
        String password = request.getParameter("password").trim();
        try {

            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
            if (Admin.checkLogin(username, password)) {
                response.sendRedirect(request.getContextPath() + "/departements");
            } else {
                response.sendRedirect(request.getContextPath() + "/");
            }
        }
        catch (SQLException e) {
            response.sendRedirect(request.getContextPath() + "/");
            e.printStackTrace();
        }
    }

}

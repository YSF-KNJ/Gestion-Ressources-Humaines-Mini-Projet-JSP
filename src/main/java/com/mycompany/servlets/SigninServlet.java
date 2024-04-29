package com.mycompany.servlets;

import com.mycompany.models.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/signinServlet")
public class SigninServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("login").trim();
        String password = request.getParameter("password").trim();
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            if (Admin.checkLogin(username, password)) {
                HttpSession session = request.getSession();
                int userId = Admin.getAdminId(username);
                session.setAttribute("userId", userId);
                response.sendRedirect(request.getContextPath() + "/departements");
            } else {
                String errorMessage = "Invalid username or password";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("/").forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException e) {
            response.sendRedirect(request.getContextPath() + "/");
            e.printStackTrace();
        }
    }

}

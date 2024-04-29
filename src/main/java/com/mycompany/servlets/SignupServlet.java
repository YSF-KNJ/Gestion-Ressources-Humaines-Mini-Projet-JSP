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

@WebServlet(name = "signupServlet", value = "/signupServlet")
public class SignupServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String username = request.getParameter("signup_login");
        String password = request.getParameter("signup_password");
        try {
            if (Admin.isEmailExist(username)) {
                String emailErrorMessage = "Username already exists";
                request.setAttribute("emailErrorMessage", emailErrorMessage);
                request.getRequestDispatcher("/").forward(request, response);
            } else {
                Admin.addAdmin(firstName, lastName, username, password);
                HttpSession session = request.getSession();
                int userId = Admin.getAdminId(username);
                session.setAttribute("userId", userId);
                response.sendRedirect(request.getContextPath() + "/postes");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
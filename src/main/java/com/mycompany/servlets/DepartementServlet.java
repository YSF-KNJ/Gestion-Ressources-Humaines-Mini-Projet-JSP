package com.mycompany.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "departementsServlet", value = "/departements")
public class DepartementServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "employeesServlet!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/departement.jsp");
        dispatcher.forward(request, response);
    }

    public void destroy() {
    }
}
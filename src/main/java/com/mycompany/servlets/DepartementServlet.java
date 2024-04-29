package com.mycompany.servlets;

import com.mycompany.models.Departement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "departementsServlet", value = "/departements")
public class DepartementServlet extends HttpServlet {
    public static List<String[]> data = new ArrayList<>();

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userId") != null) {
            String userId = String.valueOf(session.getAttribute("userId"));
            try {
                data = Departement.getDepartmentDataList(Integer.parseInt(userId));
                request.setAttribute("departments", data);
                request.getRequestDispatcher("/departement.jsp").forward(request, response);
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }

        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }


    }

}
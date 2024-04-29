package com.mycompany.servlets;

import com.mycompany.models.Localisation;

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


@WebServlet(name = "localisationServlet", value = "/localisations")
public class LocalisationServlet extends HttpServlet {
    public static List<String[]> data = new ArrayList<>();

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userId") != null) {
            String userId = String.valueOf(session.getAttribute("userId"));
            try {
                data = Localisation.getLocalisationDataList(Integer.parseInt(userId));
                request.setAttribute("localisations", data);
                request.getRequestDispatcher("/localisation.jsp").forward(request, response);
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }

        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
}
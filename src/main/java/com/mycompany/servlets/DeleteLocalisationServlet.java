package com.mycompany.servlets;

import com.mycompany.models.Departement;
import com.mycompany.models.Localisation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeleteLocalisationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String localisationId = request.getParameter("localisationId").trim();
        int id = Integer.parseInt(localisationId);
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userId") != null) {
            String userId = String.valueOf(session.getAttribute("userId"));
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Departement.replaceLocalisationWithNull(id);
                Localisation.deleteLocalisation(id);
                List<String[]> data = new ArrayList<>();
                data = Localisation.getLocalisationDataList(Integer.parseInt(userId));
                request.setAttribute("localisations", data);
                response.sendRedirect(request.getContextPath() + "/localisations");
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }

        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }

    }
}
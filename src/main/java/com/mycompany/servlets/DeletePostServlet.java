package com.mycompany.servlets;

import com.mycompany.models.Employe;
import com.mycompany.models.Poste;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeletePostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String postId = request.getParameter("postId").trim();
        int id = Integer.parseInt(postId);
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userId") != null) {
            String userId = String.valueOf(session.getAttribute("userId"));
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Employe.replacePosteWithNull(id);
                Poste.deletePoste(id);
                List<String[]> data = new ArrayList<>();
                data = Poste.getPosteDataList(Integer.parseInt(userId));
                request.setAttribute("postes", data);
                response.sendRedirect(request.getContextPath() + "/postes");
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }

        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }

    }
}
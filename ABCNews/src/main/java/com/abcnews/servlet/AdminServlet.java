package com.abcnews.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin", "/admin/home"})
public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String uri = req.getRequestURI();

        if (uri.endsWith("/admin")) {
            resp.sendRedirect(req.getContextPath() + "/admin/home");
            return;
        }

        req.setAttribute("page", "/views/admin/admin-home.jsp");
        req.getRequestDispatcher("/views/admin/admin-layout.jsp").forward(req, resp);
    }
}

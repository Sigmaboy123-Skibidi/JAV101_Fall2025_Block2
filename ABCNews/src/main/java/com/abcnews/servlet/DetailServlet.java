package com.abcnews.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/admin/chitiet")
public class DetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        String id = req.getParameter("id");

        req.setAttribute("id", id);

        // Nhúng trang chitiet.jsp vào layout
        req.setAttribute("page", "/views/admin/chitiet.jsp");
        req.getRequestDispatcher("/views/admin/admin-layout.jsp").forward(req, resp);
    }
}

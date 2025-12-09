package com.abcnews.servlet;

import com.abcnews.dao.NewsletterDAO;
import com.abcnews.daoimpl.NewsletterDAOImpl;
import com.abcnews.entity.Newsletter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/newsletter")
public class NewsletterServlet extends HttpServlet {
    private NewsletterDAO newsletterDAO = new NewsletterDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String email = req.getParameter("email");
        if (email != null && !email.trim().isEmpty()) {
            Newsletter n = new Newsletter(email.trim());
            newsletterDAO.insert(n);
        }
        resp.sendRedirect(req.getContextPath() + "/trang-chu?page=home");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Nếu có truy cập GET thì redirect về trang chủ
        resp.sendRedirect(req.getContextPath() + "/trang-chu?page=home");
    }
}


package com.abcnews.servlet;

import com.abcnews.dao.NewsletterDAO;
import com.abcnews.daoimpl.NewsletterDAOImpl;
import com.abcnews.entity.Newsletter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/newsletter")
public class AdminNewsletterServlet extends HttpServlet {
    private NewsletterDAO newsletterDAO = new NewsletterDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Newsletter> list = newsletterDAO.findAll();
        req.setAttribute("list", list);
        req.setAttribute("page", "/views/admin/admin-newsletter.jsp");
        req.getRequestDispatcher("/views/admin/admin-layout.jsp").forward(req, resp);
    }
}

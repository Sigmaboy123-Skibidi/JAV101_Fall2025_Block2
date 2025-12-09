package com.abcnews.servlet;

import com.abcnews.dao.NewsletterDAO;
import com.abcnews.daoimpl.NewsletterDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/admin/newsletter/delete")
public class AdminNewsletterDeleteServlet extends HttpServlet {
    private NewsletterDAO newsletterDAO = new NewsletterDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String idStr = req.getParameter("id");
        if (idStr != null) {
            int id = Integer.parseInt(idStr);
            newsletterDAO.delete(id);
        }
        resp.sendRedirect(req.getContextPath() + "/admin/newsletter");
    }
}

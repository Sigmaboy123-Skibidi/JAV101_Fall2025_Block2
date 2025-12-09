package com.abcnews.servlet;

import com.abcnews.dao.NewsDAO;
import com.abcnews.dao.CategoryDAO;
import com.abcnews.daoimpl.NewsDAOImpl;
import com.abcnews.daoimpl.CategoryDAOImpl;
import com.abcnews.entity.News;
import com.abcnews.entity.Category;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {
        "/admin/news",
        "/admin/news/create",
        "/admin/news/edit",
        "/admin/news/delete"
})
public class AdminNewsServlet extends HttpServlet {

    private final NewsDAO newsDAO = new NewsDAOImpl();
    private final CategoryDAO categoryDAO = new CategoryDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String uri = req.getRequestURI();

        if (uri.endsWith("/news")) {
            list(req, resp);
        } else if (uri.endsWith("/create")) {
            showCreateForm(req, resp);
        } else if (uri.endsWith("/edit")) {
            showEditForm(req, resp);
        } else if (uri.endsWith("/delete")) {
            delete(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String uri = req.getRequestURI();

        if (uri.endsWith("/create")) {
            create(req, resp);
        } else if (uri.endsWith("/edit")) {
            update(req, resp);
        }
    }

    // ==================== LIST ====================
    private void list(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<News> newsList = newsDAO.findAll();
        List<Category> categories = categoryDAO.findAll();

        req.setAttribute("newsList", newsList);
        req.setAttribute("categories", categories);

        req.setAttribute("page", "/views/admin/admin-news.jsp"); 
        req.getRequestDispatcher("/views/admin/admin-layout.jsp").forward(req, resp);
    }

    // ==================== CREATE ====================
    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Category> categories = categoryDAO.findAll();
        req.setAttribute("categories", categories);

        req.setAttribute("page", "/views/admin/admin-news-form.jsp");
        req.getRequestDispatcher("/views/admin/admin-layout.jsp").forward(req, resp);
    }

    private void create(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        News n = new News();
        n.setTitle(req.getParameter("title"));
        n.setContent(req.getParameter("content"));
        n.setImage(req.getParameter("image"));  
        n.setCategoryId(Integer.parseInt(req.getParameter("categoryId")));

        newsDAO.insert(n);

        resp.sendRedirect(req.getContextPath() + "/admin/news");
    }

    // ==================== EDIT ====================
    private void showEditForm(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        News n = newsDAO.findById(id);
        if (n == null) {
            resp.sendRedirect(req.getContextPath() + "/admin/news");
            return;
        }

        List<Category> categories = categoryDAO.findAll();
        req.setAttribute("categories", categories);
        req.setAttribute("news", n);
        req.setAttribute("page", "/views/admin/admin-news-form.jsp");
        req.getRequestDispatcher("/views/admin/admin-layout.jsp").forward(req, resp);
    }

    private void update(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        News n = new News();
        n.setId(Integer.parseInt(req.getParameter("id")));
        n.setTitle(req.getParameter("title"));
        n.setContent(req.getParameter("content"));
        n.setImage(req.getParameter("image"));
        n.setCategoryId(Integer.parseInt(req.getParameter("categoryId")));

        newsDAO.update(n);

        resp.sendRedirect(req.getContextPath() + "/admin/news");
    }

    // ==================== DELETE ====================
    private void delete(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        newsDAO.delete(id);

        resp.sendRedirect(req.getContextPath() + "/admin/news");
    }
}

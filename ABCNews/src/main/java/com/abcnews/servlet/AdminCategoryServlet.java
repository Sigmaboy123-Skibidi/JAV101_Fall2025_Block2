package com.abcnews.servlet;

import com.abcnews.dao.CategoryDAO;
import com.abcnews.daoimpl.CategoryDAOImpl;
import com.abcnews.entity.Category;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/admin/categories")
public class AdminCategoryServlet extends HttpServlet {

    private CategoryDAO categoryDAO = new CategoryDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if (action == null || action.equals("list")) {
            List<Category> list = categoryDAO.findAll();
            req.setAttribute("categories", list);
            req.setAttribute("page", "/views/admin/admin-categories.jsp");
            req.getRequestDispatcher("/views/admin/admin-layout.jsp").forward(req, resp);

        } else if (action.equals("create")) {
            Category category = new Category(); // id = null
            req.setAttribute("category", category);
            req.setAttribute("page", "/views/admin/admin-category-form.jsp");
            req.getRequestDispatcher("/views/admin/admin-layout.jsp").forward(req, resp);

        } else if (action.equals("edit")) {
            int id = Integer.parseInt(req.getParameter("id"));
            Category c = categoryDAO.findById(id);
            req.setAttribute("category", c);
            req.setAttribute("page", "/views/admin/admin-category-form.jsp");
            req.getRequestDispatcher("/views/admin/admin-layout.jsp").forward(req, resp);

        } else if (action.equals("delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            categoryDAO.delete(id);
            resp.sendRedirect(req.getContextPath() + "/admin/categories");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idStr = req.getParameter("id");
        String name = req.getParameter("name");

        Category c = new Category();
        c.setName(name);

        // Nếu id null, rỗng, hoặc =0 thì insert
        if (idStr == null || idStr.trim().isEmpty() || idStr.equals("0")) {
            categoryDAO.insert(c);
            System.out.println("Inserted category '" + name + "'; Rows affected: 1");
        } else {
            c.setId(Integer.parseInt(idStr));
            categoryDAO.update(c);
            System.out.println("Updated category id=" + idStr + "; Rows affected: 1");
        }

        resp.sendRedirect(req.getContextPath() + "/admin/categories");
    }
}

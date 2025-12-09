package com.abcnews.servlet;

import com.abcnews.dao.UserDAO;
import com.abcnews.daoimpl.UserDAOImpl;
import com.abcnews.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/admin/users")
public class AdminUserServlet extends HttpServlet {

    private UserDAO userDAO = new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null) action = "";

        try {
            switch (action) {
                case "create":
                    req.setAttribute("user", new User());
                    req.setAttribute("page", "/views/admin/admin-user-form.jsp");
                    req.getRequestDispatcher("/views/admin/admin-layout.jsp").forward(req, resp);
                    break;

                case "edit":
                    String idEdit = req.getParameter("id");
                    User u = userDAO.findById(idEdit);
                    req.setAttribute("user", u);
                    req.setAttribute("page", "/views/admin/admin-user-form.jsp");
                    req.getRequestDispatcher("/views/admin/admin-layout.jsp").forward(req, resp);
                    break;

                case "delete":
                    String idDelete = req.getParameter("id");
                    userDAO.delete(idDelete);
                    resp.sendRedirect(req.getContextPath() + "/admin/users");
                    break;

                default:
                    List<User> list = userDAO.findAll();
                    req.setAttribute("users", list);
                    req.setAttribute("page", "/views/admin/admin-users.jsp");
                    req.getRequestDispatcher("/views/admin/admin-layout.jsp").forward(req, resp);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null) action = "";

        String id = req.getParameter("id");
        String password = req.getParameter("password");
        String fullname = req.getParameter("fullname");
        Date birthday = null;
        try {
            if(req.getParameter("birthday") != null && !req.getParameter("birthday").isEmpty()) {
                birthday = Date.valueOf(req.getParameter("birthday"));
            }
        } catch (Exception e) {
            birthday = null;
        }
        Boolean gender = "1".equals(req.getParameter("gender"));
        String mobile = req.getParameter("mobile");
        String email = req.getParameter("email");
        Boolean role = "1".equals(req.getParameter("role"));

        User u = new User();
        u.setId(id);
        u.setPassword(password);
        u.setFullname(fullname);
        u.setBirthday(birthday);
        u.setGender(gender);
        u.setMobile(mobile);
        u.setEmail(email);
        u.setRole(role);

        try {
            if ("create".equals(action)) {
                userDAO.insert(u);
            } else if ("edit".equals(action)) {
                userDAO.update(u);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }

        resp.sendRedirect(req.getContextPath() + "/admin/users");
    }
}

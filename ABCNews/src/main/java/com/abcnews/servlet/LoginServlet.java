package com.abcnews.servlet;

import com.abcnews.dao.UserDAO;
import com.abcnews.daoimpl.UserDAOImpl;
import com.abcnews.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserDAO userDAO = new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("/views/client/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String id = req.getParameter("id");
        String password = req.getParameter("password");

        try {
            User user = userDAO.login(id, password);

            if (user == null) {
                req.setAttribute("error", "Sai tài khoản hoặc mật khẩu!");
                req.getRequestDispatcher("/views/client/login.jsp").forward(req, resp);
                return;
            }

            HttpSession session = req.getSession();
            session.setAttribute("user", user);

            // ✔ Admin & phóng viên vào admin
            if (user.getRole()) {
                // Admin → vào admin
                resp.sendRedirect(req.getContextPath() + "/admin/home");

            } else {
                // Phóng viên → cũng vào admin
                resp.sendRedirect(req.getContextPath() + "/admin/home");
            }

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Đăng nhập gặp lỗi hệ thống!");
            req.getRequestDispatcher("/views/client/login.jsp").forward(req, resp);
        }
    }
}

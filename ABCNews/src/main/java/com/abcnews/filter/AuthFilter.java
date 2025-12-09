package com.abcnews.filter;

import com.abcnews.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebFilter("/admin/*")
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);
        User user = (session != null) ? (User) session.getAttribute("user") : null;

        // ❌ Chưa đăng nhập → bắt login
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        String uri = req.getRequestURI();

        // ✔ Admin = true
        // ✔ Phóng viên = false
        boolean isAdmin = Boolean.TRUE.equals(user.getRole());
        boolean isReporter = Boolean.FALSE.equals(user.getRole());

        // ❌ PHÓNG VIÊN KHÔNG ĐƯỢC TRUY CẬP User + Newsletter
        if (isReporter && (
                uri.contains("/admin/users") ||
                uri.contains("/admin/newsletter")
        )) {
            resp.sendRedirect(req.getContextPath() + "/admin/news");
            return;
        }

        chain.doFilter(request, response);
    }
}

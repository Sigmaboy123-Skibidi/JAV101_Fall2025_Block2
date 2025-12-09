package com.poly.controller;

import java.io.IOException;
import org.apache.commons.codec.binary.Base64;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lab5Login")
public class Lab5_B3 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Đọc cookie trước
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("user")) {
					String encoded = c.getValue();
					byte[] decodedBytes = Base64.decodeBase64(encoded);
					String decoded = new String(decodedBytes);

					String[] userInfo = decoded.split(",");
					req.setAttribute("username", userInfo[0]);
					req.setAttribute("password", userInfo[1]);
				}
			}
		}

		// Forward sang JSP
		req.getRequestDispatcher("L5_B3_Login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String username = req.getParameter("username");
	    String password = req.getParameter("password");
	    String remember = req.getParameter("remember-me");

	    req.getSession().setAttribute("username", username);

	    if (remember != null && !username.isEmpty() && !password.isEmpty()) {
	        // Tạo cookie mới, ghi đè cookie cũ
	        byte[] bytes = (username + "," + password).getBytes();
	        String userInfo = Base64.encodeBase64String(bytes);
	        Cookie cookie = new Cookie("user", userInfo);
	        cookie.setMaxAge(30 * 24 * 60 * 60);
	        cookie.setPath("/");
	        resp.addCookie(cookie);
	    } else {
	        // Xóa cookie nếu không nhớ
	        Cookie cookie = new Cookie("user", "");
	        cookie.setMaxAge(0);
	        cookie.setPath("/");
	        resp.addCookie(cookie);
	    }

	    // Redirect để trình duyệt gửi lại cookie mới
	    resp.sendRedirect(req.getContextPath() + "/lab5Login");
	}

	}




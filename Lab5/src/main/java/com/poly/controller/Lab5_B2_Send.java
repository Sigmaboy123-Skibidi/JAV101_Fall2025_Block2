package com.poly.controller;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/send")
public class Lab5_B2_Send extends HttpServlet {
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	        req.getRequestDispatcher("L5_B2.jsp").forward(req, resp);
	    }

	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {

	        String from = req.getParameter("from");
	        String to = req.getParameter("to");
	        String subject = req.getParameter("subject");
	        String body = req.getParameter("body");

	        Lab5_B2_Mailer.send(from, to, subject, body);

	        req.setAttribute("message", "Đã gửi email!");

	        req.getRequestDispatcher("L5_B2.jsp").forward(req, resp);
	    }
}

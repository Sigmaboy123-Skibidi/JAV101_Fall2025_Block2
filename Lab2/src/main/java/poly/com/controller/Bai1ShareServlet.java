package poly.com.controller;

import java.io.IOException;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/bai1shareservlet")
public class Bai1ShareServlet extends HttpServlet
{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	req.setAttribute("message", "webcome fpoly");
	req.setAttribute("now", new Date());
	req.getRequestDispatcher("page.jsp").forward(req, resp);
}
}

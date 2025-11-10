package poly.com.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet({"/bai4","/crud/them","/crud/xoa","/crud/sua"})
public class Bai4controller extends HttpServlet
{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	String uri = req.getRequestURI();
	// Kiểm tra đường dẫn và xuất thông báo tương ứng
	if (uri.contains("/crud/them"))
		resp.getWriter().println("<h1>Createing a new record...</h1>");
	else if (uri.contains("/crud/xoa"))
		resp.getWriter().println("<h1>Deleting a new record...</h1>");
	else if (uri.contains("/crud/sua"))
		resp.getWriter().println("<h1>Updating a new record...</h1>");
	else 
		resp.getWriter().println("<h1>Not known</h1>");
}
}

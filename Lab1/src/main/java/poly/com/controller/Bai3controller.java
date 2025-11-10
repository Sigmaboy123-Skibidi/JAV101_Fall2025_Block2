package poly.com.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/bai3")
public class Bai3controller extends HttpServlet
{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	// Thiết lập kiểu nội dung xuất ra là HTML và mã hóa UTF-8
    resp.setContentType("text/html;charset=UTF-8");

    // Xuất thông tin ra trình duyệt
    resp.getWriter().println("<html><body>");
    resp.getWriter().println("<h2>Thông tin URL hiện tại:</h2>");
    resp.getWriter().println("<ul>");
    resp.getWriter().println("<li><b>URL:</b> " + req.getRequestURL() + "</li>");
    resp.getWriter().println("<li><b>URI:</b> " + req.getRequestURI() + "</li>");
    resp.getWriter().println("<li><b>Query String:</b> " + req.getQueryString() + "</li>");
    resp.getWriter().println("<li><b>Servlet Path:</b> " + req.getServletPath() + "</li>");
    resp.getWriter().println("<li><b>Context Path:</b> " + req.getContextPath() + "</li>");
    resp.getWriter().println("<li><b>Path Info:</b> " + req.getPathInfo() + "</li>");
    resp.getWriter().println("<li><b>Method:</b> " + req.getMethod() + "</li>");
    resp.getWriter().println("</ul>");
    resp.getWriter().println("</body></html>");
}
}

package poly.com.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/bai2UserServlet")
public class Bai2UserServlet extends HttpServlet
{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	req.setAttribute("message", "Welcome to FPT Polytechnic");
	Map<String, Object> map = new HashMap<>();
	map.put("fullname", "Nguyễn Võ Hoài Nam");
	map.put("gender", "Nam");
	map.put("country", "Việt Nam");
	req.setAttribute("user", map);
	req.getRequestDispatcher("/page.jsp").forward(req, resp);
}

}

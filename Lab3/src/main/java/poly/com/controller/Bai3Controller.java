package poly.com.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet({"/Bai3","/Bai4"})
public class Bai3Controller extends HttpServlet
{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	String chon=req.getRequestURI();
	if (chon.contains("/Bai3"))
	{
	Map<String, Object> map = new HashMap<>();
	map.put("name", "iPhone 2025");
	map.put("price", 12345678);
	map.put("date", new Date());
	req.setAttribute("item", map);
	req.getRequestDispatcher("Bai3.jsp").forward(req, resp);
	}
	else
	{
		Map<String, Object> map = new HashMap<>();
		map.put("title", "Tiêu đề bản tin");
		map.put("content", "Nội dung bản tin thường rất dài");
		req.setAttribute("item", map);
		req.getRequestDispatcher("Bai4.jsp").forward(req, resp);
	}
}
}

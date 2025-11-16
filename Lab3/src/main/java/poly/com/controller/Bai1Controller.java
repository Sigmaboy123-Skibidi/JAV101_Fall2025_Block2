package poly.com.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import poly.com.model.Country;
@WebServlet("/Bai1")
public class Bai1Controller extends HttpServlet
{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	List<Country> list = List.of(
			new Country("VN", "Việt Nam"),
			new Country("US", "United States"),
			new Country("CN", "China")
			);
			req.setAttribute("countries", list);
			req.getRequestDispatcher("Bai1.jsp").forward(req, resp);
}
}

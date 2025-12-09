package com.poly.controller;

import java.io.IOException;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.Converter;

@WebServlet({"/L5_B1","/save"})
public class Lab5_B1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("L5_B1.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Staff bean = new Staff(); // dùng để chứa dữ liệu form
		try {
			// Khai báo định dạng ngày
			DateConverter  dtc = new DateConverter();
			dtc.setPattern("MM/dd/yyyy");
			ConvertUtils.register(dtc, Date.class);
			// đọc và chuyển đổi tham số vào bean
			BeanUtils.populate(bean, req.getParameterMap());
			
			 // Đẩy bean sang JSP để hiển thị
            req.setAttribute("form", bean);
			System.out.println(bean.getFullname());
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("save.jsp").forward(req, resp);
	}
	
}

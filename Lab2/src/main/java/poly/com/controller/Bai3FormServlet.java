package poly.com.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/bai3FormServlet", "/form/ud", "/form/create"})
public class Bai3FormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Tạo dữ liệu mẫu ban đầu
        Map<String, Object> map = new HashMap<>();
        map.put("fullname", "Nguyễn Võ Hoài Nam");
        map.put("gender", true);
        map.put("country", "VN");

        req.setAttribute("user", map);
        req.setAttribute("editabled", true);

        // Chuyển đến trang form.jsp
        req.getRequestDispatcher("/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        // Lấy tham số từ form
        String fullname = req.getParameter("fullname");
        String gender = req.getParameter("gender");
        String country = req.getParameter("country");

        // Lưu dữ liệu lại vào request để hiển thị lại trên form
        Map<String, Object> user = new HashMap<>();
        user.put("fullname", fullname);
        user.put("gender", "true".equals(gender));
        user.put("country", country);
        req.setAttribute("user", user);
        req.setAttribute("editabled", true);

        // Xác định người dùng bấm nút nào (Create hay Update)
        String uri = req.getRequestURI();
        String message = "";
        if (uri.endsWith("/create")) {
            message = "Đã tạo mới thành công!";
        } else if (uri.endsWith("/ud")) {
            message = "Đã cập nhật thông tin thành công!";
        }

        // Gửi thông báo ra form (nếu cần)
        req.setAttribute("message", message);

        // Trả về form.jsp
        req.getRequestDispatcher("/form.jsp").forward(req, resp);
    }
}

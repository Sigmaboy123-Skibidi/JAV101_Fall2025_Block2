package poly.com.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;

@WebServlet("/bai4User")
public class Bai4User extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Tạo 1 User mẫu
        User user = new User("Nguyễn Văn A", true, "VN");

        // Đưa user vào request để hiển thị trên JSP
        req.setAttribute("user", user);

        req.getRequestDispatcher("/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        // Lấy dữ liệu từ form
        String fullname = req.getParameter("fullname");
        String gender = req.getParameter("gender");
        String country = req.getParameter("country");

        User user = new User(fullname, "true".equals(gender), country);

        // Gửi lại user về JSP
        req.setAttribute("user", user);
        req.getRequestDispatcher("/form.jsp").forward(req, resp);
    }

    // ===================== Inner class User =====================
    public static class User {
        private String fullname;
        private boolean gender;
        private String country;

        public User() {
        }

        public User(String fullname, boolean gender, String country) {
            this.fullname = fullname;
            this.gender = gender;
            this.country = country;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public boolean isGender() {
            return gender;
        }

        public void setGender(boolean gender) {
            this.gender = gender;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }
}


package poly.com.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Bai5Controller.java
 * Servlet xử lý yêu cầu tính tổng hai số từ form bai5.jsp
 */
@WebServlet("/bai5")
public class Bai5controller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Bai5controller() {
        super();
    }

    /**
     * Xử lý phương thức GET — khi người dùng truy cập trực tiếp /bai5
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            // Lấy dữ liệu người dùng nhập từ form
            String sa = req.getParameter("txta");
            String sb = req.getParameter("txtb");

            // Nếu chưa nhập gì thì không xử lý
            if (sa == null || sb == null || sa.isEmpty() || sb.isEmpty()) {
                req.getRequestDispatcher("bai5.jsp").forward(req, resp);
                return;
            }

            // Ép kiểu sang float
            float a = Float.parseFloat(sa);
            float b = Float.parseFloat(sb);

            // Tính tổng
            float kq = a + b;

            // Gửi kết quả về lại JSP
            req.setAttribute("kq", kq);
        } 
        catch (NumberFormatException e) {
            // Báo lỗi nếu nhập sai định dạng
            req.setAttribute("error", "❌ Bạn nhập số không hợp lệ!");
        }

        // Dù thành công hay lỗi đều quay lại trang kết quả
        req.getRequestDispatcher("bai5.jsp").forward(req, resp);
    }

    /**
     * Xử lý phương thức POST — khi người dùng nhấn nút Submit trên form
     * Gọi lại doGet để tái sử dụng logic
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}


package poly.com.controller;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet({"/add"})
@MultipartConfig
public class Bai3Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Đường dẫn lưu ảnh
    private static final String UPLOAD_DIRECTORY = "uploads";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Lấy thông tin từ form
        String fullname = request.getParameter("fullname");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String married = request.getParameter("married");
        String country = request.getParameter("country");
        String note = request.getParameter("note");
        String[] hobbies = request.getParameterValues("hobbies");

        // Xử lý file ảnh
        Part filePart = request.getPart("photo_file");
        String fileName = filePart.getSubmittedFileName();

        // Lưu file lên server
        String uploadPath = request.getServletContext().getRealPath("uploads");
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdirs();

        filePart.write(uploadPath + File.separator + fileName);

        // Gửi sang JSP để hiển thị lại
        request.setAttribute("fullname", fullname);
        request.setAttribute("password", password);
        request.setAttribute("gender", gender);
        request.setAttribute("married", married);
        request.setAttribute("country", country);
        request.setAttribute("note", note);
        request.setAttribute("hobbies", hobbies);
        request.setAttribute("photo", fileName);

        request.getRequestDispatcher("/ketqua.jsp").forward(request, response);
    }
}

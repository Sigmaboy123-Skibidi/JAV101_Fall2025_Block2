package com.abcnews.servlet;

import com.abcnews.dao.NewsDAO;
import com.abcnews.dao.CategoryDAO;
import com.abcnews.daoimpl.NewsDAOImpl;
import com.abcnews.daoimpl.CategoryDAOImpl;
import com.abcnews.entity.News;
import com.abcnews.entity.Category;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/trang-chu")
public class HomeServlet extends HttpServlet {

    private final NewsDAO newsDAO = new NewsDAOImpl();
    private final CategoryDAO categoryDAO = new CategoryDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {

        String page = req.getParameter("page");
        if (page == null || page.isEmpty()) page = "home";

        // Load danh sách category
        List<Category> categories = categoryDAO.findAll();
        req.setAttribute("categories", categories);

        List<News> newsList = new ArrayList<>();

        try {
            switch (page) {
                case "home":
                    newsList = newsDAO.findLatest();
                    req.setAttribute("contentPage", "home.jsp");
                    break;

                case "category":
                    String catIdParam = req.getParameter("id");
                    if (catIdParam != null && !catIdParam.isEmpty()) {
                        try {
                            int catId = Integer.parseInt(catIdParam);
                            newsList = newsDAO.findByCategory(catId);
                            req.setAttribute("currentCategory", categoryDAO.findById(catId));
                        } catch (NumberFormatException e) {
                            newsList = new ArrayList<>();
                        }
                    }
                    req.setAttribute("contentPage", "category.jsp");
                    break;

                case "chitiet":
                    String newsIdParam = req.getParameter("id");
                    if (newsIdParam != null && !newsIdParam.isEmpty()) {
                        try {
                            int newsId = Integer.parseInt(newsIdParam);
                            News news = newsDAO.findById(newsId);
                            if (news != null) {
                                newsDAO.increaseView(newsId);
                                req.setAttribute("news", news);

                                List<News> related = newsDAO.findRelatedNews(news.getCategoryId(), newsId);
                                req.setAttribute("relatedNews", related);

                                // Lưu viewed news vào session
                                HttpSession session = req.getSession();
                                List<News> viewed = (List<News>) session.getAttribute("viewedNews");
                                if (viewed == null) viewed = new ArrayList<>();
                                viewed.removeIf(n -> n.getId() == newsId);
                                viewed.add(0, news);
                                if (viewed.size() > 5) viewed = viewed.subList(0, 5);
                                session.setAttribute("viewedNews", viewed);

                                req.setAttribute("contentPage", "newsDetail.jsp");
                            } else {
                                newsList = newsDAO.findLatest();
                                req.setAttribute("contentPage", "newsList.jsp");
                            }
                        } catch (NumberFormatException e) {
                            newsList = newsDAO.findLatest();
                            req.setAttribute("contentPage", "newsList.jsp");
                        }
                    }
                    break;

                case "xemnhieu":
                    newsList = newsDAO.findTopView();
                    req.setAttribute("contentPage", "newsList.jsp");
                    break;

                case "moinhat":
                    newsList = newsDAO.findLatest();
                    req.setAttribute("contentPage", "newsList.jsp");
                    break;

                case "daxem":
                    HttpSession session = req.getSession();
                    List<News> viewed = (List<News>) session.getAttribute("viewedNews");
                    newsList = viewed != null ? viewed : new ArrayList<>();
                    req.setAttribute("contentPage", "newsList.jsp");
                    break;

                default:
                    newsList = newsDAO.findLatest();
                    req.setAttribute("contentPage", "home.jsp");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            newsList = new ArrayList<>();
            req.setAttribute("contentPage", "home.jsp");
        }

        req.setAttribute("newsList", newsList);
        req.getRequestDispatcher("/views/client/layout.jsp").forward(req, resp);
    }
}

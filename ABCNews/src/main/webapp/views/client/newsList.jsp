<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
    body {
        font-family: Arial;
        background: #f4f4f4;
    }

    h2 {
        color: #5BA0D0;
        border-bottom: 3px solid #5BA0D0;
        padding-bottom: 8px;
        margin-bottom: 20px;
    }

    .news-item {
        background: white;
        border: 1px solid #ddd;
        border-radius: 6px;
        padding: 15px;
        display: flex;
        margin-bottom: 20px;
        transition: 0.25s;
    }

    .news-item:hover {
        box-shadow: 0px 0px 8px rgba(0,0,0,0.15);
        transform: translateY(-2px);
    }

    .news-item img {
        width: 150px;
        height: 100px;
        object-fit: cover;
        border-radius: 5px;
        margin-right: 15px;
        border: 1px solid #ccc;
    }

    .news-title {
        font-size: 18px;
        font-weight: bold;
        text-decoration: none;
        color: #0056d6;
    }

    .news-title:hover {
        text-decoration: underline;
    }

    .info {
        font-size: 14px;
        color: #666;
        margin-top: 5px;
    }
</style>

<h2>Danh sách tin tức</h2>

<c:forEach var="n" items="${newsList}">
    <div class="news-item">
        
        <img src="${n.image}" alt="News">

        <div>
            <a class="news-title"
               href="${pageContext.request.contextPath}/trang-chu?page=chitiet&id=${n.id}">
                ${n.title}
            </a>

            <div class="info">
                Ngày đăng: 
                <fmt:formatDate value="${n.postedDate}" pattern="dd/MM/yyyy" />
            </div>

            <div class="info">
                Lượt xem: ${n.viewCount}
            </div>
        </div>

    </div>
</c:forEach>

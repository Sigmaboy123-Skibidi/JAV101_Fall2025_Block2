<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
    body {
        font-family: Arial, sans-serif;
        background: #f5f5f5;
        padding: 25px;
        margin: 0;
    }

    h2 {
        color: #0a3d91;
        font-size: 26px;
        border-left: 5px solid #0a3d91;
        padding-left: 12px;
        margin-bottom: 25px;
    }

    .news-box {
        background: #fff;
        padding: 18px;
        border-radius: 8px;
        margin-bottom: 18px;
        box-shadow: 0 2px 8px rgba(0,0,0,0.12);
        border-left: 4px solid #0a3d91;
        transition: 0.2s;
    }

    .news-box:hover {
        transform: translateX(4px);
        box-shadow: 0 3px 12px rgba(0,0,0,0.18);
    }

    .news-title {
        text-decoration: none;
        color: #0a3d91;
        font-size: 18px;
        font-weight: bold;
    }

    .news-title:hover {
        text-decoration: underline;
    }

    .meta {
        font-size: 12px;
        color: gray;
        margin: 4px 0 10px 0;
    }

    .summary {
        font-size: 15px;
        line-height: 1.6;
        color: #333;
        margin-top: 5px;
    }
</style>

<h2>5 bản tin mới nhất</h2>

<c:forEach var="item" items="${newsList}">
    <div class="news-box">

        <a class="news-title"
           href="${pageContext.request.contextPath}/trang-chu?page=chitiet&id=${item.id}">
            ${item.title}
        </a>

        <div class="meta">
            Ngày đăng:
            <fmt:formatDate value="${item.postedDate}" pattern="dd/MM/yyyy" />
            | Category ID: ${item.categoryId}
        </div>

        <p class="summary">
            ${item.content.substring(0, item.content.length() > 100 ? 100 : item.content.length())}...
        </p>
    </div>
</c:forEach>

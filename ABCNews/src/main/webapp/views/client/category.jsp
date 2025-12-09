<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
    body {
        font-family: Arial, sans-serif;
        background: #f5f5f5;
        margin: 0;
        padding: 30px;
    }

    h2 {
        color: #0a3d91;
        margin-bottom: 20px;
        text-transform: uppercase;
    }

    .news-item {
        background: white;
        padding: 15px 20px;
        margin-bottom: 18px;
        border-radius: 8px;
        box-shadow: 0 2px 6px rgba(0,0,0,0.06);
        transition: 0.2s;
        border-left: 4px solid #0a3d91;
    }

    .news-item:hover {
        transform: scale(1.01);
        box-shadow: 0 3px 10px rgba(0,0,0,0.12);
    }

    .news-title {
        font-size: 20px;
        font-weight: bold;
        color: #0a3d91;
        text-decoration: none;
    }

    .news-title:hover {
        text-decoration: underline;
    }

    .meta {
        font-size: 12px;
        color: #777;
        margin-top: 5px;
        margin-bottom: 8px;
    }

    .summary {
        font-size: 15px;
        line-height: 1.6;
        color: #333;
    }
</style>

<h2>Tin theo danh mục: ${currentCategory.name}</h2>

<c:forEach var="item" items="${newsList}">

    <div class="news-item">

        <a class="news-title"
           href="${pageContext.request.contextPath}/trang-chu?page=chitiet&id=${item.id}">
            ${item.title}
        </a>

        <div class="meta">
            Ngày đăng:
            <fmt:formatDate value="${item.postedDate}" pattern="dd/MM/yyyy" />
            &nbsp;|&nbsp; Danh mục ID: ${item.categoryId}
        </div>

        <div class="summary">
            ${item.content.substring(0, item.content.length() > 150 ? 150 : item.content.length())}...
        </div>

    </div>

</c:forEach>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>${news.title}</title>

<style>
    body {
        font-family: Arial;
        background: #f4f4f4;
        margin: 0;
        padding: 0;
    }

    .news-container {
        width: 900px;
        background: white;
        margin: 30px auto;
        padding: 25px;
        border: 1px solid #ddd;
        border-radius: 6px;
    }

    h2 {
        color: #5BA0D0;
        margin-top: 0;
    }

    .date {
        color: #777;
        margin-bottom: 20px;
        font-size: 14px;
    }

    .content {
        font-size: 16px;
        line-height: 1.6;
        margin-bottom: 30px;
        white-space: pre-line;
    }

    h3 {
        color: #333;
        border-left: 5px solid #5BA0D0;
        padding-left: 10px;
        margin-top: 40px;
        margin-bottom: 20px;
    }

    .related-item {
        margin-bottom: 10px;
    }

    .related-item a {
        text-decoration: none;
        color: #0056d6;
        font-weight: bold;
    }

    .related-item a:hover {
        text-decoration: underline;
    }
</style>

</head>
<body>

<div class="news-container">

    <h2>${news.title}</h2>

    <p class="date">
        Ngày đăng:
        <fmt:formatDate value="${news.postedDate}" pattern="dd/MM/yyyy HH:mm:ss" />
    </p>

    <div class="content">
        ${news.content}
    </div>

    <h3>Tin liên quan</h3>

    <c:forEach var="item" items="${relatedNews}">
        <div class="related-item">
            <a href="${pageContext.request.contextPath}/trang-chu?page=chitiet&id=${item.id}">
                ${item.title}
            </a>
        </div>
    </c:forEach>

</div>

</body>
</html>

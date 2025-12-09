<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>${news.title}</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f5f5f5;
            padding: 30px;
            margin: 0;
        }

        .title {
            font-size: 32px;
            font-weight: bold;
            color: #0a3d91;
            margin-bottom: 15px;
            line-height: 1.3;
        }

        .news-container {
            background: #fff;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 3px 10px rgba(0,0,0,0.12);
            border-left: 5px solid #0a3d91;
        }

        .thumb {
            width: 100%;
            max-width: 600px;
            height: auto;
            border-radius: 8px;
            margin: 20px 0;
            display: block;
            box-shadow: 0 3px 8px rgba(0,0,0,0.15);
        }

        .meta {
            font-size: 14px;
            color: #666;
            margin-bottom: 20px;
        }

        .content {
            font-size: 18px;
            line-height: 1.75;
            color: #333;
            margin-top: 10px;
            text-align: justify;
        }

        h3 {
            margin-top: 40px;
            font-size: 20px;
            text-transform: uppercase;
            color: #0a3d91;
            border-left: 4px solid #0a3d91;
            padding-left: 10px;
        }

        ul {
            margin-top: 10px;
            padding-left: 20px;
        }

        ul li {
            margin-bottom: 8px;
            line-height: 1.5;
        }

        ul li a {
            text-decoration: none;
            color: #0a3d91;
            font-size: 16px;
        }

        ul li a:hover {
            text-decoration: underline;
        }

        .back-btn {
            display: inline-block;
            margin-top: 30px;
            font-size: 16px;
            color: #0a3d91;
            text-decoration: none;
            padding: 8px 14px;
            border-radius: 6px;
            border: 1px solid #0a3d91;
            transition: 0.2s;
        }

        .back-btn:hover {
            background: #0a3d91;
            color: #fff;
        }
    </style>
</head>

<body>

<div class="news-container">

    <!-- TIÊU ĐỀ -->
    <h2 class="title">${news.title}</h2>

    <!-- ẢNH -->
    <img class="thumb"
         src="${pageContext.request.contextPath}/images/${news.image}"
         alt="Thumbnail">

    <!-- META -->
    <div class="meta">
        Ngày đăng:
        <fmt:formatDate value="${news.createdDate}" pattern="dd/MM/yyyy" /> |
        Lượt xem: ${news.viewCount}
    </div>

    <!-- NỘI DUNG -->
    <div class="content">
        ${news.content}
    </div>

</div>

<!-- TIN CÙNG LOẠI -->
<h3>Tin cùng loại</h3>
<ul>
    <c:forEach items="${relatedNews}" var="item">
        <li>
            <a href="${pageContext.request.contextPath}/trang-chu?page=chitiet&id=${item.id}">
                ${item.title}
            </a>
        </li>
    </c:forEach>

    <c:if test="${empty relatedNews}">
        <li>Không có tin cùng loại.</li>
    </c:if>
</ul>

<!-- BACK -->
<a href="${pageContext.request.contextPath}/trang-chu?page=home" class="back-btn">
    ⬅ Quay lại Trang chủ
</a>

</body>
</html>

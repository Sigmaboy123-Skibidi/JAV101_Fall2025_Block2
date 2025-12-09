<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>VN News</title>

    <style>
        body {
            margin: 0;
            background: #f4f4f4;
            font-family: Arial, sans-serif;
        }

        /* HEADER */
        header {
            background: #0a3d91;
            padding: 22px;
            color: white;
            font-size: 26px;
            font-weight: bold;
            text-align: center;
            box-shadow: 0 3px 10px rgba(0,0,0,0.25);
        }

        /* MENU */
        nav {
            background: white;
            border-bottom: 2px solid #0a3d91;
            padding: 12px;
            text-align: center;
        }
        nav a {
            margin: 0 14px;
            font-size: 16px;
            text-decoration: none;
            font-weight: bold;
            color: #0a3d91;
        }
        nav a:hover {
            text-decoration: underline;
        }

        /* LAYOUT */
        .container {
            display: flex;
            width: 1200px;
            margin: 25px auto;
        }

        .content {
            flex: 1;
            background: white;
            padding: 25px;
            border-radius: 8px;
            box-shadow: 0 3px 10px rgba(0,0,0,0.12);
            border-left: 4px solid #0a3d91;
        }

        /* SIDEBAR */
        .sidebar {
            width: 260px;
            margin-left: 25px;
        }

        .box {
            padding: 15px;
            margin-bottom: 12px;
            font-weight: bold;
            text-align: center;
            color: white;
            border-radius: 6px;
            transition: 0.2s;
            box-shadow: 0 3px 8px rgba(0,0,0,0.18);
        }

        .box:hover {
            transform: translateX(3px);
            box-shadow: 0 5px 12px rgba(0,0,0,0.22);
        }

        .box1 { background: #fec42e; }
        .box2 { background: #888; }
        .box3 { background: #80c780; }

        /* LOGIN LINK */
        .login-link {
            width: 1200px;
            margin: auto;
            text-align: right;
            margin-top: 10px;
        }
        .login-link a {
            color: #0a3d91;
            font-weight: bold;
            text-decoration: none;
        }
        .login-link a:hover { text-decoration: underline; }

        /* FOOTER */
        footer {
            background: #0a3d91;
            padding: 25px;
            margin-top: 30px;
            color: white;
            text-align: center;
        }
        footer input {
            width: 260px;
            padding: 8px;
            border-radius: 4px;
            border: none;
            margin-right: 5px;
        }
        footer button {
            padding: 8px 14px;
            background: white;
            color: #0a3d91;
            border: none;
            border-radius: 4px;
            font-weight: bold;
            cursor: pointer;
        }
        footer button:hover {
            background: #e3e3e3;
        }

        footer .msg {
            margin-top: 10px;
            font-size: 14px;
            color: #ffe066;
        }

    </style>
</head>

<body>

<header>VN News</header>

<nav>
    <a href="${pageContext.request.contextPath}/trang-chu?page=home">Trang chủ</a> |
    <c:forEach var="cat" items="${categories}">
        <a href="${pageContext.request.contextPath}/trang-chu?page=category&id=${cat.id}">
            ${cat.name}
        </a> |
    </c:forEach>
</nav>

<div class="container">
    <div class="content">
        <c:choose>
            <c:when test="${not empty contentPage}">
                <jsp:include page="/views/client/${contentPage}" />
            </c:when>
            <c:otherwise>
                <p>Không có nội dung.</p>
            </c:otherwise>
        </c:choose>
    </div>

    <div class="sidebar">
        <a href="${pageContext.request.contextPath}/trang-chu?page=xemnhieu">
            <div class="box box1">5 bản tin xem nhiều nhất</div>
        </a>

        <a href="${pageContext.request.contextPath}/trang-chu?page=moinhat">
            <div class="box box2">5 bản tin mới nhất</div>
        </a>

        <a href="${pageContext.request.contextPath}/trang-chu?page=daxem">
            <div class="box box3">5 bản tin đã xem</div>
        </a>
    </div>
</div>

<div class="login-link">
    <a href="${pageContext.request.contextPath}/login">Đăng nhập</a>
</div>

<footer>
    <b>Nhà Báo Tin Tức</b>

    <form action="${pageContext.request.contextPath}/newsletter" method="post" style="margin-top:12px;">
        <input type="email" name="email" placeholder="Nhập email để nhận tin" required>
        <button type="submit">Đăng ký</button>
    </form>

    <c:if test="${not empty msg}">
        <div class="msg">${msg}</div>
    </c:if>
</footer>

</body>
</html>

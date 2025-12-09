<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản trị tin tức</title>

    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: #eef2f7;
        }

        /* HEADER */
        .admin-header {
            background: #0046b5;
            padding: 22px;
            text-align: center;
            color: white;
            font-size: 24px;
            font-weight: bold;
            letter-spacing: 1px;
            box-shadow: 0 2px 6px rgba(0,0,0,0.2);
        }

        /* MENU */
        .admin-menu {
            background: #ffffff;
            padding: 14px 0;
            text-align: center;
            border-bottom: 1px solid #ddd;
            box-shadow: 0 2px 4px rgba(0,0,0,0.05);
        }

        .admin-menu a {
            color: #0046b5;
            text-decoration: none;
            margin: 0 12px;
            font-size: 16px;
            font-weight: bold;
        }

        .admin-menu a:hover {
            text-decoration: underline;
            color: #0077ff;
        }

        /* CONTENT BOX */
        .admin-content {
            max-width: 1050px;
            margin: 35px auto;
            background: white;
            border: 1px solid #ccc;
            border-radius: 12px;
            padding: 30px;
            min-height: 480px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.08);
            animation: fadeIn 0.35s ease-in-out;
        }

        /* Animation */
        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(10px); }
            to { opacity: 1; transform: translateY(0); }
        }
    </style>
</head>
<body>

<div class="admin-header">
    CÔNG CỤ QUẢN TRỊ TIN TỨC
</div>

<div class="admin-menu">
    <a href="${pageContext.request.contextPath}/admin/home">Trang chủ</a>
    |
    <a href="${pageContext.request.contextPath}/admin/news">Tin tức</a>
    |
    <a href="${pageContext.request.contextPath}/admin/categories">Loại tin</a>

    <c:if test="${sessionScope.user.id == 'admin'}">
        |
        <a href="${pageContext.request.contextPath}/admin/users">Người dùng</a>
        |
        <a href="${pageContext.request.contextPath}/admin/newsletter">Newsletter</a>
    </c:if>

    |
    <a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
</div>

<div class="admin-content">
    <jsp:include page="${page}" />
</div>

</body>
</html>

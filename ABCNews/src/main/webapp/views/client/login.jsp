<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>

<style>
    body {
        font-family: Arial;
        background: #f4f4f4;
        margin: 0;
    }

    .login-container {
        width: 400px;
        margin: 60px auto;
        background: white;
        padding: 25px;
        border: 1px solid #ddd;
        border-radius: 6px;
    }

    h2 {
        margin-top: 0;
        text-align: center;
        color: #5BA0D0;
    }

    label {
        font-weight: bold;
        color: #333;
    }

    input[type="text"], input[type="password"] {
        width: 100%;
        padding: 10px;
        margin-top: 6px;
        margin-bottom: 16px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    button {
        width: 100%;
        padding: 10px;
        background: #5BA0D0;
        border: none;
        font-size: 16px;
        color: white;
        border-radius: 4px;
        cursor: pointer;
        font-weight: bold;
    }

    button:hover {
        background: #4a8ab8;
    }

    .back-btn {
        display: inline-block;
        margin-top: 14px;
        text-decoration: none;
        color: #0056d6;
        font-weight: bold;
    }

    .back-btn:hover {
        text-decoration: underline;
    }

    .error-msg {
        color: red;
        text-align: center;
        margin-bottom: 15px;
        font-weight: bold;
    }
</style>

</head>
<body>

<div class="login-container">
    <h2>Đăng nhập hệ thống</h2>

    <p class="error-msg">
        <c:out value="${error}" />
    </p>

    <form method="post" action="${pageContext.request.contextPath}/login">

        <label>Mã đăng nhập:</label>
        <input type="text" name="id" required>

        <label>Mật khẩu:</label>
        <input type="password" name="password" required>

        <button type="submit">Login</button>
    </form>

    <a href="trang-chu?page=home" class="back-btn">⬅ Quay lại Trang chủ</a>
</div>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<style>
    body {
        font-family: Arial, sans-serif;
        background: #f5f5f5;
        margin: 20px;
    }

    h2 {
        color: #333;
        margin-bottom: 20px;
    }

    form {
        background: #fff;
        padding: 20px;
        width: 400px;
        border-radius: 8px;
        box-shadow: 0 2px 6px rgba(0,0,0,0.1);
    }

    label {
        font-weight: bold;
        color: #333;
    }

    input[type="text"] {
        width: 100%;
        padding: 10px;
        margin-top: 5px;
        border: 1px solid #ccc;
        border-radius: 4px;
        font-size: 15px;
    }

    button {
        margin-top: 15px;
        padding: 10px 18px;
        background: #007bff;
        color: #fff;
        border: none;
        border-radius: 4px;
        font-size: 15px;
        cursor: pointer;
        font-weight: bold;
    }

    button:hover {
        background: #0069d9;
    }

    .back-link {
        display: inline-block;
        margin-top: 15px;
        text-decoration: none;
        color: #555;
        font-weight: bold;
    }

    .back-link:hover {
        color: #000;
        text-decoration: underline;
    }
</style>

<h2>${category.id == null ? "Thêm loại tin" : "Sửa loại tin"}</h2>

<form action="${pageContext.request.contextPath}/admin/categories" method="post">

    <!-- Chỉ gửi id khi khác null và >0 -->
    <c:if test="${category.id != null && category.id > 0}">
        <input type="hidden" name="id" value="${category.id}">
    </c:if>

    <label>Tên loại:</label><br>
    <input type="text" name="name" required value="${category.name}"><br>

    <button type="submit">Lưu</button>
</form>

<a class="back-link" href="${pageContext.request.contextPath}/admin/categories">
    ← Quay lại
</a>

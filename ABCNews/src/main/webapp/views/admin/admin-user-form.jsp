<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!-- ======================= CSS trực tiếp ======================= -->
<style>
    body {
        font-family: Arial, sans-serif;
        background: #f5f6fa;
        margin: 0;
        padding: 20px;
    }

    h2 {
        color: #333;
        margin-bottom: 20px;
    }

    form {
        background: #ffffff;
        padding: 20px 25px;
        max-width: 500px;
        border-radius: 10px;
        box-shadow: 0 4px 12px rgba(0,0,0,0.1);
    }

    label {
        font-weight: bold;
        display: block;
        margin-bottom: 6px;
        color: #444;
    }

    input[type="text"],
    input[type="password"],
    input[type="date"],
    input[type="email"],
    select {
        width: 100%;
        padding: 10px 12px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 6px;
        outline: none;
        transition: 0.2s;
        font-size: 15px;
    }

    input:focus,
    select:focus {
        border-color: #007bff;
        box-shadow: 0 0 5px rgba(0,123,255,0.4);
    }

    button {
        background: #007bff;
        padding: 10px 18px;
        border: none;
        border-radius: 6px;
        color: white;
        font-size: 16px;
        cursor: pointer;
        transition: 0.2s;
        width: 100%;
        margin-top: 10px;
    }

    button:hover {
        background: #0056b3;
    }

    a {
        display: inline-block;
        margin-top: 15px;
        text-decoration: none;
        color: #007bff;
        font-size: 15px;
    }

    a:hover {
        text-decoration: underline;
    }
</style>
<!-- ======================= END CSS ======================= -->


<h2>${user.id == null ? "Thêm user" : "Sửa user"}</h2>

<form action="${pageContext.request.contextPath}/admin/users" method="post">
    <input type="hidden" name="action" value="${user.id == null ? 'create' : 'edit'}">

    <!-- Chỉ dùng hidden ID khi EDIT -->
    <c:if test="${user.id != null}">
        <input type="hidden" name="id" value="${user.id}">
    </c:if>

    <label>Id:</label><br>
    <input 
        type="text" 
        name="id"
        value="${user.id}"
        ${user.id != null ? 'readonly' : ''}
        required
    ><br><br>

    <label>Fullname:</label><br>
    <input type="text" name="fullname" required value="${user.fullname}"><br><br>

    <label>Password:</label><br>
    <input type="password" name="password" required value="${user.password}"><br><br>

    <label>Birthday:</label><br>
    <input type="date" name="birthday" value="${user.birthday}"><br><br>

    <label>Gender:</label><br>
    <select name="gender">
        <option value="1" ${user.gender ? 'selected' : ''}>Nam</option>
        <option value="0" ${!user.gender ? 'selected' : ''}>Nữ</option>
    </select><br><br>

    <label>Mobile:</label><br>
    <input type="text" name="mobile" value="${user.mobile}"><br><br>

    <label>Email:</label><br>
    <input type="email" name="email" value="${user.email}"><br><br>

    <label>Role:</label><br>
    <select name="role">
        <option value="1" ${user.role != null && user.role == true ? 'selected' : ''}>Admin</option>
        <option value="0" ${user.role != null && user.role == false ? 'selected' : ''}>User</option>
    </select>

    <button type="submit">Lưu</button>
</form>

<br>
<a href="${pageContext.request.contextPath}/admin/users">Quay lại danh sách</a>

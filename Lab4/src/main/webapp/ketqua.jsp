<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kết quả</title>
</head>
<body>

<h2>Kết quả đăng ký</h2>

Họ tên: ${fullname}<br>
Mật khẩu: ${password}<br>
Giới tính: ${gender}<br>
Tình trạng hôn nhân: ${married}<br>
Quốc tịch: ${country}<br>
Ghi chú: ${note}<br><br>

Sở thích:
<ul>
<c:forEach items="${hobbies}" var="h">
    <li>${h}</li>
</c:forEach>
</ul>

Ảnh đại diện: <br>
<img src="uploads/${photo}" width="200">

</body>
</html>

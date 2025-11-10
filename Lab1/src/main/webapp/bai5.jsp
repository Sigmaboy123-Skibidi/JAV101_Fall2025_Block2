<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab1</title>
</head>
<body>
<img src="Logo.jpg"/>
<hr/>
<jsp:include page="menu.jsp"></jsp:include>
<hr/>
<h1>Tính tổng 2 số</h2>

    <form action="bai5" method="post">
        <label>Nhập số A:</label>
        <input type="text" name="txta" value="${param.txta}"><br><br>

        <label>Nhập số B:</label>
        <input type="text" name="txtb" value="${param.txtb}"><br><br>

        <button type="submit">Tính tổng</button>
    </form>

    <hr>

    Hiển thị kết quả nếu có
    <c:if test="${not empty kq}">
        <p>Kết quả: ${kq}</p>
    </c:if>

    Hiển thị lỗi nếu có
    <c:if test="${not empty error}">
        <p style="color:red;">${error}</p>
    </c:if>
</body>
</html>
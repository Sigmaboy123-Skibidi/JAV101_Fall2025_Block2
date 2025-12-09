<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="menu5.jsp"></jsp:include>
<form action="${pageContext.request.contextPath}/lab5Login" method="post">
    <input name="username" value="${username != null ? username : ''}">
    <br>
    <input name="password" value="${password != null ? password : ''}">
    <br>
    <input type="checkbox" name="remember-me"> Remember me?
    <button>Login</button>
</form>
</body>
</html>
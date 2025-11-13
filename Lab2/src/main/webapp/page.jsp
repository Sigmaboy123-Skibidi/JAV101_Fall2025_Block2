<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab2</title>
</head>
<body>
<hr>
<h1>${message}</h1>
<h2>${now.date}</h2> <!-- now.getDate() -->
</hr>
<h2>${message}</h2>
<jsp:include page="/user-info.jsp"/>
</body>
</html>
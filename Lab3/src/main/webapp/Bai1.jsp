<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr/>
<jsp:include page="menu.jsp"></jsp:include>
<hr/>
<h2>Chọn quốc gia:</h2>
<select name="Country">
<c:forEach var="ct" items="${countries}">
<option value="${ct.id}">${ct.name}</option>
</c:forEach>
</select>
</body>
</html>
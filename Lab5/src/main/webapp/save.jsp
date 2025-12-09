<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Saved Staff</title>
</head>
<body>

    <h2>Saved Staff information</h2>

    <p><b>Fullname:</b> ${form.fullname}</p>
    <p><b>Birthday:</b> ${form.birthday}</p>
    <p><b>Gender:</b> 
        <c:choose>
            <c:when test="${form.gender}">Male</c:when>
            <c:otherwise>Female</c:otherwise>
        </c:choose>
    </p>

    <p><b>Country:</b> ${form.country}</p>
    <p><b>Salary:</b> ${form.salary}</p>

    <p><b>Hobbies:</b></p>
    <c:if test="${form.hobbies != null}">
        <ul>
            <c:forEach var="h" items="${form.hobbies}">
                <li>${h}</li>
            </c:forEach>
        </ul>
    </c:if>

    <br><br>
    <a href="L5_B1.jsp">⬅ Quay lại </a>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Send Email</title>
</head>
<body>
<jsp:include page="menu5.jsp"></jsp:include>
    <h2>Send Email</h2>

    <c:url var="url" value="/send" />

    <form action="${url}" method="post">
        From: <input name="from"> <br><br>
        To: <input name="to"> <br><br>
        Subject: <input name="subject"> <br><br>
        Body: <textarea name="body" rows="5"></textarea> <br><br>

        <button type="submit">Send</button>
    </form>

</body>
</html>

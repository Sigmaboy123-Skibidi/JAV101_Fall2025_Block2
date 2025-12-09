<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    h2 {
        font-size: 26px;
        font-weight: bold;
        color: #0046b5;
        text-align: center;
        margin-bottom: 25px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 15px;
        border-radius: 8px;
        overflow: hidden;
        font-family: Arial;
        font-size: 14px;
    }

    th {
        background: #6fa8dc;
        color: white;
        padding: 12px;
        text-align: center;
        font-weight: bold;
    }

    td {
        padding: 10px;
        border-bottom: 1px solid #ddd;
        text-align: center;
        color: #333;
    }

    tr:hover {
        background: #f1f7ff;
    }

    .action-del {
        color: #d00;
        font-weight: bold;
        text-decoration: none;
    }
    .action-del:hover {
        text-decoration: underline;
    }
</style>

<h2>Danh sách Email đăng ký nhận tin</h2>

<table>
    <tr>
        <th>ID</th>
        <th>Email</th>
        <th>Hành động</th>
    </tr>

    <c:forEach var="n" items="${list}">
        <tr>
            <td>${n.id}</td>
            <td>${n.email}</td>
            <td>
                <a class="action-del"
                   href="${pageContext.request.contextPath}/admin/newsletter/delete?id=${n.id}"
                   onclick="return confirm('Bạn có chắc muốn xóa email này?');">
                    Xóa
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

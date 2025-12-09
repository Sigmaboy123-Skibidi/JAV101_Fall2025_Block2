<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<style>
    body {
        font-family: Arial, sans-serif;
        background: #f5f5f5;
        margin: 20px;
    }

    h2 {
        color: #333;
        margin-bottom: 15px;
    }

    .btn-add {
        display: inline-block;
        padding: 8px 14px;
        background: #28a745;
        color: white;
        text-decoration: none;
        border-radius: 4px;
        font-weight: bold;
    }

    .btn-add:hover {
        background: #218838;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        background: white;
        box-shadow: 0 2px 4px rgba(0,0,0,0.1);
    }

    th {
        background: #4CAF50;
        color: white;
        padding: 10px;
        text-align: left;
    }

    td {
        padding: 10px;
        border-bottom: 1px solid #ddd;
    }

    tr:hover {
        background: #f1f1f1;
    }

    a.action-link {
        color: #007bff;
        text-decoration: none;
        font-weight: bold;
    }

    a.action-link:hover {
        text-decoration: underline;
    }

    .delete {
        color: #dc3545;
    }
</style>

<h2>Quản lý loại tin</h2>

<a class="btn-add" href="${pageContext.request.contextPath}/admin/categories?action=create">
    + Thêm loại tin mới
</a>

<table>
    <tr>
        <th>Mã loại</th>
        <th>Tên loại</th>
        <th>Hành động</th>
    </tr>

    <c:forEach var="c" items="${categories}">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>
                <a class="action-link" 
                   href="${pageContext.request.contextPath}/admin/categories?action=edit&id=${c.id}">
                    Sửa
                </a>
                &nbsp;|&nbsp;
                <a class="action-link delete"
                   href="${pageContext.request.contextPath}/admin/categories?action=delete&id=${c.id}"
                   onclick="return confirm('Xóa loại tin này?');">
                    Xóa
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

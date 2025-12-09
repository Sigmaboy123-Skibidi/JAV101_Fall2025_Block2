<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!-- ======================= CSS TRỰC TIẾP ======================= -->
<style>
    body {
        font-family: Arial, sans-serif;
        background: #f4f6f9;
        padding: 20px;
    }

    h2 {
        margin-bottom: 15px;
        color: #333;
    }

    a.add-btn {
        display: inline-block;
        background: #28a745;
        padding: 10px 14px;
        color: white;
        text-decoration: none;
        border-radius: 6px;
        font-size: 14px;
    }

    a.add-btn:hover {
        background: #218838;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        background: white;
        margin-top: 20px;
        border-radius: 8px;
        overflow: hidden;
        box-shadow: 0 3px 12px rgba(0,0,0,0.1);
    }

    th {
        background: #6fa8dc;
        color: white;
        padding: 12px;
        text-align: left;
        font-size: 15px;
    }

    td {
        padding: 10px;
        border-bottom: 1px solid #eee;
        font-size: 14px;
    }

    tr:hover td {
        background: #f1f7ff;
    }

    a.action-link {
        color: #007bff;
        text-decoration: none;
        margin: 0 4px;
    }

    a.action-link:hover {
        text-decoration: underline;
    }

    .delete-link {
        color: #dc3545;
    }

    .delete-link:hover {
        text-decoration: underline;
    }
</style>
<!-- ======================= END CSS ======================= -->

<h2>Quản lý user</h2>

<a class="add-btn" href="${pageContext.request.contextPath}/admin/users?action=create">
    + Thêm user mới
</a>

<table>
    <tr>
        <th>ID</th>
        <th>Fullname</th>
        <th>Birthday</th>
        <th>Gender</th>
        <th>Mobile</th>
        <th>Email</th>
        <th>Role</th>
        <th>Hành động</th>
    </tr>

    <c:forEach var="u" items="${users}">
        <tr>
            <td>${u.id}</td>
            <td>${u.fullname}</td>
            <td>${u.birthday}</td>
            <td>${u.gender ? 'Nam' : 'Nữ'}</td>
            <td>${u.mobile}</td>
            <td>${u.email}</td>
            <td>${u.role ? 'Admin' : 'User'}</td>
            <td>
                <a class="action-link" 
                   href="${pageContext.request.contextPath}/admin/users?action=edit&id=${u.id}">
                    Sửa
                </a>

                |

                <a class="action-link delete-link"
                   href="${pageContext.request.contextPath}/admin/users?action=delete&id=${u.id}"
                   onclick="return confirm('Xóa user này?');">
                    Xóa
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

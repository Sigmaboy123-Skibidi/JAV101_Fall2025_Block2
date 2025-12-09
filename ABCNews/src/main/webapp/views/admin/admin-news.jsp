<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
    h2 {
        font-size: 26px;
        color: #0046b5;
        text-align: center;
        margin-bottom: 25px;
    }

    /* Nút thêm mới */
    .add-btn {
        display: inline-block;
        padding: 10px 16px;
        background: #0046b5;
        color: #fff;
        text-decoration: none;
        border-radius: 6px;
        font-weight: bold;
        margin-bottom: 20px;
    }
    .add-btn:hover {
        background: #0062ff;
    }

    /* Bảng tin tức */
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 10px;
        border-radius: 8px;
        overflow: hidden;
        font-size: 14px;
    }

    th {
        background: #6fa8dc;
        color: white;
        padding: 12px;
        text-align: center;
    }

    td {
        padding: 10px;
        border-bottom: 1px solid #ddd;
        text-align: center;
    }

    tr:hover {
        background: #f1f7ff;
    }

    /* Liên kết trong bảng */
    a.action-link {
        color: #0046b5;
        text-decoration: none;
        font-weight: bold;
    }
    a.action-link:hover {
        text-decoration: underline;
    }
</style>

<h2>Quản lý Tin tức</h2>

<a class="add-btn" href="${pageContext.request.contextPath}/admin/news/create">
    + Thêm tin mới
</a>

<table>
    <tr>
        <th>ID</th>
        <th>Tiêu đề</th>
        <th>Ảnh</th>
        <th>Ngày</th>
        <th>Loại</th>
        <th>Hành động</th>
    </tr>

    <c:forEach var="n" items="${newsList}">
        <tr>
            <td>${n.id}</td>
            <td>${n.title}</td>
            <td>${n.image}</td>
            <td>${n.postedDate}</td>
            <td>
                <c:forEach var="c" items="${categories}">
                    <c:if test="${c.id == n.categoryId}">
                        ${c.name}
                    </c:if>
                </c:forEach>
            </td>
            <td>
                <a class="action-link"
                   href="${pageContext.request.contextPath}/admin/news/edit?id=${n.id}">
                    Sửa
                </a>
                |
                <a class="action-link"
                   href="${pageContext.request.contextPath}/admin/news/delete?id=${n.id}"
                   onclick="return confirm('Xóa tin này?')">
                    Xóa
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

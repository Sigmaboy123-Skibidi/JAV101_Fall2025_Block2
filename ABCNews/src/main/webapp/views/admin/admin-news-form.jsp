<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
    h2 {
        font-size: 26px;
        font-weight: bold;
        color: #0046b5;
        text-align: center;
        margin-bottom: 25px;
    }

    form {
        max-width: 650px;
        margin: 0 auto;
        background: #ffffff;
        padding: 25px 35px;
        border-radius: 12px;
        border: 1px solid #ccc;
        box-shadow: 0 4px 10px rgba(0,0,0,0.08);
    }

    label {
        font-size: 15px;
        font-weight: bold;
        color: #0046b5;
    }

    input[type="text"],
    textarea,
    select {
        width: 100%;
        padding: 10px;
        margin-top: 6px;
        margin-bottom: 18px;
        border-radius: 6px;
        border: 1px solid #ccc;
        font-size: 14px;
        font-family: Arial;
    }

    input:focus,
    textarea:focus,
    select:focus {
        outline: none;
        border-color: #0062ff;
        box-shadow: 0 0 5px rgba(0, 98, 255, .4);
    }

    .btn-save {
        background: #0046b5;
        color: white;
        padding: 10px 18px;
        border-radius: 6px;
        border: none;
        font-size: 15px;
        cursor: pointer;
        font-weight: bold;
        margin-right: 10px;
    }
    .btn-save:hover {
        background: #0062ff;
    }

    .btn-cancel {
        text-decoration: none;
        padding: 10px 16px;
        border-radius: 6px;
        background: #ddd;
        color: #333;
        font-weight: bold;
    }
    .btn-cancel:hover {
        background: #c0c0c0;
    }

    .error {
        color: red;
        font-size: 14px;
        text-align: center;
        margin-bottom: 15px;
        font-weight: bold;
    }
</style>

<h2>
    <c:choose>
        <c:when test="${not empty news}">
            Sửa tin tức
        </c:when>
        <c:otherwise>
            Thêm tin tức mới
        </c:otherwise>
    </c:choose>
</h2>

<c:if test="${not empty error}">
    <p class="error">${error}</p>
</c:if>

<form method="post"
      action="<c:choose>
                  <c:when test='${not empty news}'>
                      ${pageContext.request.contextPath}/admin/news/edit
                  </c:when>
                  <c:otherwise>
                      ${pageContext.request.contextPath}/admin/news/create
                  </c:otherwise>
              </c:choose>">

    <c:if test="${not empty news}">
        <input type="hidden" name="id" value="${news.id}" />
    </c:if>

    <label>Tiêu đề:</label>
    <input type="text" name="title" value="${news.title}" required />

    <label>Nội dung:</label>
    <textarea name="content" rows="6" required>${news.content}</textarea>

    <label>Ảnh (URL):</label>
    <input type="text" name="image" value="${news.image}" />

    <label>Loại tin:</label>
    <select name="categoryId" required>
        <c:forEach var="c" items="${categories}">
            <option value="${c.id}" 
                <c:if test="${news.categoryId == c.id}">selected</c:if>>
                ${c.name}
            </option>
        </c:forEach>
    </select>

    <button type="submit" class="btn-save">Lưu</button>
    <a href="${pageContext.request.contextPath}/admin/news" class="btn-cancel">Hủy</a>
</form>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Trang Chủ</title>

<style>
    body {
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
        background: #f4f6f9;
    }

    /* Header */
    .header {
        background: #0046b5;
        padding: 15px 40px;
        color: white;
        font-size: 20px;
        font-weight: bold;
        display: flex;
        justify-content: space-between;
        align-items: center;
        box-shadow: 0 2px 5px rgba(0,0,0,0.15);
    }

    .logout {
        color: #ffe082;
        font-weight: bold;
        text-decoration: none;
    }
    .logout:hover { text-decoration: underline; }

    .container {
        padding: 30px 60px;
    }

    h2 {
        font-size: 26px;
        font-weight: bold;
        color: #0046b5;
        margin-bottom: 25px;
        text-align: center;
    }

    /* Một bài viết */
    .news-card {
        background: #ffffff;
        padding: 20px;
        border-radius: 8px;
        display: flex;
        margin-bottom: 25px;
        align-items: flex-start;
        box-shadow: 0 3px 6px rgba(0,0,0,0.10);
        transition: 0.2s;
    }

    .news-card:hover {
        transform: translateY(-3px);
        box-shadow: 0 4px 10px rgba(0,0,0,0.15);
    }

    .thumbnail {
        width: 100px;
        height: 100px;
        background: #8ab4d8;
        color: white;
        font-size: 18px;
        font-weight: bold;
        display: flex;
        justify-content: center;
        align-items: center;
        margin-right: 20px;
        border-radius: 6px;
    }

    .title {
        font-size: 20px;
        font-weight: bold;
        color: #0046b5;
        text-decoration: none;
    }
    .title:hover {
        text-decoration: underline;
    }

    .desc {
        font-size: 15px;
        margin: 8px 0;
        color: #333;
        line-height: 1.4;
    }

    .meta {
        font-size: 13px;
        color: #777;
        font-style: italic;
        margin-top: 5px;
    }
</style>

</head>
<body>

<!-- 🔵 HEADER -->
<div class="header">
    <div>Trang Chủ Tin Tức</div>

    <div>
        Xin chào, ${sessionScope.user.fullname} |
        <a class="logout" href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
    </div>
</div>

<div class="container">

    <h2>Bản tin nổi bật</h2>

    <!-- Bài viết 1 -->
    <div class="news-card">
        <div class="thumbnail">Ảnh</div>
        <div>
            <a class="title" href="${pageContext.request.contextPath}/admin/chitiet?id=1">
                Mưa lũ miền Trung gây thiệt hại nặng
            </a>
            <div class="desc">
                (Dân trí) - Mưa lũ miền Trung gây thiệt hại nặng...
            </div>
            <div class="meta">20/11/2025 | Vũ Đức Tín</div>
        </div>
    </div>

    <!-- Bài viết 2 -->
    <div class="news-card">
        <div class="thumbnail">Ảnh</div>
        <div>
            <a class="title" href="${pageContext.request.contextPath}/admin/chitiet?id=2">
                Đội tuyển Việt Nam tăng 1 bậc trên BXH FIFA
            </a>
            <div class="desc">
                Đội tuyển Việt Nam thi đấu xuất sắc và vươn lên thứ hạng mới...
            </div>
            <div class="meta">21/11/2025 | Phạm Quốc Trung</div>
        </div>
    </div>

    <!-- Bài viết 3 -->
    <div class="news-card">
        <div class="thumbnail">Ảnh</div>
        <div>
            <a class="title" href="${pageContext.request.contextPath}/admin/chitiet?id=3">
                Văn hóa truyền thống – giá trị được lưu giữ
            </a>
            <div class="desc">
                Văn hóa truyền thống là tổng hòa các giá trị, phong tục...
            </div>
            <div class="meta">22/11/2025 | Dương Quang Trung</div>
        </div>
    </div>

</div>

</body>
</html>

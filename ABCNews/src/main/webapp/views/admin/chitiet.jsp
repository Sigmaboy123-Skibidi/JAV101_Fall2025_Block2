<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    // Lấy id từ URL
    String id = request.getParameter("id");
    int index = (id != null) ? Integer.parseInt(id) - 1 : 0;

    String[] titles = {
        "Mưa lũ miền Trung gây thiệt hại nặng",
        "Đội tuyển Việt Nam tăng 1 bậc trên BXH FIFA",
        "Văn hóa truyền thống – giá trị được lưu giữ"
    };

    String[] shortContents = {
        "(Dân trí) - Mưa lũ ở các tỉnh miền Trung đã khiến 41 người tử vong, 9 người mất tích; 167 nhà bị hư hỏng, hơn 52.000 nhà đang bị ngập...",
        "Theo Liên đoàn Bóng đá Việt Nam, đội tuyển Việt Nam tăng 1 bậc lên hạng 110 trên bảng xếp hạng FIFA tháng 11/2025...",
        "Văn hóa truyền thống là gì, những truyền thống văn hóa Việt Nam?..."
    };

    String[] fullContents = {
        "(Dân trí) - Mưa lũ ở các tỉnh miền Trung đã khiến 41 người tử vong, 9 người mất tích; 167 nhà bị hư hỏng..."
        + "<br><br>Chiến thắng trước Đội tuyển Lào cũng là trận đấu cuối cùng của Đội tuyển Việt Nam trong năm 2025..."
        + "<br><br>Được biết, sau khi hoàn thành nhiệm vụ quốc gia, các cầu thủ sẽ trở về CLB chủ quản...",
        
        "Đội tuyển Việt Nam đã tăng 1 bậc lên hạng 110 thế giới sau trận thắng trước Lào..."
        + "<br><br>Sau khi hoàn thành nhiệm vụ quốc gia, các cầu thủ trở về CLB chủ quản...",
        
        "Văn hóa truyền thống là tập hợp gồm các giá trị, phong tục, niềm tin và lối sống đã được lưu truyền..."
    };

    String[] dates = { "20/11/2025", "21/11/2025", "22/11/2025" };
    String[] authors = { "Nguyễn Võ Hoài Nam", "Nguyễn Tiến Hùng", "Võ Vinh Quang" };

    if (index < 0 || index >= titles.length) index = 0;
%>

<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title><%= titles[index] %></title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: #f5f5f5;
        padding: 30px;
        margin: 0;
    }

    .container {
        max-width: 900px;
        margin: auto;
        background: #fff;
        padding: 25px 35px;
        border-radius: 8px;
        box-shadow: 0 4px 16px rgba(0,0,0,0.1);
    }

    .title {
        font-size: 30px;
        font-weight: bold;
        color: #0a3d91;
        margin-bottom: 15px;
        line-height: 1.3;
    }

    .summary-box {
        display: flex;
        margin-top: 15px;
        padding-bottom: 15px;
        border-bottom: 2px solid #e6e6e6;
    }

    .thumb {
        width: 260px;
        height: 190px;
        background: #bdd7ee;
        color: #0a3d91;
        display: flex;
        justify-content: center;
        align-items: center;
        font-size: 22px;
        font-weight: bold;
        border-radius: 6px;
        margin-right: 25px;
    }

    .summary-text {
        font-size: 17px;
        line-height: 1.6;
    }

    .full-text {
        margin-top: 20px;
        font-size: 17px;
        line-height: 1.7;
        text-align: justify;
    }

    .meta {
        font-size: 14px;
        color: #666;
        margin-top: 15px;
        font-style: italic;
        text-align: right;
    }

    h3 {
        margin-top: 40px;
        font-size: 20px;
        color: #0a3d91;
        text-transform: uppercase;
    }

    ul li {
        margin: 8px 0;
    }

    ul li a {
        text-decoration: none;
        color: #0066cc;
        font-size: 16px;
    }

    ul li a:hover {
        text-decoration: underline;
    }

    .back-btn {
        display: inline-block;
        margin-top: 25px;
        background: #0a3d91;
        padding: 10px 16px;
        color: white;
        text-decoration: none;
        border-radius: 5px;
        transition: 0.2s;
    }

    .back-btn:hover {
        background: #08407a;
    }
</style>

</head>

<body>

<div class="container">

    <h2 class="title"><%= titles[index] %></h2>

    <div class="summary-box">
        <div class="thumb">Ảnh</div>

        <div class="summary-text">
            <%= shortContents[index] %>
        </div>
    </div>

    <div class="full-text">
        <%= fullContents[index] %>
    </div>

    <div class="meta">
        <%= dates[index] %> | <%= authors[index] %>
    </div>

    <h3>Tin cùng loại</h3>

    <ul>
        <li><a href="${pageContext.request.contextPath}/views/admin/chitiet.jsp?id=1">Tin 1</a></li>
        <li><a href="${pageContext.request.contextPath}/views/admin/chitiet.jsp?id=2">Tin 2</a></li>
        <li><a href="${pageContext.request.contextPath}/views/admin/chitiet.jsp?id=3">Tin 3</a></li>
    </ul>

    <a href="${pageContext.request.contextPath}/admin/home" class="back-btn">
        ⬅ Quay lại Trang chủ
    </a>

</div>

</body>
</html>

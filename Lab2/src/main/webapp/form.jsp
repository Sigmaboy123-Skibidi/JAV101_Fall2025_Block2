<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Form Demo</title>
</head>
<body>

<jsp:include page="menu.jsp" />

<h2>Thông tin người dùng</h2>

<form method="post">
    <label>Họ và tên:</label>
    <input type="text" name="fullname" value="${user.fullname}" /> 
    <br><br>

    <label>Giới tính:</label>
    <input type="radio" name="gender" value="true" 
           ${user.gender ? "checked" : ""}/> Nam
    <input type="radio" name="gender" value="false" 
           ${!user.gender ? "checked" : ""}/> Nữ
    <br><br>

    <label>Quốc gia:</label>
    <select name="country">
        <option value="VN" ${user.country == "VN" ? "selected" : ""}>Việt Nam</option>
        <option value="US" ${user.country == "US" ? "selected" : ""}>Mỹ</option>
        <option value="JP" ${user.country == "JP" ? "selected" : ""}>Nhật Bản</option>
    </select>
    <br><br>

    <!-- Các nút hành động -->
    <button formaction="form/create">Create</button>
    <button formaction="form/ud">Update</button>
</form>

</body>
</html>


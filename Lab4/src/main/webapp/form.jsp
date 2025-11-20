<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
</head>
<body>

<h2>Đăng ký</h2>

<form method="post" action="add" enctype="multipart/form-data">

    Họ tên:
    <input name="fullname"><br><br>

    Mật khẩu:
    <input type="password" name="password"><br><br>

    Giới tính:
    <input type="radio" name="gender" value="Nam"> Nam
    <input type="radio" name="gender" value="Nữ"> Nữ
    <br><br>

    Đã có gia đình?
    <input type="checkbox" name="married" value="true">
    <br><br>

    Quốc tịch:
    <select name="country">
        <option>United States</option>
        <option>Vietnam</option>
        <option>Japan</option>
    </select>
    <br><br>

    Sở thích:
    <input type="checkbox" name="hobbies" value="Đọc sách"> Đọc sách
    <input type="checkbox" name="hobbies" value="Du lịch"> Du lịch
    <input type="checkbox" name="hobbies" value="Âm nhạc"> Âm nhạc
    <input type="checkbox" name="hobbies" value="Khác"> Khác
    <br><br>

    Ghi chú: <br>
    <textarea name="note" rows="5" cols="40"></textarea>
    <br><br>

    Ảnh đại diện:
    <input type="file" name="photo_file">
    <br><br>

    <button>Đăng ký</button>

</form>

</body>
</html>

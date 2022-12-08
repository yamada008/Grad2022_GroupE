<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>農地掲載</title>
</head>
<body>
<form action="/SotsukenE/Main" method="post" enctype="multipart/form-data">
名前:<input type="text" name="name"><br>
住所:<input type="text" name="word"><br>
農地写真:<input type="file" name="pict"><br>
<button type="submit">送信</button>
</form>
</body>
</html>
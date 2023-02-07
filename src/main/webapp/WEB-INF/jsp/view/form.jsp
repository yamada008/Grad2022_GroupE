<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>農地</title>
</head>
<body>
<form action="/SotsukenE/Main" method="post" enctype="multipart/form-data">
userID:<input type="text" name="id"><br>
名前:<input type="text" name="name"><br>
住所:<input type="text" name="word"><br>
広さ:<input type="text" name="breadth"><br>

好きな写真:<input type="file" name="pict"><br>
<button type="submit">送信</button>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id=(String)request.getAttribute("id");
	String name=(String)request.getAttribute("name");
	String word=(String)request.getAttribute("word");
	String breadth=(String)request.getAttribute("breadth");
	String filename=(String)request.getAttribute("filename");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fileupload</title>

</head>
<body>
<h1>※写真はサンプルです</h1>
<p>userID:<%=id %></p>
<p>名前:<%=name %></p>
<p>住所:<%=word %></p>
<p>広さ:<%=breadth %></p>
<p>畑の写真:<br><img src="/SotsukenE/upload/<%=filename %>"></p>
</body>
</html>
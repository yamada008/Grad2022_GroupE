<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name=(String)request.getAttribute("name");
	String word=(String)request.getAttribute("word");
	String filename=(String)request.getAttribute("filename");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>農地掲載</title>
</head>
<body>
<p>名前:<%=name %></p>
<p>住所:<%=word %></p>
<p>農地写真:<br><img src="/fileupload/upload/<%=filename %>"></p>
</body>
</html>
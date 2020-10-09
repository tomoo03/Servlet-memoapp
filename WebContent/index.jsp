<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>index</title>
	</head>
	<body>
		<% String message = (String)request.getAttribute("greeting"); %>
		<p><%= message %></p>
		<a href="new">新規作成</a>
	</body>
</html>
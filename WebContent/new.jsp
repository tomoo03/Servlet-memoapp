<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>new</title>
	</head>
	<body>
		<% String message = (String)request.getAttribute("testMessage"); %>
		<p><%= message %></p>
	</body>
</html>
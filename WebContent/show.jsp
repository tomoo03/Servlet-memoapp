<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
		<title>show</title>
	</head>
	<body>
		<h1>メモ詳細</h1>
		<% String message = (String)request.getAttribute("message"); %>
		<p><%= message %></p>
		<p>タイトル:<%= request.getAttribute("title") %></p>
		<p>本文:</p>
		<p><%= request.getAttribute("content") %></p>
		<p>
			<a href="index">戻る</a>
			<a href='edit?id=<%= request.getAttribute("id") %>'>編集する</a>
			<a href='destroy?id=<%= request.getAttribute("id") %>'>削除する</a>
		</p>
	</body>
</html>
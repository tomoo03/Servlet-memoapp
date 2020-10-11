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
		<form action="create" method="post">
			<input type="hidden" name="id" value="">
			<label for="title">タイトル</label><br>
			<input type="text" name="title" id="title">
			<p></p>
			<label for="content">本文</label><br>
			<textarea name="content" cols="40" rows="10" id="content"></textarea>
			<p></p>
			<input type="submit" value="保存する">
			<a href="index">キャンセル</a>
		</form>
	</body>
</html>
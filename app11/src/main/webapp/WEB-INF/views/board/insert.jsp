<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH</title>
<link rel="stylesheet" href="/css/board/style.css">
<script defer src="/js/board/insert.js"></script>
</head>
<body>
	<h1>게시글 작성</h1>

    		<input type="text" name="title" placeholder="제목">
    		<br>
    		<textarea name="content" placeholder="내용"></textarea>
    		<br>
    		<input type="button" value="게시글 작성" onclick="insertBoard();">
</body>
</html>
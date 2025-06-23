<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH</title>
<script defer src="/js/board/insert.js"></script>
<link rel="stylesheet" href="/css/board/style.css">
</head>
<body>
	<h1>BOARD INSERT</h1>

            <input type="text" name="title" placeholder="제목" enctype="multipart/form-data">
            <br>
            <textarea name="content" placeholder="내용"></textarea>
            <br>
            <input type="file" name="f">
            <br>
            <input type="submit" value="게시글 작성" onclick="insertBoard();">

</body>
</html>
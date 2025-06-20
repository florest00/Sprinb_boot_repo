<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH</title>
<link rel="stylesheet" href="/css/style.css">
<script defer src="/js/script.js"></script>
</head>
<body>
	<h1>게시글 상세조회</h1>

        <input type="text" name="title" placeholder="제목" value="뭔가,,,,,">
        <br>
        <textarea name="content" placeholder="내용">
            뭔가,,,,,내용,,,,
        </textarea>
        <br>
        <input type="button" value="수정하기" onclick="update();">
        <input type="button" value="삭제하기" onclick="del();">
</body>
</html>
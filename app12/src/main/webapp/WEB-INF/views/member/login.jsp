<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH</title>
<link rel="stylesheet" href="/css/style.css">
<script defer src="/js/member/login.js"></script>
</head>
<body>
	<h1>로그인</h1>

        <input type="text" name="userId" placeholder="유저아이디">
        <br>
        <input type="password" name="userPwd" placeholder="비밀번호">
        <br>
        <input type="button" value="로그인" onclick="login();">
</body>
</html>
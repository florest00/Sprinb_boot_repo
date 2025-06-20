<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH</title>
<link rel="stylesheet" href="/css/style.css">
<script defer src="/js/member/join.js"></script>
</head>
<body>
	<h1>회원가입</h1>

        <input type="text" name="userId" placeholder="유저아이디">
        <br>
        <input type="password" name="userPwd" placeholder="비밀번호">
        <br>
        <input type="text" name="userNick" placeholder="닉네임">
        <br>
        <input type="button" value="회원가입" onclick="join();">
</body>
</html>
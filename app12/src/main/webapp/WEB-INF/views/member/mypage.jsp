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
	<h1>마이페이지</h1>

        <input type="text" name="userId" placeholder="유저아이디" readonly value="zzzzz">
        <br>
        <input type="password" name="userPwd" placeholder="비밀번호">
        <br>
        <input type="text" name="userNick" placeholder="닉네임" value="zzzzz">

        <br>
            <input type="button" value="수정하기">
            <input type="button" value="탈퇴하기">

</body>
</html>
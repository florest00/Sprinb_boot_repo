<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH</title>
<%@ include file="/WEB-INF/views/common/layout.jsp" %>
<link rel="stylesheet" href="/css/common/main.css">
<link rel="stylesheet" href="/css/member/mypage.css">
<script defer src="/js/member/mypage.js"></script>
</head>
<body>
	
    <div id="layout">
        <%@ include file="/WEB-INF/views/common/sidebar.jsp" %>
        <div>
            <%@ include file="/WEB-INF/views/common/header.jsp" %>
            <main>
                <form>
                    <label for="">아이디</label>
                    <input type="text" name="id" readonly>
                    <label for="">현재 비밀번호</label>
                    <input type="password" name="oldPwd">
                    <label for="">신규 비밀번호</label>
                    <input type="password" name="newPwd">
                    <label for="">신규 비밀번호 확인</label>
                    <input type="password" name="newPwdCheck">
                    <div id="newPwdCheckResult"></div>
                    <label for="">닉네임</label>
                    <input type="text" name="nick">
                    <input type="file" name="f">
                    <img id="profile-preview"></img>
                    <input type="button" value="탈퇴하기" onclick="quit();">
                    <input type="button" value="수정하기" onclick="edit();">
                </form>
            </main>
            <%@ include file="/WEB-INF/views/common/footer.jsp" %>
        </div>
    </div>

</body>
</html>
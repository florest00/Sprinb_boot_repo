<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH</title>
<%@ include file="/WEB-INF/views/common/layout.jsp" %>
<link rel="stylesheet" href="/css/common/main.css">
<link rel="stylesheet" href="/css/member/join.css">
<script defer src="/js/member/join.js"></script>
</head>
<body>
	
    <div id="layout">
        <%@ include file="/WEB-INF/views/common/sidebar.jsp" %>
        <div>
            <%@ include file="/WEB-INF/views/common/header.jsp" %>
            <main>
                <form>
                    <label for="">아이디</label>
                    <input type="text" name="id">
                    <label for="">비밀번호</label>
                    <input type="password" name="pwd">
                    <label for="">닉네임</label>
                    <input type="text" name="nick">
                    <input type="file" name="f" onchange="showPreview();">
                    <img width="200" height="200" src="" alt="profile-image" id="profile-preview">
                    <input type="button" value="회원가입" onclick="join();">
                </form>
            </main>
            <%@ include file="/WEB-INF/views/common/footer.jsp" %>
        </div>
    </div>

</body>
</html>
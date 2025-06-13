<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>

        	<main>
        	    <h1>게시글작성</h1>

        	    <form action="/board/insert" method="post">
                		<input type="text" name="title" placeholder="제목">
                		<br>
                		<textarea name="content" placeholder="내용"></textarea>
                		<br>
                		<input type="submit" value="게시글 작성">
                	</form>
        	</main>

        	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
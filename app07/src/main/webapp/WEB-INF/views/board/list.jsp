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
            	    <h1>게시글 목록조회</h1>

            	    <table border="1">
                                <tr>
                                    <th>번호</th>
                                    <th>제목</th>
                                    <th>날짜</th>
                                </tr>
                                <c:forEach var="vo" items="${voList}">
                                    <tr>
                                        <td>${vo.no}</td>
                                        <td>${vo.title}</td>
                                        <td>${vo.createdDate}</td>
                                    </tr>
                                </c:forEach>
                            </table>
            	</main>

            	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
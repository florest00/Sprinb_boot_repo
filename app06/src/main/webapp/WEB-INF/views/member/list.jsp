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
	<h1>회원목록</h1>

	<p>
	${voList}
	</p>

	<%
	List<BoardVo> voList = (List<BoardVo>) request.getAttribute("voList");
	for(BoardVo vo : voList){
	    out.write("<h3>");
	    out.write(vo.toString());
	    out.write("</h3>");
	}
	%>

</body>
</html>
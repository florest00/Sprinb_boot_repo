<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH</title>
<%@ include file="/WEB-INF/views/common/layout.jsp" %>
<link rel="stylesheet" href="/css/common/main.css">
<script defer src="/js/board/insert.js"></script>
</head>
<body>
	
    <div id="layout">
        <%@ include file="/WEB-INF/views/common/sidebar.jsp" %>
        <div>
            <%@ include file="/WEB-INF/views/common/header.jsp" %>
            <main>
                <form onsubmit="return insert();">
                    <input type="text" name="title">
                    <input type="text" name="content">
                    <select name="categoryNo">
                        <!-- <option value="1">자유</option>
                        <option value="2">운동</option>
                        <option value="3">코딩</option> -->
                    </select>
                    <input type="submit" value="작성하기">
                </form>
            </main>
            <%@ include file="/WEB-INF/views/common/footer.jsp" %>
        </div>
    </div>

</body>
</html>
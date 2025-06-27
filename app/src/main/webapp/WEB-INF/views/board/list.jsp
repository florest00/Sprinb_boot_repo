<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH</title>
<%@ include file="/WEB-INF/views/common/layout.jsp" %>
<link rel="stylesheet" href="/css/common/main.css">
<script defer src="/js/board/list.js"></script>
</head>
<body>
	
    <div id="layout">
        <%@ include file="/WEB-INF/views/common/sidebar.jsp" %>
        <div>
            <%@ include file="/WEB-INF/views/common/header.jsp" %>
            <main>
                <h1>게시글 목록</h1>
                <table border="1">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>제목</th>
                            <th>조회수</th>
                            <th>작성자</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>
                <div id="page-area">
                    <!-- btn*5 -->
                </div>
            </main>
            <%@ include file="/WEB-INF/views/common/footer.jsp" %>
        </div>
    </div>

</body>
</html>
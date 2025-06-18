<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH</title>
<script defer src="/js/home.js"></script>
<link rel="stylesheet" href="/css/home.css">
</head>
<body>

    <main>

        <h1>홈페이지</h1>
    
        <hr>
    
        <h2>게시글 작성</h2>
        <input type="text" id="title">
        <br>
        <textarea id="content"></textarea>
        <br>
        <button onclick="insert();">작성하기</button>
    
        <hr>
    
        <h2>게시글 상세조회</h2>
        <div id="boardDetail">
            <!-- 안쪽 채워주는 걸로 -->
        </div>
        <!-- <h3>제목 : </h3>
        <h3>작성자 : </h3>
        <h3>조회수 : </h3>
        <h3>작성일시 : </h3>
        <h3>내용 : </h3> -->
    
        <hr>
    
        <h2>게시글 목록조회</h2>
        <button onclick="selectList();">조회하기</button>
        <table>
            <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성일</th>
                </tr>
            </thead>
            <tbody>
                <!-- js로 채워지게 -->
                조회된 내용이 없습니다.
            </tbody>
        </table>


        
        <div id="page-area">
            
        </div>

    </main>

</body>
</html>
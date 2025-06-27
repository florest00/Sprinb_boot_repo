<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<link rel="stylesheet" href="/css/common/sidebar.css">
<script defer src="/js/common/sidebar.js"></script>

<div class="sidebar">
    <nav>
        <ul>
            <li>
                <a>NOTICE</a>
                <ul class="submenu">
                    <li><a href="/notice/list">공지사항 목록</a></li>
                    <li><a href="/notice/insert">공지사항 작성</a></li>
                </ul>
            </li>
            <li>
                <a>BOARD</a>
                <ul class="submenu">
                    <li><a href="/board/list/1">게시글 목록</a></li>
                    <li><a href="/board/insert">게시글 작성</a></li>
                </ul>
            </li>
            <li>
                <a>GALLERY</a>
                <ul class="submenu">
                    <li><a href="/gallery/list">갤러리 목록</a></li>
                    <li><a href="/gallery/insert">갤러리 작성</a></li>
                </ul>
            </li>
            <li>
                <a>MEMBER</a>
                <ul class="submenu">
                    <c:if test="${empty loginMember}">
                    <li><a href="/member/join">회원가입</a></li>
                    <li><a href="/member/login">로그인</a></li>
                    </c:if>
                    <c:if test="${not empty loginMember}">
                    <li><a href="/member/mypage">마이페이지</a></li>
                    </c:if>
                </ul>
            </li>
        </ul>
    </nav>
</div>


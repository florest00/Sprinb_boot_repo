<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<link rel="stylesheet" href="/css/common/header.css">

<header>
    <div class="logo-area">
        <div class="logo" onclick="location.href='/home'">
            🎉 🌸 ✨ 🎈 💗 환 영 합 니 다 ~ ^^ 💛 💫 🌟 🍬 🎀
        </div>
    </div>
    <div class="profile">

        <c:choose>
            <c:when test="${empty loginMember}">
                <img src="/images/member/user.png" alt="User Profile" onclick="location.href='/member/mypage'" />
            </c:when>   
            <c:otherwise>
                <img src="${loginMember.savePath}" alt="User Profile" onclick="location.href='/member/mypage'" />
            </c:otherwise>
        </c:choose>
        <!-- <span>${loginMember.nick}</span> -->
        <c:if test="${not empty loginMember}">
            <button onclick="location.href='/member/logout'">로그아웃</button>
        </c:if>

    </div>
</header>

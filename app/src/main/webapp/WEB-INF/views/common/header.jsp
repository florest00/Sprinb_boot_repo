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
        <img src="${loginMember.savePath}" alt="User Profile" onclick="location.href='/member/mypage'" />
        <span>${loginMember.nick}</span>
    </div>
</header>

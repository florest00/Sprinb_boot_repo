package com.swy.app.member.controller;

import com.swy.app.member.vo.MemberVo;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member")
public class MemberController {

    @GetMapping("join")
    public void join(){}

    @GetMapping("login")
    public void login(){}

    @GetMapping("mypage")
    public String mypage(HttpSession session){
        //로그인 정보 검증 (loginMember 세션에 들어있나? 없으면 예외 던짐)
        MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
        if(loginMember == null){
//            throw new IllegalStateException();
            return "redirect:/member/login";
        }
        return "member/mypage";
    }

    @GetMapping("logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/home";
    }

}

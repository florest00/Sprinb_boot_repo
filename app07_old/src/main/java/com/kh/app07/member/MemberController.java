package com.kh.app07.member;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member")
public class MemberController {

    @Autowired
    private MemberService memberService;


    /* 회원가입 화면 */
    @GetMapping("join")
    public String join(){
        return "member/join";
    }

    /* 마페 화면 */
    @GetMapping("mypage")
    public void mypage(){}

    /* 로그인 화면 */
    @GetMapping("login")
    public void login(){

    }

    @PostMapping("login")
    public String login(MemberVo vo, HttpSession session){
        MemberVo loginMember = memberService.login(vo);
        session.setAttribute("loginMember", loginMember);
        return "redirect:/home";
    }


    /* 회원가입 기능 */
    @PostMapping("join")
    public String join(MemberVo vo){
        //service
        int result = memberService.join(vo);

       if(result != 1){
           throw new IllegalThreadStateException("[MEMBER-001] 회원가입 문제 발생 ...");
       }

        //result
        return "redirect:/member/login";
    }

/**/

    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/home";
    }

    /* 회원탈퇴 */
    @GetMapping("quit")
    public void quit(HttpSession session){
        //data
        session.getAttribute("loginMember");
    }

}

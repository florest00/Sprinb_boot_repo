package com.kh.app07.member;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


//컨트롤러 어노테이션
@Controller
//
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
    public String mypage(HttpSession session){
        MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
        if(loginMember != null) { //login_ok
            return "member/mypage";
        }else {
            return "member/login";
        }
//        return "member/mypage";
//        return "member/login";
    }

    /* 로그인 화면 */
    @GetMapping("login")
    public void login(){

    }

    @PostMapping("login")
    public String login(MemberVo vo, HttpSession session){
        MemberVo loginMember = memberService.login(vo);
        if(loginMember == null){
            session.setAttribute("alertMsg", "login fail...");
        } else {
            session.setAttribute("loginMember", loginMember);
        }
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


    /*로그아웃*/

    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/home";
    }

    /* 회원탈퇴 */
    @GetMapping("quit")
    public String quit(HttpSession session){
        //data
        MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
        int result = memberService.quit(loginMember);
//        String userId = loginMember.getUserId();
//        String userPwd = loginMember.getUserPwd();
        if(result != 1){
            throw new IllegalStateException("[MEMBER-002] QUIT ERROR");
        }
        session.invalidate();
        // 회원탈퇴하고 닉네임 안나오고 "게스트님 환영합니다" 나옴
//        new MemberVo();
        return "redirect:/home";
    }

    /* 회원정보 수정 */
    @PostMapping("edit")
    public String edit(MemberVo vo, HttpSession session) {
        //data
        //service
        //result
        MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
        String no = loginMember.getNo();
        vo.setNo(no);
        int result = memberService.edit(vo);
        if(result != 1) {
            throw new IllegalStateException("[MEMBER-003] edit fail");
        }
        session.invalidate();
        return "redirect:/member/login";
    }

}

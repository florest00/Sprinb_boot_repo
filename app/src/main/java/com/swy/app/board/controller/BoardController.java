package com.swy.app.board.controller;

import com.swy.app.member.vo.MemberVo;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    //컨트롤러에서 jsp로 포워딩
    @GetMapping("insert")
    public String insert(HttpSession session){
        MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
        if(loginMember == null){
            session.setAttribute("alertMsg", "로그인 후 작성 가능합니다.");
            return "redirect:/member/login";
        }
        return "board/insert";
    }

    @GetMapping("list/*")
    public String list(){
        return "board/list";
    }

//    @GetMapping("list/*")
//    public String list(){
//        return "board/list";
//    }

}

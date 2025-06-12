package com.kh.app05.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member")
public class MemberController {

    @GetMapping("join")
    // 화면
    public void join(){

    }

    @PostMapping("join")
    // 로직
    public void join(MemberVo vo) {
        System.out.println("vo = " + vo);
    }


}

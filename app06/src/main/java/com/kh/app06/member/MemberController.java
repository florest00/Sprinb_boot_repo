package com.kh.app06.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("member")
//모든 메서드의 경로 자동추가

public class MemberController {

    @Autowired
    // AutoWired 추가하면 실행 안되는데,, 왜그냐면
    //멤버서비스라는 변수에 객체가 만들어짐
    private MemberService memberService;
    //private final MemberService memberService = new MemberService();

    @GetMapping("join")
    public String join() {
        return "member/join";
    }

    @PostMapping("join")
    public String join(MemberVo vo) {
        //data
        System.out.println("vo = " + vo);
        //service

        int result = memberService.join(vo);

        //result
        return "redirect:/home";
    }

    @GetMapping("list")
    public String memberList(Model model) {
        List<MemberVo> voList = memberService.findMemberList();
        model.addAttribute("voList", voList);
        // req, resp 를 쓰면 스프링의 기능을 활용못하는 거니까 ds를 사용해라
        return "member/list";
    }



}

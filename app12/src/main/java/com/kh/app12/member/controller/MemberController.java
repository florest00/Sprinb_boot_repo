package com.kh.app12.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member")
public class MemberController {

    @GetMapping("join")
    public void join() {}

    @GetMapping("login")
    public void login() {}

    @GetMapping("list")
    public void list() {}

    @GetMapping("mypage")
    public void mypage() {}


}

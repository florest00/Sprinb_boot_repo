package com.kh.app13.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("board")
public class BoardController {

    @RequestMapping("insert")
    public void insert(){}

    @RequestMapping("detail/*")
    public String detail() {
        return "board/detail";
    }

}

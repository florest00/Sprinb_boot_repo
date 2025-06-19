package com.kh.app11.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("board")
public class BoardController {
    /**
     * 등록 화면
     */
    @GetMapping("insert")
    public void insert() {}

    /**
     * 리스트 화면
     */
    @GetMapping("list")
    public void list() {}

    /**
     * 상세 조회
     *
     * @return
     */
    @GetMapping("detail/*")
    public String detail() {
        return "board/detail";
    }
}

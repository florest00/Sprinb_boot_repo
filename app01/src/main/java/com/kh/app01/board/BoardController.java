package com.kh.app01.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
    @RequestMapping("/board/insert")
    public void m01() {
        System.out.println("게시글 작성~~~");
    }
}

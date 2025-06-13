package com.kh.app07.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("board")
public class BoardController {

    @Autowired
//    private final BoardService boardController; 결합도 높아지니까 x
    private BoardService boardController;

    @GetMapping("board")
    public String insert() {
        return "board/insert";
    }

}

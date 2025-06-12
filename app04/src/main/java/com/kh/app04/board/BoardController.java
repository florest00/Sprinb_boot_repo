package com.kh.app04.board;

import com.kh.app04.board.board.BoardVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {
    @GetMapping("board/list")
    public String m01() {
        return "board/list";
    }

    @GetMapping("board/insert")
    public void m02() {

    }

    //POST 방식 요청,,, board/insert URL ,,,
    @PostMapping("board/insert")
//    public void m03(HttpServletRequest req) {
//    public void m03(@RequestParam(value = "title") String x, String content) {
        public String m03(BoardVo vo) {
        //data : req
            
        //service
        System.out.println("vo = " + vo);
        
        // result
        return "redirect:/board/list";
    }
}

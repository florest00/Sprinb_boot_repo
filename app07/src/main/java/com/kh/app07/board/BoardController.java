package com.kh.app07.board;

import com.kh.app07.member.MemberVo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("board")
public class BoardController {

    @Autowired
//    private final BoardService boardController; 결합도 높아지니까 x
    private BoardService boardService;


    /* 게시글 작성 화면 */
    @GetMapping("insert")
    // getmapping 있어야 받는거
    public void insert() {}


    /**
     *  게시글 작성
     *  */
    @PostMapping("insert")
    public String insert(BoardVo vo, HttpSession session){
//        vo.setWriterNo(1);
        MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
        vo.setWriterNo(loginMember.getNo());
        if(loginMember == null){
            throw new IllegalStateException("[BOARD-001] login first");
        }
        int result = boardService.insert(vo);
        return "redirect:/board/list";

    }

    /**
     *  게시글 목록조회
     *  */
    @GetMapping("list")
    public void list(Model model) {
        List<BoardVo> voList = boardService.getBoardList();
//        req.setAttr => model
        model.addAttribute("voList", voList);

    }

//    @GetMapping("board")
//    public String insert() {
//        return "board/insert";
//    }

}//class

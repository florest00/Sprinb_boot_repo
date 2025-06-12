package com.kh.app03.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {

    // 목록조회 화면 + 로직
    @RequestMapping("board/list")
    //service 메서드 같은거
    public  void  m01() {
        System.out.println("게시글 목록조회 ~~~");
    }
    // 작성하기 회면
    //@RequestMapping(value = "board/write", method = RequestMethod.GET)
    // method 는 요청방식으로 맵핑 처리
    @GetMapping("board/write")
    //특정 메서드
    public void m02() {
        System.out.println("게시글 작성하기 화면 ~~~");
    }
    // 작성하기 로직
    //@RequestMapping(value = "board/write", method = RequestMethod.POST)
    @PostMapping("board/write")
    //특정 메서드
    public void m03() {
        System.out.println("게시글 작성하기 로직~~~");
    }


    // 삭제하기 로직
    // 상세조회 화면+로직
    // 수정하기 로직


}

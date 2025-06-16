package com.kh.app10.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("board")
//@RequiredArgsConstructor
public class BoardController {

//    private final BoardService boardService;
//    private final BoardService service;



//    /**
//     * 게시글 작성 기능
//     *
//     * @return
//     */
//    @PostMapping("insert")
//    @ResponseBody // 리턴값을 그대로 "응답"함
////    public int insert(BoardVo vo){
////    public void insert(String str){
////    public void insert(@RequestBody String str){
//    public int insert(@RequestBody BoardVo vo){
////        req.getBody.getStr
////        System.out.println("BoardController.insert called");
////        System.out.println("vo = " + vo);
//        //data
//        vo.setWriterNo("1");
//        //service
//        int result = service.insert(vo);
//        return result;
//    }
//
//    /**
//     * 게시글 목록 얻기
//     */
//
//    @GetMapping("list")
//    @ResponseBody
//    public List<BoardVo> list(){
//        List<BoardVo> voList = service.getBoardList();
//        System.out.println("voList = " + voList);
////        return voList.toString(); //JSON 형식으로 바꿔 응답하면 fetch함수로 편하게
////        return voList -> JSON
//        return voList;
//    }
    
    // 위에 있는 애들은 다 BoardApiController에 옮김

    /**
     * 게시글 작성 (화면)
     */
    @GetMapping("insert")
    public void insert(){}

    /**
     * 게시글 목록 (화면)
     */
    @GetMapping("list")
    public void list() {}


}

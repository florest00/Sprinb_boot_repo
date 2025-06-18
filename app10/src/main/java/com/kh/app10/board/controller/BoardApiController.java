package com.kh.app10.board.controller;

import com.kh.app10.board.service.BoardService;
import com.kh.app10.board.vo.BoardVo;
import com.kh.app10.common.page.PageVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/board")
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService service;

    /**
     *  게시글 작성
     */
    @PostMapping
    public int insert(@RequestBody BoardVo vo) {
        return service.insert(vo);
    }

    /**
     * 게시글 목록 조회
     */
    @GetMapping
//    public List<BoardVo> selectList(PageVo pvo) {
        public Map<String, Object> selectList(@RequestParam(required = false, defaultValue = "1") int pno) { // (required = false) 필수 아니다

            int listCount = service.getBoardCnt();
            int currentPage = pno;
            int pageLimit = 5;
            int boardLimit = 10;

            PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);

            List<BoardVo> voList = service.selectList(pvo);
            
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("pvo", pvo);
            map.put("voList", voList);

            return map;
//        return service.selectList(pvo);
    }

    /**
     * 게시글 상세 조회
     */
    @GetMapping("{no}")
    public BoardVo selectOne(@PathVariable String no){
        //data
        //service

        return service.selectOne(no);
    }

}

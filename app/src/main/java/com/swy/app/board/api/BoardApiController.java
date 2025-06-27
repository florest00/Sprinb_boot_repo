package com.swy.app.board.api;

import com.swy.app.board.service.BoardService;
import com.swy.app.board.vo.BoardVo;
import com.swy.app.board.vo.CategoryVo;
import com.swy.app.member.vo.MemberVo;
import com.swy.app.util.page.PageVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/board")
public class BoardApiController {

    private final BoardService service;

    // 게시글 등록
    @PostMapping
    public ResponseEntity<Integer> insert(BoardVo vo, List<MultipartFile> fileList, HttpSession session){
        //파일 여러개 폼으로 받을거라 @RequestBody없음
        //service

        //세션.loginMember
        MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
        String writerNo = loginMember.getNo();
        vo.setWriterNo(writerNo);
        //BoardVo 작성자번호세팅

        int result = service.insert(vo);

        if(result != 1){
            return ResponseEntity
//                    .badRequest()
                    .internalServerError()
                    .body(result);
        }

        return ResponseEntity
                .ok()
                .body(result);
    }

    @GetMapping("category")
    public ResponseEntity<List<CategoryVo>> getCategoryAll(){
        List<CategoryVo> voList = service.getCategoryAll();
        return ResponseEntity
                .ok()
                .body(voList);
    }


    @GetMapping("/{currentPage}")
    public ResponseEntity<Map<String, Object>> getBoardAll(@PathVariable int currentPage){


        // 전체 게시글 개수
        int listCount = service.getBoardCnt();
        int pageLimit = 5;
        int boardLimit = 10;

        // 페이지 정보 객체 생성
        PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
        // 게시글 목록 조회
        List<BoardVo> voList = service.getBoardAll(pvo);
    
        // 응답할 Map 객체 생성
        Map<String, Object> map = new HashMap<>();
        map.put("voList", voList);
        map.put("pvo", pvo); // 페이지 정보

        // 응답 반환
        return ResponseEntity
                .ok()
                .body(map)
                ;
    }

}//class

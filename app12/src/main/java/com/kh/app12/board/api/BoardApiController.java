package com.kh.app12.board.api;

import com.kh.app12.board.service.BoardService;
import com.kh.app12.board.vo.BoardVo;
import com.kh.app12.member.vo.MemberVo;
import jakarta.servlet.http.HttpSession;
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

    //insert
    @PostMapping
    public Map<String, Object> insert(@RequestBody BoardVo vo, HttpSession session) {
        MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
        vo.setWriterNo(loginMember.getNo());
        //data
        //service
        int result = service.insert(vo);
        Map<String, Object> map = new HashMap<>();
        map.put("data", result);
        map.put("status", "insert ok ~~~");
        //result
        return map;
    }

    //selectList
    @GetMapping
    public Map<String, Object> selectList(BoardVo vo) {
        List<BoardVo> voList = service.selectList(vo);
        Map<String, Object> map = new HashMap<>();
        map.put("data", voList);
        map.put("status", "selectList ok ~~~");
        return map;
    }


    //selectOne
    @GetMapping("{no}")
    public Map<String, Object> selectOne(@PathVariable String no) {
        BoardVo vo = service.selectOne(no);
        Map<String, Object> map = new HashMap<>();
        map.put("data", vo);
        map.put("status", "selectOne ok ~~~");
        return map;
    }


    //update
    @PutMapping
    public Map<String, Object> update(@RequestBody BoardVo vo) {
        int result = service.update(vo);
        Map<String, Object> map = new HashMap<>();
        map.put("data", result);
        map.put("status", "update ok ~~~");
        return map;
    }

    //delete
    @DeleteMapping
    public Map<String, Object> delete(@RequestBody BoardVo vo) {
        int result = service.delete(vo);
        Map<String, Object> map = new HashMap<>();
        map.put("data", result);
        map.put("status", "delete ok ~~~");
        return map;
    }

}

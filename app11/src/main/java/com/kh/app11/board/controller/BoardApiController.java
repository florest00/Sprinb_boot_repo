package com.kh.app11.board.controller;

import com.kh.app11.board.service.BoardService;
import com.kh.app11.board.vo.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/board")
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService service;

    // insert
    @PostMapping
    public Map<String, String> insert(@RequestBody BoardVo vo) {
        vo.setWriterNo("1");
        //원래는 session에서 꺼내와야함
        int result = service.insert(vo);
        Map<String, String> map = new HashMap<String, String>();
        map.put("data", result + "");
        map.put("status", "insert success ~~~");
        return map;
    }

    // list
    @GetMapping
    public Map<String, Object> selectList() {
        List<BoardVo> voList = service.selectList();
        Map<String, Object> map = new HashMap<>();
        map.put("data", voList);
        map.put("status", "goooooood");
        return map;
    }

    // detail
    @GetMapping("{no}")
    // @RequestParam int no 대신 경로 변수
    public Map<String, Object> selectOne(@PathVariable String no) {
        BoardVo vo = service.selectOne(no);
        Map<String, Object> map = new HashMap<>();
        map.put("data", vo);
        map.put("status", "select detail ok ~~~~");
        return map;
    }

    // update
    @PutMapping
    public Map<String, Object> update(@RequestBody BoardVo vo) {
        int result = service.update(vo);
        Map<String, Object> map = new HashMap<>();
        map.put("data", result);
        map.put("status", "update okkkkkk ~~~~");
        return map;
    }

    // delete
    @DeleteMapping
    public Map<String, Object> delete(@RequestBody HashMap<String, String> reqMap) {
//        System.out.println("no = " + no);
        int result = service.delete(reqMap.get("no"));
        Map<String, Object> map = new HashMap<>();
        map.put("data", result);
        map.put("status", "delete ok ~~~~~");
        return map;
    }

}

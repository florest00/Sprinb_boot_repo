package com.kh.app10.board.service;

import com.kh.app10.board.vo.BoardVo;
import com.kh.app10.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper mapper;

    public int insert(BoardVo vo){
        return mapper.insert(vo);
    }


    public List<BoardVo> getBoardList() {
        return mapper.getBoardList();
    }
}

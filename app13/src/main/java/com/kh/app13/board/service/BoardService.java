package com.kh.app13.board.service;

import com.kh.app13.board.mapper.BoardMapper;
import com.kh.app13.board.vo.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper mapper;

    public int insert(BoardVo vo) {

        return mapper.insert(vo);

    }

    public BoardVo selectOne(String no) {
        return mapper.selectOne(no);
    }
}

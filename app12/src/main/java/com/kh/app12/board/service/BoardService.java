package com.kh.app12.board.service;

import com.kh.app12.board.mapper.BoardMapper;
import com.kh.app12.board.vo.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final BoardMapper mapper;

    public int insert(BoardVo vo) {
        return mapper.insert(vo);
    }

    public List<BoardVo> selectList(BoardVo vo) {
        return mapper.selectList(vo);
    }

    public BoardVo selectOne(String no) {
        return mapper.selectOne(no);
    }


    public int update(BoardVo vo) {
        return mapper.update(vo);
    }


    public int delete(BoardVo vo) {
        return mapper.delete(vo);
    }
}

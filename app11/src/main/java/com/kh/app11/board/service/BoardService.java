package com.kh.app11.board.service;

import com.kh.app11.board.mapper.BoardMapper;
import com.kh.app11.board.vo.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper mapper;

    public int insert(BoardVo vo) {
        return mapper.insert(vo);
    }


    public List<BoardVo> selectList() {
        return mapper.selectList();
    }

    public BoardVo selectOne(String no) {
        int result = mapper.increaseHit(no);
        if(result != 1) {
            throw new IllegalStateException();
        }
        return mapper.selectOne(no);
    }

    public int update(BoardVo vo) {
        return mapper.update(vo);
    }

    public int delete(String no) {
        return mapper.delete(no);
    }
}

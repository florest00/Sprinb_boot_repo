package com.kh.app10.board.service;

import com.kh.app10.board.vo.BoardVo;
import com.kh.app10.common.page.PageVo;
import com.kh.app10.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper mapper;

    public int insert(BoardVo vo) {
        return mapper.insert(vo);
    }

    public List<BoardVo> selectList(PageVo pvo) {
        return mapper.selectList(pvo);
    }

    public BoardVo selectOne(String no) {
        int result = mapper.increaseHit(no);
        if(result != 1) {
            throw new IllegalStateException("조회수 증가 실패");
        }
        return mapper.selectOne(no);
    }

    public int getBoardCnt() {
        return mapper.getBoardCnt();
    }
}

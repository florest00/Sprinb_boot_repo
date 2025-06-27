package com.swy.app.board.service;

import com.swy.app.board.mapper.BoardMapper;
import com.swy.app.board.vo.BoardVo;
import com.swy.app.board.vo.CategoryVo;
import com.swy.app.util.page.PageVo;
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

    public List<CategoryVo> getCategoryAll() {
        return mapper.getCategoryAll();
    }

    public List<BoardVo> getBoardAll(PageVo pvo) {
        return mapper.getBoardAll(pvo);
    }

    public int getBoardCnt() {
        return mapper.getBoardCnt();
    }
}

package com.kh.app07.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// 서비스보다도 @Component 때문에 bin으로 등록할 수 있어서 됨
// spring container 안쪽의 객체를 bin(bean?)이라고 함
public class BoardService {

    @Autowired
    //스프링아 이거 연결해줘라
    private BoardMapper boardMapper;

    /* 게시글 작성 */
    public int insert(BoardVo vo) {
        return boardMapper.insert(vo);
    }

    public List<BoardVo> getBoardList() {
        return boardMapper.getBoardList();
//        return boardMapper.findBoardList(); 로 이름 맘대로 해도 되긴 함
    }

//        @GetMapping("board")
//    public String insert() {
//        return "board/insert";
//    }

}

package com.kh.app10.board.mapper;

import com.kh.app10.board.vo.BoardVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Insert("""
                INSERT INTO BOARD
                (
                    NO
                    ,TITLE
                    ,CONTENT
                    ,WRITER_NO
                )
                VALUES
                (
                    SEQ_BOARD.NEXTVAL
                    , #{title}
                    , #{content}
                    , #{writerNo}
                )
                """)
    int insert(BoardVo vo);

    @Select("""
            SELECT
                NO
                ,TITLE
                ,CONTENT
                ,WRITER_NO
                ,CREATED_DATE
                ,HIT
                ,DEL_YN
            FROM BOARD
            WHERE DEL_YN = 'N'
            ORDER BY NO DESC
            """)
    List<BoardVo> getBoardList();
}

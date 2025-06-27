package com.swy.app.board.mapper;

import com.swy.app.board.vo.BoardVo;
import com.swy.app.board.vo.CategoryVo;
import com.swy.app.util.page.PageVo;
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
                ,CATEGORY_NO
                ,WRITER_NO
            )
            VALUES
            (
                SEQ_BOARD.NEXTVAL
                , #{title}
                , #{content}
                , #{categoryNo}
                , #{writerNo}
            )
            """)
    int insert(BoardVo vo);

    @Select("""
            SELECT
                NO
                ,NAME
            FROM CATEGORY
            """)
    List<CategoryVo> getCategoryAll();

    @Select("""
            SELECT
                NO
                , TITLE
                , CONTENT
                , CATEGORY_NO
                , WRITER_NO
                , HIT
                , CREATE_DATE
                , DEL_YN
            FROM BOARD
            WHERE DEL_YN = 'N'
            ORDER BY NO DESC
            OFFSET #{offset} ROWS FETCH NEXT #{boardLimit} ROW ONLY
            """)
    List<BoardVo> getBoardAll(PageVo vo);

    @Select("""
            SELECT
                COUNT(NO)
            FROM BOARD
            WHERE DEL_YN = 'N'
            """)
    int getBoardCnt();
}

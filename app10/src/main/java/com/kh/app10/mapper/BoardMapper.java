package com.kh.app10.mapper;

import com.kh.app10.board.vo.BoardVo;
import com.kh.app10.common.page.PageVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
                , 1
            )""")
    int insert(BoardVo vo);

    @Select("""
            SELECT\s
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
            OFFSET #{offset} ROWS FETCH NEXT #{boardLimit} ROWS ONLY
            """)
    List<BoardVo> selectList(PageVo vo);

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
            WHERE NO = #{no}
            AND DEL_YN = 'N'
            """)
    BoardVo selectOne(String no);

    @Update("""
            UPDATE BOARD
                SET
                    HIT = HIT + 1
                WHERE NO = #{no}
                AND DEL_YN = 'N'
            """)
    int increaseHit(String no);

    @Select ("""
            SELECT COUNT(NO)
            FROM BOARD
            WHERE DEL_YN = 'N'
            """)
    int getBoardCnt();
}

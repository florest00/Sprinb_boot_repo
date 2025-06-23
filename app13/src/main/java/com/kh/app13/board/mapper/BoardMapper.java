package com.kh.app13.board.mapper;

import com.kh.app13.board.vo.BoardVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BoardMapper {


    @Insert("""
            INSERT INTO BOARD
            (
                NO
                ,TITLE
                ,CONTENT
                ,WRITER_NO
                ,ORIGIN_NAME
                ,CHANGE_NAME
            )
            VALUES
            (
                SEQ_BOARD.NEXTVAL
                , #{title}
                , #{content}
                , #{writerNo}
                , #{originName}
                , #{changeName}
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
                ,origin_name
                ,change_name
                ,HIT
                ,DEL_YN
            FROM BOARD
            WHERE NO = #{a}
            AND DEL_YN = 'N'
            """)
    BoardVo selectOne(String no);
}

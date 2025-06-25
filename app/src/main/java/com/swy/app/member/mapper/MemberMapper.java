package com.swy.app.member.mapper;

import com.swy.app.member.vo.MemberVo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface MemberMapper {


    @Insert("""
            INSERT INTO MEMBER
            (
                NO
                ,ID
                ,PWD
                ,NICK
                ,PROFILE
            )
            VALUES
            (
                SEQ_MEMBER.NEXTVAL
                , #{id}
                , #{pwd}
                , #{nick}
                , #{profile}
            )""")
    int join(MemberVo vo);

    @Select("""
            SELECT
                NO
                ,ID
                ,NICK
                ,ENROLL_DATE
                ,MODIFY_DATE
                ,PROFILE
            FROM MEMBER
            WHERE ID = #{id}
            AND PWD = #{pwd}
            AND DEL_YN = 'N'
            """)
    MemberVo login(MemberVo vo);

    @Update("""
            UPDATE MEMBER
                SET DEL_YN='Y'
                WHERE NO = #{no}
            """)
    int quit(String no);

    @Update("""
            UPDATE MEMBER
                SET
                    PWD = #{newPwd}
                    , NICK = #{nick}
                WHERE NO = #{no}
                AND PWD = #{pwd}
                AND DEL_YN = 'N'
            """)
    int edit(MemberVo vo);
}

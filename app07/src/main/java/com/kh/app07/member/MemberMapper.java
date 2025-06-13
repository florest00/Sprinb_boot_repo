package com.kh.app07.member;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface MemberMapper {

    @Insert("""
            INSERT INTO MEMBER
            (
                NO
                ,USER_ID
                ,USER_PWD
                ,USER_NICK
            )
            VALUES
            (
                SEQ_MEMBER.NEXTVAL
                , #{userId}
                , #{userPwd}
                , #{userNick}
            )
            """)
    int join(MemberVo vo);

    @Select("""
            SELECT
                NO
                ,USER_ID
                ,USER_PWD
                ,USER_NICK
                ,CREATED_DATE
                ,DEL_YN
            FROM MEMBER
            WHERE USER_ID = #{userId}
            AND USER_PWD = #{userPwd}
            AND DEL_YN = 'N'
            """)
    MemberVo login(MemberVo vo);

    @Update("""
            UPDATE MEMBER
                SET
                    DEL_YN = 'Y'
                WHERE USER_ID = #{userId}
                AND USER_PWD = #{userPwd}
            """)
    int quit(MemberVo loginMember);

    @Update("""
            UPDATE MEMBER
                SET
                    USER_PWD = #{userPwd}
                    , USER_NICK = #{userNick}
                WHERE NO = #{no}
                AND DEL_YN = 'N'
            """)
    int edit(MemberVo vo);

//    @Select("""
//            SELECT *
//            FROM MEMBER
//            WHERE DEL_YN = 'N'
//            ORDER BY NO DESC
//            """)
//    List<MemberVo> findMemberList();
}
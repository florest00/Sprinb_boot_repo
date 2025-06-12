package com.kh.app06.member;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
            SELECT *
            FROM MEMBER
            WHERE DEL_YN = 'N'
            ORDER BY NO DESC
            """)
    List<MemberVo> findMemberList();
}

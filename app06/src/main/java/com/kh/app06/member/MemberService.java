package com.kh.app06.member;


import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;



    public int join(MemberVo vo) {
        //biz
        return memberMapper.join(vo);
    }


    public List<MemberVo> findMemberList() {
        return memberMapper.findMemberList();
    }
}

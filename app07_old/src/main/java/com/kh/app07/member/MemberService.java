package com.kh.app07.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;



    public int join(MemberVo vo) {
        //biz
//        validateData();
        //DAO
        return memberMapper.join(vo);

    }

    public MemberVo login(MemberVo vo) {
        return memberMapper.login(vo);
    }


//    public List<MemberVo> findMemberList() {
//        return memberMapper.findMemberList();
//    }
}
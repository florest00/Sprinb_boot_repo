package com.swy.app.member.service;

import com.swy.app.member.mapper.MemberMapper;
import com.swy.app.member.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper mapper;

    public int join(MemberVo vo) {

        return mapper.join(vo);

    }

    public MemberVo login(MemberVo vo) {

        return mapper.login(vo);

    }

    public int quit(String no) {
        return mapper.quit(no);
    }

    public int edit(MemberVo vo) {
        return mapper.edit(vo);
    }
}

package com.kh.app12.member.service;

import com.kh.app12.member.member.mapper.MemberMapper;
import com.kh.app12.member.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public List<MemberVo> selectList() {
        return mapper.selectList();
    }

    public int edit(MemberVo vo) {
        return mapper.edit(vo);
    }

    public int quit(MemberVo vo) {
        return mapper.quit(vo);
    }
}

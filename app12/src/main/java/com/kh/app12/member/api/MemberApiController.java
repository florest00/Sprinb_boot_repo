package com.kh.app12.member.api;

import com.kh.app12.member.service.MemberService;
import com.kh.app12.member.vo.MemberVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/member")
public class MemberApiController {

    private final MemberService service;

    //join (insert)
    @PostMapping("join")
    public Map<String, Object> join(@RequestBody MemberVo vo) {
        int result = service.join(vo);
        Map<String, Object> map = new HashMap<>();
        map.put("data", result);
        map.put("status", "join ok ~~~");
        return map;
    }

    //login (selectOne)
//    @GetMapping => 이렇게 하면 url에 다 나와서 보안상 문제있음
    @PostMapping("login")
    public Map<String, Object> selectOne(@RequestBody MemberVo vo, HttpSession session) {
        MemberVo loginMemberVo = service.login(vo);
        // db에서 처리된 어떤 로그인 정보를 가져옴, 객체 하나 얻어옴
        session.setAttribute("loginMember", loginMemberVo);
        Map<String, Object> map = new HashMap<>();
        map.put("data", loginMemberVo);
        map.put("status", "login ok ~~~");
        return map;
    }

    //selectList
    @GetMapping
    public Map<String, Object> selectList() {
        List<MemberVo> voList = service.selectList();
        Map<String, Object> map = new HashMap<>();
        map.put("data", voList);
        map.put("status", "selectList ok ~~~");
        return map;
    }

    //edit (update)
    @PutMapping
    public Map<String, Object> edit(@RequestBody MemberVo vo) {
        int result = service.edit(vo);
        Map<String, Object> map = new HashMap<>();
        map.put("data", result);
        map.put("status", "selectList ok ~~~");
        return map;
    }

    //quit (delete)
    @DeleteMapping
    public Map<String, Object> quit(@RequestBody MemberVo vo, HttpSession session) {
        MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
        loginMember.getNo();
        vo.setNo(loginMember.getNo());
        int result = service.quit(vo);
        // n번 회원에 대한 탈퇴

        Map<String, Object> map = new HashMap<>();
        map.put("data", result);
        map.put("status", "quit ok ~~~");
        return map;
    }

}

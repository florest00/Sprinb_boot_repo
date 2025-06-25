package com.swy.app.member.api;

import com.swy.app.member.service.MemberService;
import com.swy.app.member.vo.MemberVo;
import com.swy.app.util.file.FileUploader;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("api/member")
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService service;

    @Value("${upload.path.member}")
//    private String x;
    private String profilePath;

    // 회원가입
    @PostMapping
    public ResponseEntity<Integer> join(MemberVo vo, MultipartFile f) throws IOException {
//@RequestBody : json형식으로 받을때만 씀
        // 경로 전달
        String dirPath = "D:\\dev\\spring_boot_repo\\app\\src\\main\\resources\\static\\upload\\profile\\";
//        String dirPath = .properties;
        //.properties => k:v 형태를 가져온다? application.properties 문자열 읽고 1, 2줄~읽고 등호 기준 k값,, 어떤 값들을 다룰 때 유용함
        String changeName = FileUploader.save(f, dirPath);

        vo.setProfile(changeName);
        int result = service.join(vo);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }

    //로그인
    @PostMapping("login")
    public ResponseEntity<MemberVo> login(@RequestBody MemberVo vo, HttpSession session) {
        MemberVo loginMember = service.login(vo);
//        String profilePath = "/upload/profile/";
        loginMember.setSavePath(profilePath + loginMember.getProfile());
        session.setAttribute("loginMember", loginMember);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(loginMember);
    }

    //마이페이지
    @GetMapping
    public ResponseEntity<MemberVo> selectMemberOne(HttpSession session){
        //data
        MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
//        loginMember.getNo();
        //service
        //result
        if(loginMember == null){
            return ResponseEntity
                    .badRequest() //400
                    .build();
        }
        return ResponseEntity
//                .status(HttpStatus.OK) => 어떤 상태 코드를 이백?으로 하겠다 하는 건데 그냥 .ok
                .ok()
                .body(loginMember);
    }

    //탈퇴하기
    @DeleteMapping
    public ResponseEntity<Integer> quit(HttpSession session) {
        MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
        String no = loginMember.getNo();
        //        String no = session.getAttribute("loginMember").getNo();
        int result = service.quit(no);
        if(result != 1) {
            throw new IllegalStateException();
        }
        session.removeAttribute("loginMember");
        return ResponseEntity
                .ok()
                .body(result);
    }

    //수정하기
    @PutMapping
    //@RequestParam => RequestBody
    public ResponseEntity<Integer> edit(@RequestBody MemberVo vo, HttpSession session){
        MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
        String no = loginMember.getNo();
        vo.setNo(no);
        //data
        //service
        int result = service.edit(vo);
        if(result != 1){
            // err~~~
            throw new IllegalStateException();
            // 세션 자체를 무효화시킴
        }
        session.invalidate();
        return ResponseEntity
                .ok()
                .body(result);
    }


}//class

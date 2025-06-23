package com.kh.app13.board.api;

import com.kh.app13.board.service.BoardService;
import com.kh.app13.board.vo.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/board")
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService service;

    @PostMapping
    public Map<String, Object> insert(BoardVo vo, MultipartFile f) throws IOException {

        vo.setWriterNo("1");
        // 로그인처리 안해서 일단 1
//        System.out.println("vo = " + vo);
//        System.out.println("f = " + f);

        //파일 업로드
        String dirPath = "D:\\dev\\spring_boot_repo\\app13\\src\\main\\resources\\static\\upload\\";
        String random = System.currentTimeMillis() + "_" + UUID.randomUUID().toString();
        String originalFilename = f.getOriginalFilename();
        int extIdx = originalFilename.lastIndexOf(".");
        String ext = originalFilename.substring(extIdx);
        String changeName = random + ext;
        String savePath = dirPath + changeName;
        File targetFile = new File(savePath);
        f.transferTo(targetFile);

        //service
        vo.setOriginName(originalFilename);
        vo.setChangeName(changeName);
        int result = service.insert(vo);

        //result
        Map<String, Object> map = new HashMap<>();
        map.put("data", result);
        map.put("status", "insert ok ~~~");
        return map;


    }

    @GetMapping("{no}")
    public Map<String, Object> selectOne(@PathVariable String no) {
        BoardVo vo = service.selectOne(no);
        Map<String, Object> map = new HashMap<>();
        map.put("data", vo);
        map.put("status", "selectOne ok ~~~");
        return map;
    }

}

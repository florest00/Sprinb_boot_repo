package com.swy.app.util.file;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileUploader {

    public static String save(MultipartFile f, String dirPath) throws IOException {

        //파일 저장
        String originName = f.getOriginalFilename();
        assert originName != null;
        int idx = originName.lastIndexOf(".");
        String ext = originName.substring(idx);
        String changeName = System.currentTimeMillis() + "_" + UUID.randomUUID() + ext;
        String savePath = dirPath + changeName;
        File targetFile = new File(savePath);
        f.transferTo(targetFile);

        return changeName;

    }


}//class

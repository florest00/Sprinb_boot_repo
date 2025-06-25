package com.swy.app.member.vo;

import lombok.Data;

@Data
public class MemberVo {
    private String no;
    private String id;
    private String pwd;
    private String newPwd;
    private String nick;
    private String profile;
    private String savePath;
    private String delYn;
    private String enrollDate;
    private String modifyDate;
}

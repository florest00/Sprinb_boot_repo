package com.kh.app06.member;

import lombok.Data;

@Data
// 여러개의 어노테이션을 묶어놓음
public class MemberVo {

    private String no;
    private String userId;
    private String userPwd;
    private String userNick;
    private String createdDate;
    private String delYn;

}

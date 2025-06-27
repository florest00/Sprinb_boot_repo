package com.swy.app.board.vo;

import lombok.Data;

@Data
public class BoardVo {
    private String no;
    private String title;
    private String content;
    private String categoryNo;
    private String writerNo;
    private String hit;
    private String createDate;
    private String delYn;
}

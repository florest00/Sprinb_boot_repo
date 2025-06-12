package com.kh.app04.board.board;

public class BoardVo {

    private String no;
    private String title;
    private String content;
    private String writerNo;
    private String createdDate;
    private String hit;
    private String delYn;

    public BoardVo() {
    }

    public BoardVo(String no, String title, String content, String writerNo, String createdDate, String hit, String delYn) {
        this.no = no;
        this.title = title;
        this.content = content;
        this.writerNo = writerNo;
        this.createdDate = createdDate;
        this.hit = hit;
        this.delYn = delYn;
    }

    public BoardVo(String no) {
        this.no = no;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedDate() {
        return createdDate;
    }


    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    @Override
    public String toString() {
        return "BoardVo{" +
                "no='" + no + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writerNo='" + writerNo + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", hit='" + hit + '\'' +
                ", delYn='" + delYn + '\'' +
                '}';
    }
}

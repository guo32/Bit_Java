package model;

import java.util.Date;

public class Board2DTO {
    private int id;
    private String title;
    private int writerId; // 회원 번호
    private String writerNickname; // 회원 닉네임
    private String content;
    private Date entryDate;
    private Date modifyDate;

    /*
    1. 회원 번호와 닉네임이 함께 저장되는 경우: 속도는 빠름 (최신화가 없음)
    2. 회원 번호만 저장되는 경우: 상대적으로 느림(최신화)
     */

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public int getWriterId() {
        return writerId;
    }

    public void setWriterId(int writerId) {
        this.writerId = writerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriterNickname() {
        return writerNickname;
    }

    public void setWriterNickname(String writerNickname) {
        this.writerNickname = writerNickname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean equals(Object object) {
        if (object instanceof Board2DTO) {
            Board2DTO b = (Board2DTO) object;
            return id == b.id;
        }
        return false;
    }

    public Board2DTO(Board2DTO origin) {
        id = origin.id;
        title = origin.title;
        writerId = origin.writerId;
        writerNickname = origin.writerNickname;
        content = origin.content;
        entryDate = origin.entryDate;
        modifyDate = origin.modifyDate;
    }

    public Board2DTO() {

    }

    public Board2DTO(int id) {
        this.id = id;
    }
}

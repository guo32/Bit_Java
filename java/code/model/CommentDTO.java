package model;

public class CommentDTO {
    private int id; // 댓글 고유 번호
    private int boardId; // 게시글 고유 번호
    private int userId; // 회원 고유 번호
    private String userNickname; // 회원 이름
    private String content; // 내용

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean equals(Object object) {
        if (object instanceof CommentDTO) {
            CommentDTO c = (CommentDTO) object;
            return id == c.getId();
        }
        return false;
    }

    // 생성자
    public CommentDTO() {}

    public CommentDTO(CommentDTO original) {
        id = original.id;
        boardId = original.boardId;
        userId = original.userId;
        userNickname = original.userNickname;
        content = original.content;
    }

    public CommentDTO(int id) { this.id = id; }
}

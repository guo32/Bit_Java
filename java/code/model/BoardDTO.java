package model;

public class BoardDTO {
    private int id;
    private String title;
    private String writer;
    private String content;

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

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean equals(Object object) {
        if (object instanceof BoardDTO) {
            BoardDTO b = (BoardDTO) object;
            return id == b.id;
        }
        return false;
    }

    public BoardDTO(BoardDTO boardDTO) {
        id = boardDTO.id;
        title = boardDTO.title;
        writer = boardDTO.writer;
        content = boardDTO.content;
    }

    public BoardDTO() {

    }
}

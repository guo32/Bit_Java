package day0111;

public class Board {
    private int id;
    private String title;
    private String writer;
    private String content;

    // 게시물 생성자
    public Board(int id, String title, String writer, String content) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.content = content;
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

    // 게시물 출력
    public void print() {
        System.out.println("------------------------------");
        System.out.println("No. " + id);
        System.out.println("제목: " + title);
        System.out.println("작성자: " + writer);
        System.out.println("------------------------------");
        System.out.println("<내용>");
        System.out.println(content);
    }

    // 게시물 비교
    public boolean equals(Object object) {
        if(object instanceof Board) {
            Board b = (Board)object;
            return id == b.id;
        }
        return false;
    }
}

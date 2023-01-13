package model;

public class UserDTO {
    private int id; // 회원 번호
    private String username; // 흔히 알고 있는 아이디
    private String password;
    private String nickname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean equals(Object object) {
        if (object instanceof UserDTO) {
            UserDTO u = (UserDTO) object;
            return id == u.id;
        }
        return false;
    }

    // 깊은 복사를 위한 생성자
    public UserDTO(UserDTO origin) {
        id = origin.id;
        username = origin.username;
        password = origin.password;
        nickname = origin.nickname;
    }

    public UserDTO() {

    }

    public UserDTO(int id) {
        this.id = id;
    }

    public String toString() {
        return "{" +
                "\"id\": " + id + ", " +
                "\"username\": " + username + ", " +
                "\"password\": " + password + ", " +
                "\"nickname\": " + nickname +
                "}";
    }
}

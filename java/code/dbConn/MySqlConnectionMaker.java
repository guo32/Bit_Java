package dbConn;

import java.sql.Connection;

public class MySqlConnectionMaker implements ConnectionMaker {
    private final String ADDRESS = "192.168.0.1";
    private final String USERNAME = "admin";
    private final String PASSWORD = "1111";
    @Override
    public Connection makeConnection() {
        System.out.println("MySQL 데이터베이스 연결 시도");
        System.out.println("연결 주소: " + ADDRESS);
        System.out.println("아이디: " + USERNAME);
        System.out.println("비밀번호: " + PASSWORD);
        System.out.println("연결 성공");

        return null;
    }
}

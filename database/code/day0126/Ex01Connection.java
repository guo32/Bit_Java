package day0126;

import java.sql.*;

public class Ex01Connection {
    public static void main(String[] args) {
        String address = "jdbc:mysql://localhost/basic";
        String username = "root";
        String password = "1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(address, username, password);
            System.out.println("MySQL 연결 성공");

            // 1. insert
            String query = "insert into `student`(`name`, `korean`, `english`, `math`) values(?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "김정민");
            preparedStatement.setInt(2, 91);
            preparedStatement.setInt(3, 91);
            preparedStatement.setInt(4, 92);

            preparedStatement.executeUpdate();
            System.out.println("INSERT 성공");

            // 2. read
            query = "select * from `student`";
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int korean = resultSet.getInt("korean");
                int english = resultSet.getInt("english");
                int math = resultSet.getInt("math");

                System.out.printf("번호: %d번 이름: %s 국어: %d점 영어: %d점 수학: %d점\n", id, name, korean, english, math);
            }

            query = "select * from `student` where `id` = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 9);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int korean = resultSet.getInt("korean");
                int english = resultSet.getInt("english");
                int math = resultSet.getInt("math");

                System.out.printf("번호: %d번 이름: %s 국어: %d점 영어: %d점 수학: %d점\n", id, name, korean, english, math);
            }

            System.out.println("READ 종료");

            // 3. update
            query = "update `student` set `name` = ? where `id` = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "박길수");
            preparedStatement.setInt(2, 13);
            preparedStatement.executeUpdate();

            System.out.println("UPDATE 종료");

            // 4. delete
            query = "delete from `student` where `name` = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "김정민");
            preparedStatement.executeUpdate();

            System.out.println("DELETE 종료");

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
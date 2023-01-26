package controller;

import model.Student;

import java.sql.*;
import java.util.ArrayList;

public class StudentController {
    private PreparedStatement preparedStatement = null;
    private Connection connection = null;
    private ResultSet resultSet = null;

    public void initialize() {
        String address = "jdbc:mysql://localhost/basic";
        String username = "root";
        String password = "1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(address, username, password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void terminate() throws SQLException {
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (resultSet != null) {
            resultSet.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    public void insert(Student student) {
        String query = "insert into `student`(`name`, `korean`, `english`, `math`) values(?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getKorean());
            preparedStatement.setInt(3, student.getEnglish());
            preparedStatement.setInt(4, student.getMath());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Student student) {
        String query = "update `student` set `korean` = ?, `english` = ?, `math` = ? where `id` = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, student.getKorean());
            preparedStatement.setInt(2, student.getEnglish());
            preparedStatement.setInt(3, student.getMath());
            preparedStatement.setInt(4, student.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        String query = "delete from `student` where `id` = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Student selectById(int id) {
        String query = "select * from `student` where `id` = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Student student = new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("korean"),
                        resultSet.getInt("english"),
                        resultSet.getInt("math")
                );
                return student;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public ArrayList<Student> selectAll() {
        ArrayList<Student> list = new ArrayList<>();
        String query = "select * from `student`";
        try {
            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("korean"),
                        resultSet.getInt("english"),
                        resultSet.getInt("math")
                );
                list.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}

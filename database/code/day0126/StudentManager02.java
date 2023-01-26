package day0126;

import util.ScannerUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
학생 관리 프로그램 ver 2.0
Student 객체와 메소드 분리를 활용한 버전
 */
public class StudentManager02 {
    static final Scanner SCANNER = new Scanner(System.in);
    static PreparedStatement preparedStatement = null;
    static Connection connection = null;
    static ResultSet resultSet = null;

    public static void main(String[] args) {
        initialize();
        showMenu();
        try {
            terminate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void showMenu() {
        String message = "1. 입력 2. 목록 보기 3. 종료";
        while (true) {
            int userChoice = ScannerUtil.nextInt(SCANNER, message, 1, 3);
            if (userChoice == 1) {
                insert();
            } else if (userChoice == 2) {
                printList();
            } else if (userChoice == 3) {
                System.out.println("시스템 종료");
                break;
            }
        }
    }

    static void initialize() {
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

    static void terminate() throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
        SCANNER.close();
    }

    // insert()
    static void insert() {
        Student s = new Student();
        String message = "학생의 이름을 입력해주세요.";
        s.setName(ScannerUtil.nextLine(SCANNER, message));

        message = "학생의 국어 점수를 입력해주세요.";
        s.setKorean(ScannerUtil.nextInt(SCANNER, message, 0, 100));

        message = "학생의 영어 점수를 입력해주세요.";
        s.setEnglish(ScannerUtil.nextInt(SCANNER, message, 0, 100));

        message = "학생의 수학 점수를 입력해주세요.";
        s.setMath(ScannerUtil.nextInt(SCANNER, message, 0, 100));

        String query = "insert into `student`(`name`, `korean`, `english`, `math`) values(?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, s.getName());
            preparedStatement.setInt(2, s.getKorean());
            preparedStatement.setInt(3, s.getEnglish());
            preparedStatement.setInt(4, s.getMath());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printList() {
        String query = "select * from `student`";

        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            ArrayList<Student> list = selectAll();

            if (list.isEmpty()) {
                System.out.println("아직 입력된 학생이 없습니다.");
            } else {
                for (Student s : list) {
                    System.out.printf("%d. %s\n", s.getId(), s.getName());
                }

                String message = "상세보기할 학생의 번호나 뒤로 가시려면 0을 입력해주세요.";
                int userChoice = ScannerUtil.nextInt(SCANNER, message);

                while (userChoice != 0 && selectOne(userChoice) == null) {
                    System.out.println("잘못 입력하셨습니다.");
                    userChoice = ScannerUtil.nextInt(SCANNER, message);
                }

                if (userChoice != 0) {
                    printOne(userChoice);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Student> selectAll() {
        ArrayList<Student> list = new ArrayList<>();

        try {
            while (resultSet.next()) {
                Student s = new Student();
                s.setId(resultSet.getInt("id"));
                s.setName(resultSet.getString("name"));
                s.setKorean(resultSet.getInt("korean"));
                s.setEnglish(resultSet.getInt("english"));
                s.setMath(resultSet.getInt("math"));

                list.add(s);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    static Student selectOne(int id) {
        String query = "select * from `student` where `id` = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Student s = new Student();
                s.setId(resultSet.getInt("id"));
                s.setName(resultSet.getString("name"));
                s.setKorean(resultSet.getInt("korean"));
                s.setEnglish(resultSet.getInt("english"));
                s.setMath(resultSet.getInt("math"));

                return s;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    static void printOne(int id) {
        Student s = selectOne(id);
        s.printInfo();

        String message = "1. 수정 2. 삭제 3. 뒤로가기";
        int userChoice = ScannerUtil.nextInt(SCANNER, message, 1, 3);
        if (userChoice == 1) {
            update(id);
        } else if (userChoice == 2) {
            delete(id);
        } else if (userChoice == 3) {
            printList();
        }
    }

    static void update(int id) {
        String message = "새로운 국어 점수를 입력해주세요.";
        int korean = ScannerUtil.nextInt(SCANNER, message, 0, 100);

        message = "새로운 영어 점수를 입력해주세요.";
        int english = ScannerUtil.nextInt(SCANNER, message, 0, 100);

        message = "새로운 수학 점수를 입력해주세요.";
        int math = ScannerUtil.nextInt(SCANNER, message, 0, 100);

        String query = "update `student` set `korean` = ?, `english` = ?, `math` = ? where `id` = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, korean);
            preparedStatement.setInt(2, english);
            preparedStatement.setInt(3, math);
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();

            printOne(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static void delete(int id) {
        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(SCANNER, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            String query = "delete from `student` where `id` = ?";
            try {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, id);

                preparedStatement.executeUpdate();

                printList();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            printOne(id);
        }
    }
}

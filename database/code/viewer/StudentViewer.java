package viewer;

import controller.StudentController;
import model.Student;
import util.ScannerUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentViewer {
    private final Scanner SCANNER;
    private final int SCORE_MIN = 0;
    private final int SCORE_MAX = 100;
    private final int SUBJECT_SIZE = 3;
    private StudentController studentController;

    public StudentViewer() {
        SCANNER = new Scanner(System.in);
        studentController = new StudentController();
    }

    public void showMenu() {
        studentController.initialize();
        while (true) {
            String message = "[1] 학생 입력 [2] 학생 목록 [3] 종료";
            int userChoice = ScannerUtil.nextInt(SCANNER, message, 1, 3);
            if (userChoice == 1) {
                insertStudent();
            } else if (userChoice == 2) {
                printStudentList();
            } else if (userChoice == 3) {
                System.out.println("시스템을 종료합니다.");
                break;
            }
        }
        try {
            studentController.terminate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void insertStudent() {
        String message = "학생의 이름을 입력해주세요.";
        String name = ScannerUtil.nextLine(SCANNER, message);

        message = "학생의 국어 점수를 입력해주세요.";
        int korean = ScannerUtil.nextInt(SCANNER, message, SCORE_MIN, SCORE_MAX);

        message = "학생의 영어 점수를 입력해주세요.";
        int english = ScannerUtil.nextInt(SCANNER, message, SCORE_MIN, SCORE_MAX);

        message = "학생의 수학 점수를 입력해주세요.";
        int math = ScannerUtil.nextInt(SCANNER, message, SCORE_MIN, SCORE_MAX);

        Student newStudent = new Student(name, korean, english, math);
        studentController.insert(newStudent);

        System.out.println("정상적으로 입력되었습니다.");
    }

    private void printStudentList() {
        ArrayList<Student> list = studentController.selectAll();
        if (list.isEmpty()) {
            System.out.println("아직 입력된 학생의 정보가 없습니다.");
        } else {
            for (Student s : list) {
                System.out.printf("[%d] %s\n", s.getId(), s.getName());
            }
            String message = "상세보기할 학생의 번호를 입력해주세요.\n[번호] 상세보기 [0] 뒤로가기";
            int userChoice = ScannerUtil.nextInt(SCANNER, message);
            while (userChoice != 0 && studentController.selectById(userChoice) == null) {
                System.out.println("존재하지 않는 학생의 번호입니다.");
                userChoice = ScannerUtil.nextInt(SCANNER, message);
            }
            if (userChoice != 0) {
                printStudentInfo(userChoice);
            }
        }
    }

    private void printStudentInfo(int id) {
        Student student = studentController.selectById(id);

        int sum = student.getKorean() + student.getEnglish() + student.getMath();
        double average = (double) sum / SUBJECT_SIZE;

        System.out.printf("[번호] %d번\n[이름] %s\n[국어] %d점 [영어] %d점 [수학] %d점\n[총점] %d점 [평균] %.2f점\n", student.getId(), student.getName(), student.getKorean(), student.getEnglish(), student.getMath(), sum, average);

        String message = "[1] 수정 [2] 삭제 [3] 뒤로가기";
        int userChoice = ScannerUtil.nextInt(SCANNER, message, 1, 3);
        if (userChoice == 1) {
            updateStudent(id);
        } else if (userChoice == 2) {
            deleteStudent(id);
        } else if (userChoice == 3) {
            printStudentList();
        }
    }

    private void updateStudent(int id) {
        Student student = studentController.selectById(id);

        String message = "새로운 국어 점수를 입력해주세요.";
        student.setKorean(ScannerUtil.nextInt(SCANNER, message, SCORE_MIN, SCORE_MAX));

        message = "새로운 영어 점수를 입력해주세요.";
        student.setEnglish(ScannerUtil.nextInt(SCANNER, message, SCORE_MIN, SCORE_MAX));

        message = "새로운 수학 점수를 입력해주세요.";
        student.setMath(ScannerUtil.nextInt(SCANNER, message, SCORE_MIN, SCORE_MAX));

        studentController.update(student);
        printStudentInfo(id);
    }

    private void deleteStudent(int id) {
        String message = "정말로 삭제하시겠습니까?\n[Y] 삭제 [N] 취소";
        String yesNo = ScannerUtil.nextLine(SCANNER, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            studentController.delete(id);
            printStudentList();
        } else {
            printStudentInfo(id);
        }
    }
}

package day0111;

import util.ScannerUtil;

import java.util.Scanner;

/*
학생 관리 프로그램
 */
public class Ex01Gradebook02 {
    // 상수
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final int STUDENT_SIZE = 5;
    public static final int SCORE_MIN = 0;
    public static final int SCORE_MAX = 100;

    // 전역 배열 변수
    public static Student[] studentArray = new Student[STUDENT_SIZE];
    public static void main(String[] args) {
        showMenu();

        SCANNER.close();
    }

    // 메뉴를 출력하는 메소드
    public static void showMenu() {
        while(true) {
            String message = "1. 입력 2. 출력 3. 종료";
            int userChoice = ScannerUtil.nextInt(SCANNER, message, 1, 3);

            if(userChoice == 1) {
                insertStudent();
            } else if(userChoice == 2) {
                printStudent();
            } else if(userChoice == 3) {
                // 종료
                System.out.println("시스템을 종료합니다.");
                break;
            }
        }
    }

    public static void insertStudent() {
        int insertNumber = findLastNumber();
        boolean duplicate = true;

        while(duplicate) {
            Student s = new Student();
            String message = "학생의 번호를 입력하세요.";
            s.setId(ScannerUtil.nextInt(SCANNER, message));

            message = "학생의 이름을 입력하세요.";
            s.setName(ScannerUtil.nextLine(SCANNER, message));

            message = "학생의 국어 점수를 입력하세요.";
            s.setKorean(ScannerUtil.nextInt(SCANNER, message, SCORE_MIN, SCORE_MAX));

            message = "학생의 영어 점수를 입력하세요.";
            s.setEnglish(ScannerUtil.nextInt(SCANNER, message, SCORE_MIN, SCORE_MAX));

            message = "학생의 수학 점수를 입력하세요.";
            s.setMath(ScannerUtil.nextInt(SCANNER, message, SCORE_MIN, SCORE_MAX));

            // 중복 검사하기
            duplicate = checkDuplicate(s);
            if(duplicate) {
                System.out.println("중복된 번호입니다. 다시 입력해주세요.");
            } else {
                if(insertNumber == -1) {
                    moveElement();
                    insertNumber = STUDENT_SIZE - 1;
                }
                studentArray[insertNumber] = s;
            }
        }
    }

    public static void moveElement() {
        for(int i = 0; i < STUDENT_SIZE - 1; i++) {
            studentArray[i] = studentArray[i + 1];
        }
    }

    // 학생의 번호가 중복되는지 검사하는 메소드 중복 시 true
    public static boolean checkDuplicate(Student student) {
        int lastNumber = findLastNumber();
        if(lastNumber == -1) lastNumber = STUDENT_SIZE;
        for(int i = 0; i < lastNumber; i++) {
            if(studentArray[i].equals(student)) return true;
        }
        return false;
    }

    public static int findLastNumber() {
        for(int i = 0; i < STUDENT_SIZE; i++) {
            if(studentArray[i] == null) return i;
        }
        return -1;
    }

    public static void printStudent() {
        int lastNumber = findLastNumber();
        if(lastNumber == 0) {
            System.out.println("입력된 내용이 없습니다.");
        } else {
            if(lastNumber == -1) lastNumber = STUDENT_SIZE;
            for(int i = 0; i < lastNumber; i++) {
                studentArray[i].print();
            }
        }
    }
}

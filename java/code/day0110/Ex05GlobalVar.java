package day0110;

import util.ScannerUtil;

import java.util.Scanner;

/*
전역 변수(Global Variable)
 */
public class Ex05GlobalVar {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final int SUBJECT_SIZE = 3;
    public static final int SCORE_MIN = 0;
    public static final int SCORE_MAX = 100;
    public static Student student = null;

    public static void main(String[] args) {
        while(true) {
            String message = "1. 입력 2. 출력 3. 종료";
            int userChoice = ScannerUtil.nextInt(SCANNER, message);
            if(userChoice == 1) {
                insertInfo();
            }
            if(userChoice == 2) {
                if(student != null) {
                    printInfo();
                } else {
                    System.out.println("아직 입력된 학생의 정보가 존재하지 않습니다.");
                }
            }
            if(userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
        SCANNER.close();
    }

    public static void insertInfo() {
        String message = "";
        // 번호
        message = "학생의 번호를 입력해주세요.";
        student.id = ScannerUtil.nextInt(SCANNER, message);

        // 이름
        message = "학생의 이름을 입력해주세요.";
        student.name = ScannerUtil.nextLine(SCANNER, message);

        // 국어
        message = "학생의 국어 점수를 입력해주세요.";
        student.korean = ScannerUtil.nextInt(SCANNER, message, SCORE_MIN, SCORE_MAX);

        // 영어
        message = "학생의 영어 점수를 입력해주세요.";
        student.english = ScannerUtil.nextInt(SCANNER, message, SCORE_MIN, SCORE_MAX);

        // 수학
        message = "학생의 수학 점수를 입력해주세요.";
        student.math = ScannerUtil.nextInt(SCANNER, message, SCORE_MIN, SCORE_MAX);
    }

    public static void printInfo() {
        System.out.println("번호: " + student.id + "번 이름: " + student.name);
        System.out.println("국어: " + student.korean + "점 영어: " + student.english + "점 수학: " + student.math + "점");
        System.out.printf("총점: %d점 평균: %.2f점\n", calculateSum(), calculateAvg());
    }

    public static int calculateSum() {
        return student.korean + student.english + student.math;
    }

    public static double calculateAvg() {
        return (double)calculateSum() / SUBJECT_SIZE;
    }
}
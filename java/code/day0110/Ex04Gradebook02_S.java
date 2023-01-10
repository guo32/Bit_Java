package day0110;

import util.ScannerUtil;

import java.util.Scanner;

/*
무한 루프를 사용하여
사용자가 입력을 누를 때마다 새로운 학생의 정보가 입력이 되고
출력을 누를 때마다 맨 마지막으로 입력된 학생의 정보가 출력되는 프로그램을
작성해보시오.
 */
public class Ex04Gradebook02_S {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        boolean inputSwitch = false;
        while (true) {
            int menu = inputMenu(scanner);
            if(menu == 1) {
                insertInfo(scanner, student);
                inputSwitch = true;
            }
            if(menu == 2) {
                if(inputSwitch) {
                    printInfo(student);
                } else {
                    System.out.println("아직 입력된 학생의 정보가 존재하지 않습니다.");
                }
            }
            if(menu == 3) {
                System.out.println("시스템 종료");
                break;
            }
        }
    }

    public static int inputMenu(Scanner scanner) {
        String message = "1: 입력, 2: 출력, 3: 종료";
        return ScannerUtil.nextInt(scanner, message);
    }

    public static void insertInfo(Scanner scanner, Student student) {
        String message = "";
        int min = 0;
        int max = 100;
        // 번호
        message = "학생의 번호를 입력해주세요.";
        student.id = ScannerUtil.nextInt(scanner, message);

        // 이름
        message = "학생의 이름을 입력해주세요.";
        student.name = ScannerUtil.nextLine(scanner, message);

        // 국어
        message = "학생의 국어 점수를 입력해주세요.";
        student.korean = ScannerUtil.nextInt(scanner, message, min, max);

        // 영어
        message = "학생의 영어 점수를 입력해주세요.";
        student.english = ScannerUtil.nextInt(scanner, message, min, max);

        // 수학
        message = "학생의 수학 점수를 입력해주세요.";
        student.math = ScannerUtil.nextInt(scanner, message, min, max);
    }

    public static void printInfo(Student student) {
        System.out.println("번호: " + student.id + "번 이름: " + student.name);
        System.out.println("국어: " + student.korean + "점 영어: " + student.english + "점 수학: " + student.math + "점");
        System.out.printf("총점: %d점 평균: %.2f점\n", calculateSum(student), calculateAvg(student));
    }

    public static int calculateSum(Student student) {
        return student.korean + student.english + student.math;
    }

    public static double calculateAvg(Student student) {
        return (double)calculateSum(student) / 3.0;
    }
}

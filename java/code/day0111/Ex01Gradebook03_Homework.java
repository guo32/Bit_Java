package day0111;

import util.ArrayUtil;
import util.ScannerUtil;

import java.util.Scanner;

/*
학생 관리 프로그램
 */
public class Ex01Gradebook03_Homework {
    // 상수
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final int SCORE_MIN = 0;
    public static final int SCORE_MAX = 100;

    // 전역 배열 변수
    public static Student[] studentArray = new Student[0];
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
                printList();
            } else if(userChoice == 3) {
                // 종료
                System.out.println("시스템을 종료합니다.");
                break;
            }
        }
    }

    public static void insertStudent() {
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
            duplicate = ArrayUtil.contains(studentArray, s);
            if(duplicate) {
                System.out.println("중복된 번호입니다. 다시 입력해주세요.");
            } else {
                studentArray = ArrayUtil.add(studentArray, s); // 새로운 학생 삽입
            }
        }
    }

    public static void printList() {
        if (ArrayUtil.isEmpty(studentArray)) {
            System.out.println("입력된 정보가 없습니다.");
        } else {
            for (Student student : studentArray) {
                System.out.printf("* %d번 %s\n", student.getId(), student.getName());
            }
            String message = "성적을 확인할 학생의 번호를 입력하세요. 돌아가려면 0번을 입력하세요.";
            int userChoice = ScannerUtil.nextInt(SCANNER, message);
            while ((userChoice!=0 && ArrayUtil.indexOf(studentArray, userChoice) == -1)) {
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(SCANNER, message);
            }
            if(userChoice != 0) {
                printStudent(userChoice);
            }
        }
    }

    public static void printStudent(int id) {
        if (ArrayUtil.indexOf(studentArray, id) == -1) {
            System.out.println("존재하지 않는 학생의 id입니다.");
        } else {
            studentArray[ArrayUtil.indexOf(studentArray, id)].print();
            String message = "1. 수정 2. 삭제 3. 돌아가기";
            int userChoice = ScannerUtil.nextInt(SCANNER, message, 1, 3);
            if(userChoice == 1) {
                updateStudent(id);
            } else if (userChoice == 2) {
                deleteStudent(id);
            } else if (userChoice == 3) {
                printList();
            }
        }
    }

    public static void updateStudent(int id) {
        String message = "국어 점수 수정";
        studentArray[ArrayUtil.indexOf(studentArray, id)].setKorean(ScannerUtil.nextInt(SCANNER, message, SCORE_MIN, SCORE_MAX));

        message = "영어 점수 수정";
        studentArray[ArrayUtil.indexOf(studentArray, id)].setEnglish(ScannerUtil.nextInt(SCANNER, message, SCORE_MIN, SCORE_MAX));

        message = "수학 점수 수정";
        studentArray[ArrayUtil.indexOf(studentArray, id)].setMath(ScannerUtil.nextInt(SCANNER, message, SCORE_MIN, SCORE_MAX));

        printStudent(id);
    }

    public static void deleteStudent(int id) {
        studentArray = ArrayUtil.removeByIndex(studentArray, ArrayUtil.indexOf(studentArray, id));
        System.out.println("삭제되었습니다");

        printList();
    }
}

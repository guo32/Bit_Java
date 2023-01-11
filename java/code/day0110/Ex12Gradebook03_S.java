package day0110;

import util.ScannerUtil;

import java.util.Scanner;

/*
1. 5명의 학생의 성적을 관리하는 프로그램을 작성하시오.
   단, 5명을 모두 입력한 후에는 더이상 입력할 수 없도록 코드를 작성하시오. V
2. 5명의 학생 성적을 관리하는 프로그램을 작성하시오.
   단, 5명을 모두 입력한 후에 새로운 학생 정보를 입력할 시에는
   가장 오래된 기록을 제거하고 새로운 학생 정보가 입력되도록 코드를 작성하시오.
 */
public class Ex12Gradebook03_S {
    public static final int STUDENT_SIZE = 5;
    public static final int SCORE_MIN = 0;
    public static final int SCORE_MAX = 100;
    public static final Scanner SCANNER = new Scanner(System.in);

    // 전역 배열 변수
    public static Student[] studentArray = new Student[STUDENT_SIZE];
    public static void main(String[] args) {
        showMenu();

        SCANNER.close();
    }

    public static void showMenu() {
        while(true) {
            String message = "1. 입력 2. 출력 3. 종료";
            int userChoice = ScannerUtil.nextInt(SCANNER, message);

            if(userChoice == 1) {
                insertStudent();
            } else if(userChoice == 2) {
                printStudent();
            } else if(userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    // 학생의 정보를 삽입하는 메소드
    public static void insertStudent() {
        int index = findNextIndex();
        if(index == -1) {
            moveElement();
            index = 4;
            // System.out.println("더 이상 저장할 수 없습니다.");
        }

        Student s = new Student();
        String message;

        message = "학생의 번호를 입력하세요.";
        s.id = ScannerUtil.nextInt(SCANNER, message);

        message = "학생의 이름을 입력하세요.";
        s.name = ScannerUtil.nextLine(SCANNER, message);

        message = "학생의 국어 점수를 입력하세요.";
        s.korean = ScannerUtil.nextInt(SCANNER, message, SCORE_MIN, SCORE_MAX);

        message = "학생의 영어 점수를 입력하세요.";
        s.english = ScannerUtil.nextInt(SCANNER, message, SCORE_MIN, SCORE_MAX);

        message = "학생의 수학 점수를 입력하세요.";
        s.math = ScannerUtil.nextInt(SCANNER, message, SCORE_MIN, SCORE_MAX);

        studentArray[index] = s;
    }

    /*
     다음에 삽입될 인덱스를 찾는 메소드
     배열의 null 값이 존재하지 않으면 더 이상 값을
     추가할 수 없으므로 -1을 반환한다.
     */
    public static int findNextIndex() {
        for(int i = 0; i < studentArray.length; i++) {
            if(studentArray[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public static void moveElement() {
        for(int i = 0; i < studentArray.length - 1; i++) {
            studentArray[i] = studentArray[i + 1];
        }
    }

    // 학생의 정보를 출력하는 메소드
    public static void printStudent() {
        if(findNextIndex() == 0) {
            System.out.println("아직 입력된 학생이 존재하지 않습니다.");
        } else {
            int lastIndex = findNextIndex();
            if(lastIndex == -1) {
                lastIndex = 5;
            }
            for(int i = 0; i < lastIndex; i++) {
                Student s = studentArray[i];
                System.out.println("번호: " + s.id);
            }
        }
    }
}

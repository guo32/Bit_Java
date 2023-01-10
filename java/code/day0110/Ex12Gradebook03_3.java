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
public class Ex12Gradebook03_3 {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final int STUDENT_SIZE = 5;
    public static final int SUBJECT_SIZE = 3;

    public static void main(String[] args) {
        int accrue = 0;
        int old = 0;
        boolean inputSwitch = false;

        Student[] studentArray = new Student[STUDENT_SIZE];

        String message;
        while(true) {
            // 메뉴 입력 받기
            message = "1. 입력 2. 출력 3. 종료";
            int userChoice = ScannerUtil.nextInt(SCANNER, message, 1, 3);

            if(userChoice == 1) {
                // 입력된 학생의 수가 5명보다 적을 경우
                if(accrue < STUDENT_SIZE) {
                    studentArray[accrue] = new Student();
                    insertInfo(SCANNER, studentArray[accrue]);
                    accrue++;
                } else {
                    if(old >= STUDENT_SIZE) old -= STUDENT_SIZE;
                    message = STUDENT_SIZE + "명 초과로 학생" + studentArray[old].id + "번이 지워질 수 있습니다.\n계속하시겠습니까? 1. 예 2. 아니오";
                    int agree = ScannerUtil.nextInt(SCANNER, message, 1, 2);
                    if(agree == 1) {
                        for(int i = 0; i < STUDENT_SIZE; i++) {
                            if(i != STUDENT_SIZE - 1) studentArray[i] = studentArray[i + 1];
                            else {
                                Student temp = new Student();
                                insertInfo(SCANNER, temp);
                                studentArray[i] = temp;
                            }
                        }
                        old++;
                    } else {
                        System.out.println("입력을 취소하셨습니다.");
                    }
                }
                inputSwitch = true;
            } else if(userChoice == 2) {
                if(inputSwitch) {
                    for(Student student:studentArray) {
                        if(student == null) break;
                        else printInfo(student);
                    }
                } else {
                    System.out.println("입력된 데이터가 없습니다.");
                }
            } else {
                System.out.println("시스템을 종료합니다.");
                break;
            }
        }
    }

    public static void insertInfo(Scanner scanner, Student student) {
        String message;
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
        System.out.println("--------------------------------");
    }

    public static int calculateSum(Student student) {
        return student.korean + student.english + student.math;
    }

    public static double calculateAvg(Student student) {
        return (double)calculateSum(student) / (double)SUBJECT_SIZE;
    }
}

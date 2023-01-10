package day0110;

import util.ScannerUtil;

import java.util.Random;
import java.util.Scanner;

/*
로또 번호 추첨기
ver 3.0
사용자 숫자 추가

사용자로부터 1. 자동 2. 수동 입력받아서
각각에 맞게 메소드를 실행시킨 후
컴퓨터의 숫자와 비교해서
총 맞은 갯수를 출력하는 프로그램을 작성하시오.
 */
public class Ex10Lotto03_S {
    // 전역 상수 선언
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final int MIN = 1; // 최소
    public static final int MAX = 45; // 최대
    public static final int NUMBER_LENGTH = 6;

    // 전역 변수 선언
    // 사용자 숫자 배열(자동/수동)
    public static int[] userNumbers = new int[NUMBER_LENGTH];
    // 컴퓨터 숫자 배열
    public static int[] computerNumbers = new int[NUMBER_LENGTH];

    public static void main(String[] args) {
        // 자동, 수동 입력받기
        String message = "1. 자동 2. 수동";
        int select = ScannerUtil.nextInt(SCANNER, message);

        if(select == 1) {
            // 자동으로 번호 입력
            setAutoNumbers(userNumbers);
        } else {
            // 수동으로 번호 입력
            setManualNumbers(userNumbers);
        }
        // 입력된 숫자 배열 정렬
        sort(userNumbers);

        // 컴퓨터 숫자 배열 생성 및 정렬
        setAutoNumbers(computerNumbers);
        sort(computerNumbers);

        // 결과 출력
        printResult();
    }

    // 자동으로 로또 번호를 생성하는 메소드
    public static void setAutoNumbers(int[] array) {
        Random random = new Random();
        // 조건에 따라 증감되는 경우가 달라지기 때문에 증감식 생략
        for(int i = 0; i < array.length;) {
            int temp = random.nextInt(MAX) + MIN;
            /*
            temp의 값이 존재하는지 확인
            temp와 중복되는 값이 없다면(false) if문 내 문장 실행
             */
            if(!contains(array, temp)) {
                array[i] = temp;
                i++; // i의 값 증가
            }
        }
    }

    /*
    element가 array에 존재하는지 확인하기 위한 메소드
    존재할 때 true
    존재하지 않을 때 false
     */
    public static boolean contains(int[] array, int element) {
        for(int i = 0; i < array.length; i++) {
            // element와 array의 i번째 원소의 값이 같다면
            if(element == array[i]) return true;
        }
        return false;
    }

    // 수동으로 로또 번호를 생성하는 메소드
    public static void setManualNumbers(int[] array) {
        for(int i = 0; i < array.length;) {
            int temp = ScannerUtil.nextInt(SCANNER, "1~45 사이의 숫자를 입력해주세요.", MIN, MAX);
            if(!contains(array, temp)) { // 중복되지 않은 경우
                array[i] = temp;
                i++;
            } else { // 중복된 경우
                System.out.println("중복된 숫자는 입력하실 수 없습니다.");
            }
        }
    }

    // 배열을 정렬하는 메소드
    public static void sort(int[] array) {
        for(int i = 0; i < array.length - 1; i++) {
            if(array[i] > array[i + 1]) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                i = -1;
            }
        }
    }

    // 결과를 출력하는 메소드
    public static void printResult() {
        System.out.println("사용자의 숫자");
        printArray(userNumbers);

        System.out.println("컴퓨터의 숫자");
        printArray(computerNumbers);

        System.out.println("총 맞은 개수: " + countSame());
    }

    // 배열을 출력하는 메소드
    public static void printArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.printf("%d", array[i]);
            if(i < array.length - 1) System.out.print(", ");
            else System.out.println();
        }
    }

    // 배열 간 같은 원소의 개수를 찾아내는 메소드
    public static int countSame() {
        int count = 0;
        for(int number:computerNumbers) {
            if(contains(userNumbers, number)) count++;
        }

        return count;
    }
}

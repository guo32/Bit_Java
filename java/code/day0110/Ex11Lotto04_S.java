package day0110;

import util.ScannerUtil;

import java.util.Scanner;

public class Ex11Lotto04_S {
    // 전역 상수
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final int ARRAY_LENGTH = 6;
    public static final int NUMBER_MIN = 1;
    public static final int NUMBER_MAX = 45;

    public static void main(String[] args) {
        // 게임 세트 입력 받기
        String message = "총 몇 게임을 하시겠습니까?";
        int gameSize = ScannerUtil.nextInt(SCANNER, message);

        int[][] userNumbers = new int[gameSize][ARRAY_LENGTH];

        setNumbers(userNumbers);

        int[] computerNumbers = new int[ARRAY_LENGTH];
        Ex11Lotto04.setAutoNumbers(computerNumbers);
        Ex11Lotto04.sort(computerNumbers);

        printResult(userNumbers, computerNumbers);
    }

    public static void setNumbers(int[][] arrays) {
        for(int i = 0; i < arrays.length; i++) {
            System.out.println((i + 1) + "번째 게임");
            String message = "1. 자동 2. 수동";
            // 1 또는 2만 입력받도록 함
            int userChoice = ScannerUtil.nextInt(SCANNER, message, 1, 2);

            if(userChoice == 1) { // 자동
                Ex11Lotto04.setAutoNumbers(arrays[i]);
            } else { // 수동
                Ex11Lotto04.setManualNumbers(arrays[i]);
            }

            // 배열 정렬
            Ex11Lotto04.sort(arrays[i]);
        }
    }

    public static void printResult(int[][] userNumbers, int[] computerNumbers) {
        System.out.print("컴퓨터 숫자: ");
        printArray(computerNumbers);
        System.out.println();
        System.out.println("사용자 숫자");
        for(int i = 0; i < userNumbers.length; i++) {
            System.out.printf("%d번 게임: ", i + 1);
            printArray(userNumbers[i]);
            System.out.printf(" - %d개\n", countSame(computerNumbers, userNumbers[i]));
        }
    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for(int i = 0; i < array.length; i++) {
            System.out.printf("%2d", array[i]);
            if(i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    public static int countSame(int[] computerNumbers, int[] userNumbers) {
        int count = 0;
        for(int i = 0; i < computerNumbers.length; i++) {
            if(Ex11Lotto04.contains(userNumbers, computerNumbers[i])) count++;
        }

        return count;
    }
}

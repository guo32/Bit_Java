package day0110;

import util.ScannerUtil;

import java.util.Random;
import java.util.Scanner;

/*
로또 시뮬레이터
ver 4.0
사용자로부터 총 몇 게임할지 입력 받은 후에
해당 게임마다 각각 자동/수동 입력을 받아서
알맞게 처리하는 프로그램
 */
public class Ex11Lotto04 {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final int MIN = 1;
    public static final int MAX = 45;
    public static final int NUMBER_LENGTH = 6;

    public static int[] computerNumbers = new int[NUMBER_LENGTH];

    public static void main(String[] args) {
        String message = "게임 수를 입력해주세요.";
        int set = ScannerUtil.nextInt(SCANNER, message);
        int[][] lottoArray = new int[set][NUMBER_LENGTH];

        setAutoNumbers(computerNumbers);
        sort(computerNumbers);

        for(int i = 0; i < set; i++) {
            // 자동, 수동 입력받기
            message = (i + 1) + "번 게임\n1. 자동 2. 수동";
            int select = ScannerUtil.nextInt(SCANNER, message);

            if(select == 1) {
                setAutoNumbers(lottoArray[i]);
            } else {
                setManualNumbers(lottoArray[i]);
            }
            sort(lottoArray[i]);
        }

        for(int i = 0; i < set; i++) {
            System.out.printf("[%d번 게임 결과]\n", i + 1);
            printResult(lottoArray[i]);
        }
    }

    public static void setAutoNumbers(int[] array) {
        Random random = new Random();
        for(int i = 0; i < array.length; ) {
            int temp = random.nextInt(MAX) + MIN;
            if(!contains(array, temp)) {
                array[i] = temp;
                i++;
            }
        }
    }

    public static boolean contains(int[] array, int element) {
        for(int i = 0; i < array.length; i++) {
            if(element == array[i]) return true;
        }
        return false;
    }

    public static void setManualNumbers(int[] array) {
        for(int i = 0; i < array.length;) {
            int temp = ScannerUtil.nextInt(SCANNER, "1~45 사이의 숫자를 입력해주세요.", MIN, MAX);
            if(!contains(array, temp)) {
                array[i] = temp;
                i++;
            } else {
                System.out.println("중복된 숫자는 입력하실 수 없습니다.");
            }
        }
    }

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

    public static void printResult(int[] array) {
        System.out.println("사용자의 숫자");
        printArray(array);

        System.out.println("컴퓨터의 숫자");
        printArray(computerNumbers);

        System.out.println("총 맞은 개수: " + countSame(array));
    }

    public static void printArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.printf("%d", array[i]);
            if(i < array.length - 1) System.out.print(", ");
            else System.out.println();
        }
    }

    public static int countSame(int[] array) {
        int count = 0;
        for(int i = 0; i < computerNumbers.length; i++) {
            if(contains(array, computerNumbers[i])) count++;
        }

        return count;
    }
}

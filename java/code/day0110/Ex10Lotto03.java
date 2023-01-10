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
public class Ex10Lotto03 {
    public static final int MIN = 1;
    public static final int MAX = 45;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 자동, 수동 입력받기
        String message = "1. 자동 2. 수동";
        int select = ScannerUtil.nextInt(scanner, message);

        // 컴퓨터 숫자 생성
        int[] computerLottoNumbers = new int[6];
        createAutoLottoNumbers(computerLottoNumbers);

        int[] autoLottoNumbers = new int[6];
        int[] nonAutoLottoNumbers = new int[6];
        int count = 0;

        if(select == 1) {
            // 자동으로 숫자 생성
            createAutoLottoNumbers(autoLottoNumbers);
            // 갯수 확인
            count = countSameLottoNumbers(computerLottoNumbers, autoLottoNumbers);
            // 출력
            printArray(computerLottoNumbers);
            printArray(autoLottoNumbers);
            System.out.println("맞은 개수: " + count);
        }
        if(select == 2) {
            // 수동으로 숫자 생성
            createNonAutoLottoNumbers(scanner, nonAutoLottoNumbers);
            // 갯수 확인
            count = countSameLottoNumbers(computerLottoNumbers, nonAutoLottoNumbers);
            printArray(computerLottoNumbers);
            printArray(nonAutoLottoNumbers);
            System.out.println("맞은 개수: " + count);
        }
    }

    public static void createAutoLottoNumbers(int[] lottoNumbers) {
        Random random = new Random();
        // 중복되지 않는 숫자를 배열에 부여하기
        for(int i = 0; i < lottoNumbers.length;) {
            int temp = random.nextInt(45) + 1;
            boolean numberSwitch = true;
            for(int j = 0; j < i; j++) {
                if(temp == lottoNumbers[j]) numberSwitch = false;
            }
            if(numberSwitch) {
                lottoNumbers[i] = temp;
                i++;
            } else continue;
        }

        sortArray(lottoNumbers);
    }

    public static void createNonAutoLottoNumbers(Scanner scanner, int[] lottoNumbers) {
        for(int i = 0; i < lottoNumbers.length;) {
            String message = (i + 1) + "번째 번호 입력";
            int temp = ScannerUtil.nextInt(scanner, message, MIN, MAX);
            boolean numberSwitch = true;
            for(int j = 0; j < i; j++) {
                if(temp == lottoNumbers[j]) {
                    System.out.println("중복된 숫자입니다. 다시 입력해주세요.");
                    numberSwitch = false;
                }
            }
            if(numberSwitch) {
                lottoNumbers[i] = temp;
                i++;
            } else continue;
        }

        sortArray(lottoNumbers);
    }

    public static void sortArray(int[] lottoNumbers) {
        for(int i = 0; i < lottoNumbers.length - 1; i++) {
            if(lottoNumbers[i] > lottoNumbers[i + 1]) {
                int temp = lottoNumbers[i];
                lottoNumbers[i] = lottoNumbers[i + 1];
                lottoNumbers[i + 1] = temp;
                i = -1;
            }
        }
    }

    public static void printArray(int[] lottoNumbers) {
        for(int i = 0; i < lottoNumbers.length; i++) {
            System.out.printf("%d", lottoNumbers[i]);
            if(i < lottoNumbers.length - 1) System.out.print(", ");
            else System.out.println();
        }
    }

    public static int countSameLottoNumbers(int[] computer, int[] array) {
        int result = 0;
        for(int i = 0; i < computer.length; i++) {
            for(int j = i; j < computer.length; j++) {
                if(computer[i] == array[j]) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}

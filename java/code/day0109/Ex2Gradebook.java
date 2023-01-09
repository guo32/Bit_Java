package day0109;
/*
사용자로부터 번호, 이름, 국어, 영어, 수학 점수를 입력받아서
각각의 정보를 다음과 같이 출력되는 프로그램을 작성하시오.
단, 입력에 관한 메소드, 출력에 관한 메소드, 총점 및 평균을 계산하는 메소드를 따로 분리하시오.

출력 방법:
번호: ###번 이름: ###
국어: ##점 영어: ##점 수학: ##점
총점: ##점 평균: ##.######점
 */

import java.util.Scanner;

public class Ex2Gradebook {

    public static void main(String[] args) {
        String[] gradeData = inputData();
        double[] scoreData = calculateTotal(gradeData);
        printData(gradeData, scoreData);
    }

    // 데이터 입력 메소드
    public static String[] inputData() {
        Scanner scanner = new Scanner(System.in);
        String[] data = new String[5];
        String[] infoName = {"번호", "이름", "국어", "영어", "수학"};
        for(int i = 0; i < infoName.length; i++) {
            System.out.print("> " + infoName[i] + "입력: ");
            data[i] = scanner.next();
        }
        return data;
    }

    // 데이터 출력 메소드
    public static void printData(String[] gradeData, double[] scoreData) {
        System.out.println("번호: " + gradeData[0] + "번 이름: " + gradeData[1]);
        System.out.println("국어: " + gradeData[2] + "점 영어: " + gradeData[3] + "점 수학: " + gradeData[4] + "점");
        System.out.println("총점: " + (int)scoreData[0] + "점 평균: " + scoreData[1] + "점");

    }

    // 총점 및 평균 계산 메소드
    public static double[] calculateTotal(String[] data) {
        double[] result = new double[2];
        for(int i = 2; i < data.length; i++) {
            result[0] += Integer.parseInt(data[i]);
        }
        result[1] = result[0] / 3.0;

        return result;
    }
}
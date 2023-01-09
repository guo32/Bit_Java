package day0109;

public class Ex1Method {
    public static void main(String[] args) {
        printIntro();

        int a = 3, b = 4;
        printBigger(a, b);
        a = 4; b = 2;
        printBigger(a, b);
        printBigger(4, 4);

        a = 5; b = 3;
        int result = 5 * 5 * 5;
        System.out.println("a의 b승: " + result);
        a = 4; b = 3;
        result = calculatePower(a, b);
        System.out.println(a + "의 " + b + "승: " + result);
        System.out.println("a의 b승: " + calculatePower(2, 10));
    }

    // 단순 출력 메소드
    public static void printIntro() {
        System.out.println("Ex1Method");
        System.out.println("작성자: 구도경");
        System.out.println("작성일: 2023년 01월 09일");
        System.out.println("내용: 메소드에 대한 설명 및 예제");
    }

    // 파라미터 값을 받아온 후 단순 출력 메소드
    public static void printBigger(int num1, int num2) {
        if(num1 > num2) System.out.println("a가 더 큽니다.");
        else System.out.println("b가 더 크거나 같습니다.");
    }

    // 파라미터 값을 받아온 후 값을 반환하는 메소드
    public static int calculatePower(int num1, int num2) {
        int result = num1;
        for(int i = 0; i < num2 - 1; i++) result *= num1;

        return result;
    }
}

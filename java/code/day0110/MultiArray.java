package day0110;
/*
다차원 배열
다차원 배열이란, 배열이라는 데이터 타입의 공간 여러 개를 묶어서
하나의 다른 데이터 타입으로 만든 데이터 타입이다.
다차원 배열을 만들 때에는
차원 수만큼 [][]를 붙여주면 된다.
 */
public class MultiArray {
    public static void main(String[] args) {
        // int가 4개 모여있는 배열이 3개 모여있는 2차원 배열
        int[][] intArray = new int[3][4];

        System.out.println("intArray[0]: " + intArray[0]);

        System.out.println("intArray[1][2]: " + intArray[1][2]);

        // 다차원 배열의 경우, 몇 개의 배열이 모여있는지만 지정할 수도 있고
        // 각 배열의 길이는 각각 다르게 만들어질 수도 있다.
        // 이러한 배열을 가변형 배열이라고 한다.
        intArray = new int[4][];

        System.out.println("intArray[0]: " + intArray[0]);

        intArray[0] = new int[7];
        intArray[1] = new int[6];
        intArray[2] = new int[9];
        intArray[3] = new int[4];
        System.out.println("intArray[1][2]: " + intArray[1][2]);
    }
}

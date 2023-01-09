package day0109;

import java.util.Scanner;

public class Ex3_PrintStar {
    public void draw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("출력할 줄 수 입력 : ");
        int num = scanner.nextInt();
        // 3.
        for(int i = 1; i <= num; i++) {
            for(int j = num; j > 0; j--) {
                if(j - i > 0) System.out.print(" ");
                else System.out.print("*");
            }
            System.out.println();
        }
    }
}

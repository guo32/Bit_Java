package day0109;

import java.util.Scanner;

public class Ex4_PrintStar {
    public void draw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("출력할 줄 수 입력 : ");
        int num = scanner.nextInt();
        // 4.
        for(int i = num; i > 0 ; i--) {
            for(int j = 1; j <= num; j++) {
                if(num - i < j) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
}

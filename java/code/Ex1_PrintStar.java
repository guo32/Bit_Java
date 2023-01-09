package day0109;

import java.util.Scanner;

public class Ex1_PrintStar {
    public void draw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("출력할 줄 수 입력 : ");
        int num = scanner.nextInt();
        // 1.
        for(int i = 0; i < num; i++) {
            for(int j = 0; j <= i; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}

package day0109;

import java.util.Scanner;

public class Ex2_PrintStar {
    public void draw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("출력할 줄 수 입력 : ");
        int num = scanner.nextInt();
        // 2.
        /*
        for(int i = num; i > 0; i--) {
            for(int j = 0; j < i; j++)
                System.out.print("*");
            System.out.println();
        }
        */
        for(int i = 1; i <= num; i++) {
            String stars = "";
            for(int j = i; j <= num; j++) {
                stars += "*";
            }
            System.out.println(stars);
        }
    }
}

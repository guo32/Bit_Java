package day0109;

import java.util.Scanner;

public class Ex6_PrintStar {
    public void draw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("출력할 줄 수 입력 : ");
        int num = scanner.nextInt();
        // 6.
        /*
        for(int i = num; i > 0; i--) {
            String stars = "";
            for(int j = 1; j <= num - i; j++) {
                stars += " ";
            }
            for(int j = 2 * i - 1; j > 0; j--) {
                stars += "*";
            }
            System.out.println(stars);
        }
        */

        // 6(Hard).
        /*
        for(int i = 1; i <= num; i++) {
            String stars = "";
            for(int j = 1; j <= i - 1; j++) {
                stars += " ";
            }
            // -2 * i + (2 * num + 1)
            for(int j = 1; j <= 2 * (num - i) + 1; j++) {
                stars += "*";
            }
            System.out.println(stars);
        }
        */

        // 6(Easy).
        for(int i = num; i >= 1; i--) {
            String stars = "";
            for(int j = 1; j <= num - i; j++) {
                stars += " ";
            }
            for(int j = 1; j <= 2 * i - 1; j++) {
                stars += "*";
            }
            System.out.println(stars);
        }
    }
}

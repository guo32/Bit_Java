package day0109;

import java.util.Scanner;

public class Ex5_PrintStar {
    public void draw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("출력할 줄 수 입력 : ");
        int num = scanner.nextInt();
        // 5.
        /*
        for(int i = 1; i <= num; i++) {
            for(int j = num; j > 0; j--) {
                if(j - i > 0) System.out.print(" ");
                else {
                    System.out.print("*");
                    for(int k = 1; k < i; k++) {
                        if(k % 2 != 0) continue;
                        else System.out.print("*");
                    }
                }
            }
            System.out.println();
        }
        */

        for(int i = 1; i <= num; i++) {
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

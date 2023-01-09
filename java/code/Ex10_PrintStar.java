package day0109;

import java.util.Scanner;

public class Ex10_PrintStar {
    public void draw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("출력할 줄 수 입력 : ");
        int num = scanner.nextInt();
        // 10.
        /*
        for(int i = 1; i <= num; i++) {
            String stars = "";
            for(int j = 1; j <= num; j++) {
                if(num - i < j - 1) stars += " ";
                else stars += "*";
            }
            for(int j = num; j > 0; j--) {
                if(num - i < j - 1) stars += " ";
                else stars += "*";
            }
            System.out.println(stars);
        }
        for(int i = 2; i <= num; i++) {
            String stars = "";
            for(int j = 1; j <= i; j++) {
                stars += "*";
            }
            for(int j = 1; j <= num - i; j++) {
                stars += " ";
            }
            for(int j = 1; j <= num - i; j++) {
                stars += " ";
            }
            for(int j = 1; j <= i; j++) {
                stars += "*";
            }
            System.out.println(stars);
        }
         */

        int totalHeight = 2 * num - 1;

        for(int i = 1; i <= totalHeight; i++) {
            String stars = "";

            if(i == 1 || i == totalHeight) {
                for(int j = 1; j <= totalHeight; j++) stars += "*";
            } else {
                int starWidth = 0;

                if(i < num) {
                    starWidth = num - i + 1;
                } else {
                    int lowerI = i - num + 1;
                    starWidth = lowerI;
                }

                int spaceWidth = totalHeight - starWidth * 2;

                for(int j = 1; j <= starWidth; j++) stars += "*";
                for(int j = 1; j <= spaceWidth; j++) stars += " ";
                for(int j = 1; j <= starWidth; j++) stars += "*";
            }

            System.out.println(stars);
        }
    }
}

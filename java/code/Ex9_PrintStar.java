package day0109;

import java.util.Scanner;

public class Ex9_PrintStar {
    public void draw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("출력할 줄 수 입력 : ");
        int num = scanner.nextInt();
        // 9.
        /*
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
        for(int i = num - 1; i >= 1; i--) {
            String stars = "";
            for(int j = 1; j <= num - i; j++) {
                stars += " ";
            }
            for(int j = 1; j <= 2 * i - 1; j++) {
                stars += "*";
            }
            System.out.println(stars);
        }

         */

        int totalHeight = 2 * num - 1;
        for(int i = 1; i <= totalHeight; i++) {
            String stars = "";
            int spaceWidth = 0;
            int starWidth = 0;

            if(i < num) {
                // 윗부분
                spaceWidth = num - i;
                starWidth = 2 * i - 1;
                /*
                for(int j = 1; j <= num - i; j++) {
                    stars += " ";
                }
                for(int j = 1; j <= 2 * i - 1; j++) {
                    stars += "*";
                }
                */
            } else {
                int lowerI = i - num + 1;
                spaceWidth = lowerI - 1;
                starWidth = 2 * (num - lowerI) + 1;

                /*
                // 아랫부분
                for(int j = 1; j <= lowerI - 1; j++) {
                    stars += " ";
                }
                // -2 * i + (2 * num + 1)
                for(int j = 1; j <= 2 * (num - lowerI) + 1; j++) {
                    stars += "*";
                }
                */
            }

            for(int j = 1; j <= spaceWidth; j++) {
                stars += " ";
            }
            for(int j = 1; j <= starWidth; j++) {
                stars += "*";
            }
            System.out.println(stars);
        }
    }
}

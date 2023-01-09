package day0109;

import java.util.Scanner;

public class M_PrintStar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("별 찍기 번호 입력 : ");
            int num = scanner.nextInt();
            if(num == 1) {
                Ex1_PrintStar e = new Ex1_PrintStar();
                e.draw();
            }
            if(num == 2) {
                Ex2_PrintStar e = new Ex2_PrintStar();
                e.draw();
            }
            if(num == 3) {
                Ex3_PrintStar e = new Ex3_PrintStar();
                e.draw();
            }
            if(num == 4) {
                Ex4_PrintStar e = new Ex4_PrintStar();
                e.draw();
            }
            if(num == 5) {
                Ex5_PrintStar e = new Ex5_PrintStar();
                e.draw();
            }
            if(num == 6) {
                Ex6_PrintStar e = new Ex6_PrintStar();
                e.draw();
            }
            if(num == 9) {
                Ex9_PrintStar e = new Ex9_PrintStar();
                e.draw();
            }
            if(num == 10) {
                Ex10_PrintStar e = new Ex10_PrintStar();
                e.draw();
            }
            if(num == 11) break;
        }

    }
}

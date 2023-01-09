import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int totalHeight = num * 2 - 1; // 최종 높이
        for(int i = 1; i <= totalHeight; i++) {
            String stars = "";
            int spaceWidth = 0;
            int starWidth = 0;

            if(i < num) {
                spaceWidth = i - 1;
                starWidth = (num - i) * 2 + 1;
            } else {
                int lowerI = i - num + 1;
                spaceWidth = num - lowerI;
                starWidth = lowerI * 2 - 1;
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

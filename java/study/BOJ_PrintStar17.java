import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        for(int i = 1; i <= num; i++) {
            String stars = "";
            int outSpaceWidth = num - i;
            if(i == num) for(int j = 1; j <= num * 2 - 1; j++) stars += "*";
            else if(i == 1) {
                for(int j = 1; j <= outSpaceWidth; j++) stars += " ";
                stars += "*";
            }
            else {
                int inSpaceWidth = num * 2 - 3 - (outSpaceWidth * 2);

                for(int j = 1; j <= outSpaceWidth; j++) stars += " ";
                stars += "*";
                for(int j = 1; j <= inSpaceWidth; j++) stars += " ";
                stars += "*";

            }
            System.out.println(stars);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int N = 5;
        int spaces = 2 * N - 1;
        int stars = 0;
        for (int i = 1; i <= 2 * N - 1; i++) {
            if (i <= N) {
                spaces = spaces - 2;
                stars++;
            }
            else {
                spaces = spaces + 2;
                stars--;
            }
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= stars; j++) {
                if (j != N) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}

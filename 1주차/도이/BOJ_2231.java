package 도이;

import java.util.Scanner;

public class BOJ_2231 {

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);
        final int N = Integer.parseInt(scanner.nextLine());

        int M = 0;
        int x = N;
        while (x > 1) {
            if (N == x + sumAllDigits(x)) {
                M = x;
            }
            x--;
        }

        System.out.println(M);
    }

    private static int sumAllDigits(int number) {
        int result = 0;
        while (number > 0) {
            result += number%10;
            number /= 10;
        }
        return result;
    }
}

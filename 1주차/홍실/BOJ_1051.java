import static java.lang.Integer.*;

import java.util.Scanner;
import java.util.stream.Stream;

public class BOJ_1051 {

    static int N;
    static int M;
    static int[][] map;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        N = parseInt(scanner.next());
        M = parseInt(scanner.next());
        scanner.nextLine();
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            map[i] = splitToIntArray(line);
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int size = calculateSize(i, j);
                answer = max(size, answer);
            }
        }
        System.out.println(answer);
    }

    public static int calculateSize(final int row, final int col) {
        final int number = map[row][col];
        int ans = 1;
        int temp = 1;

        while (temp + row < N && temp + col < M) {
            if (map[row + temp][col] == number
                    && map[row][col + temp] == number
                    && map[row + temp][col + temp] == number) {
                ans = temp + 1;
            }
            temp++;
        }

        return ans * ans;
    }

    public static int[] splitToIntArray(final String line) {
        return Stream.of(line.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}

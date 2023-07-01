import java.io.*;
import java.util.*;

public class BOJ_1051 {

    private static int N;
    private static int M;
    private static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                int num = line.charAt(j) + '0';
                board[i][j] = num;
            }
        }

        int maxSquareLength = 0;
        for (int i = 0; i < N - maxSquareLength - 1; i++) {
            for (int j = 0; j < M - maxSquareLength - 1; j++) {
                int length = maxSquareLength + 1;
                while (i + length < N && j + length < M) {
                    if (hasSameNumberedSquare(i, j, length)) {
                        maxSquareLength = length;
                    }
                    length++;
                }
            }
        }
        System.out.println((maxSquareLength + 1) * (maxSquareLength + 1));
    }

    private static boolean hasSameNumberedSquare(int topLeftY, int topLeftX, int length) {
        if (topLeftY + length >= N || topLeftX + length >= M) {
            return false;
        }
        int topLeft = board[topLeftY][topLeftX];
        int topRight = board[topLeftY][topLeftX + length];
        int bottomLeft = board[topLeftY + length][topLeftX];
        int bottomRight = board[topLeftY + length][topLeftX + length];
        return topLeft == topRight && topLeft == bottomLeft && topLeft == bottomRight;
    }
}

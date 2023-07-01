package 헤나;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1051 {
    private static int N, M;
    private static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][M + 1];
        for (int row = 1; row <= N; row++) {
            String[] values = br.readLine().split("");
            for (int col = 1; col <= M; col++) {
                arr[row][col] = Integer.parseInt(values[col - 1]);
            }
        }

        int maxLength = 1;
        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= M; col++) {

                final int maxRowHeight = N - row + 1;
                final int maxColWidth = M - col + 1;
                final int currentMaxLength = Math.min(maxRowHeight, maxColWidth);
                for (int targetRow = row + 1; calculateLength(row, targetRow) <= currentMaxLength; targetRow++) {
                    for (int targetCol = col + 1; calculateLength(col, targetCol) <= currentMaxLength; targetCol++) {
                        if (calculateLength(row, targetRow) != calculateLength(col, targetCol)) {
                            continue;
                        }

                        final int leftUp = arr[row][col];
                        final int rightUp = arr[row][targetCol];
                        final int leftDown = arr[targetRow][col];
                        final int rightDown = arr[targetRow][targetCol];

                        if (isAllSame(leftUp, rightUp, leftDown, rightDown)) {
                            maxLength = Math.max(maxLength, targetRow - row + 1);
                        }
                    }
                }
            }
        }

        System.out.println(maxLength * maxLength);
    }

    private static int calculateLength(int current, int target) {
        return target - current + 1;
    }

    private static boolean isAllSame(int leftUp, int rightUp, int leftDown, int rightDown) {
        return leftUp == rightUp && rightUp == leftDown && leftDown == rightDown;
    }
}

package 헤나;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500 {
    private static final int MAX_N = 500, MAX_M = 500;
    private static final int MAX_COUNT = 4;
    private static final int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
    private static final int[][][] H = {
            {{0, 0}, {-1, -1}, {-1, 0}, {-1, 1}},
            {{0, 0}, {-1, 1}, {0, 1}, {1, 1}},
            {{0, 0}, {1, -1}, {1, 0}, {1, 1}},
            {{0, 0}, {-1, -1}, {0, -1}, {1, -1}}
    };

    private static int N, M;
    private static int[][] arr;
    private static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        arr = new int[MAX_N + 1][MAX_M + 1];
        visited = new boolean[MAX_N + 1][MAX_M + 1];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int row = 1; row <= N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 1; col <= M; col++) {
                arr[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        int maxSum = 0;
        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= M; col++) {
                visited[row][col] = true;
                maxSum = Math.max(maxSum, dfs(row, col, 1));
                maxSum = Math.max(maxSum, h(row, col));
                visited[row][col] = false;
            }
        }

        System.out.println(maxSum);
    }

    private static int dfs(final int row, final int col, final int count) {
        if (count > MAX_COUNT) {
            return 0;
        }

        int maxSum = 0;
        for (int type = 0; type < 4; type++) {
            final int nextRow = row + dy[type];
            final int nextCol = col + dx[type];

            if (!isRangeOk(nextRow, nextCol)) {
                continue;
            }
            if (visited[nextRow][nextCol]) {
                continue;
            }

            visited[nextRow][nextCol] = true;
            maxSum = Math.max(maxSum, dfs(nextRow, nextCol, count + 1) + arr[row][col]);
            visited[nextRow][nextCol] = false;
        }

        return maxSum;
    }

    private static boolean isRangeOk(final int row, final int col) {
        return (1 <= row && row <= N) && (1 <= col && col <= M);
    }

    private static int h(final int row, final int col) {
        int maxSum = 0;
        for (int type = 0; type < 4; type++) {
            int typeSum = 0;
            final int[][] positions = H[type];
            for (int current = 0; current < 4; current++) {
                final int currentRow = row + positions[current][0];
                final int currentCol = col + positions[current][1];

                if (!isRangeOk(currentRow, currentCol)) {
                    break;
                }

                typeSum += arr[currentRow][currentCol];
            }

            maxSum = Math.max(maxSum, typeSum);
        }

        return maxSum;
    }
}

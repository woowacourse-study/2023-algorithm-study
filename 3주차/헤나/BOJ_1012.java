package 헤나;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1012 {
    private static final int MAX_M = 50, MAX_N = 50;
    private static final int EXIST = 1, EMPTY = 0;
    private static final int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};

    private static int[][] arr;
    private static int T;

    public static void main(String[] args) throws Exception {
        arr = new int[MAX_M + 1][MAX_N + 1];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < T; testCase++) {
            st = new StringTokenizer(br.readLine());
            final int m = Integer.parseInt(st.nextToken());
            final int n = Integer.parseInt(st.nextToken());
            final int k = Integer.parseInt(st.nextToken());

            for (int untilK = 0; untilK < k; untilK++) {
                st = new StringTokenizer(br.readLine());
                final int currentX = Integer.parseInt(st.nextToken());
                final int currentY = Integer.parseInt(st.nextToken());
                arr[currentY][currentX] = EXIST;
            }

            int count = 0;
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if (arr[y][x] == EXIST) {
                        arr[y][x] = EMPTY;
                        count++;
                        check(y, x, n, m);
                    }
                }
            }

            sb.append(count).append(System.lineSeparator());
        }

        System.out.println(sb);
    }

    private static void check(int currentY, int currentX, int maxY, int maxX) {
        for (int directionType = 0; directionType < 4; directionType++) {
            final int nextY = currentY + dy[directionType];
            final int nextX = currentX + dx[directionType];

            if (!isRangeOK(nextY, nextX, maxY, maxX)) {
                continue;
            }
            if (arr[nextY][nextX] == EXIST) {
                arr[nextY][nextX] = EMPTY;
                check(nextY, nextX, maxY, maxX);
            }
        }
    }

    private static boolean isRangeOK(final int nextY, final int nextX, final int maxY, final int maxX) {
        return (0 <= nextY && nextY < maxY) && (0 <= nextX && nextX < maxX);
    }
}

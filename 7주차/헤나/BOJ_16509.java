package 헤나;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_16509 {

    private static final int MAX_R = 9;
    private static final int MAX_C = 8;

    private static final int[] dy = {1, -1, 0, 0}, dx = {0, 0, -1, 1};
    private static final int[][][] dy2 = {{{2}, {2}}, {{-2}, {-2}}, {{-2}, {2}}, {{-2}, {2}}};
    private static final int[][][] dx2 = {{{-2}, {2}}, {{-2}, {2}}, {{-2}, {-2}}, {{2}, {2}}};

    private static int R1, C1;
    private static int R2, C2;
    private static int[][] visited;

    public static void main(String[] args) throws Exception {
        visited = new int[MAX_R + 1][MAX_C + 1];

        for (int row = 0; row <= MAX_R; row++) {
            Arrays.fill(visited[row], Integer.MAX_VALUE);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R1 = Integer.parseInt(st.nextToken());
        C1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        R2 = Integer.parseInt(st.nextToken());
        C2 = Integer.parseInt(st.nextToken());

        Deque<Position> deque = new ArrayDeque<>();
        deque.add(new Position(R1, C1, 0));
        visited[R1][C1] = 0;
        while (!deque.isEmpty()) {
            final Position poll = deque.poll();

            for (int type = 0; type < 4; type++) {
                for (int type2 = 0; type2 < 2; type2++) {
                    // 한 칸 앞
                    if (poll.row + dy[type] == R2 && C2 == poll.col + dx[type]) {
                        continue;
                    }
                    // 한 칸 앞 + 대각선 한 칸
                    if (poll.row + dy[type] + dy2[type][type2][0] / 2 == R2 && C2 == poll.col + dx[type] + dx2[type][type2][0] / 2) {
                        continue;
                    }

                    final int nextRow = poll.row + dy[type] + dy2[type][type2][0];
                    final int nextCol = poll.col + dx[type] + dx2[type][type2][0];

                    if (!isRangeOk(nextRow, nextCol)) {
                        continue;
                    }
                    // 다음 위치가 이전에 도달한 위치보다 더 늦게 도착할 경우 continue
                    if (visited[nextRow][nextCol] <= poll.count + 1) {
                        continue;
                    }
                    visited[nextRow][nextCol] = poll.count + 1;

                    deque.add(new Position(nextRow, nextCol, poll.count + 1));
                }
            }
        }

        System.out.println(visited[R2][C2] == Integer.MAX_VALUE ? -1 : visited[R2][C2]);
    }

    private static boolean isRangeOk(final int row, final int col) {
        return 0 <= row && row <= MAX_R && 0 <= col && col <= MAX_C;
    }

    private static class Position {
        private final int row;
        private final int col;
        private final int count;

        public Position(final int row, final int col, final int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }
}

package 헤나;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ_14442 {

    private static final int MAX_N = 1_000, MAX_M = 1_000, MAX_K = 10;
    private static final int UNMOVABLE = 1, MOVABLE = 0;
    private static final int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};

    private static int N, M, K;
    private static int[][] arr;
    private static int[][][] history;

    public static void main(String[] args) throws Exception {
        arr = new int[MAX_N + 1][MAX_M + 1];
        history = new int[MAX_K + 1][MAX_N + 1][MAX_M + 1];

        for (int k = 0; k <= MAX_K; k++) {
            for (int row = 0; row <= MAX_N; row++) {
                Arrays.fill(history[k][row], Integer.MAX_VALUE);
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int row = 1; row <= N; row++) {
            final List<String> cols = Arrays.stream(br.readLine().split("")).collect(Collectors.toList());
            for (int col = 1; col <= M; col++) {
                arr[row][col] = Integer.parseInt(cols.get(col - 1));
            }
        }

        Deque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(1, 1, 1, 0));

        int minCount = Integer.MAX_VALUE;
        while (!deque.isEmpty()) {
            final Node poll = deque.pollFirst();

            if (poll.row == N && poll.col == M) {
                minCount = Math.min(minCount, poll.count);
            }

            for (int type = 0; type < 4; type++) {
                final int nextRow = poll.row + dy[type];
                final int nextCol = poll.col + dx[type];

                if (!isRangeOk(nextRow, nextCol)) {
                    continue;
                }
                if (isUnMovable(nextRow, nextCol) && poll.isFullBreakCount()) {
                    continue;
                }

                if (isUnMovable(nextRow, nextCol) && !poll.isFullBreakCount()) {
                    if (history[poll.breakCount][nextRow][nextCol] <= poll.nextCount()) {
                        continue;
                    }
                    history[poll.breakCount][nextRow][nextCol] = poll.nextCount();
                    deque.addLast(new Node(nextRow, nextCol, poll.nextCount(), poll.nextBrokenCount()));
                } else if (isMovable(nextRow, nextCol)) {
                    if (history[poll.breakCount][nextRow][nextCol] <= poll.nextCount()) {
                        continue;
                    }
                    history[poll.breakCount][nextRow][nextCol] = poll.nextCount();
                    deque.addLast(new Node(nextRow, nextCol, poll.nextCount(), poll.breakCount));
                }
            }
        }

        System.out.println(minCount == Integer.MAX_VALUE ? -1 : minCount);
    }

    private static boolean isUnMovable(final int nextRow, final int nextCol) {
        return arr[nextRow][nextCol] == UNMOVABLE;
    }

    private static boolean isMovable(final int nextRow, final int nextCol) {
        return arr[nextRow][nextCol] == MOVABLE;
    }

    private static boolean isRangeOk(final int row, final int col) {
        return 1 <= row && row <= N && 1 <= col && col <= M;
    }

    private static class Node {
        private final int row;
        private final int col;
        private final int count;
        private final int breakCount;

        public Node(final int row, final int col, final int count, final int breakCount) {
            this.row = row;
            this.col = col;
            this.count = count;
            this.breakCount = breakCount;
        }

        public boolean isFullBreakCount() {
            return this.breakCount == K;
        }

        public int nextCount() {
            return this.count + 1;
        }

        public int nextBrokenCount() {
            return this.breakCount + 1;
        }
    }
}

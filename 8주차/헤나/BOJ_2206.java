package 헤나;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ_2206 {

    private static final int MAX_N = 1_000, MAX_M = 1_000;
    private static final int UNMOVABLE = 1, MOVABLE = 0;
    private static final int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};

    private static int N, M;
    private static int[][] arr;
    private static int[][] history;
    private static int[][] brokenHistory;

    public static void main(String[] args) throws Exception {
        arr = new int[MAX_N + 1][MAX_M + 1];
        history = new int[MAX_N + 1][MAX_M + 1];
        brokenHistory = new int[MAX_N + 1][MAX_M + 1];

        for (int row = 0; row <= MAX_N; row++) {
            Arrays.fill(history[row], Integer.MAX_VALUE);
            Arrays.fill(brokenHistory[row], Integer.MAX_VALUE);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int row = 1; row <= N; row++) {
            final List<String> cols = Arrays.stream(br.readLine().split("")).collect(Collectors.toList());
            for (int col = 1; col <= M; col++) {
                arr[row][col] = Integer.parseInt(cols.get(col - 1));
            }
        }

        Deque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(1, 1, 1, false));
        history[1][1] = 0;

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
                if (arr[nextRow][nextCol] == UNMOVABLE && poll.brokenHistory) {
                    continue;
                }

                if (isUnMovableAndNoBrokenHistory(poll, nextRow, nextCol) || isMovableAndBrokenHistory(poll, nextRow, nextCol)) {
                    if (brokenHistory[nextRow][nextCol] <= poll.count + 1) {
                        continue;
                    }
                    brokenHistory[nextRow][nextCol] = poll.count + 1;
                    deque.add(new Node(nextRow, nextCol, poll.count + 1, true));
                } else if (isMovableAndNoBrokenHistory(poll, nextRow, nextCol)) {
                    if (history[nextRow][nextCol] <= poll.count + 1) {
                        continue;
                    }
                    history[nextRow][nextCol] = poll.count + 1;
                    deque.add(new Node(nextRow, nextCol, poll.count + 1, poll.brokenHistory));
                }

            }
        }

        System.out.println(minCount == Integer.MAX_VALUE ? -1 : minCount);
    }

    private static boolean isMovableAndNoBrokenHistory(final Node poll, final int nextRow, final int nextCol) {
        return arr[nextRow][nextCol] == MOVABLE && !poll.brokenHistory;
    }

    private static boolean isMovableAndBrokenHistory(final Node poll, final int nextRow, final int nextCol) {
        return arr[nextRow][nextCol] == MOVABLE && poll.brokenHistory;
    }

    private static boolean isUnMovableAndNoBrokenHistory(final Node poll, final int nextRow, final int nextCol) {
        return arr[nextRow][nextCol] == UNMOVABLE && !poll.brokenHistory;
    }

    private static boolean isRangeOk(final int row, final int col) {
        return 1 <= row && row <= N && 1 <= col && col <= M;
    }

    private static class Node {

        private final int row;
        private final int col;
        private final int count;
        private final boolean brokenHistory;

        public Node(final int row, final int col, final int count, final boolean brokenHistory) {
            this.row = row;
            this.col = col;
            this.count = count;
            this.brokenHistory = brokenHistory;
        }
    }
}

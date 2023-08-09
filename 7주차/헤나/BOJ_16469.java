package 헤나;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ_16469 {

    private static final int MAX_R = 100, MAX_C = 100, MAX_TIME = 10000;
    private static final int UNMOVABLE = 1;
    private static final int[] dy = {0, 1, 0, -1, 0}, dx = {0, 0, 1, 0, -1};
    private static final String BAD_A = "A", BAD_B = "B", BAD_C = "C";
    private static final String[] BAD_GUYS = {BAD_A, BAD_B, BAD_C};

    private static int R, C;
    private static int[][] miro;
    private static int[][][] mirosTime;

    public static void main(String[] args) throws Exception {
        miro = new int[MAX_R + 1][MAX_C + 1];
        mirosTime = new int[BAD_GUYS.length][MAX_R + 1][MAX_C + 1];

        for (int type = 0; type < BAD_GUYS.length; type++) {
            for (int i = 1; i <= MAX_R; i++) {
                Arrays.fill(mirosTime[type][i], 10001);
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for (int row = 1; row <= R; row++) {
            final List<Integer> cols = Arrays.stream(br.readLine().split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            for (int col = 1; col <= C; col++) {
                miro[row][col] = cols.get(col - 1);
            }
        }

        PriorityQueue<Position> queue = new PriorityQueue<>();
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            final int row = Integer.parseInt(st.nextToken());
            final int col = Integer.parseInt(st.nextToken());
            queue.add(new Position(BAD_GUYS[i], row, col, 0));
        }

        while (!queue.isEmpty()) {
            final Position poll = queue.poll();

            for (int type = 0; type < 5; type++) {
                final int nextRow = poll.row + dy[type];
                final int nextCol = poll.col + dx[type];

                if (!isRangeOk(nextRow, nextCol)) {
                    continue;
                }

                if (miro[nextRow][nextCol] == UNMOVABLE) {
                    continue;
                }

                for (int badType = 0; badType < BAD_GUYS.length; badType++) {
                    if (BAD_GUYS[badType].equals(poll.who)) {
                        if (mirosTime[badType][nextRow][nextCol] <= poll.time + 1) {
                            continue;
                        }
                        mirosTime[badType][nextRow][nextCol] = poll.time + 1;
                        queue.add(new Position(BAD_GUYS[badType], nextRow, nextCol, poll.time + 1));
                    }
                }
            }
        }

        int minTime = MAX_TIME + 1;
        int count = 0;
        for (int row = 1; row <= R; row++) {
            for (int col = 1; col <= C; col++) {
                final int aTime = mirosTime[0][row][col];
                final int bTime = mirosTime[1][row][col];
                final int cTime = mirosTime[2][row][col];

                if (aTime >= MAX_TIME + 1 || bTime >= MAX_TIME + 1 || cTime >= MAX_TIME + 1) {
                    continue;
                }

                final int tempMaxTime = Math.max(aTime, Math.max(bTime, cTime));
                if (minTime > tempMaxTime) {
                    minTime = tempMaxTime;
                    count = 1;
                } else if (minTime == tempMaxTime) {
                    count++;
                }
            }
        }

        if (count == 0) {
            System.out.println(-1);
        } else {
            System.out.println(minTime);
            System.out.println(count);
        }
    }

    private static boolean isRangeOk(final int row, final int col) {
        return 1 <= row && row <= R && 1 <= col && col <= C;
    }

    private static class Position implements Comparable<Position> {
        private final String who;
        private final int row;
        private final int col;
        private final int time;

        public Position(final String who, final int row, final int col, final int time) {
            this.who = who;
            this.row = row;
            this.col = col;
            this.time = time;
        }

        @Override
        public int compareTo(final Position o) {
            return time > o.time ? 1 : -1;
        }
    }
}

package 헤나;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_16569 {

    private static final int MAX_N = 100, MAX_M = 100;
    private static final int[] dy = {1, 0, -1, 0}, dx = {0, 1, 0, -1};

    private static int Y, X;
    private static int M, N, V;
    private static int[][] mountain;
    private static int[][] movable;
    private static int[][] movable2;
    private static int[][] visited;

    public static void main(String[] args) throws Exception {
        mountain = new int[MAX_N + 1][MAX_M + 1];
        movable = new int[MAX_N + 1][MAX_M + 1];
        movable2 = new int[MAX_N + 1][MAX_M + 1];
        visited = new int[MAX_N + 1][MAX_M + 1];

        for (int i = 1; i <= MAX_N; i++) {
            Arrays.fill(movable[i], 5000);
            Arrays.fill(movable2[i], 5000);
            Arrays.fill(visited[i], 10001);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for (int row = 1; row <= M; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 1; col <= N; col++) {
                mountain[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<Position> volcanos = new PriorityQueue<>((o1, o2) -> o1.time > o2.time ? 1 : -1);
        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            final int row = Integer.parseInt(st.nextToken());
            final int col = Integer.parseInt(st.nextToken());
            final int time = Integer.parseInt(st.nextToken());
            movable2[row][col] = 0;
            volcanos.add(new Position(row, col, time));
        }

        volcanoMovable(volcanos);
        for (int row = 1; row <= M; row++) {
            for (int col = 1; col <= N; col++) {
                if (movable2[row][col] == 0) {
                    movable[row][col] = 0;
                }
            }
        }

        PriorityQueue<Position> jaesang = new PriorityQueue<>((o1, o2) -> o1.time > o2.time ? 1 : -1);
        jaesang.add(new Position(Y, X, 0));
        int time = 0;
        int maxHeight = mountain[Y][X];
        visited[Y][X] = 0;
        while (!jaesang.isEmpty()) {
            final Position currentJaesang = jaesang.poll();

            for (int type = 0; type < 4; type++) {
                final int nextRow = currentJaesang.row + dy[type];
                final int nextCol = currentJaesang.col + dx[type];

                if (
                        isRangeOk(nextRow, nextCol)
                        && movable[nextRow][nextCol] > currentJaesang.time + 1
                        && visited[nextRow][nextCol] > currentJaesang.time + 1
                ) {
                    jaesang.add(new Position(nextRow, nextCol, currentJaesang.time + 1));
                    visited[nextRow][nextCol] = currentJaesang.time + 1;
                    if (maxHeight < mountain[nextRow][nextCol]) {
                        maxHeight = mountain[nextRow][nextCol];
                        time = currentJaesang.time + 1;
                    }
                }
            }
        }

        System.out.println(maxHeight + " " + time);
    }

    private static void volcanoMovable(final PriorityQueue<Position> volcanos) {
        int currentTime = 0;
        while (!volcanos.isEmpty()) {
            while (!volcanos.isEmpty() && volcanos.peek().time == currentTime) {
                final Position volcano = volcanos.poll();
                if (movable[volcano.row][volcano.col] <= currentTime) {
                    continue;
                }

                movable[volcano.row][volcano.col] = currentTime;

                for (int type = 0; type < 4; type++) {
                    final int nextRow = volcano.row + dy[type];
                    final int nextCol = volcano.col + dx[type];

                    if (isRangeOk(nextRow, nextCol) && (movable[nextRow][nextCol] > currentTime + 1)) {
                        volcanos.add(new Position(nextRow, nextCol, currentTime + 1));
                    }
                }
            }

            if (!volcanos.isEmpty()) {
                currentTime = volcanos.peek().time;
            }
        }
    }

    private static boolean isRangeOk(final int row, final int col) {
        return (1 <= row && row <= M) && (1 <= col && col <= N);
    }

    private static class Position {
        private final int row;
        private final int col;
        private final int time;

        public Position(final int row, final int col, final int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
}

/*
3 3 2
1 1
0 0 9
0 0 0
0 0 0
2 3 9
3 3 0
 */

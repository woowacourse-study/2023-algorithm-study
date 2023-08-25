package 헤나;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ_1261 {

    private static final int MAX_DISTANCE = Integer.MAX_VALUE;
    private static final int MAX_N = 100, MAX_M = 100;
    private static final int EMPTY = 0, WALL = 1;
    private static final int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};

    private static int N, M;
    private static int[][] arr;
    private static int[][] distances;

    public static void main(String[] args) throws Exception {
        arr = new int[MAX_N + 1][MAX_M + 1];
        distances = new int[MAX_N + 1][MAX_M + 1];

        for (int row = 0; row <= MAX_N; row++) {
            Arrays.fill(distances[row], MAX_DISTANCE);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for (int row = 1; row <= N; row++) {
            final List<Integer> cols = Arrays.stream(br.readLine().split("")).map(Integer::parseInt).collect(Collectors.toList());
            for (int col = 1; col <= M; col++) {
                arr[row][col] = cols.get(col - 1);
            }
        }
        arr[1][1] = EMPTY;
        arr[N][M] = EMPTY;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.distance > b.distance ? 1 : -1);
        pq.add(new Node(1, 1, 0));
        distances[1][1] = 0;

        while (!pq.isEmpty()) {
            final Node poll = pq.poll();

            for (int type = 0; type < 4; type++) {
                final int nextRow = poll.row + dy[type];
                final int nextCol = poll.col + dx[type];

                if (!isRangeOk(nextRow, nextCol)) {
                    continue;
                }

                if (distances[nextRow][nextCol] != MAX_DISTANCE) {
                    continue;
                }

                if (arr[nextRow][nextCol] == WALL) {
                    distances[nextRow][nextCol] = poll.distance + 1;
                }
                if (arr[nextRow][nextCol] == EMPTY) {
                    distances[nextRow][nextCol] = poll.distance;
                }

                if (nextRow == N && nextCol == M) {
                    break;
                }

                pq.add(new Node(nextRow, nextCol, distances[nextRow][nextCol]));
            }
        }

        System.out.println(distances[N][M]);
    }

    private static boolean isRangeOk(final int row, final int col) {
        return 1 <= row && row <= N && 1 <= col && col <= M;
    }

    private static final class Node {
        private final int row;
        private final int col;
        private final int distance;

        public Node(final int row, final int col, final int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }
}

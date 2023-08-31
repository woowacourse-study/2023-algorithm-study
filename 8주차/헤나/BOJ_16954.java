package 헤나;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class BOJ_16954 {

    private static final int MAX_ROW = 8, MAX_COL = 8;
    private static final int MAX_TIME = 8 * 8 * 8;
    private static final String EMPTY = ".", BRICK = "#";
    private static final int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1}, dx = {0, 0, 1, 1, 1, 0, -1, -1, -1};

    private static String[][] arr;
    private static boolean[][][] visited;

    public static void main(String[] args) throws Exception {
        arr = new String[MAX_ROW + 1][MAX_COL + 1];
        visited = new boolean[MAX_TIME + 1][MAX_ROW + 1][MAX_COL + 1];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int row = 1; row <= MAX_ROW; row++) {
            final List<String> cols = Arrays.stream(br.readLine().split("")).collect(Collectors.toList());
            for (int col = 1; col <= MAX_COL; col++) {
                arr[row][col] = cols.get(col - 1);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.time > b.time ? 1 : -1);
        pq.add(new Node(MAX_ROW, 1, 0));

        boolean isPossible = false;
        int currentTime = 0;
        while (!pq.isEmpty()) {
            final Node poll = pq.poll();

            if (currentTime != poll.time) {
                currentTime = poll.time;
                moveArr();
            }

            if (arr[poll.row][poll.col].equals(BRICK)) {
                continue;
            }

            if (poll.row == 1 && poll.col == MAX_COL) {
                isPossible = true;
                break;
            }

            for (int type = 0; type < dy.length; type++) {
                final int nextRow = poll.row + dy[type];
                final int nextCol = poll.col + dx[type];

                if (!isRangeOk(nextRow, nextCol)) {
                    continue;
                }
                if (visited[poll.time + 1][nextRow][nextCol]) {
                    continue;
                }
                if (arr[nextRow][nextCol].equals(BRICK)) {
                    continue;
                }

                visited[poll.time + 1][nextRow][nextCol] = true;
                pq.add(new Node(nextRow, nextCol, poll.time + 1));
            }
        }

        System.out.println(isPossible ? 1 : 0);
    }

    private static void moveArr() {
        for (int row = MAX_ROW; row >= 2; row--) {
            for (int col = 1; col <= MAX_COL; col++) {
                arr[row][col] = arr[row - 1][col];
            }
        }

        for (int col = 1; col <= MAX_COL; col++) {
            arr[1][col] = EMPTY;
        }
    }

    private static boolean isRangeOk(final int row, final int col) {
        return 1 <= row && row <= MAX_ROW && 1 <= col && col <= MAX_COL;
    }

    private static class Node {
        private final int row;
        private final int col;
        private final int time;

        public Node(final int row, final int col, final int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
}

/*
######..
.#.#.###
........
........
........
........
........
........

######..
.#######
######..
........
........
........
........
........

########
........
........
........
........
........
........
........
 */

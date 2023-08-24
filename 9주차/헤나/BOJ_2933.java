package 헤나;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ_2933 {

    private static final int MAX_R = 100, MAX_C = 100, MAX_N = 100;
    private static final String EMPTY = ".", MINERAL = "x";
    private static final int[] dy = {1, 0, 0, -1}, dx = {0, 1, -1, 0};

    private static int R, C, N;
    private static String[][] arr;
    private static int[] stick;
    private static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        arr = new String[MAX_R + 1][MAX_C + 1];
        stick = new int[MAX_N + 1];
        visited = new boolean[MAX_R + 1][MAX_C + 1];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for (int row = R; row >= 1; row--) {
            final List<String> cols = Arrays.stream(br.readLine().split("")).collect(Collectors.toList());
            for (int col = 1; col <= C; col++) {
                arr[row][col] = cols.get(col - 1);
            }
        }

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int turn = 0; turn < N; turn++) {
            stick[turn] = Integer.parseInt(st.nextToken());
        }


        for (int turn = 0; turn < N; turn++) {
            if (turn % 2 == 0) {
                for (int col = 1; col <= C; col++) {
                    if (arr[stick[turn]][col].equals(MINERAL)) {
                        arr[stick[turn]][col] = EMPTY;
                        break;
                    }
                }
            } else {
                for (int col = C; col >= 1; col--) {
                    if (arr[stick[turn]][col].equals(MINERAL)) {
                        arr[stick[turn]][col] = EMPTY;
                        break;
                    }
                }
            }
            visitAllReferencedByBottom();
            downMinerals();
        }

        StringBuilder sb = new StringBuilder();
        for (int row = R; row >= 1; row--) {
            for (int col = 1; col <= C; col++) {
                sb.append(arr[row][col]);
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb);
    }

    private static void visitAllReferencedByBottom() {
        for (int row = 1; row <= R; row++) {
            Arrays.fill(visited[row], false);
        }
        for (int col = 1; col <= C; col++) {
            if (arr[1][col].equals(MINERAL) && !visited[1][col]) {
                Deque<Node> deque = new ArrayDeque<>();
                visited[1][col] = true;
                deque.add(new Node(1, col));

                while (!deque.isEmpty()) {
                    final Node poll = deque.poll();

                    for (int type = 0; type < 4; type++) {
                        final int nextRow = poll.row + dy[type];
                        final int nextCol = poll.col + dx[type];

                        if (!isRangeOk(nextRow, nextCol)) {
                            continue;
                        }

                        if (visited[nextRow][nextCol]) {
                            continue;
                        }

                        if (arr[nextRow][nextCol].equals(EMPTY)) {
                            continue;
                        }

                        visited[nextRow][nextCol] = true;
                        deque.add(new Node(nextRow, nextCol));
                    }
                }
            }
        }
    }

    private static void downMinerals() {
        Deque<Node> deque = new ArrayDeque<>();
        for (int row = 1; row <= R; row++) {
            for (int col = 1; col <= C; col++) {
                if (visited[row][col]) {
                    continue;
                }

                if (arr[row][col].equals(EMPTY)) {
                    continue;
                }

                deque.add(new Node(row, col));
                arr[row][col] = EMPTY;
            }
        }

        if (deque.isEmpty()) {
            return;
        }

        Deque<Node> downs = new ArrayDeque<>();
        boolean isAbleToDown = true;
        while (isAbleToDown) {
            for (final Node node : deque) {
                if (!isRangeOk(node.row - 1, node.col) || arr[node.row - 1][node.col].equals(MINERAL)) {
                    isAbleToDown = false;
                    break;
                }
            }

            if (isAbleToDown) {
                while (!deque.isEmpty()) {
                    final Node poll = deque.poll();
                    downs.add(new Node(poll.row - 1, poll.col));
                }

                deque = new ArrayDeque<>(downs);
                downs.clear();
            }
        }

        while (!deque.isEmpty()) {
            final Node poll = deque.poll();
            arr[poll.row][poll.col] = MINERAL;
        }
    }

    private static boolean isRangeOk(final int row, final int col) {
        return 1 <= row && row <= R && 1 <= col && col <= C;
    }

    private static class Node {
        private final int row;
        private final int col;

        public Node(final int row, final int col) {
            this.row = row;
            this.col = col;
        }
    }
}

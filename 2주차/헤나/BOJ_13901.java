package 헤나;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13901 {
    private static final int MAX_R = 1_000, MAX_C = 1000, MAX_MOVEMENT = 4;
    private static final int UNABLE_POSITION = -1;
    private static final int[] dy = {0, -1, 1, 0, 0}, dx = {0, 0, 0, -1, 1};

    private static int[][] board;
    private static int[] movement;
    private static int R, C, K;
    private static int SR, SC;

    public static void main(String[] args) throws Exception {
        board = new int[MAX_R][MAX_C];
        movement = new int[MAX_MOVEMENT];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            final int row = Integer.parseInt(st.nextToken());
            final int col = Integer.parseInt(st.nextToken());
            board[row][col] = UNABLE_POSITION;
        }

        st = new StringTokenizer(br.readLine());
        SR = Integer.parseInt(st.nextToken());
        SC = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < MAX_MOVEMENT; i++) {
            movement[i] = Integer.parseInt(st.nextToken());
        }

        board[SR][SC] = UNABLE_POSITION;
        boolean isContinue = false;
        while (!isContinue) {
            for (int i = 0; i < MAX_MOVEMENT; i++) {
                int row = SR;
                int col = SC;

                while (true) {
                    final int nextRow = row + dy[movement[i]];
                    final int nextCol = col + dx[movement[i]];

                    if (!isRowRange(nextRow) || !isColRange(nextCol)) {
                        break;
                    }

                    if (board[nextRow][nextCol] == UNABLE_POSITION) {
                        break;
                    }

                    row = nextRow;
                    col = nextCol;
                    board[row][col] = UNABLE_POSITION;
                }

                SR = row;
                SC = col;
            }

            isContinue = true;
            for (int i = 0; i < MAX_MOVEMENT; i++) {
                final int row = SR + dy[movement[i]];
                final int col = SC + dx[movement[i]];

                if (!isRowRange(row) || !isColRange(col)) {
                    continue;
                }

                if (board[row][col] == UNABLE_POSITION) {
                    continue;
                }

                isContinue = false;
                break;
            }
        }

        System.out.println(SR + " " + SC);
    }

    private static boolean isRowRange(final int row) {
        return 0 <= row && row < R;
    }

    private static boolean isColRange(final int col) {
        return 0 <= col && col < C;
    }
}

//2023.07.03
//https://www.acmicpc.net/problem/13901

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Boj_13901 {

    private static final int NOT_MOVABLE = -1;
    private static int R;
    private static int C;
    private static int[][] board;

    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer RC = new StringTokenizer(br.readLine());
        R = Integer.parseInt(RC.nextToken());
        C = Integer.parseInt(RC.nextToken());

        board = new int[R][C];

        final int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int row = Integer.parseInt(st.nextToken());
            final int column = Integer.parseInt(st.nextToken());
            board[row][column] = NOT_MOVABLE;
        }

        final StringTokenizer startPositionSt = new StringTokenizer(br.readLine());
        int robotRow = Integer.parseInt(startPositionSt.nextToken());
        int robotCol = Integer.parseInt(startPositionSt.nextToken());

        final List<Move> moves = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .map(Move::findMoveByIndex)
                .collect(Collectors.toList());

        int moveCursor = 0;
        final int movesSize = moves.size();
        board[robotRow][robotCol] = -1;

        do {
            final Move move = moves.get(moveCursor % movesSize);
            while (true) {
                final int nextRow = robotRow + move.rowMove;
                final int nextCol = robotCol + move.columnMove;
                if (isMovable(nextRow, nextCol)) {
                    robotRow = nextRow;
                    robotCol = nextCol;
                    board[robotRow][robotCol] = -1;
                    continue;
                }

                break;
            }

            moveCursor += 1;
        } while (isStuck(robotRow, robotCol));

        System.out.println(robotRow + " " + robotCol);
    }

    private static boolean isMovable(final int row, final int column) {
        if (row < 0 || row >= R
                || column < 0 || column >= C
                || board[row][column] == -1) {
            return false;
        }

        return true;
    }

    private static boolean isStuck(final int row, final int column) {
        for (final Move move : Move.values()) {
            if (isMovable(row + move.rowMove, column + move.columnMove)) {
                return true;
            }
        }

        return false;
    }

    private enum Move {
        UP(-1, 0),
        DOWN(1, 0),
        LEFT(0, -1),
        RIGHT(0, 1),
        ;

        private final int rowMove;
        private final int columnMove;

        Move(final int rowMove, final int columnMove) {
            this.rowMove = rowMove;
            this.columnMove = columnMove;
        }

        private static Move findMoveByIndex(final int index) {
            switch (index) {
                case 1:
                    return UP;
                case 2:
                    return DOWN;
                case 3:
                    return LEFT;
                case 4:
                    return RIGHT;
                default:
                    return null;
            }
        }
    }
}


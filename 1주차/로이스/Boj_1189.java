package Royce.practice;

//2023.06.28
//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/1189

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1189 {
    private static int answer = 0;
    private static int R = 0;
    private static int C = 0;
    private static int K = 0;
    private static boolean[][] board;

    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            final char[] numbers = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (numbers[j] != '.') {
                    board[i][j] = true;
                }
            }
        }

        final int startRow = R - 1;
        board[startRow][0] = true;
        dfs(startRow, 0, 1);
        System.out.println(answer);
    }

    private static void dfs(final int row, final int column, final int distance) {
        if (distance == K
                && row == 0
                && column == C - 1) {
            answer += 1;
            return;
        }

        for (final Direction direction : Direction.values()) {
            final int nextRow = row + direction.rowMove;
            final int nextCol = column + direction.columnMove;

            if (nextRow < 0 || nextRow >= R
                    || nextCol < 0 || nextCol >= C
                    || board[nextRow][nextCol]
                    || distance >= K) {
                continue;
            }

            board[nextRow][nextCol] = true;
            dfs(nextRow, nextCol, distance + 1);
            board[nextRow][nextCol] = false;
        }
    }

    private enum Direction {
        UP(-1, 0),
        RIGHT(0, 1),
        DOWN(1, 0),
        LEFT(0, -1),
        ;

        private final int rowMove;
        private final int columnMove;

        Direction(final int rowMove, final int columnMove) {
            this.rowMove = rowMove;
            this.columnMove = columnMove;
        }
    }
}

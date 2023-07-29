//https://www.acmicpc.net/problem/14500

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_14500 {

    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer NM = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(NM.nextToken());
        final int M = Integer.parseInt(NM.nextToken());

        final int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (final Tetromino tetromino : Tetromino.values()) {
                    for (final Directions shapes : tetromino.moves) {
                        int summation = board[i][j];
                        boolean skipFlag = false;
                        for (final Direction connectedDirection : shapes.directions) {
                            final int connectedBlockRow = i + connectedDirection.rowMove;
                            final int connectedBlockCol = j + connectedDirection.colMove;

                            if (connectedBlockRow < 0 || connectedBlockRow >= N
                                    || connectedBlockCol < 0 || connectedBlockCol >= M) {
                                skipFlag = true;
                                break;
                            }

                            summation += board[connectedBlockRow][connectedBlockCol];
                        }

                        if (skipFlag) {
                            continue;
                        }

                        if (summation > answer) {
                            answer = summation;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private enum Tetromino {
        I(List.of(
                new Directions(Direction.RIGHT_ONE, Direction.RIGHT_TWO, Direction.RIGHT_THREE),
                new Directions(Direction.DOWN_ONE, Direction.DOWN_TWO, Direction.DOWN_THREE)
        )),
        L(List.of(
                new Directions(Direction.RIGHT_ONE, Direction.DOWN_ONE, Direction.DOWN_TWO),
                new Directions(Direction.RIGHT_ONE, Direction.RIGHT_ONE_DOWN_ONE, Direction.RIGHT_ONE_DOWN_TWO),
                new Directions(Direction.RIGHT_ONE, Direction.RIGHT_TWO, Direction.RIGHT_TWO_UP_ONE),
                new Directions(Direction.DOWN_ONE, Direction.DOWN_ONE_RIGHT_ONE, Direction.DOWN_ONE_RIGHT_TWO),
                new Directions(Direction.RIGHT_ONE, Direction.RIGHT_TWO, Direction.RIGHT_TWO_DOWN_ONE),
                new Directions(Direction.DOWN_ONE, Direction.RIGHT_ONE, Direction.RIGHT_TWO),
                new Directions(Direction.DOWN_ONE, Direction.DOWN_TWO, Direction.DOWN_TWO_LEFT_ONE),
                new Directions(Direction.DOWN_ONE, Direction.DOWN_TWO, Direction.DOWN_TWO_RIGHT_ONE)
        )),
        O(List.of(new Directions(Direction.RIGHT_ONE, Direction.DOWN_ONE, Direction.DOWN_ONE_RIGHT_ONE))),
        S(List.of(
                new Directions(Direction.RIGHT_ONE, Direction.RIGHT_ONE_DOWN_ONE, Direction.RIGHT_TWO_DOWN_ONE),
                new Directions(Direction.RIGHT_ONE, Direction.RIGHT_ONE_UP_ONE, Direction.RIGHT_TWO_UP_ONE),
                new Directions(Direction.DOWN_ONE, Direction.RIGHT_ONE_DOWN_ONE, Direction.DOWN_TWO_RIGHT_ONE),
                new Directions(Direction.DOWN_ONE, Direction.DOWN_ONE_LEFT_ONE, Direction.DOWN_TWO_LEFT_ONE)
        )),
        T(List.of(
                new Directions(Direction.RIGHT_ONE, Direction.RIGHT_ONE_DOWN_ONE, Direction.RIGHT_TWO),
                new Directions(Direction.RIGHT_ONE, Direction.RIGHT_ONE_UP_ONE, Direction.RIGHT_TWO),
                new Directions(Direction.DOWN_ONE, Direction.DOWN_ONE_LEFT_ONE, Direction.DOWN_TWO),
                new Directions(Direction.DOWN_ONE, Direction.DOWN_ONE_RIGHT_ONE, Direction.DOWN_TWO)
        )),
        ;

        private final List<Directions> moves;

        Tetromino(final List<Directions> moves) {
            this.moves = moves;
        }
    }

    private static class Directions {
        private final List<Direction> directions;

        public Directions(final Direction... directions) {
            this.directions = Arrays.asList(directions);
        }
    }

    private enum Direction {
        RIGHT_ONE(0, 1),
        RIGHT_TWO(0, 2),
        RIGHT_THREE(0, 3),
        RIGHT_ONE_DOWN_ONE(1, 1),
        RIGHT_ONE_UP_ONE(-1, 1),
        RIGHT_ONE_DOWN_TWO(2, 1),
        RIGHT_TWO_DOWN_ONE(1, 2),
        RIGHT_TWO_UP_ONE(-1, 2),
        DOWN_ONE(1, 0),
        DOWN_TWO(2, 0),
        DOWN_THREE(3, 0),
        DOWN_ONE_RIGHT_ONE(1, 1),
        DOWN_ONE_RIGHT_TWO(1, 2),
        DOWN_ONE_LEFT_ONE(1, -1),
        DOWN_TWO_LEFT_ONE(2, -1),
        DOWN_TWO_RIGHT_ONE(2, 1),
        ;

        private final int rowMove;
        private final int colMove;

        Direction(final int rowMove, final int colMove) {
            this.rowMove = rowMove;
            this.colMove = colMove;
        }
    }
}


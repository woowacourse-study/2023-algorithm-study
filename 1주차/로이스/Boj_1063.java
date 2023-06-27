import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(final String[] args) throws IOException {
        final boolean[][] board = new boolean[8][8];

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final String kingPosition = st.nextToken();
        final String rockPosition = st.nextToken();
        final int N = Integer.parseInt(st.nextToken());

        final char[] kingColRow = kingPosition.toCharArray();
        int kingColumn = kingColRow[0] - 'A';
        int kingRow = 8 - ((int) kingColRow[1] - '0');
        board[kingRow][kingColumn] = true;

        final char[] rockColRow = rockPosition.toCharArray();
        int rockColumn = rockColRow[0] - 'A';
        int rockRow = 8 - ((int) rockColRow[1] - '0');
        board[rockRow][rockColumn] = true;

        for (int i = 0; i < N; i++) {
            final Direction direction = Direction.findDirection(br.readLine());
            final int movedKingRow = kingRow + direction.rowMove;
            final int movedKingColumn = kingColumn + direction.columnMove;
            if (movedKingRow >= 8
                    || movedKingColumn >= 8
                    || movedKingRow < 0
                    || movedKingColumn < 0) {
                continue;
            }

            if (board[movedKingRow][movedKingColumn]) { //이동 위치에 바위가 있는 경우
                final int movedRockRow = rockRow + direction.rowMove;
                final int movedRockColumn = rockColumn + direction.columnMove;
                if (movedRockRow >= 8
                        || movedRockColumn >= 8
                        || movedRockRow < 0
                        || movedRockColumn < 0) {
                    continue;
                }
                board[rockRow][rockColumn] = false;
                board[movedRockRow][movedRockColumn] = true;
                rockRow = movedRockRow;
                rockColumn = movedRockColumn;
            }

            board[kingRow][kingColumn] = false;
            board[movedKingRow][movedKingColumn] = true;
            kingRow = movedKingRow;
            kingColumn = movedKingColumn;
        }

        final char kingColumnLetter = (char) (kingColumn + 'A');
        final int kingRowLetter = 8 - kingRow;
        System.out.print(kingColumnLetter);
        System.out.print(kingRowLetter);
        System.out.println();

        final char rockColumnLetter = (char) (rockColumn + 'A');
        final int rockRowLetter = 8 - rockRow;
        System.out.print(rockColumnLetter);
        System.out.print(rockRowLetter);
    }

    private enum Direction {
        R(0, 1),
        L(0, -1),
        B(1, 0),
        T(-1, 0),
        RT(-1, 1),
        LT(-1, -1),
        RB(1, 1),
        LB(1, -1),
        ;

        private final int rowMove;
        private final int columnMove;

        Direction(final int rowMove, final int columnMove) {
            this.rowMove = rowMove;
            this.columnMove = columnMove;
        }

        public static Direction findDirection(final String input) {
            return Arrays.stream(Direction.values())
                    .filter(direction -> direction.name().equals(input))
                    .findFirst()
                    .orElse(null);
        }
    }
}


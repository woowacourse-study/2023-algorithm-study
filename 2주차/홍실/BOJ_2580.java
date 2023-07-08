import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2580 {

    static class Point {

        int row;
        int col;

        public Point(final int row, final int col) {
            this.row = row;
            this.col = col;
        }
    }

    static final int BLANK = 0;

    static int[][] sdocu = new int[9][9];
    static List<Point> blankPoints = new ArrayList<>();
    static int[][] answer = new int[9][9];

    private static void solve(int count) {
        if (count == blankPoints.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    answer[i][j] = sdocu[i][j];
                }
            }
            return;
        }

        Point blankPoint = blankPoints.get(count);
        final Point section = calculateSection(blankPoint.row, blankPoint.col);
        for (int number = 1; number <= 9; number++) {
            if (checkSection(section, number)
                && checkRow(blankPoint, number)
                && checkCol(blankPoint, number)) {
                sdocu[blankPoint.row][blankPoint.col] = number;
                solve(count + 1);
                sdocu[blankPoint.row][blankPoint.col] = BLANK;
            }
        }
    }

    private static boolean checkRow(final Point point, final int number) {
        for (int i = 0; i < 9; i++) {
            if (sdocu[point.row][i] == number) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkCol(final Point point, final int number) {
        for (int i = 0; i < 9; i++) {
            if (sdocu[i][point.col] == number) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkSection(final Point section, final int number) {
        final int sectionRow = section.row * 3;
        final int sectionCol = section.col * 3;

        return sdocu[sectionRow][sectionCol] != number
            && sdocu[sectionRow][sectionCol + 1] != number
            && sdocu[sectionRow][sectionCol + 2] != number
            && sdocu[sectionRow + 1][sectionCol] != number
            && sdocu[sectionRow + 1][sectionCol + 1] != number
            && sdocu[sectionRow + 1][sectionCol + 2] != number
            && sdocu[sectionRow + 2][sectionCol] != number
            && sdocu[sectionRow + 2][sectionCol + 1] != number
            && sdocu[sectionRow + 2][sectionCol + 2] != number;
    }

    private static Point calculateSection(final int row, final int col) {
        final int rowSection = row / 3;
        final int colSection = col / 3;
        return new Point(rowSection, colSection);
    }

    public static void main(String[] args) {
        input();
        solve(0);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void input() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            final String line = scanner.nextLine();
            final String[] split = line.split(" ");
            for (int j = 0; j < 9; j++) {
                sdocu[i][j] = Integer.parseInt(split[j]);
                if (sdocu[i][j] == BLANK) {
                    blankPoints.add(new Point(i, j));
                }
            }
        }
    }

}

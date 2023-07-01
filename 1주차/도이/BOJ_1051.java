package 도이;

import java.util.Scanner;

public class BOJ_1051 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] widthAndHeight = scanner.nextLine().split(" ");
        final int height = Integer.parseInt(widthAndHeight[0]);
        final int width = Integer.parseInt(widthAndHeight[1]);

        final int[][] rectangle = new int[height][width];

        for (int i = 0; i < height; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < width; j++) {
                rectangle[i][j] = line.charAt(j) - '0';
            }
        }

        int maxLength = Math.min(height, width);

        while (maxLength > 1) {
            for (int i = 0; i <= (height - maxLength); i++) {
                for (int j = 0; j <= (width - maxLength); j++) {
                    int point = rectangle[i][j];
                    if (isSquare(point, i, j, maxLength, rectangle)) {
                        System.out.println(maxLength*maxLength);
                        return;
                    };
                }
            }
            maxLength--;
        }
        System.out.println(maxLength);
    }

    private static boolean isSquare(int point,
                                    int x,
                                    int y,
                                    int maxLength,
                                    int[][] rectangle) {
        if (point != rectangle[x][y + maxLength - 1]) {
            return false;
        }
        if (point != rectangle[x + maxLength - 1][y]) {
            return false;
        }
        if (point != rectangle[x + maxLength - 1][y + maxLength - 1]) {
            return false;
        }
        return true;
    }
}

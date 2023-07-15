package 도이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2799 {

    static boolean[] type1 = new boolean[]{false, false, false, false};
    static boolean[] type2 = new boolean[]{true, false, false, false};
    static boolean[] type3 = new boolean[]{true, true, false, false};
    static boolean[] type4 = new boolean[]{true, true, true, false};
    static boolean[] type5 = new boolean[]{true, true, true, true};

    static int M;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);

        int lineIndex = 0;
        int windowCount = 0;
        boolean[][] windows = new boolean[M*N][4];
        while (windowCount < M*N) {
            if (lineIndex == 4) {
                lineIndex = 0;
                windowCount += N;
                continue;
            }
            final String[] split = br.readLine()
                    .substring(1, 5*N)
                    .split("#");
            if (split.length == 0) {
                continue;
            }
            for (int i = 0; i < split.length; i++) {
                String blind = split[i];
                windows[windowCount + i][lineIndex] = blind.contains("****");
            }
            lineIndex++;
        }

        int[] counts = new int[5];
        for (final boolean[] window : windows) {
            if (isType(type1, window)) {
                counts[0] += 1;
            }
            if (isType(type2, window)) {
                counts[1] += 1;
            }
            if (isType(type3, window)) {
                counts[2] += 1;
            }
            if (isType(type4, window)) {
                counts[3] += 1;
            }
            if (isType(type5, window)) {
                counts[4] += 1;
            }
        }

        for (final int count : counts) {
            System.out.print(count + " ");
        }
    }

    private static boolean isType(boolean[] type, boolean[] window) {
        for (int i = 0; i < 4; i++) {
            if (type[i] != window[i]) {
                return false;
            }
        }
        return true;
    }
}

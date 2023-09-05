import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2799 {

    private static final String[] types = new String[]{"....", "*...", "**..", "***.", "****"};
    private static char[][][] windows;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        windows = new char[N][M][4];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                Arrays.fill(windows[r][c], '.');
            }
        }

        /**
         * 1,1 -> 0,0
         * 1,6 -> 0,1
         * 6,6 -> 2,1
         */
        for (int r = 0; r < 5 * N + 1; r++) {
            final String value = br.readLine();
            if (r == 0) {
                continue;
            }

            for (int c = 0; c < 5 * M + 1; c++) {
                if (c % 5 != 1) {
                    continue;
                }

                if (r % 5 == 1) {
                    windows[r / 5][c / 5 + c % 5 - 1][0] = value.charAt(c);
                    continue;
                }
                if (r % 5 == 2) {
                    windows[r / 5][c / 5 + c % 5 - 1][1] = value.charAt(c);
                    continue;
                }
                if (r % 5 == 3) {
                    windows[r / 5][c / 5 + c % 5 - 1][2] = value.charAt(c);
                    continue;
                }
                if (r % 5 == 4) {
                    windows[r / 5][c / 5 + c % 5 - 1][3] = value.charAt(c);
                }
            }
        }

        int[] answer = new int[5];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 4; i++) {
                    sb.append(windows[r][c][i]);
                }

                for (int i = 0; i < 5; i++) {
                    if (types[i].contentEquals(sb)) {
                        answer[i]++;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i + " ");
        }
        System.out.println(sb);
    }
}

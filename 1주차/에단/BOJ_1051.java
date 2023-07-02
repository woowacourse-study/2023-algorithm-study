package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1051 {

    private static int[][] map;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int r = 0; r < N; r++) {
            final String s = br.readLine();
            for (int c = 0; c < M; c++) {
                map[r][c] = s.charAt(c) - '0';
            }
        }

        int max = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                final int criteria = map[r][c];
                for (int nc = c; nc < M; nc++) {
                    if (map[r][nc] != criteria) {
                        continue;
                    }

                    final int diff = nc - c;
                    if (r + diff >= N) {
                        continue;
                    }

                    if (map[r + diff][c] == criteria && map[r + diff][nc] == criteria) {
                        max = Math.max(max, (diff + 1) * (diff + 1));
                    }
                }
            }
        }

        System.out.println(max);
    }
}

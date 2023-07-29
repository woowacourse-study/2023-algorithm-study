import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Problem14500 {

    private static int[][] map;
    private static Boolean[][][] tetromino = {
            {
                    {TRUE, FALSE, FALSE, FALSE},
                    {TRUE, FALSE, FALSE, FALSE},
                    {TRUE, FALSE, FALSE, FALSE},
                    {TRUE, FALSE, FALSE, FALSE}
            }, {
            {TRUE, TRUE, TRUE, TRUE},
            {FALSE, FALSE, FALSE, FALSE},
            {FALSE, FALSE, FALSE, FALSE},
            {FALSE, FALSE, FALSE, FALSE}
    }, {
            {TRUE, TRUE, FALSE, FALSE},
            {TRUE, TRUE, FALSE, FALSE},
            {FALSE, FALSE, FALSE, FALSE},
            {FALSE, FALSE, FALSE, FALSE}
    }, {
            {TRUE, TRUE, FALSE, FALSE},
            {FALSE, TRUE, TRUE, FALSE},
            {FALSE, FALSE, FALSE, FALSE},
            {FALSE, FALSE, FALSE, FALSE}
    }, {
            {FALSE, TRUE, FALSE, FALSE},
            {TRUE, TRUE, FALSE, FALSE},
            {TRUE, FALSE, FALSE, FALSE},
            {FALSE, FALSE, FALSE, FALSE}
    }, {
            {FALSE, TRUE, TRUE, FALSE},
            {TRUE, TRUE, FALSE, FALSE},
            {FALSE, FALSE, FALSE, FALSE},
            {FALSE, FALSE, FALSE, FALSE}
    }, {
            {TRUE, FALSE, FALSE, FALSE},
            {TRUE, TRUE, FALSE, FALSE},
            {FALSE, TRUE, FALSE, FALSE},
            {FALSE, FALSE, FALSE, FALSE}
    }, {
            {TRUE, FALSE, FALSE, FALSE},
            {TRUE, FALSE, FALSE, FALSE},
            {TRUE, TRUE, FALSE, FALSE},
            {FALSE, FALSE, FALSE, FALSE}
    }, {
            {TRUE, TRUE, TRUE, FALSE},
            {TRUE, FALSE, FALSE, FALSE},
            {FALSE, FALSE, FALSE, FALSE},
            {FALSE, FALSE, FALSE, FALSE}
    }, {
            {TRUE, TRUE, FALSE, FALSE},
            {FALSE, TRUE, FALSE, FALSE},
            {FALSE, TRUE, FALSE, FALSE},
            {FALSE, FALSE, FALSE, FALSE}
    }, {
            {FALSE, FALSE, TRUE, FALSE},
            {TRUE, TRUE, TRUE, FALSE},
            {FALSE, FALSE, FALSE, FALSE},
            {FALSE, FALSE, FALSE, FALSE}
    }, {
            {FALSE, TRUE, FALSE, FALSE},
            {FALSE, TRUE, FALSE, FALSE},
            {TRUE, TRUE, FALSE, FALSE},
            {FALSE, FALSE, FALSE, FALSE}
    }, {
            {TRUE, FALSE, FALSE, FALSE},
            {TRUE, TRUE, TRUE, FALSE},
            {FALSE, FALSE, FALSE, FALSE},
            {FALSE, FALSE, FALSE, FALSE}
    }, {
            {TRUE, TRUE, FALSE, FALSE},
            {TRUE, FALSE, FALSE, FALSE},
            {TRUE, FALSE, FALSE, FALSE},
            {FALSE, FALSE, FALSE, FALSE}
    }, {
            {TRUE, TRUE, TRUE, FALSE},
            {FALSE, FALSE, TRUE, FALSE},
            {FALSE, FALSE, FALSE, FALSE},
            {FALSE, FALSE, FALSE, FALSE}
    }, {
            {TRUE, TRUE, TRUE, FALSE},
            {FALSE, TRUE, FALSE, FALSE},
            {FALSE, FALSE, FALSE, FALSE},
            {FALSE, FALSE, FALSE, FALSE}
    }, {
            {FALSE, TRUE, FALSE, FALSE},
            {TRUE, TRUE, TRUE, FALSE},
            {FALSE, FALSE, FALSE, FALSE},
            {FALSE, FALSE, FALSE, FALSE}
    }, {
            {FALSE, TRUE, FALSE, FALSE},
            {TRUE, TRUE, FALSE, FALSE},
            {FALSE, TRUE, FALSE, FALSE},
            {FALSE, FALSE, FALSE, FALSE}
    }, {
            {TRUE, FALSE, FALSE, FALSE},
            {TRUE, TRUE, FALSE, FALSE},
            {TRUE, FALSE, FALSE, FALSE},
            {FALSE, FALSE, FALSE, FALSE}
    }
    };

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int R = Integer.parseInt(st.nextToken());
        final int C = Integer.parseInt(st.nextToken());

        final int[][] map = new int[R][C];
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for (int i = 0; i < tetromino.length; i++) {

            final Boolean[][] cur = tetromino[i];
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {

					int sum = 0;
					for (int tr = 0; tr < 4; tr++) {
						for (int tc = 0; tc < 4; tc++) {
							final int nr = r + tr;
							final int nc = c + tc;

							if (nr >= R || nc >= C || !cur[tr][tc]) {
								continue;
							}
							sum += map[nr][nc];
						}
					}

					max = Math.max(max, sum);
                }
            }
        }
		System.out.println(max);
    }
}

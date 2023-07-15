import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13901 {
    static int R, C, sr, sc, count;
    static int[][] map;
    static int[][] deltas = {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[] dirs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 1;
        }

        st = new StringTokenizer(br.readLine());

        sr = Integer.parseInt(st.nextToken());
        sc = Integer.parseInt(st.nextToken());

        map[sr][sc] = 1;

        dirs = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            dirs[i] = Integer.parseInt(st.nextToken());
        }

        count = 0;
        int dir = 0;

        while (true) {
            int nr = sr + deltas[dirs[dir]][0];
            int nc = sc + deltas[dirs[dir]][1];

            if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == 0) {
                map[nr][nc] = 1;
                sr = nr;
                sc = nc;
                count = 0;
            } else {
                dir = (dir + 1) % 4;
                count++;
            }

            if (count == 4) break;
        }

        System.out.println(sr + " " + sc);
    }
}

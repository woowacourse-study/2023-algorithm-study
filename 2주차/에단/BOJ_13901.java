import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem13901 {

    private static int R;
    private static int C;
    private static int[][] map;
    private static boolean[][] isVisited;
    private static int[] dr = {0, -1, 1, 0, 0};
    private static int[] dc = {0, 0, 0, -1, 1};
    private static int lr;
    private static int lc;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        isVisited = new boolean[R][C];

        final int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            isVisited[r][c] = true;
        }

        st = new StringTokenizer(br.readLine());

        int sr = Integer.parseInt(st.nextToken());
        int sc = Integer.parseInt(st.nextToken());

        List<Integer> orders = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            orders.add(Integer.parseInt(st.nextToken()));
        }

        int mapSize = R * C;
        List<Integer> newOrders = new ArrayList<>();
        while (mapSize > newOrders.size()) {
            newOrders.addAll(orders);
        }

        move(sr, sc, newOrders);
        System.out.println(lr + " " + lc);
    }

    private static void move(final int sr, final int sc, final List<Integer> orders) {
        int cr = sr;
        int cc = sc;
        int currentPosition = 0;

        isVisited[cr][cc] = true;

        for (int d = 0; d < orders.size(); d++) {
            final Integer direction = orders.get(d);
            int nr = cr + dr[direction];
            int nc = cc + dc[direction];

            if (nr < 0 || nc < 0 || nr >= R || nc >= C || isVisited[nr][nc]) {
                continue;
            }

            isVisited[nr][nc] = true;
            map[nr][nc] = ++currentPosition;
            lr = cr = nr;
            lc = cc = nc;
            d--;
        }
    }
}

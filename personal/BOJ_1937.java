import java.io.*;
import java.util.*;

// 방문체크가 필요없다 (팬더는 지금 자신이 있던 곳보다 더 많은 대나무를 가지고 있는 곳에만 방문을 하기 때문
// dfs 와 dp 를 같이 사용해야 한다

public class BOJ_1937 {
    static int N;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans = Math.max(ans, dfs(i,j));
            }
        }
        System.out.print(ans);

    }


    static int dfs(int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        dp[i][j] = 1;

        for (int d = 0;  d < 4; d++) {
            int x = i + dirs[d][0];
            int y = j + dirs[d][1];

            if (x < 0 || x >= N || y < 0 || y >= N) {
                continue;
            }

            if (map[i][j] < map[x][y]) {
                dp[i][j] = Math.max(dp[i][j], dfs(x,y) + 1);
            }
        }
        return dp[i][j];
    }
}

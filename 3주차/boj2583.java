import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class q2583 {

    static int n, m, k;
    static int[][] pos = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] map;
    static List<Integer> answer;
    static int count;
    static boolean[][] visited;

    public static void main(String[] args) {
        initData();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count = 0;
                if (i >= 0 && i < n && j >= 0 && j < m && !visited[i][j] && map[i][j] == 0) {
                    visited[i][j] = true;
                    count += 1;
                    map[i][j] = 1;
                    dfs(i, j);
                    answer.add(count);
                }
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for (Integer integer : answer) {
            System.out.print(integer + " ");
        }
    }

    private static void dfs(int row, int col) {
        for (int i = 0; i < pos.length; i++) {
            int nr = row + pos[i][0];
            int nc = col + pos[i][1];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && map[nr][nc] == 0) {
                visited[nr][nc] = true;
                map[nr][nc] = 1;
                dfs(nr, nc);
                count++;
            }
        }
    }

    private static void initData() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        count = 0;
        visited = new boolean[n][m];
        map = new int[n][m];
        answer = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            int leftX = sc.nextInt(); // 0
            int leftY = sc.nextInt(); // 2

            int rightX = sc.nextInt(); // 4
            int rightY = sc.nextInt(); // 4

            int rightUpRow = n - rightY; // 1
            int leftUnderRow = n - leftY - 1; // 2

            for (int j = rightUpRow; j <= leftUnderRow; j++) {
                for (int k = leftX; k < rightX; k++) {
                    map[j][k] = 1;
                }
            }
        }
    }
}

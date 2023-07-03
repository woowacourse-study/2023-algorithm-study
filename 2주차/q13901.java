import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n, m;
    static int k;
    static int[][] map;
    static boolean[][] visited;
    static int startRow, startCol;
    static int posIndex;
    static int[] directions;
    static int[][] pos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        initData();
        bfs();
        System.out.println(startRow + " " + startCol);
    }

    private static void bfs() {
        visited[startRow][startCol] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < pos.length; i++) {
                // 0 1 4
                int d = directions[(posIndex + i) % 4];
                int nr = now[0] + pos[d][0];
                int nc = now[1] + pos[d][1];

                if (!(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && map[nr][nc] != -1)) {
                    continue;
                }

                visited[nr][nc] = true;
                queue.add(new int[]{nr, nc});

                posIndex = (posIndex + i) % 4;
                startRow = nr;
                startCol = nc;
                break;
            }
        }
    }

    private static void initData() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        directions = new int[4];
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < k; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            map[r][c] = -1;
        }

        startRow = sc.nextInt();
        startCol = sc.nextInt();


        for (int i = 0; i < 4; i++) {
            directions[i] = sc.nextInt() - 1;
        }
    }
}

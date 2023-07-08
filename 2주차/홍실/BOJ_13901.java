import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_13901 {

    static final int obstacle = -1;

    static int R;
    static int C;
    static int K;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static List<Integer> moveDir = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        R = scanner.nextInt();
        C = scanner.nextInt();
        scanner.nextLine();
        K = scanner.nextInt();
        scanner.nextLine();

        map = new int[R][C];

        for (int i = 0; i < K; i++) {
            int br = scanner.nextInt();
            int bc = scanner.nextInt();
            scanner.nextLine();
            map[br][bc] = obstacle;
        }

        int sr = scanner.nextInt();
        int sc = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < 4; i++) {
            moveDir.add(scanner.nextInt());
        }

        int temp = 0;
        int endCount = 0;
        while (true) {
            int dir = moveDir.get(temp);
            for (int i = 0; i < 4; i++) {
                if (sr + dy[i] < 0
                    || sr + dy[i] >= R
                    || sc + dx[i] < 0
                    || sc + dx[i] >= C
                    || map[sr + dy[i]][sc + dx[i]] == obstacle) {
                    endCount++;
                }
            }
            if (endCount == 4) {
                break;
            }
            while (true) {
                if (sr + dy[dir - 1] < 0
                    || sr + dy[dir - 1] >= R
                    || sc + dx[dir - 1] < 0
                    || sc + dx[dir - 1] >= C
                    || map[sr + dy[dir - 1]][sc + dx[dir - 1]] == obstacle) {
                    break;
                }
                map[sr][sc] = obstacle;
                sr += dy[dir - 1];
                sc += dx[dir - 1];
            }
            temp = (temp + 1) % 4;
            endCount = 0;
        }

        System.out.print(sr + " ");
        System.out.print(sc);
    }
}

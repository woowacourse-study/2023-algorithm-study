import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class BOJ_13901 {
    private static int IMPOSSIBLE = 1;
    private static int R;
    private static int C;
    private static int[][] MAP = new int[1000][1000];
    private static int[] move = new int[4];
    private static int[] dx = {-1, +1, 0, 0};
    private static int[] dy = {0, 0, -1, +1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());
        for (int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            MAP[r][c] = IMPOSSIBLE;
        }

        st = new StringTokenizer(br.readLine(), " ");
        int nowR = Integer.parseInt(st.nextToken());
        int nowC = Integer.parseInt(st.nextToken());
        MAP[nowR][nowC] = IMPOSSIBLE;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<4; i++) {
            move[i] = Integer.parseInt(st.nextToken())-1;
        }

        int idx = 0;

        while(canMove(nowR, nowC)) {
            int newR = nowR + dx[move[idx % 4]];
            int newC = nowC + dy[move[idx % 4]];
            if (isPossible(newR, newC)) {
                MAP[newR][newC] = 1;
                nowR = newR;
                nowC = newC;
            } else {
                idx++;
            }
        }

        System.out.println(nowR+" "+ nowC);
    }

    public static boolean isPossible(int nr, int nc) {
        if (nr < 0 || nc < 0 || nr >= R || nc >= C || MAP[nr][nc] == IMPOSSIBLE) {
            return false;
        }
        return true;
    }

    public static boolean canMove(int nr, int nc) {
        for (int i=0; i<4; i++) {
            if (isPossible(nr + dx[move[i]], nc + dy[move[i]])) {
                return true;
            }
        }
        return false;
    }
}

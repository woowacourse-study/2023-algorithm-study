import static java.util.Arrays.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class 백준_14500 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final List<List<Integer>> map = new ArrayList<>();
    private static final boolean[][] visited = new boolean[500][500];
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    private static int Y;
    private static int X;

    public static void main(String[] args) {
        String[] input = readLine().split(" ");
        Y = Integer.parseInt(input[0]);
        X = Integer.parseInt(input[1]);
        for (int i = 0; i < Y; i++) {
            map.add(stream(readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
        }
        Collections.reverse(map);

        int max = 0;
        for (int i = 0; i < Y; i++) {
            for (int i1 = 0; i1 < X; i1++) {

                visited[i][i1] = true;
                int solve = solve(i1, i, 1);
                visited[i][i1] = false;
                max = Math.max(max, solve);
            }
        }

        System.out.println(max);
    }

    public static String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int solve(int x, int y, int depth) {
        int current = getValue(x, y);
        if (depth == 4) {
            return current;
        }

        int max = 0;
        for (int i = 0; i < 4; i++) {
            int dx1 = dx[i];
            int dy1 = dy[i];
            if (canVisit(x + dx1, y + dy1) && !visited[y + dy1][x + dx1]) {
                if (depth == 2) {
                    visited[y + dy1][x + dx1] = true;
                    int solve = solve(x, y, depth + 1)  // 2. t 모양 만들기 위해 남은 한칸
                            + getValue(x + dx1, y + dy1)  // 1. 다음거 방문했다 치고
                            - current;  // 3. depth 3에서 current + max 로 인해 current가 중복이므로 제거
                    max = Math.max(max, solve);
                    visited[y + dy1][x + dx1] = false;
                }
                visited[y + dy1][x + dx1] = true;
                int solve = solve(x + dx1, y + dy1, depth + 1);
                max = Math.max(max, solve);
                visited[y + dy1][x + dx1] = false;

            }
        }
        return max + current;
    }

    private static int getValue(int x, int y) {
        return map.get(y).get(x);
    }

    private static boolean canVisit(int x, int y) {
        if (x < 0 || x >= X) {
            return false;
        }
        if (y < 0 || y >= Y) {
            return false;
        }
        return true;
    }
}

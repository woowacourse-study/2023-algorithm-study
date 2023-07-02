import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        int maxDist = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maxDist = Math.max(maxDist, findMaxDist(arr, N, M, i, j));
            }
        }
        System.out.println((maxDist + 1) * (maxDist + 1));
    }

    private static int findMaxDist(int[][] arr, int N, int M, int i, int j) {
        int dis = 1;
        int maxDist = 0;
        while (i + dis < N && j + dis < M) {
            int leftUp = arr[i][j];
            int rightUp = arr[i][j + dis];
            int leftDown = arr[i + dis][j];
            int rightDown = arr[i + dis][j + dis];

            if (leftUp == rightUp && rightUp == leftDown && leftDown == rightDown) {
                maxDist = dis;
            }
            dis++;
        }
        return maxDist;
    }
}

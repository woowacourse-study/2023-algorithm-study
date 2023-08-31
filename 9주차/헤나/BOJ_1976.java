package 헤나;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976 {

    private static final int MAX_N = 200, MAX_M = 1_000;
    private static final int ABLE = 1;

    private static int N, M;
    private static int[] parent;
    private static int[] target;

    public static void main(String[] args) throws Exception {
        parent = new int[MAX_N + 1];
        target = new int[MAX_M + 1];

        for (int i = 0; i <= MAX_N; i++) {
            parent[i] = i;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for (int row = 1; row <= N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 1; col <= N; col++) {
                final int currentValue = Integer.parseInt(st.nextToken());
                if (currentValue == ABLE) {
                    unionParent(row, col);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }


        boolean isAble = true;
        for (int i = 1; i < M; i++) {
            if (findParent(target[i]) == findParent(target[M])) {
                continue;
            }
            isAble = false;
            break;
        }

        System.out.println(isAble ? "YES" : "NO");
    }

    private static int findParent(int number) {
        if (parent[number] == number) {
            return number;
        }
        return findParent(parent[number]);
    }

    private static void unionParent(int left, int right) {
        left = findParent(left);
        right = findParent(right);

        if (left < right) {
            parent[right] = left;
        } else {
            parent[left] = right;
        }
    }
}

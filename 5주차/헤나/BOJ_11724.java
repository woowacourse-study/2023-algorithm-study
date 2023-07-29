package 헤나;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_11724 {
    private static final int MAX_N = 1000;

    private static int N, M;
    private static boolean[][] arr;

    public static void main(String[] args) throws Exception {
        arr = new boolean[MAX_N + 1][MAX_N + 1];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int number = 1; number <= N; number++) {
            arr[number][number] = true;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            final int u = Integer.parseInt(st.nextToken());
            final int v = Integer.parseInt(st.nextToken());

            arr[u][v] = true;
            arr[v][u] = true;
        }

        int findCount = 0;
        for (int u = 1; u <= N; u++) {
            Deque<Edge> deque = new ArrayDeque<>();
            for (int v = 1; v <= N; v++) {
                if (!arr[u][v]) {
                    continue;
                }

                findCount++;

                deque.addLast(new Edge(u, v));
                arr[u][v] = false;
                arr[v][u] = false;

                while (!deque.isEmpty()) {
                    final Edge poll = deque.pollFirst();

                    for (int nextNumber = 1; nextNumber <= N; nextNumber++) {
                        if (arr[poll.u][nextNumber]) {
                            arr[poll.u][nextNumber] = false;
                            arr[nextNumber][poll.u] = false;
                            deque.addLast(new Edge(poll.u, nextNumber));
                        }

                        if (arr[nextNumber][poll.v]) {
                            arr[nextNumber][poll.v] = false;
                            arr[poll.v][nextNumber] = false;
                            deque.addLast(new Edge(nextNumber, poll.v));
                        }
                    }
                }
            }
        }

        System.out.println(findCount);
    }

    private static class Edge {
        private final int u;
        private final int v;

        public Edge(final int u, final int v) {
            this.u = u;
            this.v = v;
        }
    }
}

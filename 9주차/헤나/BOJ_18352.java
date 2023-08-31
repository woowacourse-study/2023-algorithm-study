package 헤나;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_18352 {

    private static final int MAX_N = 300_000;

    private static int N, M, K, X;
    private static List<Integer>[] arr;
    private static int[] distances;

    public static void main(String[] args) throws Exception {
        arr = new List[MAX_N + 1];
        for (int i = 0; i <= MAX_N; i++) {
            arr[i] = new ArrayList<>();
        }
        distances = new int[MAX_N + 1];
        for (int i = 0; i <= MAX_N; i++) {
            distances[i] = Integer.MAX_VALUE;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            final int index = Integer.parseInt(st.nextToken());
            final int value = Integer.parseInt(st.nextToken());
            arr[index].add(value);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.distance > b.distance ? 1 : -1);
        distances[X] = 0;
        for (Integer target : arr[X]) {
            pq.add(new Node(target, 1));
            distances[target] = 1;
        }

        while (!pq.isEmpty()) {
            final Node poll = pq.poll();

            for (Integer target : arr[poll.end]) {
                if (distances[target] != Integer.MAX_VALUE) {
                    continue;
                }

                distances[target] = poll.distance + 1;
                pq.add(new Node(target, poll.distance + 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= MAX_N; i++) {
            if (distances[i] == K) {
                sb.append(i).append(System.lineSeparator());
            }
        }
        System.out.println(sb.length() == 0 ? -1 : sb);
    }

    private static class Node {
        private final int end;
        private final int distance;

        public Node(final int end, final int distance) {
            this.end = end;
            this.distance = distance;
        }
    }
}

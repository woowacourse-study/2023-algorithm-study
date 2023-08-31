package 헤나;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1446 {

    private static final int MAX_D = 10_000;

    private static int N, D;
    private static List<Node> fastWays;
    private static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        fastWays = new ArrayList<>();
        visited = new boolean[MAX_D + 1][MAX_D + 1];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            final int start = Integer.parseInt(st.nextToken());
            final int end = Integer.parseInt(st.nextToken());
            final int distance = Integer.parseInt(st.nextToken());

            fastWays.add(new Node(start, end, distance));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.distance > b.distance ? 1 : -1);
        pq.add(new Node(0, 0, 0));
        visited[0][0] = true;

        int minDistance = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            final Node poll = pq.poll();

            if (poll.end == D) {
                minDistance = Math.min(minDistance, poll.distance);
            }

            for (final Node fastWay : fastWays) {
                if (poll.end == fastWay.start) {
                    if (fastWay.end - poll.end < fastWay.distance) {
                        pq.add(new Node(poll.end, fastWay.end, poll.distance + fastWay.end - poll.end));
                    } else {
                        pq.add(new Node(poll.end, fastWay.end, fastWay.distance + poll.distance));
                    }
                    visited[poll.end][fastWay.end] = true;
                }
            }

            if (poll.end < D) {
                if (visited[poll.end][poll.end + 1]) {
                    continue;
                }
                visited[poll.end][poll.end + 1] = true;
                pq.add(new Node(poll.end, poll.end + 1, poll.distance + 1));
            }
        }

        System.out.println(minDistance);
    }

    private static class Node {
        private final int start;
        private final int end;
        private final int distance;

        public Node(final int start, final int end, final int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }
}

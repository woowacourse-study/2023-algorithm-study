//https://www.acmicpc.net/problem/1240

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_1240 {
    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        final List<Edge>[] nodes = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            final StringTokenizer nodeInfoSt = new StringTokenizer(br.readLine());
            final int from = Integer.parseInt(nodeInfoSt.nextToken());
            final int to = Integer.parseInt(nodeInfoSt.nextToken());
            final int weight = Integer.parseInt(nodeInfoSt.nextToken());

            nodes[from].add(new Edge(to, weight));
            nodes[to].add(new Edge(from, weight));
        }

        for (int i = 0; i < M; i++) {
            final StringTokenizer pathSt = new StringTokenizer(br.readLine());
            final int from = Integer.parseInt(pathSt.nextToken());
            final int to = Integer.parseInt(pathSt.nextToken());

            final boolean[] visited = new boolean[N + 1];
            final Deque<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{from, 0});
            visited[from] = true;

            while (!queue.isEmpty()) {
                final int[] nodeWithDistance = queue.pollFirst();
                final int nodeNumber = nodeWithDistance[0];
                final int distanceFrom = nodeWithDistance[1];

                if (nodeNumber == to) {
                    System.out.println(distanceFrom);
                    break;
                }

                final List<Edge> node = nodes[nodeNumber];
                for (final Edge edge : node) {
                    if (visited[edge.to]) {
                        continue;
                    }

                    queue.add(new int[]{edge.to, distanceFrom + edge.weight});
                    visited[edge.to] = true;
                }
            }
        }

    }

    private static class Edge {
        private final int to;
        private final int weight;

        public Edge(final int to, final int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}


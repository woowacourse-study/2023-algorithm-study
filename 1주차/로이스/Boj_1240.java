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

        final List<Edge>[] nodes = new ArrayList[N + 1]; //이어진 node 번호 List를 가지는 node 번호의 배열
        for (int i = 1; i < N + 1; i++) {
            nodes[i] = new ArrayList<>();
        }
      
        for (int i = 0; i < N - 1; i++) {
            final StringTokenizer nodeInfoSt = new StringTokenizer(br.readLine());
            final int from = Integer.parseInt(nodeInfoSt.nextToken());
            final int to = Integer.parseInt(nodeInfoSt.nextToken());
            final int weight = Integer.parseInt(nodeInfoSt.nextToken());

            nodes[from].add(new Edge(to, weight)); //양방향 저장
            nodes[to].add(new Edge(from, weight));
        }

        for (int i = 0; i < M; i++) {
            final StringTokenizer pathSt = new StringTokenizer(br.readLine());
            final int from = Integer.parseInt(pathSt.nextToken());
            final int to = Integer.parseInt(pathSt.nextToken());

            final boolean[] visited = new boolean[N + 1];
            final Deque<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{from, 0});

            while (!queue.isEmpty()) {
                final int[] nodeWithDistance = queue.pollFirst();
                final int nodeNumber = nodeWithDistance[0];
                final int distanceFrom = nodeWithDistance[1];
                if (visited[nodeNumber]) { //visited 탈출
                    continue;
                }
                visited[nodeNumber] = true;

                if (nodeNumber == to) {
                    System.out.println(distanceFrom);
                    break;
                }

              //BFS
              //탐색중인 노드에 연결된 Edge들을 queue에 추가
                final List<Edge> node = nodes[nodeNumber];
                for (final Edge edge : node) {
                    queue.add(new int[]{edge.to, distanceFrom + edge.weight});
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


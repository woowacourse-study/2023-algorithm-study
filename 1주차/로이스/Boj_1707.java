//https://www.acmicpc.net/problem/1707

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_1707 {
    private static final short EMPTY = 0;
    private static final short RED = 1;
    private static final short BLACK = 2;


    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            solution(br);
        }
    }

    private static void solution(final BufferedReader br) throws IOException {
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final int V = Integer.parseInt(st.nextToken());
        final int E = Integer.parseInt(st.nextToken());
        final Node[] nodes = new Node[V + 1];
        for (int i = 1; i < V + 1; i++) {
            nodes[i] = new Node(i);
        }

        final List<Node>[] nodeGraph = new ArrayList[V + 1];
        for (int i = 1; i < V + 1; i++) {
            nodeGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            final StringTokenizer edgeSt = new StringTokenizer(br.readLine());
            final int from = Integer.parseInt(edgeSt.nextToken());
            final int to = Integer.parseInt(edgeSt.nextToken());

            nodeGraph[from].add(nodes[to]);
            nodeGraph[to].add(nodes[from]);
        }

        for (int i = 1; i < V + 1; i++) {
            if (nodeGraph[i].isEmpty()
                    || nodes[i].color != 0) {
                continue;
            }

            final Deque<Node> deque = new ArrayDeque<>();
            nodes[i].color = RED;
            for (final Node node : nodeGraph[i]) {
                node.color = BLACK;
                deque.add(node);
            }

            while (!deque.isEmpty()) {
                final Node node = deque.poll();
                final int number = node.number;
                final short nextColor = node.getNextColor();

                for (final Node nextNode : nodeGraph[number]) {
                    if (nextNode.color == EMPTY) {
                        nextNode.color = nextColor;
                        deque.add(nextNode);
                        continue;
                    }

                    if (nextNode.color != nextColor) {
                        System.out.println("NO");
                        return;
                    }
                }
            }
        }

        System.out.println("YES");
    }

    private static class Node {
        private final int number;
        private short color = EMPTY;

        public Node(final int number) {
            this.number = number;
        }

        private short getNextColor() {
            return (this.color == RED) ? BLACK : RED;
        }
    }
}

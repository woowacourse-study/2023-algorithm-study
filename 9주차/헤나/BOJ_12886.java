package 헤나;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_12886 {

    private static final int YES = 1, NO = 0;

    private static int A, B, C;
    private static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        visited = new boolean[1501][1501];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        boolean isAble = false;
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(A, B, C));
        visited[A][B] = true;


        while (!queue.isEmpty()) {
            final Node poll = queue.poll();

            if (poll.isAllSame()) {
                isAble = true;
                break;
            }

            final int[] ab = calculate(poll.a, poll.b);
            if (ab.length == 2) {
                if (isRangeOk(ab[0]) && isRangeOk(ab[1]) && isRangeOk(poll.c)
                    && !visited[ab[0]][ab[1]]
                ) {
                    visited[ab[0]][ab[1]] = true;
                    queue.add(new Node(ab[0], ab[1], poll.c));
                }
            }

            final int[] ac = calculate(poll.a, poll.c);
            if (ac.length == 2) {
                if (isRangeOk(ac[0]) && isRangeOk(poll.b) && isRangeOk(ac[1])
                    && !visited[ac[0]][ac[1]]
                ) {
                    visited[ac[0]][ac[1]] = true;
                    queue.add(new Node(ac[0], poll.b, ac[1]));
                }
            }

            final int[] bc = calculate(poll.b, poll.c);
            if (bc.length == 2) {
                if (isRangeOk(poll.a) && isRangeOk(bc[0]) && isRangeOk(bc[1])
                    && !visited[bc[0]][bc[1]]
                ) {
                    visited[bc[0]][bc[1]] = true;
                    queue.add(new Node(poll.a, bc[0], bc[1]));
                }
            }
        }

        System.out.println(isAble ? YES : NO);
    }

    private static int[] calculate(int smaller, int bigger) {
        if (smaller == bigger) {
            return new int[]{};
        }
        if (smaller > bigger) {
            int temp = smaller;
            smaller = bigger;
            bigger = temp;
        }

        return new int[]{smaller + smaller, bigger - smaller};
    }

    private static boolean isRangeOk(final int number) {
        return 1 <= number;
    }

    private static class Node {
        private final int a;
        private final int b;
        private final int c;

        public Node(final int a, final int b, final int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public boolean isAllSame() {
            return a == b && b == c;
        }
    }
}

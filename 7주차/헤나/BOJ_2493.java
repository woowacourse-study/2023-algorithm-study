package 헤나;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {

    private static final int MAX_N = 500_000;

    private static int N;
    private static int[] tops;

    public static void main(String[] args) throws Exception {
        tops = new int[MAX_N + 1];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            tops[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        Stack<Top> stack = new Stack<>();

        sb.append(0).append(" ");
        stack.push(new Top(tops[1], 1));
        for (int i = 2; i <= N; i++) {
            final Top lastTop = stack.peek();
            if (lastTop.value <= tops[i]) {
                while (!stack.isEmpty() && stack.peek().value <= tops[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    sb.append(0).append(" ");
                } else {
                    final Top beforeTop = stack.peek();
                    sb.append(beforeTop.index).append(" ");
                }
            } else {
                sb.append(lastTop.index).append(" ");
            }
            stack.push(new Top(tops[i], i));
        }

        System.out.println(sb);
    }

    private static class Top {
        private final int value;
        private final int index;

        public Top(final int value, final int index) {
            this.value = value;
            this.index = index;
        }
    }
}

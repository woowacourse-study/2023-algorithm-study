package 헤나;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_1697 {
    private static final int MAX_N = 100_000;

    private static int arr[];

    public static void main(String[] args) throws Exception {
        arr = new int[MAX_N + 1];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int subin = Integer.parseInt(st.nextToken());
        int bro = Integer.parseInt(st.nextToken());
        int answer = 0;

        if (subin != bro) {
            answer = bfs(subin, bro);

        }

        System.out.println(answer);
    }

    private static int bfs(int subin, int bro) {
        Deque<Integer> deque = new ArrayDeque<>();

        deque.addLast(subin);
        arr[subin] = 0;
        while (!deque.isEmpty()) {
            int subinPolled = deque.poll();
            if (subinPolled + 1 == bro
                || subinPolled - 1 == bro
                || subinPolled * 2 == bro) {
                return arr[subinPolled] + 1;
            }

            if (isRange(subinPolled + 1) && subinPolled < bro && arr[subinPolled + 1] == 0) {
                deque.offer(subinPolled + 1);
                arr[subinPolled + 1] = arr[subinPolled] + 1;
            }
            if (isRange(subinPolled - 1) && subinPolled > 0 && arr[subinPolled - 1] == 0) {
                deque.offer(subinPolled - 1);
                arr[subinPolled - 1] = arr[subinPolled] + 1;
            }
            if (isRange(subinPolled * 2) && subinPolled < bro && arr[subinPolled * 2] == 0) {
                deque.offer(subinPolled * 2);
                arr[subinPolled * 2] = arr[subinPolled] + 1;
            }
        }

        return 0;
    }

    private static boolean isRange(final int index) {
        return 1 <= index && index <= MAX_N;
    }
}

package 헤나;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_23757 {

    private static final int SUCCESS = 1, FAIL = 0;

    private static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> presents = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 1; i <= N; i++) {
            presents.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        Deque<Integer> children = new ArrayDeque<>();
        for (int i = 1; i <= M; i++) {
            children.add(Integer.parseInt(st.nextToken()));
        }

        int answer = SUCCESS;
        while (!children.isEmpty()) {
            final int childrenPollNumber = children.poll();
            final int presentPollNumber = presents.poll();

            if (childrenPollNumber < presentPollNumber) {
                presents.add(presentPollNumber - childrenPollNumber);
                continue;
            } else if (childrenPollNumber > presentPollNumber) {
                answer = FAIL;
                break;
            }

            if (presents.isEmpty()) {
                answer = FAIL;
                break;
            }
        }
        System.out.println(answer);
    }
}

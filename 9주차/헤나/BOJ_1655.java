package 헤나;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_1655 {

    private static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> leftPQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> rightPQ = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            final int currentValue = Integer.parseInt(br.readLine());

            if (i % 2 == 0) {
                if (!rightPQ.isEmpty() && rightPQ.peek() < currentValue) {
                    rightPQ.add(currentValue);
                    leftPQ.add(rightPQ.poll());
                } else {
                    leftPQ.add(currentValue);
                }
            } else {
                if (leftPQ.peek() > currentValue) {
                    rightPQ.add(leftPQ.poll());
                    leftPQ.add(currentValue);
                } else {
                    rightPQ.add(currentValue);
                }
            }

            sb.append(leftPQ.peek()).append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}

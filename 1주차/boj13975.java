package com.sosow0212.백준;

import java.util.PriorityQueue;
import java.util.Scanner;

public class boj13975 {

    private static final Scanner sc = new Scanner(System.in);

    private static long answer;

    public static void main(String[] args) {

        int test = sc.nextInt();

        for (int i = 0; i < test; i++) {
            answer = 0;
            getAnswer();
            System.out.println(answer);
        }
    }

    private static void getAnswer() {
        int n = sc.nextInt();
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.offer(sc.nextLong());
        }

        while (pq.size() > 1) {
            Long file1 = pq.poll();
            Long file2 = pq.poll();
            answer += file1 + file2;
            pq.offer(file1 + file2);
        }
    }
}

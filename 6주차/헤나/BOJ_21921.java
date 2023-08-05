package 헤나;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21921 {

    private static final int MAX_X = 250_000;

    private static int N, X;
    private static int[] visitedCount;

    public static void main(String[] args) throws Exception {
        visitedCount = new int[MAX_X + 1];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            visitedCount[i] = Integer.parseInt(st.nextToken());
        }

        int currentVisitedCountSum = 0;
        for (int i = 1; i <= X; i++) {
            currentVisitedCountSum += visitedCount[i];
        }

        int maxVisitedCountSum = currentVisitedCountSum;
        int foundCount = currentVisitedCountSum == 0 ? 0 : 1;
        int left = 2;
        for (int right = left + X - 1; right <= N; right++) {
            currentVisitedCountSum -= visitedCount[left - 1];
            currentVisitedCountSum += visitedCount[right];
            left++;

            if (currentVisitedCountSum > maxVisitedCountSum) {
                foundCount = 1;
                maxVisitedCountSum = currentVisitedCountSum;
            } else if (currentVisitedCountSum == maxVisitedCountSum) {
                foundCount++;
            }
        }

        if (maxVisitedCountSum == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxVisitedCountSum);
            System.out.println(foundCount);
        }
    }
}

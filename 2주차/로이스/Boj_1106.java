//2023.07.04
//https://www.acmicpc.net/problem/1082

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj_1106 {
    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer CN = new StringTokenizer(br.readLine());
        final int C = Integer.parseInt(CN.nextToken());
        final int N = Integer.parseInt(CN.nextToken());
        final Map<Integer, Integer> costByPersonCount = new HashMap<>();
        final int[] costs = new int[1000 + 100 + 1];
        final int MAX_VALUE = 100 * 1000 + 1;
        Arrays.fill(costs, MAX_VALUE);
        int maxPersonCount = 0;
        for (int i = 0; i < N; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int cost = Integer.parseInt(st.nextToken());
            final int personCount = Integer.parseInt(st.nextToken());

            costs[personCount] = Math.min(cost, costs[personCount]);
            costByPersonCount.put(personCount, costs[personCount]);
            if (maxPersonCount < personCount) {
                maxPersonCount = personCount;
            }
        }

        final int i1 = C + maxPersonCount + 1;
        for (int i = 1; i < i1; i++) {
            if (costs[i] == 0) {
                continue;
            }

            for (final int personCount : costByPersonCount.keySet()) {
                final int cost = costByPersonCount.get(personCount);
                costs[i + personCount] = Math.min(cost + costs[i], costs[i + personCount]);
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = C; i < i1; i++) {
            if (costs[i] < answer) {
                answer = costs[i];
            }
        }

        System.out.println(answer);
    }
}

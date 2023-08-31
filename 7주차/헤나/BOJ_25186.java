package 헤나;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_25186 {

    private static final int MAX_N = 100_000;
    private static final String HAPPY = "Happy";
    private static final String UNHAPPY = "Unhappy";

    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws Exception {
        arr = new int[MAX_N];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        final long maxCloth = Arrays.stream(arr).asLongStream().max().getAsLong();
        final long population = Arrays.stream(arr).asLongStream().reduce(Long::sum).getAsLong();

        boolean isUnhappy = maxCloth > Math.floorDiv(population, 2);

        if (population == 1) {
            isUnhappy = false;
        }
        System.out.println(isUnhappy ? UNHAPPY : HAPPY);
    }
}

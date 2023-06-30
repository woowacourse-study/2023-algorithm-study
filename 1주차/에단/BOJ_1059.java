package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1059 {

    private static int[] array;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int L = Integer.parseInt(br.readLine());

        array = new int[L];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < L; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        final int n = Integer.parseInt(br.readLine());

        Arrays.sort(array);

        int start = -1;
        int end = L - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (array[mid] >= n) {
                end = mid;
                continue;
            }

            start = mid;
        }

        if (array[end] == n) {
            System.out.println(0);
            return;
        }

        if (end == 0) {
            System.out.println((n - 1) * (array[0] - n) + (array[0] - (n + 1)));
            return;
        }

        final int s = array[start] + 1;
        final int e = array[start + 1] - 1;
        int sum = (n - s) * (e - n + 1) + (e - n);
        System.out.println(sum);
    }
}

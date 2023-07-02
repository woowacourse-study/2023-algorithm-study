package 헤나;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654 {
    private static final int MAX_N = 1_000_000;
    private static final long MAX_LENGTH = (long) (Math.pow(2, 31) - 1);

    private static int K, N;
    private static int[] arr;

    public static void main(String[] args) throws Exception {
        arr = new int[MAX_N + 1];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long findValue = find(1, MAX_LENGTH + 1, 0);
        System.out.println(findValue);
    }

    private static long find(long leftLengthValue, long rightLengthValue, long beforeMidLength) {
        long midLengthValue = Math.floorDiv(leftLengthValue + rightLengthValue, 2);
        if (midLengthValue == beforeMidLength) {
            return beforeMidLength;
        }
        beforeMidLength = midLengthValue;

        long n = 0;
        for (int i = 1; i <= N; i++) {
            n += Math.floorDiv(arr[i], midLengthValue);
        }

        if (N > n) {
            return find(leftLengthValue, midLengthValue, beforeMidLength);
        } else {
            return find(midLengthValue, rightLengthValue, beforeMidLength);
        }
    }
}

//https://www.acmicpc.net/problem/1253

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1253 {
    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        final StringTokenizer st = new StringTokenizer(br.readLine());
        final int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        int answer = 0;
        final int maxLength = numbers.length - 1;
        for (int i = maxLength; i >= 0; i--) {
            final int targetNumber = numbers[i];
            int startIndex = 0;
            int endIndex = numbers.length - 1;

            long sum = 0;
            while (startIndex < endIndex) {
                sum = numbers[startIndex] + numbers[endIndex];
                if (sum > targetNumber || endIndex == i) {
                    endIndex -= 1;
                    continue;
                } else if (sum < targetNumber || startIndex == i) {
                    startIndex += 1;
                    continue;
                }

                answer += 1;
                break;
            }
        }

        System.out.println(answer);
    }
}

//https://www.acmicpc.net/problem/3151

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_3151 {
    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(scores);
        final int maxIndex = scores.length - 1;
        long answer = 0;
        for (int i = 0; i < N - 2; i++) {
            if (scores[i] > 0) {
                break;
            }

            final int searchTarget = scores[i] * -1;
            int startIndex = i + 1;
            int endIndex = maxIndex;

            while (startIndex != endIndex) {
                final long frontNumber = scores[startIndex];
                final long lastNumber = scores[endIndex];
                final long sum = frontNumber + lastNumber;

                final long caseCount;
                if (sum == searchTarget) {
                    if (frontNumber == lastNumber) {
                        int numberCount = 1;
                        while (startIndex < endIndex && frontNumber == scores[++startIndex]) {
                            numberCount += 1;
                        }

                        caseCount = (long) numberCount * (numberCount - 1) / 2;
                    } else {
                        int frontNumberCount = 1;
                        while (startIndex < endIndex && frontNumber == scores[++startIndex]) {
                            frontNumberCount += 1;
                        }

                        int lastNumberCount = 1;
                        while (startIndex < endIndex && lastNumber == scores[--endIndex]) {
                            lastNumberCount += 1;
                        }

                        caseCount = (long) frontNumberCount * lastNumberCount;
                    }
                    answer += caseCount;
                    continue;
                }

                if (sum < searchTarget) {
                    startIndex += 1;
                    continue;
                }

                endIndex -= 1;
            }
        }

        System.out.println(answer);
    }
}

package 헤나;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2503 {

    private static boolean[] arr;

    public static void main(String[] args) throws Exception {
        arr = new boolean[1_000];
        Arrays.fill(arr, true);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        final int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            final char[] numbers = st.nextToken().toCharArray();
            final int strikes = Integer.parseInt(st.nextToken());
            final int balls = Integer.parseInt(st.nextToken());

            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    for (int l = 1; l <= 9; l++) {
                        if (j == k || k == l || j == l) {
                            continue;
                        }

                        final String currentNumberString = String.format("%d%d%d", j, k, l);
                        final char[] currentNumbers = currentNumberString.toCharArray();

                        int currentStrike = 0;
                        int currentBall = 0;

                        for (int m = 0; m < 3; m++) {
                            if (currentNumbers[m] == numbers[m]) {
                                currentStrike++;
                                continue;
                            }

                            for (int o = 0; o < 3; o++) {
                                if (o == m) {
                                    continue;
                                }
                                if (currentNumbers[m] == numbers[o]) {
                                    currentBall++;
                                }
                            }
                        }

                        if (currentStrike == strikes && currentBall == balls) {
                            continue;
                        }
                        arr[Integer.parseInt(currentNumberString)] = false;
                    }
                }
            }
        }

        int count = 0;
        for (int j = 1; j <= 9; j++) {
            for (int k = 1; k <= 9; k++) {
                for (int l = 1; l <= 9; l++) {
                    if (j == k || k == l || j == l) {
                        continue;
                    }

                    final int number = Integer.parseInt(String.format("%d%d%d", j, k, l));
                    if (arr[number]) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}

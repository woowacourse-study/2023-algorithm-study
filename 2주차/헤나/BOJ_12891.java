package 헤나;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12891 {
    private static char[] DNA;
    private static char A = 'A', C = 'C', G = 'G', T = 'T';
    private static int P, S;
    private static int A_MIN_COUNT, C_MIN_COUNT, G_MIN_COUNT, T_MIN_COUNT;
    private static int aCount, cCount, gCount, tCount;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        P = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        DNA = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        A_MIN_COUNT = Integer.parseInt(st.nextToken());
        C_MIN_COUNT = Integer.parseInt(st.nextToken());
        G_MIN_COUNT = Integer.parseInt(st.nextToken());
        T_MIN_COUNT = Integer.parseInt(st.nextToken());

        int passwordCount = 0;
        int right = 0;
        increaseSubWordCount(0);
        for (int left = 0; left < P; left++) {

            while (right + 1 < P && right - left + 1 < S) {

                right += 1;
                increaseSubWordCount(right);
            }

            if (isPasswordOk(left, right)) {
                passwordCount++;
            }

            decreaseSubWordCount(left);
        }

        System.out.println(passwordCount);
    }

    private static void increaseSubWordCount(final int index) {
        if (DNA[index] == A) {
            aCount++;
        } else if (DNA[index] == C) {
            cCount++;
        } else if (DNA[index] == G) {
            gCount++;
        } else if (DNA[index] == T) {
            tCount++;
        }
    }

    private static void decreaseSubWordCount(final int index) {
        if (DNA[index] == A) {
            aCount--;
        } else if (DNA[index] == C) {
            cCount--;
        } else if (DNA[index] == G) {
            gCount--;
        } else if (DNA[index] == T) {
            tCount--;
        }
    }

    private static boolean isPasswordOk(final int left, final int right) {
        return right - left + 1 == S
               && aCount >= A_MIN_COUNT
               && cCount >= C_MIN_COUNT
               && gCount >= G_MIN_COUNT
               && tCount >= T_MIN_COUNT;
    }
}

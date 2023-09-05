import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2503 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        String[][] thinkings = new String[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            final String answer = st.nextToken();
            final String strike = st.nextToken();
            final String ball = st.nextToken();

            thinkings[i][0] = answer;
            thinkings[i][1] = strike;
            thinkings[i][2] = ball;
        }

        int cnt = 0;
        for (int i = 123; i < 1000; i++) {
            int first = i / 100;
            int second = (i - first * 100) / 10;
            int third = i - first * 100 - second * 10;

            if (first == second || first == third || second == third) {
                continue;
            }

            if (third == 0 || second == 0) {
                continue;
            }

            boolean isTrue = true;
            for (int j = 0; j < N; j++) {
                int strike = 0;
                int ball = 0;
                String thinking = thinkings[j][0];
                final int tFirst = thinking.charAt(0) - '0';
                final int tSecond = thinking.charAt(1) - '0';
                final int tThird = thinking.charAt(2) - '0';

                if (first == tFirst) {
                    strike++;
                }

                if (first == tSecond || first == tThird) {
                    ball++;
                }

                if (second == tSecond) {
                    strike++;
                }

                if (second == tFirst || second == tThird) {
                    ball++;
                }

                if (third == tThird) {
                    strike++;
                }

                if (third == tFirst || third == tSecond) {
                    ball++;
                }

                if (Integer.parseInt(thinkings[j][1]) == strike
                        && Integer.parseInt(thinkings[j][2]) == ball) {
                    continue;
                }

                isTrue = false;
                break;
            }

            if (isTrue) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}

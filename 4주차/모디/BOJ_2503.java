import java.io.*;
import java.util.*;

public class BOJ_2503 {

    private static class TryAndAnswer {
        public int first;
        public int second;
        public int third;
        public int strike;
        public int ball;

        public TryAndAnswer(int number, int strike, int ball) {
            this.first = number / 100;
            this.second = (number - 100 * first) / 10;
            this.third = (number - 100 * first - 10 * second);
            this.strike = strike;
            this.ball = ball;
        }

        public boolean isNotAvailable(int targetFirst, int targetSecond, int targetThird) {
            int strikeCount = getStrikeCount(targetFirst, targetSecond, targetThird);
            int ballCount = getBallCount(targetFirst, targetSecond, targetThird);
            return strike != strikeCount || ball != ballCount;
        }

        private int getStrikeCount(int targetFirst, int targetSecond, int targetThird) {
            int strikeCount = 0;
            if (first == targetFirst) {
                strikeCount++;
            }
            if (second == targetSecond) {
                strikeCount++;
            }
            if (third == targetThird) {
                strikeCount++;
            }
            return strikeCount;
        }

        private int getBallCount(int targetFirst, int targetSecond, int targetThird) {
            int ballCount = 0;
            if (first == targetSecond || first == targetThird) {
                ballCount++;
            }
            if (second == targetThird || second == targetFirst) {
                ballCount++;
            }
            if (third == targetFirst || third == targetSecond) {
                ballCount++;
            }
            return ballCount;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int questionCount = Integer.parseInt(br.readLine());

        StringTokenizer st;
        List<TryAndAnswer> tryAndAnswers = new ArrayList<>();
        for (int i = 0; i < questionCount; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            tryAndAnswers.add(new TryAndAnswer(number, strike, ball));
        }

        int cases = 0;
        for (int first = 1; first <= 9; first++) {
            for (int second = 1; second <= 9; second++) {
                for (int third = 1; third <= 9; third++) {
                    if (isDistinct(first, second, third)) {
                        if (isAvailable(tryAndAnswers, first, second, third)) {
                            cases++;
                        }
                    }
                }
            }
        }
        System.out.println(cases);
    }

    private static boolean isAvailable(List<TryAndAnswer> tryAndAnswers, int first, int second,
            int third) {
        boolean isAvailable = true;
        for (TryAndAnswer tryAndAnswer : tryAndAnswers) {
            if (tryAndAnswer.isNotAvailable(first, second, third)) {
                isAvailable = false;
                break;
            }
        }
        return isAvailable;
    }

    private static boolean isDistinct(int first, int second, int third) {
        return first != second && second != third && third != first;
    }
}

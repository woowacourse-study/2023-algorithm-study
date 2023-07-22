package 도이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2053 {

    private static class Guess {
        String numbers;
        int strike;
        int ball;

        public Guess(String numbers, int strike, int ball) {
            this.numbers = numbers;
            this.strike = strike;
            this.ball = ball;
        }
    }

    private static List<Guess> guesses = new ArrayList<>();
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            guesses.add(new Guess(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int answerCount = 0;
        for (int i = 123; i <= 987; i++) {
            String answer = String.valueOf(i);
            if (answer.charAt(0) == answer.charAt(1))
                continue;
            if (answer.charAt(0) == answer.charAt(2))
                continue;
            if (answer.charAt(1) == answer.charAt(2))
                continue;
            if (answer.contains("0"))
                continue;

            if (isMatch(answer)) {
                answerCount++;
            }
        }

        System.out.println(answerCount);
    }

    private static boolean isMatch(String answer) {
        int matchCount = 0;
        for (Guess guess : guesses) {
            int strike = 0;
            int ball = 0;
            for (int j = 0; j < 3; j++) {
                String numbers = guess.numbers;
                char number = numbers.charAt(j);
                if (answer.contains(String.valueOf(number))) {
                    if (answer.charAt(j) == number) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }
            if (strike == guess.strike && ball == guess.ball) {
                matchCount ++;
            }
        }
        return matchCount == N;
    }
}

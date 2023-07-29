//https://www.acmicpc.net/problem/2503

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_2503 {
    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        final List<int[]> numberClues = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            final StringTokenizer numberStrikeBall = new StringTokenizer(br.readLine());
            final int number = Integer.parseInt(numberStrikeBall.nextToken());
            final int strikeAmount = Integer.parseInt(numberStrikeBall.nextToken());
            final int ballAmount = Integer.parseInt(numberStrikeBall.nextToken());

            numberClues.add(new int[]{number, strikeAmount, ballAmount});
        }

        int answer = 0;

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 1; k < 10; k++) {
                    if (j == k || i == k) {
                        continue;
                    }

                    boolean flag = true;
                    for (final int[] numberClue : numberClues) {
                        int ballCount = 0;
                        int strikeCount = 0;

                        final int clueNumber = numberClue[0];
                        final int[] clueNumberArr = new int[]{
                                clueNumber / 100,
                                (clueNumber / 10) % 10,
                                clueNumber % 10
                        };

                        if (i == clueNumberArr[0]) {
                            strikeCount += 1;
                        }

                        if (j == clueNumberArr[1]) {
                            strikeCount += 1;
                        }

                        if (k == clueNumberArr[2]) {
                            strikeCount += 1;
                        }

                        if (i == clueNumberArr[1]
                                || i == clueNumberArr[2]) {
                            ballCount += 1;
                        }

                        if (j == clueNumberArr[0]
                                || j == clueNumberArr[2]) {
                            ballCount += 1;
                        }

                        if (k == clueNumberArr[0]
                                || k == clueNumberArr[1]) {
                            ballCount += 1;
                        }

                        if (strikeCount != numberClue[1] || ballCount != numberClue[2]) {
                            flag = false;
                            break;
                        }
                    }

                    if (flag) {
                        answer += 1;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}


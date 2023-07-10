package Royce.practice;

//Created by TaeyeonRoyce
//https://www.acmicpc.net/problem/3151

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2799 {
    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer MN = new StringTokenizer(br.readLine());
        final int M = Integer.parseInt(MN.nextToken());
        final int N = Integer.parseInt(MN.nextToken());
        final int boardHeight = M * 4 + (M + 1);
        final int boardWidth = N * 4 + (N + 1);
        final char[][] board = new char[boardHeight][boardWidth];
        final int[] answer = new int[5];

        for (int i = 0; i < boardHeight; i++) {
            final String readLine = br.readLine();
            final char[] chars = readLine.toCharArray();
            System.arraycopy(chars, 0, board[i], 0, chars.length);
        }

        for (int i = 1; i < boardHeight; i += 5) {
            for (int j = 1; j < boardWidth; j += 5) {
                int blindCount = 0;
                for (int k = 0; k < 4; k++) {
                    if (board[i + k][j] == '*') {
                        blindCount += 1;
                    }
                }

                answer[blindCount]++;
            }
        }

        for (final int i : answer) {
            System.out.print(i + " ");
        }
    }
}

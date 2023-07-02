package com.sosow0212.woowacourse_study;

import java.util.Scanner;

public class boj1051 {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int answer = 1;
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String input = sc.next();
            for (int j = 0; j < m; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int range = 1; range + i < n && range + j < m; range++) {
                    if (arr[i][j] == arr[i + range][j] && arr[i][j] == arr[i][j + range] && arr[i][j] == arr[i + range][j + range]) {
                        if ((range + 1) * (range + 1) > answer) {
                            answer = (range + 1) * (range + 1);
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}

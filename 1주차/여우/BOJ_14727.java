package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_14727 {
    public static void main(String[] args) throws IOException {
        final var bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final var 직사각형개수 = Integer.parseInt(bufferedReader.readLine());
        final var 직사각형높이들 = new Integer[직사각형개수];
        for (int i = 0; i < 직사각형개수; i++) {
            직사각형높이들[i] = Integer.parseInt(bufferedReader.readLine());
        }

        final var 제일높은높이 = Arrays.stream(직사각형높이들)
                .mapToInt(i -> i)
                .max().getAsInt();

        final String[][] 히스토그램 = 히스토그램그리기(직사각형개수, 직사각형높이들, 제일높은높이);

        var 제일큰넓이 = 0;
        for (int 세로 = 1; 세로 <= 제일높은높이; 세로++) {
            for (int 출발높이 = 0; 출발높이 < 제일높은높이; 출발높이++) {
                var 넓이들 = new ArrayList<Integer>();
                var 넓이 = 0;
                for (int 가로 = 0; 가로 < 직사각형개수; 가로++) {
                    for (int i = 0; i < 세로; i++) {
                        try {
                            if (히스토그램[출발높이 + i][가로] != null) {
                                넓이++;
                                continue;
                            }
                            넓이들.add(넓이 - 넓이%세로);
                            넓이 = 0;
                        } catch (ArrayIndexOutOfBoundsException e) {}
                    }
                }
                넓이들.add(넓이 - 넓이%세로);
                제일큰넓이 = Math.max(제일큰넓이, 넓이들.stream().mapToInt(i -> i).max().getAsInt());
            }
        }

        System.out.println(제일큰넓이);
    }

    private static String[][] 히스토그램그리기(int 직사각형개수, Integer[] 직사각형높이들, int 제일높은높이) {
        final var 히스토그램 = new String[제일높은높이][직사각형개수];
        for (int 세로 = 0; 세로 < 제일높은높이; 세로++) {
            for (int 가로 = 0; 가로 < 직사각형개수; 가로++) {
                if (세로 < 직사각형높이들[가로]) {
                    히스토그램[세로][가로] = "*";
                }
            }
        }
        return 히스토그램;
    }
}

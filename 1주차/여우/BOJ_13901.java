package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_13901 {

    public static final String UP = "1";
    public static final String DOWN = "2";
    public static final String LEFT = "3";

    public static void main(String[] args) throws IOException {
        final var bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final var firstLine = bufferedReader.readLine();
        final var 세로 = Integer.parseInt(firstLine.split(" ")[0]);
        final var 가로 = Integer.parseInt(firstLine.split(" ")[1]);
        final var 방 = new String[세로][가로];

        final var 장애물개수 = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < 장애물개수; i++) {
            final var 장애물위치 = bufferedReader.readLine();
            final var 장애물y = Integer.parseInt(장애물위치.split(" ")[0]);
            final var 장애물x = Integer.parseInt(장애물위치.split(" ")[1]);
            방[장애물y][장애물x] = "x";
        }

        final var 로봇위치 = bufferedReader.readLine();
        var 로봇위치y = Integer.parseInt(로봇위치.split(" ")[0]);
        var 로봇위치x = Integer.parseInt(로봇위치.split(" ")[1]);

        final var 이동방향 = bufferedReader.readLine().split(" ");

        var 막힘 = 0;
        for (int i = 0; i < 4; i++) {
            var 이동할로봇위치x = 로봇위치x;
            var 이동할로봇위치y = 로봇위치y;

            try {
                while (방[이동할로봇위치y][이동할로봇위치x] == null) {
                    이동할로봇위치x = switch (이동방향[i]) {
                        case UP -> 로봇위치x;
                        case DOWN -> 로봇위치x;
                        case LEFT -> 로봇위치x - 1;
                        default -> 로봇위치x + 1;
                    };

                    이동할로봇위치y = switch (이동방향[i]) {
                        case UP -> 로봇위치y - 1;
                        case DOWN -> 로봇위치y + 1;
                        case LEFT -> 로봇위치y;
                        default -> 로봇위치y;
                    };

                    if (방[이동할로봇위치y][이동할로봇위치x] == null) {
                        막힘 = 0;
                        방[로봇위치y][로봇위치x] = "done";

                        로봇위치x = 이동할로봇위치x;
                        로봇위치y = 이동할로봇위치y;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }

            if (i == 3) {
                if (막힘 == 0) {
                    막힘 = 1;
                    i = -1;
                    continue;
                }
                break;
            }
        }

        System.out.println(로봇위치y + " " + 로봇위치x);
    }
}

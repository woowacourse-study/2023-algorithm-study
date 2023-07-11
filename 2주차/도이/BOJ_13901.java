package 도이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13901 {

    private static int r;
    private static int c;
    private static boolean[][] room;
    private static int robotX;
    private static int robotY;
    private static int[] directions = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        room = new boolean[r][c];

        int obsCount = Integer.parseInt(br.readLine());
        while(obsCount-- > 0) {
            st = new StringTokenizer(br.readLine());
            room[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
        }

        st = new StringTokenizer(br.readLine());
        robotX = Integer.parseInt(st.nextToken());
        robotY = Integer.parseInt(st.nextToken());
        room[robotX][robotY] = true;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            directions[i] = Integer.parseInt(st.nextToken());
        }

        move(0, 0);
        System.out.println(robotX + " " + robotY);
    }

    private static void move(int directionIndex, int count) {
        if (count == 4) {
            return;
        }
        int x = robotX;
        int y = robotY;

        if (directions[directionIndex] == 1) {
            x -= 1;
        }
        if (directions[directionIndex] == 2) {
            x += 1;
        }
        if (directions[directionIndex] == 3) {
            y -= 1;
        }
        if (directions[directionIndex] == 4) {
            y += 1;
        }

        if (0 <= x && x < r && 0 <= y && y < c) {
            if (!room[x][y]) {
                robotX = x;
                robotY = y;
                room[x][y] = true;
                move(directionIndex, 0);
                return;
            }
        }

        if (directionIndex == 3) {
            directionIndex = 0;
        } else {
            directionIndex++;
        }

        move(directionIndex, count + 1);
    }
}

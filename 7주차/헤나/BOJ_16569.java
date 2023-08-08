package 헤나;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_16569 {

    private static final int CANNOT = -1;
    private static final int MAX_M = 100, MAX_N = 100;
    private static final int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};

    private static int Y, X;
    private static int M, N, V;
    private static int[][] mountain;

    public static void main(String[] args) throws Exception {
        mountain = new int[MAX_M + 1][MAX_N + 1];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for (int col = 1; col < M; col++) {
            st = new StringTokenizer(br.readLine());
            for (int row = 1; row <= N; row++) {
                mountain[col][row] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<Bomb> bombs = new PriorityQueue<>();
        for (int bomb = 1; bomb <= V; bomb++) {
            st = new StringTokenizer(br.readLine());
            final int y = Integer.parseInt(st.nextToken());
            final int x = Integer.parseInt(st.nextToken());
            final int t = Integer.parseInt(st.nextToken());

            bombs.add(new Bomb(y, x, t));
        }

        final int currentTime = 1;


    }

    private static class Bomb implements Comparator<Bomb> {
        private final int y;
        private final int x;
        private final int t;

        public Bomb(final int y, final int x, final int t) {
            this.y = y;
            this.x = x;
            this.t = t;
        }

        @Override
        public int compare(final Bomb o1, final Bomb o2) {
            return o1.t > o2.t ? 1 : 0;
        }
    }
}

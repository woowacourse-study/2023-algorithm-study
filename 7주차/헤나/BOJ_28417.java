package 헤나;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_28417 {

    private static final int MAX_RUN = 2, MAX_TRICK = 5;

    private static int N;
    private static Integer[][] runs;
    private static Integer[][] tricks;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        runs = new Integer[N][MAX_RUN];
        tricks = new Integer[N][MAX_TRICK];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int type = 0; type < MAX_RUN; type++) {
                runs[i][type] = Integer.parseInt(st.nextToken());
            }
            for (int type = 0; type < MAX_TRICK; type++) {
                tricks[i][type] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.sort(runs[i], Collections.reverseOrder());
            Arrays.sort(tricks[i], Collections.reverseOrder());
        }

        int maxPointSum = 0;
        for (int i = 0; i < N; i++) {
            maxPointSum = Math.max(maxPointSum, runs[i][0] + tricks[i][0] + tricks[i][1]);
        }

        System.out.println(maxPointSum);
    }
}

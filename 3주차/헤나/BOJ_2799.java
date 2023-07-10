package 헤나;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2799 {
    private static final int MAX_N = 100;
    private static final char WINDOW = '*';
    private static final int WINDOW_COL_SIZE = 4, WINDOW_ROW_SIZE = 4;
    private static final int WINDOW_FRAME_ONE_BLOCK = 1;

    private static int N, M;
    private static int[] arr;
    private static int[] currentWindowState;

    public static void main(String[] args) throws Exception {
        arr = new int[5];
        currentWindowState = new int[MAX_N + 1];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for (int floor = 1; floor <= M; floor++) {
            br.readLine();
            Arrays.fill(currentWindowState, 0);
            for (int windowRow = 1; windowRow <= WINDOW_ROW_SIZE; windowRow++) {
                final char[] windowBlocks = br.readLine().toCharArray();
                for (int windowIndex = 1; windowIndex <= N; windowIndex++) {
                    final char currentBlock = windowBlocks[1 + (WINDOW_COL_SIZE + WINDOW_FRAME_ONE_BLOCK) * (windowIndex - 1)];
                    if (currentBlock == WINDOW) {
                        currentWindowState[windowIndex]++;
                    }
                }
            }

            for (int windowColIndex = 1; windowColIndex <= N; windowColIndex++) {
                arr[currentWindowState[windowColIndex]]++;
            }
        }
        br.readLine();

        for (int i = 0; i < 5; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

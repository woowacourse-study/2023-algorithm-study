import java.io.*;
import java.util.*;

public class BOJ_2799 {

    private static final int WINDOW_SIZE = 4;
    private static final int BLIND_TYPE_COUNT = 5;
    private static final char BLINDED = '*';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int windowHeight = Integer.parseInt(st.nextToken());
        int windowWidth = Integer.parseInt(st.nextToken());

        int totalHeight = windowHeight * (WINDOW_SIZE + 1) + 1;
        int totalWidth = windowWidth * (WINDOW_SIZE + 1) + 1;

        char[][] state = new char[totalHeight][totalWidth];
        for (int i = 0; i < totalHeight; i++) {
            String line = br.readLine();
            for (int j = 0; j < totalWidth; j++) {
                state[i][j] = line.charAt(j);
            }
        }

        int[] blindType = new int[BLIND_TYPE_COUNT];
        for (int i = 0; i < windowHeight; i++) {
            for (int j = 0; j < windowWidth; j++) {
                int currentY = i * (WINDOW_SIZE + 1) + 1;
                int currentX = j * (WINDOW_SIZE + 1) + 1;

                int blindLength = 0;
                while (state[currentY][currentX] == BLINDED) {
                    currentY++;
                    blindLength++;
                }
                blindType[blindLength]++;
            }
        }

        for (int i = 0; i < BLIND_TYPE_COUNT; i++) {
            System.out.print(blindType[i] + " ");
        }
    }
}
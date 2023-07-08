package 헤나;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1969 {
    private static final int MAX_N = 1_000, MAX_M = 50;
    private static final int A = 65, Z = 90;


    private static int[][] arr;
    private static int[] words;
    private static int N, M;

    public static void main(String[] args) throws Exception {
        arr = new int[MAX_N + 1][MAX_M + 1];
        words = new int[MAX_M + 1];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 1; j <= M; j++) {
                arr[i][j] = charArray[j - 1];
            }
        }

        int minTotalWordDiffCount = 0;
        for (int index = 1; index <= M; index++) {
            int selectedWord = A;
            int minWordCount = Integer.MAX_VALUE;
            for (int currentWord = A; currentWord <= Z; currentWord++) {
                int currentMinWordCount = 0;
                for (int dna = 1; dna <= N; dna++) {
                    if (arr[dna][index] != currentWord) {
                        currentMinWordCount++;
                    }
                }

                if (currentMinWordCount < minWordCount) {
                    selectedWord = currentWord;
                    minWordCount = currentMinWordCount;
                }
            }
            minTotalWordDiffCount += minWordCount;
            words[index] = selectedWord;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= M; i++) {
            sb.append((char) words[i]);
        }
        sb.append(System.lineSeparator()).append(minTotalWordDiffCount);
        System.out.println(sb);
    }
}

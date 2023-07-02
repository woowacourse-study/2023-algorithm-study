import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1051 {
    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

      //보드 입력
        final int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            final char[] numbers = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                board[i][j] = Character.getNumericValue(numbers[j]);
            }
        }

        final int maxWidth = Math.min(N, M);
        int answerWidth = 1;
      
      
        for (int i = 0; i < N; i++) {
            final int[] line = board[i];
            if (N - answerWidth <= i) { // 정답 크기보다 작은 크기의 정사각형을 탐색하는 경우 종료
                break; 
            }
            for (int j = 0; j < M; j++) {
                if (M - answerWidth <= j) {
                    break;
                }
                final int number = line[j];
                for (int k = 1; k < maxWidth; k++) {
                    if (k < answerWidth) {
                        continue;
                    }

                    if (i + k >= N || j + k >= M) {
                        break;
                    }

                    final int rightTop = board[i][j + k];
                    final int leftBottom = board[i + k][j];
                    final int rightBottom = board[i + k][j + k];
                    if (rightTop == number
                            && leftBottom == number
                            && rightBottom == number
                            && answerWidth < k + 1) {
                        answerWidth = k + 1;
                    }
                }

            }
        }
        System.out.println(answerWidth * answerWidth);
    }
}

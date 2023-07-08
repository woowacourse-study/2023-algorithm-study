import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1189 {

  static int row, col, K;
  static char[][] A;
  static boolean[][] visit;
  static int answer;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, 1, -1};

  static int atoi(String str) {
    return Integer.parseInt(str);
  }

  public static void main(String[] args) throws IOException {
    input();
    pro();
  }

  static void pro() {
    visit[row - 1][0] = true;
    dfs(row - 1, 0, 1);
    System.out.println(answer);
  }

  static void dfs(int x, int y, int count) {
    if (x == 0 && y == col - 1) {
      if (count == K) {
        answer++;
        return;
      }
    }

    for (int i = 0; i < 4; i++) {
      int nextX = x + dx[i];
      int nextY = y + dy[i];

      if (!isRangeTrue(nextX, nextY)) {
        continue;
      }
      if (visit[nextX][nextY]) {
        continue;
      }
      if (A[nextX][nextY] == 'T') {
        continue;
      }

      visit[nextX][nextY] = true;
      dfs(nextX, nextY, count + 1);
      visit[nextX][nextY] = false;
    }


  }

  private static boolean isRangeTrue(final int x, final int y) {
    return x >= 0 && x < row && y >= 0 && y < col;
  }

  static void input() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    row = atoi(st.nextToken());
    col = atoi(st.nextToken());
    K = atoi(st.nextToken());

    A = new char[row][col];
    visit = new boolean[row][col];

    for (int i = 0; i < row; i++) {
      String s = br.readLine();
      for (int j = 0; j < col; j++) {
        A[i][j] = s.charAt(j);
      }
    }
  }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13901 {

  static int row, col;
  static int k;
  static int[][] A;
  static int[] dx = {-111, -1, 1, 0, 0};
  static int[] dy = {-111, 0, 0, -1, 1};
  static int startX, startY;
  static int[] order;
  static boolean[][] visit;

  static int atoi(String str) {
    return Integer.parseInt(str);
  }

  public static void main(String[] args) throws IOException {
    input();
    pro();
  }

  static void pro() {
    int curX = startX;
    int curY = startY;
    visit[curX][curY] = true;

    while (true) {
      boolean canMove = false;
      for (int i = 1; i < 5; i++) {
        int nextDir = order[i];

        while (true) {
          int nextX = curX + dx[nextDir];
          int nextY = curY + dy[nextDir];

          if (!isRangeTrue(nextX, nextY)) {
            break;
          }
          if (visit[nextX][nextY]) {
            break;
          }
          if (A[nextX][nextY] == -1) {
            break;
          }

          visit[nextX][nextY] = true;
          curX = nextX;
          curY = nextY;
          canMove = true;
        }
      }

      if (!canMove) {
        System.out.println(curX + " " + curY);
        return;
      }
    }
  }

  static boolean isRangeTrue(int x, int y) {
    return x >= 0 && x < row && y >= 0 && y < col;
  }

  static void input() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    row = atoi(st.nextToken());
    col = atoi(st.nextToken());

    A = new int[row][col];
    visit = new boolean[row][col];

    st = new StringTokenizer(br.readLine());

    k = atoi(st.nextToken());

    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());

      final int kRow = atoi(st.nextToken());
      final int kCol = atoi(st.nextToken());

      A[kRow][kCol] = -1;
    }

    st = new StringTokenizer(br.readLine());

    startX = atoi(st.nextToken());
    startY = atoi(st.nextToken());

    order = new int[5];

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i < 5; i++) {
      order[i] = atoi(st.nextToken());
    }
  }
}

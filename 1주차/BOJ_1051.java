import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int row, col;
  static int[][] arr;

  static int atoi(String str) {
    return Integer.parseInt(str);
  }

  public static void main(String[] args) throws IOException {
    input();
    pro();
  }

  static void pro() {
    int min = Math.min(row, col);
    int answer = 1;

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        for (int k = 1; k < min; k++) {
          if (i + k < row && j + k < col) {
            int origin = arr[i][j];
            int diagonal = arr[i + k][j + k];
            int r = arr[i][j + k];
            int c = arr[i + k][j];

            if (origin == diagonal && diagonal == r && r == c) {
              answer = Math.max(answer, (k + 1) * (k + 1));
            }
          }
        }
      }
    }

    System.out.println(answer);
  }

  static void input() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    row = atoi(st.nextToken());
    col = atoi(st.nextToken());

    arr = new int[row][col];

    for (int i = 0; i < row; i++) {
      String s = br.readLine();
      for (int j = 0; j < col; j++) {
        arr[i][j] = s.charAt(j) - '0';
      }
    }
  }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2799 {

  static int floor, window;
  static char[][] A;
  static int[] answer;

  static int atoi(String str) {
    return Integer.parseInt(str);
  }

  public static void main(String[] args) throws IOException {
    input();
    pro();
  }

  static void pro() {

    for (int j = 1; j < A[0].length; j = j + 5) {

      for (int i = 1; i < A.length; i = i + 5) {

        int count = 0;
        for (int k = i; k < i + 4; k++) {
          String s = "" + A[k][j] + A[k][j + 1] + A[k][j + 2] + A[k][j + 3];

          if (s.equals("****")) {
            count++;
          }
        }

        answer[count]++;
      }
    }

    for (final int i : answer) {
      System.out.print(i + " ");
    }
  }

  static void input() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    floor = atoi(st.nextToken());
    window = atoi(st.nextToken());
    answer = new int[5];

    A = new char[5 * floor + 1][window + 1 + 4 * window];

    for (int i = 0; i < A.length; i++) {
      final String s = br.readLine();
      for (int j = 0; j < A[i].length; j++) {
        A[i][j] = s.charAt(j);
      }
    }
  }
}

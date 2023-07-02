import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int atoi(String str) {
    return Integer.parseInt(str);
  }

  static int N, S;
  static int[] A;
  static int answer;
  static int c;

  public static void main(String[] args) throws IOException {
    input();
    pro();
  }

  static void pro() {
    dfs(0, 0);

    if (S == 0) {
      answer -= 1;
    }

    System.out.println(answer);
  }

  static void dfs(int idx, int sum) {
    if (idx == N) {
      if (sum == S) {
        answer++;
      }

      return;
    }

    dfs(idx + 1, sum);
    dfs(idx + 1, sum + A[idx]);
  }

  static void input() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = atoi(st.nextToken());
    S = atoi(st.nextToken());

    A = new int[N];

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      A[i] = atoi(st.nextToken());
    }
  }
}

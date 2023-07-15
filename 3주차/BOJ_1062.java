import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1062 {

  static int N, K;
  static String[] A;

  static int answer;
  static boolean[] visit;

  static int atoi(String str) {
    return Integer.parseInt(str);
  }

  public static void main(String[] args) throws IOException {
    input();
    pro();
  }

  static void pro() {
    if (K < 5) {
      System.out.println(0);
      return;
    }

    visit['a' - 'a'] = true;
    visit['n' - 'a'] = true;
    visit['t' - 'a'] = true;
    visit['i' - 'a'] = true;
    visit['c' - 'a'] = true;

    dfs(0, 0);

    System.out.println(answer);
  }

  static void dfs(int alphabet, int len) {
    if (len == K - 5) {
      int count = 0;

      for (int i = 0; i < N; i++) {
        boolean flag = true;
        for (int j = 0; j < A[i].length(); j++) {
          if (!visit[A[i].charAt(j) - 'a']) {
            flag = false;
            break;
          }
        }
        if (flag) {
          count++;
        }
      }

      answer = Math.max(answer, count);
      return;
    }

    for (int i = alphabet; i < 26; i++) {
      if (!visit[i]) {
        visit[i] = true;
        dfs(i, len + 1);
        visit[i] = false;
      }
    }
  }

  static void input() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = atoi(st.nextToken());
    K = atoi(st.nextToken());
    visit = new boolean[26];

    A = new String[N];

    for (int i = 0; i < N; i++) {
      A[i] = br.readLine().replace("anta", "").replace("tica", "");
    }

  }
}

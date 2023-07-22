import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2559 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        int[] sum = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            final int cur = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + cur;
        }

        int max = -10000001;
        for (int i = K; i <= N; i++) {
            int tmp = sum[i] - sum[i - K];
            max = Math.max(max, tmp);
        }
        System.out.println(max);
    }
}

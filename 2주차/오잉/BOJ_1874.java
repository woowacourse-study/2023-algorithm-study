import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] stack = new int[N];
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        int start = 0;

        for (int i=0; i<N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x > start) {
                for(int j=start+1; j<=x; j++) {
                    stack[idx] = j;
                    idx++;
                    sb.append("+\n");
                }
                start = x;
            } else if (stack[idx-1] != x) {
                System.out.println("NO");
                return;
            }
            idx--;
            sb.append("-\n");

        }
        System.out.println(sb);
    }
}

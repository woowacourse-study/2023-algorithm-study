import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_2609_최대공약수와_최소공배수 {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String[] s = readLine().split(" ");
        int A = Integer.parseInt(s[0]);
        int B = Integer.parseInt(s[1]);

        int big = Math.max(A, B);
        int small = Math.min(A, B);

        int min;
        while (true) {
            int remain = big % small;
            if (remain == 0) {
                min = small;
                break;
            }
            big = small;
            small = remain;
        }
        System.out.println(small);
        System.out.println(A * B / small);

    }
}

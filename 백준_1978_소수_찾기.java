import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_1978_소수_찾기 {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final boolean[] sieveOfEratosthenes = new boolean[1001];

    public static void main(String[] args) {
        int N = readInt();
        initail();
        long count = Arrays.stream(readLine().split(" "))
                .map(Integer::parseInt)
                .filter(백준_1978_소수_찾기::isPrime)
                .count();
        System.out.println(count);
    }

    private static boolean isPrime(Integer it) {
        return sieveOfEratosthenes[it];
    }

    private static void initail() {
        for (int i = 2; i < 1001; i++) {
            sieveOfEratosthenes[i] = true;
        }
        for (int i = 2; i < 1001; i++) {
            if (!sieveOfEratosthenes[i]) {
                continue;
            }
            for (int j = 2; j * i < 1001; j++) {
                sieveOfEratosthenes[j * i] =false;
            }
        }
    }

    public static String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int readInt() {
        return Integer.parseInt(readLine());
    }
}

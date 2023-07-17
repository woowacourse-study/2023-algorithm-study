import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 백준_15829_Hashing {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        readLine();
        String input = readLine();
        List<Integer> collect = Arrays.stream(input.split(""))
                .map(it -> it.charAt(0) - 'a' + 1)
                .collect(Collectors.toList());

        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < collect.size(); i++) {
            sum = sum.add(hashing(collect.get(i), i));
        }
        System.out.println(sum.mod(BigInteger.valueOf(1234567891)));
    }

    private static String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static BigInteger hashing(int a, int i) {
        BigInteger bigInteger = BigInteger.valueOf(31);
        return BigInteger.valueOf(a).multiply(bigInteger.pow(i)).mod(BigInteger.valueOf(1234567891));
    }
}

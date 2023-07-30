import static java.util.stream.Collectors.counting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class 백준_10816_숫자_카드_2 {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        readInt();
        Map<Integer, Long> collect = Arrays.stream(readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.groupingBy(Function.identity(), counting()));
        readInt();
        String collect1 = Arrays.stream(readLine().split(" "))
                .map(it -> collect.getOrDefault(Integer.parseInt(it), 0L).toString())
                .collect(Collectors.joining(" "));
        System.out.println(collect1);
    }

    private static String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int readInt() {
        try {
            return Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

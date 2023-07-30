import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 백준_11050_이항계수_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);
        Factorial factorial = new Factorial();
        int i = factorial.factorial(N) / ((factorial.factorial(N - K) * factorial.factorial(K)));
        System.out.println(i);
    }

    static class Factorial {

        private static final Map<Integer, Integer> cache
                = new HashMap<>();

        public int factorial(int number) {
            if (number == 0 || number == 1) {
                return 1;
            }
            if (cache.containsKey(number)) {
                return cache.get(number);
            }
            int result = number * factorial(number - 1);
            cache.put(number, result);
            return result;
        }
    }
}

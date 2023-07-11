import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem12891 {

    private static int A = 0;
    private static int C = 1;
    private static int G = 2;
    private static int T = 3;
    private static int[] orders;
    private static char[] passwords;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int S = Integer.parseInt(st.nextToken());
        final int P = Integer.parseInt(st.nextToken());

        final String password = br.readLine();

        st = new StringTokenizer(br.readLine());
        orders = new int[4];
        for (int i = 0; i < orders.length; i++) {
            final int value = Integer.parseInt(st.nextToken());
            orders[i] = value;
        }

        int start = 0;
        int end = 0;
        final int length = password.length();
        passwords = password.toCharArray();
        final int[] ordersCopy = Arrays.copyOf(orders, orders.length);
        final int i = findIndex(end);
        ordersCopy[i]--;

        int sum = 0;
        while (end < length - 1) {
            if (end - start != P - 1) {
                final int index = findIndex(++end);
                ordersCopy[index]--;
                continue;
            }

            if (isAllUnderZero(ordersCopy)) {
                sum++;
            }

            increase(start++, ordersCopy);
            decrease(++end, ordersCopy);
        }

        if (isAllUnderZero(ordersCopy)) {
            sum++;
        }

        System.out.println(sum);
    }

    private static void increase(final int start, final int[] ordersCopy) {
        final int i = findIndex(start);
        if (orders[i] > ordersCopy[i]) {
            ordersCopy[i]++;
        }
    }

    private static void decrease(final int start, final int[] ordersCopy) {
        final int i = findIndex(start);
        ordersCopy[i]--;
    }

    private static boolean isAllUnderZero(final int[] ordersCopy) {
        for (final int i : ordersCopy) {
            if (i > 0) {
                return false;
            }
        }

        return true;
    }

    private static int findIndex(final int i) {
        switch (passwords[i]) {
            case 'A':
                return A;
            case 'G':
                return G;
            case 'T':
                return T;
            case 'C':
                return C;
            default:
                return 5;
        }
    }
}

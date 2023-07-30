import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_10989_수_정렬하기_3 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int[] numbers = new int[10001];

    public static void main(String[] args) {

        int number = readInt();

        for (int i = 0; i < number; i++) {
            numbers[readInt()]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 10000; i++) {
            if (numbers[i] == 0) {
                continue;
            }
            for (int i1 = 0; i1 < numbers[i]; i1++) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);

    }

    private static int readInt() {
        try {
            return Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

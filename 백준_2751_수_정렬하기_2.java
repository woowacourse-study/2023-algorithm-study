import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 백준_2751_수_정렬하기_2 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        int number = readInt();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            numbers.add(readInt());
        }
        Collections.sort(numbers);
        StringBuilder sb = new StringBuilder();
        for (Integer integer : numbers) {
            sb.append(integer + "\n");
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

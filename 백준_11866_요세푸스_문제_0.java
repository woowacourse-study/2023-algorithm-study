import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class 백준_11866_요세푸스_문제_0 {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String[] split = sc.nextLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        System.out.print("<");
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(", ");
            for (int i = 1; i < K; i++) {
                deque.add(deque.pollFirst());
            }
            sb.append(deque.pollFirst());
        }
        sb.replace(0, 2, "");
        System.out.print(sb);
        System.out.print(">");
    }
}

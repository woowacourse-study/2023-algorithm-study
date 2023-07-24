import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 백준_9012_괄호 {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int count = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < count; i++) {
            solve();
        }
    }

    private static void solve() {
        Deque<String> stack = new ArrayDeque<>();
        String[] split = sc.nextLine().split("");

        for (int i = 0; i < split.length; i++) {
            if (split[i].equals(")")) {
                if (stack.isEmpty()) {
                    System.out.println("NO");
                    return;
                }
                if (stack.peekLast().equals("(")) {
                    stack.removeLast();
                } else {
                    System.out.println("NO");
                    return;
                }
            } else {
                stack.add(split[i]);
            }
        }
        if (stack.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

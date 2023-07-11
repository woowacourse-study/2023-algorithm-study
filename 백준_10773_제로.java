import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 백준_10773_제로 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < count; i++) {
            int number = Integer.parseInt(sc.nextLine());
            if (number == 0) {
                stack.pollLast();
            } else {
                stack.add(number);
            }
        }
        int sum = stack.stream()
                .mapToInt(it -> it)
                .sum();
        System.out.println(sum);
    }
}

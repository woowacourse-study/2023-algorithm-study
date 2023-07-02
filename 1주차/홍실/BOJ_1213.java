import static java.util.Comparator.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BOJ_1213 {

    static final String FAIL_MESSAGE = "I'm Sorry Hansoo";
    static String middle = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        List<String> splitName = Stream.of(name.split(""))
                .sorted(reverseOrder())
                .collect(Collectors.toList());

        System.out.println(solution(splitName));
    }

    private static String solution(List<String> splitName) {
        List<String> alphas = new LinkedList<>();

        while (!splitName.isEmpty()) {
            String alpha = splitName.get(0);
            splitName.remove(alpha);
            int index = splitName.indexOf(alpha);

            if (index == -1) {
                if (middle.isBlank()) {
                    middle = alpha;
                    continue;
                }
                return FAIL_MESSAGE;
            }

            splitName.remove(alpha);
            alphas.add(alpha);
        }

        Deque<String> answer = new LinkedList<>();
        answer.add(middle);

        for (String alpha : alphas) {
            answer.addFirst(alpha);
            answer.addLast(alpha);
        }

        return answer.stream()
                .reduce(new StringBuilder(), StringBuilder::append, StringBuilder::append)
                .toString();
    }
}

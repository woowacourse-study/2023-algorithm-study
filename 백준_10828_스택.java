import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 백준_10828_스택 {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int N = readInt();
        for (int i = 0; i < N; i++) {
            String input = readLine();
            String command = input.split(" ")[0];
            Command parse = Command.parse(command);

            if (parse == Command.PUSH) {
                String s = input.split(" ")[1];
                deque.add(Integer.parseInt(s));
            }
            if (parse == Command.TOP) {
                Integer integer = deque.peekLast();
                if (integer == null) {
                    integer = -1;
                }
                sb.append(integer + "\n");
            }
            if (parse == Command.SIZE) {
                sb.append(deque.size() + "\n");
            }
            if (parse == Command.EMPTY) {
                sb.append(deque.isEmpty() ? 1 : 0).append("\n");
            }
            if (parse == Command.POP) {
                Integer integer = deque.pollLast();
                if (integer == null) {
                    integer = -1;
                }
                sb.append(integer + "\n");
            }
        }
        System.out.println(sb);
    }


    public static String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int readInt() {
        return Integer.parseInt(readLine());

    }

    public enum Command {
        PUSH,
        TOP,
        SIZE,
        EMPTY,
        POP,
        ;

        public static Command parse(String input) {
            return Arrays.stream(values())
                    .filter(it -> it.name().equalsIgnoreCase(input))
                    .findAny()
                    .get();
        }

    }
}

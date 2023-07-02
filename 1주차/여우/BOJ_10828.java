import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_10828 {
    public static void main(String[] args) throws IOException {
        final var bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final var 스택 = new ArrayList<Integer>();
        final var 명령의수 = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < 명령의수; i++) {
            final var 명령 = bufferedReader.readLine();
            switch (명령.split(" ")[0]) {
                case "push" -> push(Integer.parseInt(명령.split(" ")[1]), 스택);
                case "pop" -> pop(스택);
                case "size" -> size(스택);
                case "empty" -> empty(스택);
                case "top" -> top(스택);
            }
        }
    }

    private static void push(Integer 값, ArrayList<Integer> 스택) {
        스택.add(값);
    }

    private static void pop(ArrayList<Integer> 스택) {
        System.out.println(스택.isEmpty() ? -1 : 스택.remove(스택.size() - 1));
    }

    private static void size(ArrayList<Integer> 스택) {
        System.out.println(스택.size());
    }

    private static void empty(ArrayList<Integer> 스택) {
        System.out.println(스택.isEmpty() ? 1 : 0);
    }

    private static void top(ArrayList<Integer> 스택) {
        System.out.println(스택.isEmpty() ? -1 : 스택.get(스택.size() - 1));
    }
}

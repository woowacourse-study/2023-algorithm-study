import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 백준_1051_숫자_정사각형 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        String[] input = readLine().split(" ");
        int height = Integer.parseInt(input[0]);
        int width = Integer.parseInt(input[1]);
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            map.add(new ArrayList<>());
            map.get(i).addAll(Arrays.stream(readLine().split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
        }

        int maxSize = Math.min(height, width);
        for (int i = maxSize; i > 1; i--) {
            if (existRectangle(i, map)) {
                System.out.println(i * i);
                return;
            }
        }
        System.out.println(1);
    }

    private static boolean existRectangle(int maxSize, List<List<Integer>> map) {
        int height = map.size();
        int width = map.get(0).size();
        for (int i = 0; i <= height - maxSize; i++) {
            for (int j = 0; j <= width - maxSize; j++) {
                List<Integer> start = map.get(i);
                List<Integer> end = map.get(i + maxSize - 1);
                int startStart = start.get(j);
                int startEnd = start.get(j + maxSize - 1);
                int endStart = end.get(j);
                int endEnd = end.get(j + maxSize - 1);

                if ((startStart == startEnd) && (startStart == endStart) && (startStart == endEnd)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int readInt() {
        try {
            return Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

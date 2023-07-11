import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 백준_2799_블라인드 {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String[] input = sc.nextLine().split(" ");
        int height = Integer.parseInt(input[0]);
        int width = Integer.parseInt(input[1]);

        List<List<String>> apart = new ArrayList<>();
        for (int i = 0; i < height * 5 + 1; i++) {
            apart.add(Arrays.stream(sc.nextLine().split("")).collect(Collectors.toList()));
        }

        int[] result = new int[5];

        for (int i = 1; i < height * 5; i += 5) {
            for (int j = 1; j < width * 5; j += 5) {
                result[check(i, j, apart)]++;
            }
        }
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private static int check(int startHeight, int startWidth, List<List<String>> apart) {
        int count = 0;
        for (int i = startHeight; i <= startHeight + 3; i++) {
            if (apart.get(i).get(startWidth).equals("*")) {
                count++;
            }
        }
        return count;
    }
}

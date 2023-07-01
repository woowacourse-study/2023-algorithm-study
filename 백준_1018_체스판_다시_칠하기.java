import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 백준_1018_체스판_다시_칠하기 {

    private static final List<List<String>> whiteStartChess = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        int 세로 = Integer.parseInt(split[0]);
        int 가로 = Integer.parseInt(split[1]);
        makeMap(가로, 세로);

        List<List<String>> inputChess = new ArrayList<>();
        for (int i = 0; i < 세로; i++) {
            inputChess.add(new ArrayList<>());
            List<String> collect = Arrays.stream(sc.nextLine().split(""))
                    .collect(Collectors.toList());
            inputChess.get(i).addAll(collect);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= 세로 - 8; i++) {
            for (int j = 0; j <= 가로 - 8; j++) {
                List<List<String>> map = getMap(inputChess, i, j);
                int diff = checkDiff(map);
                if (min > diff) {
                    min = diff;
                }
            }
        }
        System.out.println(min);
    }

    private static void makeMap(int 가로, int 세로) {
        for (int i = 0; i < 세로; i++) {
            whiteStartChess.add(new ArrayList<>());
            for (int j = 0; j < 가로; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        whiteStartChess.get(i).add("W");
                    } else {
                        whiteStartChess.get(i).add("B");
                    }
                } else {
                    if (j % 2 == 0) {
                        whiteStartChess.get(i).add("B");
                    } else {
                        whiteStartChess.get(i).add("W");
                    }
                }
            }
        }
    }

    private static List<List<String>> getMap(List<List<String>> map, int row, int col) {
        List<List<String>> result = new ArrayList<>();
        for (int i = row; i < row + 8; i++) {
            result.add(new ArrayList<>());
            for (int j = col; j < col + 8; j++) {
                result.get(i - row).add(map.get(i).get(j));
            }
        }
        return result;
    }

    private static int checkDiff(List<List<String>> map) {
        int whiteDiff = 0;
        int blackDiff = 0;
        for (int i = 0; i < 8; i++) {
            List<String> strings = map.get(i);
            List<String> strings1 = whiteStartChess.get(i);
            for (int j = 0; j < 8; j++) {
                String stand = strings.get(j);
                String white = strings1.get(j);
                if (stand.equals(white)) {
                    blackDiff++;
                } else {
                    whiteDiff++;
                }
            }
        }
        return Math.min(whiteDiff, blackDiff);
    }
}

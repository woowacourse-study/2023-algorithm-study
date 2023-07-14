import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BOJ_1051 {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);
        final var line = scanner.nextLine();
        final var splited = line.split(" ");
        final var 세로 = Integer.parseInt(splited[0]);
        final var 가로 = Integer.parseInt(splited[1]);

        final var 직사각형 = new String[세로][가로];
        for (int i = 0; i < 세로; i++) {
            final var 직사각형_한줄 = Arrays.stream(scanner.nextLine().split("")).collect(Collectors.toList());
            for (int j = 0; j < 가로; j++) {
                직사각형[i][j] = 직사각형_한줄.get(j);
            }
        }

        var 최대거리 = 0;
        for (int i = 0; i < 세로; i++) {
            for (int j = 0; j < 가로; j++) {
                var 거리 = 1;
                while (거리 + i < 세로 && 거리 + j < 가로) {
                    var 왼쪽위 = 직사각형[i][j];
                    var 오른쪽위 = 직사각형[i][j + 거리];
                    var 왼쪽아래 = 직사각형[i + 거리][j];
                    var 오른쪽아래 = 직사각형[i + 거리][j + 거리];

                    if (왼쪽위.equals(오른쪽위) && 왼쪽위.equals(왼쪽아래) && 왼쪽아래.equals(오른쪽아래)) {
                        최대거리 = Math.max(최대거리, 거리);
                    }

                    거리++;
                }
            }
        }

        System.out.println((최대거리 + 1) * (최대거리 + 1));
    }
}

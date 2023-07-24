import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 백준_11651_좌표_정렬하기2 {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int count = Integer.parseInt(sc.nextLine());
        List<Position> positions = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String[] input = sc.nextLine().split(" ");
            Position position = new Position(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            positions.add(position);
        }
        Collections.sort(positions);
        for (Position position : positions) {
            System.out.println(position);
        }
    }

    static class Position implements Comparable<Position> {

        private final int x;
        private final int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Position o) {
            if (y > o.y) {
                return 1;
            }
            if (y < o.y) {
                return -1;
            }
            return x - o.x;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

}

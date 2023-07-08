import java.io.*;
import java.util.*;

public class BOJ_13901 {

    private static final char OBSTACLE = 'x';
    private static final char UNVISITED = '\u0000';
    private static final char VISITED = 'v';
    private static final int DIRECTION_COUNT = 4;

    private static int height;
    private static int width;
    private static char[][] map;

    private static class Point {

        public int y;
        public int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public boolean isMovableTo(int targetY, int targetX) {
            return targetY >= 0 && targetY < height && targetX >= 0 && targetX < width
                && map[targetY][targetX] == UNVISITED;
        }

        @Override
        public String toString() {
            return y + " " + x;
        }
    }

    private enum Direction {

        UP(1, new Point(-1, 0)),
        DOWN(2, new Point(1, 0)),
        LEFT(3, new Point(0, -1)),
        RIGHT(4, new Point(0, 1));

        private final int input;
        private final Point point;

        Direction(int input, Point point) {
            this.input = input;
            this.point = point;
        }

        public static Direction getDirectionFromInput(int input) {
            for (Direction direction : Direction.values()) {
                if (direction.input == input) {
                    return direction;
                }
            }
            throw new IllegalArgumentException();
        }

        public int getY() {
            return point.y;
        }

        public int getX() {
            return point.x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        map = new char[height][width];
        int obstacleCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < obstacleCount; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y][x] = OBSTACLE;
        }

        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        map[y][x] = VISITED;

        Queue<Direction> directions = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < DIRECTION_COUNT; i++) {
            int input = Integer.parseInt(st.nextToken());
            Direction inputDirection = Direction.getDirectionFromInput(input);
            directions.add(inputDirection);
        }

        Point point = new Point(y, x);
        int distance = 1;
        for (int i = 0; i < DIRECTION_COUNT; i++) {
            Direction direction = directions.poll();
            while (point.isMovableTo(point.y + distance * direction.getY(), point.x + distance * direction.getX())) {
                int targetY = point.y + distance * direction.getY();
                int targetX = point.x + distance * direction.getX();
                map[targetY][targetX] = VISITED;
                point = new Point(targetY, targetX);
                i = 0;
            }
            directions.add(direction);
        }
        System.out.println(point);
    }
}

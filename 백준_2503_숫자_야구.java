import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class 백준_2503_숫자_야구 {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

    }

    private static String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int readInt() {
        try {
            return Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static class Player {

        private Set<Integer> candidate(String number, Map<Status, Integer> statuses) {
            String[] split = number.split("");
            int first = Integer.parseInt(split[0]);
            int second = Integer.parseInt(split[1]);
            int third = Integer.parseInt(split[2]);

            if (statuses.get(Status.NONE) == 3) {
                return new HashSet<>();
            }

            if (statuses.get(Status.NONE) == 2) {
                if (statuses.get(Status.STRIKE) == 1) {
                    // 1번째가 Strike,
                }
                else {
                }
            }
            if (statuses.get(Status.NONE) == 1) {
                if (statuses.get(Status.STRIKE) == 1) {
                }
                else {
                }
            }

            throw new IllegalArgumentException();
        }

        private void test(List<BaseBallNumber> strikeNumber, List<BaseBallNumber> ballNumbers, List<Integer> excludeNumber) {
            if (strikeNumber.isEmpty()) {
                
            }
        }

    }

    static class BaseBallNumber {

        private final int index;
        private final int value;

        public BaseBallNumber(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int index() {
            return index;
        }

        public int value() {
            return value;
        }
    }

    static enum Status {
        STRIKE,
        BALL,
        NONE
    }
}

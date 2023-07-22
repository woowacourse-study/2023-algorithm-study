import java.io.*;
import java.util.*;

public class BOJ_1377 {

    private static class ValueAndIdx {
        public int value;
        public int index;
        public ValueAndIdx(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<ValueAndIdx> values = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            values.add(new ValueAndIdx(value, i));
        }

        Collections.sort(values, Comparator.comparing(v -> v.value));

        int maxForwardedDistance = 0;
        for (int i = 0; i < n; i++) {
            maxForwardedDistance = Math.max(values.get(i).index - i, maxForwardedDistance);
        }

        System.out.println(maxForwardedDistance + 1);
    }
}
